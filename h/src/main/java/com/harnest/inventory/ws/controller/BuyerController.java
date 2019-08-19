package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.BuyerInfo;
import com.harnest.inventory.ws.service.BuyerService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + BUYER)
public class BuyerController {

	@Autowired private BuyerService service;
	
	@PostMapping(GET_ALL_BUYER_INFO)
	public ResponseEntity<List<BuyerInfo>> getAllBuyerInfo(){
		List<BuyerInfo> buyerInfos= service.getAllBuyerInfo();
		if(buyerInfos == null || buyerInfos.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Buyer info " + NOT_FOUND);
			
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(buyerInfos, HttpStatus.OK);
	}
}
