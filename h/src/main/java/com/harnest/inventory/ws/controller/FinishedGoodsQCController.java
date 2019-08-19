package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.*;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.FINISH_GOODS_QC;
import static com.harnest.inventory.ws.commons.URIConstants.FINISH_GOODS_QC_GET_INFO;
import static com.harnest.inventory.ws.commons.URIConstants.FINISH_GOODS_QC_SAVE;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;

import java.net.URI;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.harnest.inventory.ws.entity.FinishedGoodsQC;
import com.harnest.inventory.ws.entity.ProdOrderDTLMST;
import com.harnest.inventory.ws.service.FinishedGoodsQCService;
import com.harnest.inventory.ws.service.ProdOrderDTLMSTService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + FINISH_GOODS_QC)
public class FinishedGoodsQCController {

	private static final String NOT_APPROVED = "N";
	private static final String SEARCH_BY_APPROVE_QC_FLAG = "approveQC";
	private static final String SEARCH_BY_PRE_QC_FLAG = "preQC";
	
	private @Autowired FinishedGoodsQCService qcService;
	private @Autowired ProdOrderDTLMSTService prOrderMstService;
	
	@PostMapping(FINISH_GOODS_QC_SAVE)
	public ResponseEntity<Void> saveFinishGoodsQC(@Valid @RequestBody FinishedGoodsQC fgqc , BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Finish goods Qc info doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		qcService.saveFinishedGoodsQC(fgqc);
		headers.add(SUCCESS_MSG, "Finish goods Qc info has been successfully saved");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(fgqc.getFgNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}
	
	@PostMapping(FINISH_GOODS_QC_GET_INFO)
	public ResponseEntity<List<FinishedGoodsQC>> getNotApprovedQCByFlag(@PathVariable String searchType){
		List<FinishedGoodsQC> qcList = new ArrayList<>();
		
		if(searchType.equalsIgnoreCase(SEARCH_BY_PRE_QC_FLAG)) {
			qcList = qcService.findAllByPreQcFlag(NOT_APPROVED);
		}else if(searchType.equalsIgnoreCase(SEARCH_BY_APPROVE_QC_FLAG)) {
			qcList = qcService.findAllByqcAProveFlag(NOT_APPROVED);
		}
		HttpHeaders headers = new HttpHeaders();
		
		if(qcList.isEmpty()) {
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(qcList, HttpStatus.OK);
	}
	
	@GetMapping(FINISH_GOODS_GET_ALL)
	public ResponseEntity<List<ProdOrderDTLMST>> getAllFinishGoods(){
		List<ProdOrderDTLMST> fgList = prOrderMstService.getFinishGoodsList();
		if(fgList == null || fgList.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(fgList, HttpStatus.OK);
	}
}
