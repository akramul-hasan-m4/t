package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.GET_BY_DATE_INIT_SAMPLE_CHD;
import static com.harnest.inventory.ws.commons.URIConstants.GET_INIT_SAMPLE_CHD_BY_ID;
import static com.harnest.inventory.ws.commons.URIConstants.INIT_SAMPLE_CHD;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.CategoryInfo;
import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.entity.GarmentInfo;
import com.harnest.inventory.ws.entity.InitSampleCHD;
import com.harnest.inventory.ws.entity.InitSampleMST;
import com.harnest.inventory.ws.model.SampleProdInfo;
import com.harnest.inventory.ws.service.CategoryInfoService;
import com.harnest.inventory.ws.service.ExecutiveInfoService;
import com.harnest.inventory.ws.service.GarmentInfoService;
import com.harnest.inventory.ws.service.InitSampleCHDService;
import com.harnest.inventory.ws.service.InitSampleMSTService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + INIT_SAMPLE_CHD)
public class InitSampleCHDController {
	
	private @Autowired InitSampleCHDService sampleService;
	private @Autowired GarmentInfoService garmentService;
	private @Autowired CategoryInfoService catService;
	private @Autowired ExecutiveInfoService exeService;
	private @Autowired InitSampleMSTService sampleMstService;
	
	@GetMapping(GET_BY_DATE_INIT_SAMPLE_CHD)
	public ResponseEntity<List<SampleProdInfo>> getAllSampleBetweenDate(@RequestParam ("startDate") String startDate, @RequestParam ("endDate") String endDate){
		
		LocalDate startDate1 = LocalDate.parse(startDate);
		LocalDate endDate1 = LocalDate.parse(endDate);
		
		List<InitSampleCHD> sampleList = sampleService.getInitSampleCHDByDate(startDate1, endDate1);
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		if(sampleList == null || sampleList.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(sampleAllValue(sampleList), HttpStatus.OK);
	}
	
	@GetMapping(GET_INIT_SAMPLE_CHD_BY_ID)
	public ResponseEntity<SampleProdInfo> getAllSampleByID(@PathVariable ("sampleChdId") Integer sampleChdId){
		
		InitSampleCHD sample = sampleService.findInitSampleCHDBySampleChdId(sampleChdId);
		
		if(sample == null ) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, NOT_FOUND);
			
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		InitSampleMST sampleMst = sampleMstService.findBySampleMstId(sample.getSampleMstId());
		ExecutiveInfo exeInfo = exeService.findByExeInfoId(sampleMst.getCreatedBy());
		GarmentInfo buyer = garmentService.findBygarmentInfoId(sample.getBuyerId());
		CategoryInfo catInfo = catService.findByCatId(sample.getLabelType());
		
		SampleProdInfo sampleInfo = new SampleProdInfo();
		sampleInfo.setSampleChdId(sample.getSampleChdId());
		sampleInfo.setSampleMstId(sample.getSampleMstId());
		sampleInfo.setBuyerNo(buyer.getGarmentInfoId());
		sampleInfo.setBuyerName(buyer.getGarmentName());
		sampleInfo.setExeId(exeInfo.getExeInfoId());
		sampleInfo.setExeName(exeInfo.getExeName());
		sampleInfo.setLabelId(catInfo.getCategoryId());
		sampleInfo.setLabelName(catInfo.getCategoryName());
		sampleInfo.setDeliveryDate(sample.getExpDeliveryDate());
		
		return new ResponseEntity<>(sampleInfo, HttpStatus.OK);
	}
	
	private List<SampleProdInfo> sampleAllValue(List<InitSampleCHD> sampleList){
		List<SampleProdInfo> list = new ArrayList<>();
		
		sampleList.stream().forEach(s -> {
			InitSampleCHD sample = sampleService.findInitSampleCHDBySampleChdId(s.getSampleChdId());
			
			if(sample != null ) {
				InitSampleMST sampleMst = sampleMstService.findBySampleMstId(sample.getSampleMstId());
				ExecutiveInfo exeInfo = exeService.findByExeInfoId(sampleMst.getCreatedBy());
				GarmentInfo buyer = garmentService.findBygarmentInfoId(sample.getBuyerId());
				CategoryInfo catInfo = catService.findByCatId(sample.getLabelType());
				
				SampleProdInfo sampleInfo = new SampleProdInfo();
				sampleInfo.setSampleChdId(sample.getSampleChdId());
				sampleInfo.setSampleMstId(sample.getSampleMstId());
				sampleInfo.setBuyerNo(buyer.getGarmentInfoId());
				sampleInfo.setBuyerName(buyer.getGarmentName());
				sampleInfo.setExeId(exeInfo.getExeInfoId());
				sampleInfo.setExeName(exeInfo.getExeName());
				sampleInfo.setLabelId(catInfo.getCategoryId());
				sampleInfo.setLabelName(catInfo.getCategoryName());
				sampleInfo.setDeliveryDate(sample.getExpDeliveryDate());
				sampleInfo.setQty(sample.getQty());
				
				list.add(sampleInfo);
			}
			
		});
		
		return list;
	}

}
