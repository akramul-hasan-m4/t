package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.*;
import static com.harnest.inventory.ws.commons.URIConstants.DEMAND;
import static com.harnest.inventory.ws.commons.URIConstants.DEMAND_FIND_ALL_APPROVED;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.SAVE_DEMAND;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;
import static com.harnest.inventory.ws.commons.CommonConstants.*;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harnest.inventory.ws.entity.CategoryInfo;
import com.harnest.inventory.ws.entity.DemandCHD;
import com.harnest.inventory.ws.entity.DemandMST;
import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.entity.GarmentInfo;
import com.harnest.inventory.ws.entity.InitSampleCHD;
import com.harnest.inventory.ws.entity.IssueMST;
import com.harnest.inventory.ws.entity.Item;
import com.harnest.inventory.ws.entity.ProdOrderDTL;
import com.harnest.inventory.ws.entity.UnitofMeasure;
import com.harnest.inventory.ws.model.DemandChdModel;
import com.harnest.inventory.ws.model.DemandMstModel;
import com.harnest.inventory.ws.service.CategoryInfoService;
import com.harnest.inventory.ws.service.DemandCHDService;
import com.harnest.inventory.ws.service.DemandMSTService;
import com.harnest.inventory.ws.service.ExecutiveInfoService;
import com.harnest.inventory.ws.service.GarmentInfoService;
import com.harnest.inventory.ws.service.InitSampleCHDService;
import com.harnest.inventory.ws.service.IssueMSTService;
import com.harnest.inventory.ws.service.ItemService;
import com.harnest.inventory.ws.service.ProdOrderDTLService;
import com.harnest.inventory.ws.service.UOMService;

import io.swagger.annotations.ApiOperation;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + DEMAND)
public class DemandController {
	
	private static final String SAMPLE = "S";
	private static final String PRODUCTION = "P";
	
	private @Autowired DemandMSTService service;
	private @Autowired DemandCHDService chdService;
	private @Autowired GarmentInfoService buyerService;
	private @Autowired ExecutiveInfoService exeService;
	private @Autowired InitSampleCHDService sampleService;
	private @Autowired CategoryInfoService catService;
	private @Autowired ProdOrderDTLService prodChdService;
	private @Autowired ItemService itemService;
	private @Autowired UOMService uomService;
	private @Autowired IssueMSTService issueMstService;
	
	@PostMapping(SAVE_DEMAND)
	public ResponseEntity<Void> saveRequisitionDemand(@Valid @RequestBody DemandMST demandMST, BindingResult errors){
		
		HttpHeaders headers = new HttpHeaders();
		if (errors.hasErrors()) {
			headers.add(ERROR_MSG, "Demand doesn't save");
			String errorResult = errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			headers.add(ERROR, errorResult);
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		demandMST.setSpFlag(demandMST.getDemandType());
		service.insertIntoDemandMST(demandMST);
		
		Integer id = demandMST.getDemandNo();
		
		if(demandMST != null || !demandMST.getDemandCHDList().isEmpty()) {
			demandMST.getDemandCHDList().stream().forEach(p ->{
				p.setDemandNo(id);
				chdService.saveDemandCHDData(p);
			});
		}
		headers.add(SUCCESS_MSG, "Demand has been successfully saved");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}
	
	@PostMapping(DEMAND_FIND_ALL_BY_PRIVILIGE)
	@ApiOperation(value = "Get Requsition", notes = "This method is used for 3 types of request.\n When you send approveable it will show Non approved Requisition list,\n "
			+ "When you send checkable it will show Non checked item and \n"
			+ " when send entry by (user code) it will show all type requisition(submited, chaked, approve) which item submited by this user. "
			+ "\n NOTE : At a time you send only one param , others param will be null")
	public ResponseEntity<List<DemandMstModel>> getRequisionByType(@RequestParam(required = false) String entryBy, 
																	 @RequestParam(required = false) String checkable, 
																	 @RequestParam(required = false) String approveable) {

		List<DemandMstModel> dmdMasterModel = new ArrayList<>();
		
		List<DemandCHD> list = new ArrayList<>();
		if(entryBy != null) {
			list = chdService.findAllByEntryBy(entryBy);
		}else if(checkable != null) {
			list = chdService.findAllCheckable();
		}else if(approveable != null) {
			list = chdService.findAllApprovable();
		}

		HttpHeaders headers = new HttpHeaders();

		if (list == null || list.isEmpty()) {
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		Set<Integer> parentIdList = list.stream().map(DemandCHD::getDemandNo).collect(Collectors.toSet());
		
		parentIdList.stream().forEach(parentId -> {
			DemandMST parent = service.findByDemandNo(parentId);
			
			if(parent != null) {

				Integer buyerId = parent.getBuyerNo() == null ? 0 : parent.getBuyerNo();
				Integer exeId = parent.getMkrRefNo() == null ? 0 : parent.getMkrRefNo();
				Integer hrRefNo = parent.getHrRefNo() == null ? 0 : parent.getHrRefNo();
				String demandType = parent.getDemandType() == null ? "" : parent.getDemandType();
				
				Integer labelNo = 0;
				String labelName = "";
				
				GarmentInfo buyer = buyerService.findBygarmentInfoId(buyerId);
				ExecutiveInfo exe = exeService.findByExeInfoId(exeId);
				
				if(demandType.equalsIgnoreCase(PRODUCTION)) {
					
					ProdOrderDTL productionChd = prodChdService.findByProdId(String.valueOf(hrRefNo));
					labelNo = productionChd == null || productionChd.getCategoryCode() == null ? 0 : Integer.parseInt(productionChd.getCategoryCode());
					labelName = productionChd == null || productionChd.getCategoryName() == null ? "" : productionChd.getCategoryName();
					
					
				} else if(demandType.equalsIgnoreCase(SAMPLE)) {
					InitSampleCHD sample = sampleService.findInitSampleCHDBySampleChdId(hrRefNo);
					Integer catId = sample == null || sample.getLabelType() == null ? 0 : sample.getLabelType();
					CategoryInfo catInfo = catService.findByCatId(catId);
					
					labelNo = catId;
					labelName = catInfo == null || catInfo.getCategoryName() == null ? "" : catInfo.getCategoryName();
					
				}
				
				String buyerName = buyer == null || buyer.getGarmentName() == null ? "" : buyer.getGarmentName();
				String exeName = exe == null || exe.getExeName() == null ? "" : exe.getExeName();
				
				DemandMstModel requsitionMst = new DemandMstModel();
				requsitionMst.setDemandMstId(parentId);
				requsitionMst.setBuyerId(buyerId);
				requsitionMst.setBuyerName(buyerName);
				requsitionMst.setExecutiveId(exeId);
				requsitionMst.setExecutiveName(exeName);
				requsitionMst.setLabelId(labelNo);
				requsitionMst.setLabelName(labelName);
				requsitionMst.setMachineRef(parent.getMachineRef());
				requsitionMst.setMachineSec(parent.getMachineSec());
				
				List<DemandChdModel> dmdChdModelList = new ArrayList<>();
				
				List<DemandCHD> listCHD = chdService.findAllByDemandNo(parentId);
				
				if(listCHD != null && !listCHD.isEmpty()) {
					listCHD.stream().forEach(dmdchd -> {
						Integer itemId = dmdchd == null || dmdchd.getItemNo() == null ? 0 : dmdchd.getItemNo();
						Integer uomId = dmdchd == null || dmdchd.getUomNo() == null ? 0 : dmdchd.getUomNo();
						
						Item item = itemService.findByItemNo(itemId);
						String itemName = item == null || item.getItemName() == null ? "" : item.getItemName();
						
						UnitofMeasure uom = uomService.findByUomNo(uomId);
						String uomName = uom == null || uom.getUomName() == null ? "" : uom.getUomName();
						
						DemandChdModel chdm = new DemandChdModel();
						chdm.setDemandChdNo(dmdchd.getDemandChildNo());
						chdm.setItemNo(itemId);
						chdm.setItemName(itemName);
						chdm.setUomNo(uomId);
						chdm.setUomName(uomName);
						chdm.setDemandQty(dmdchd.getDemandQty());
						chdm.setCheckQty(dmdchd.getCheckQty());
						chdm.setApproveQty(dmdchd.getApprovedQty());
						
						if(dmdchd != null && dmdchd.getCheckBy() != null) {
							chdm.setIsChecked(Boolean.TRUE);
						}else {
							chdm.setIsChecked(Boolean.FALSE);
						}
						if(dmdchd != null && dmdchd.getApprovedBy() != null) {
							chdm.setIsApproved(Boolean.TRUE);
						}else {
							chdm.setIsApproved(Boolean.FALSE);
						}
						
						dmdChdModelList.add(chdm);
					});
				}
				requsitionMst.setChdList(dmdChdModelList);
				
				dmdMasterModel.add(requsitionMst);
			}
		});
		
		return new ResponseEntity<>(dmdMasterModel, HttpStatus.OK);
	}
	
	@PostMapping(DEMAND_FIND_ALL_APPROVED)
	@ApiOperation(value ="findAllApprovedProd" , notes="This end point show all approved requsition")
	public ResponseEntity<List<DemandMST>> findAllApprovedProd() {

		List<DemandMST> mList = new ArrayList<>();
		
		List<DemandCHD> list = chdService.findAllByApprovedByNotNull();

		HttpHeaders headers = new HttpHeaders();

		if (list == null || list.isEmpty()) {
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		Set<Integer> parentIdList = list.stream().map(DemandCHD::getDemandNo).collect(Collectors.toSet());
		
		parentIdList.stream().forEach(parentId -> {
			List<DemandCHD> chList = new ArrayList<>();
			list.stream().filter(c -> c.getDemandNo().equals(parentId)).forEach(chld -> chList.add(chld));
			String status = "N";
			IssueMST issue = issueMstService.findByDemandNo(parentId);
			if(issue != null) {
				status = "Y";
			}
			DemandMST dmdMst = service.findByDemandNo(parentId);
			dmdMst.setDemandCHDList(chList);
			dmdMst.setStatus(status);
			mList.add(dmdMst);
		});
		
		return new ResponseEntity<>(mList, HttpStatus.OK);
	}
	
	@GetMapping(FIND_DEMAND_CHILD_BY_ID)
	public ResponseEntity<DemandCHD> findDemandChildData(@PathVariable Integer childId){
		DemandCHD chd = chdService.findByDemandChildNo(childId);
		
		if(chd == null) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(chd, HttpStatus.OK);
	}
	
	@PostMapping(SAVE_DEMAND_CHILD)
	@ApiOperation(value= "saveOrUpdateRequisitionDemandChildItem", notes ="You can save new data and update existing data by this end point. \n"
			+ "When you update a record then demandChildNo, updateBy is mandatory.\n"
			+ "Note : when you update demand qty, just add demand qty with mandatory field,\n"
			+ "when you update check ,then send only checkQty with mandatory field, \n"
			+ "when you update approve, then send only approvedQty with mandatory field")
	public ResponseEntity<Void> saveOrUpdateRequisitionDemandChildItem(@Valid @RequestBody DemandCHD chd, BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Record doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		if(chd.getDemandChildNo() != null || chd.getDemandChildNo() != 0) {
			DemandCHD dchd = chdService.findByDemandChildNo(chd.getDemandChildNo());
			
			if(chd.getDemandQty() != null) {
				dchd.setDemandQty(chd.getDemandQty());
			} else if(chd.getCheckQty() != null) {
				dchd.setCheckQty(chd.getCheckQty());
				dchd.setCheckBy(chd.getUpdateBy());
				dchd.setCheckDate(LocalDate.now());
				
			}else if(chd.getApprovedQty() != null) {
				dchd.setApprovedQty(chd.getApprovedQty());
				dchd.setApprovedBy(chd.getUpdateBy());
				dchd.setApprovedDate(LocalDate.now());
			}
			
			dchd.setUpdateDate(LocalDate.now());
			dchd.setUpdateBy(chd.getUpdateBy());
			
			chdService.saveDemandCHDData(dchd);
		}else {
			chdService.saveDemandCHDData(chd);
		}
		
		headers.add(SUCCESS_MSG, "Record has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(chd.getDemandChildNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}

}
