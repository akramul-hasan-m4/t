package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCTION;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCTION_GET_BY_BTWEEN_DATE;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.entity.GarmentInfo;
import com.harnest.inventory.ws.entity.ProdOrderDTL;
import com.harnest.inventory.ws.entity.ProdOrderDTLMST;
import com.harnest.inventory.ws.model.SampleProdInfo;
import com.harnest.inventory.ws.service.ExecutiveInfoService;
import com.harnest.inventory.ws.service.GarmentInfoService;
import com.harnest.inventory.ws.service.ProdOrderDTLMSTService;
import com.harnest.inventory.ws.service.ProdOrderDTLService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + PRODUCTION)
public class ProductOrderDTLController {
	
	private @Autowired ProdOrderDTLService prodChdService;
	private @Autowired ProdOrderDTLMSTService prodMStService;
	private @Autowired GarmentInfoService garmentService;
	private @Autowired ExecutiveInfoService exeService;
	
	@GetMapping(PRODUCTION_GET_BY_BTWEEN_DATE)
	public ResponseEntity<List<SampleProdInfo>> getAllProductonBetweenDate(@RequestParam ("startDate") String startDate, @RequestParam ("endDate") String endDate){
		
		LocalDate startDate1 = LocalDate.parse(startDate);
		LocalDate endDate1 = LocalDate.parse(endDate);
		
		List<ProdOrderDTL> productionList = prodChdService.findByCreateDateBetween(startDate1, endDate1);
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		if(productionList == null || productionList.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(productionAlldata(productionList), HttpStatus.OK);
	}
	
	
	private List<SampleProdInfo> productionAlldata(List<ProdOrderDTL> productionList) {
		List<SampleProdInfo> list = new ArrayList<>();

		productionList.stream().forEach(p -> {

			if (p != null) {
				ProdOrderDTLMST prodMaster = prodMStService.findByReferenceNo(p.getReferenceNo());
				
				Integer createBy = prodMaster == null || prodMaster.getCreateBy() == null ? 0 : Integer.parseInt(prodMaster.getCreateBy());
				Integer buyerId = prodMaster == null || prodMaster.getGrmmId() == null ? 0 : Integer.parseInt(prodMaster.getGrmmId());
				Integer prodChdId = p.getProdId() == null ? 0 : Integer.parseInt(p.getProdId());
				Integer prodMstId = p.getReferenceNo() == null ? 0 : Integer.parseInt(p.getReferenceNo());
				Integer prodLabelId = p.getCategoryCode() == null ? 0 : Integer.parseInt(p.getCategoryCode());
				
				ExecutiveInfo exeInfo = exeService.findByExeInfoId(createBy);
				GarmentInfo buyer = garmentService.findBygarmentInfoId(buyerId);
				
				Integer exeId = exeInfo == null || exeInfo.getExeInfoId() == null ? 0 : exeInfo.getExeInfoId();
				String exeName = exeInfo == null || exeInfo.getExeName() == null ? "" : exeInfo.getExeName();
				String buyerName = buyer == null || buyer.getGarmentName() == null ? "" : buyer.getGarmentName();

				SampleProdInfo sampleInfo = new SampleProdInfo();
				sampleInfo.setSampleChdId(prodChdId);
				sampleInfo.setSampleMstId(prodMstId);
				sampleInfo.setBuyerNo(buyerId);
				sampleInfo.setBuyerName(buyerName);
				sampleInfo.setExeId(exeId);
				sampleInfo.setExeName(exeName);
				sampleInfo.setLabelId(prodLabelId);
				sampleInfo.setLabelName(p.getCategoryName());
				sampleInfo.setDeliveryDate(p.getCreateDate());
				sampleInfo.setQty(p.getQty());

				list.add(sampleInfo);
			}

		});

		return list;
	}

}
