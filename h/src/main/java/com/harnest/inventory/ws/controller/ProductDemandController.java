package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_DEMAND;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_SAVE_CHD_DEMAND;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_SAVE_DEMAND;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;

import java.net.URI;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harnest.inventory.ws.entity.ProductDemandCHD;
import com.harnest.inventory.ws.entity.ProductDemandMST;
import com.harnest.inventory.ws.service.ProductDemandCHDService;
import com.harnest.inventory.ws.service.ProductDemandService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + PRODUCT_DEMAND)
public class ProductDemandController {

	private @Autowired ProductDemandService service;
	private @Autowired ProductDemandCHDService chdService;
	
	@PostMapping(PRODUCT_SAVE_DEMAND)
	public ResponseEntity<Void> saveProductDemand(@Valid @RequestBody ProductDemandMST demandMST, BindingResult errors){
		
		HttpHeaders headers = new HttpHeaders();
		if (errors.hasErrors()) {
			headers.add(ERROR_MSG, "Demand doesn't save");
			String errorResult = errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		service.saveData(demandMST);
		
		Integer prDemandNo = demandMST.getPrDemandNo();
		
		if (demandMST.getDemandCHDitems() != null && !demandMST.getDemandCHDitems().isEmpty()) {
			demandMST.getDemandCHDitems().stream().forEach(pchd -> {
				pchd.setPrDemandNo(prDemandNo);
				chdService.saveProductDemandCHDData(pchd);
			});
		}
		
		headers.add(SUCCESS_MSG, "Product Demand has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(demandMST.getPrDemandNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
		
	}
	
	
	@PostMapping(PRODUCT_SAVE_CHD_DEMAND)
	public ResponseEntity<Void> saveCHDProductDemand(@Valid @RequestBody ProductDemandCHD demandCHD, BindingResult errors){
		
		HttpHeaders headers = new HttpHeaders();
		if (errors.hasErrors()) {
			headers.add(ERROR_MSG, "Demand doesn't save");
			String errorResult = errors.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		chdService.saveProductDemandCHDData(demandCHD);
		headers.add(SUCCESS_MSG, "Product item Demand has been successfully saved");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(demandCHD.getDemandChdNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
		
	}
}
