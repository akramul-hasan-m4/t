package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_ORDER_RCV;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_ORDER_RCV_GET_BY_CREATE_BY;
import static com.harnest.inventory.ws.commons.URIConstants.PRODUCT_ORDER_RCV_SAVE;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;

import java.net.URI;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harnest.inventory.ws.entity.ProductOrderRcvCHD;
import com.harnest.inventory.ws.entity.ProductOrderRcvMST;
import com.harnest.inventory.ws.service.ProductOrderRcvCHDService;
import com.harnest.inventory.ws.service.ProductOrderRcvMSTService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + PRODUCT_ORDER_RCV)
public class ProductOrderRcvController {

	private @Autowired ProductOrderRcvMSTService mstService; 
	private @Autowired ProductOrderRcvCHDService chdService; 
	
	@PostMapping(PRODUCT_ORDER_RCV_SAVE)
	public ResponseEntity<Void> savePurchase(@Valid @RequestBody ProductOrderRcvMST poOrderRcv, BindingResult result){
		
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Purchase doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		poOrderRcv.setRcvDate(LocalDate.now());
		mstService.saveProductOrderRcvMST(poOrderRcv);
		
		Integer rcvNo = poOrderRcv.getRcvNo();
		

		if (!poOrderRcv.getProdOrderChdList().isEmpty()) {
			poOrderRcv.getProdOrderChdList().stream().forEach(pchd -> {
				pchd.setRecNo(rcvNo);;
				chdService.saveProductOrderRcvCHDData(pchd);
			});
		}
		
		headers.add(SUCCESS_MSG, "Product Demand has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(rcvNo).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}
	
	@PostMapping(PRODUCT_ORDER_RCV_GET_BY_CREATE_BY)
	public ResponseEntity<List<ProductOrderRcvMST>> getProdouctOrderByCreateBy(@PathVariable String createBy) {

		List<ProductOrderRcvMST> mList = new ArrayList<>();
		List<ProductOrderRcvMST> list = mstService.findAllByCreateBy(createBy);

		HttpHeaders headers = new HttpHeaders();

		if (list == null || list.isEmpty()) {
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		list.stream().forEach(p -> {
			List<ProductOrderRcvCHD> listCHD = chdService.findAllByRecNo(p.getRcvNo());
			p.setProdOrderChdList(listCHD);
			mList.add(p);
		});

		return new ResponseEntity<>(mList, HttpStatus.OK);
	}
	
}
