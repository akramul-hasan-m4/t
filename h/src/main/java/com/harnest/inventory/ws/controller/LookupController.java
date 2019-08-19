package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.CommonConstants.ERROR;
import static com.harnest.inventory.ws.commons.URIConstants.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
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

import com.harnest.inventory.ws.entity.LookUp;
import com.harnest.inventory.ws.entity.LookupDtl;
import com.harnest.inventory.ws.model.LookupDTLModel;
import com.harnest.inventory.ws.service.LookUpService;
import com.harnest.inventory.ws.service.LookupDtlService;

import io.swagger.annotations.ApiOperation;

/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + LOOKUP)
public class LookupController {

	private @Autowired LookupDtlService service;
	private @Autowired LookUpService lookUpService;

	@PostMapping(LOOKUP_GET_ALL_INFO)
	public ResponseEntity<List<LookupDTLModel>> getAllLookUpInfoWithDetails(){
		List<LookupDTLModel> list = service.getLookupDtlInfo();
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(LOOKUP_GET_ALL_INFO_BY_LOOKUP_NO)
	@ApiOperation(value = "getAllLookUpInfoByLookUpNo" , notes = "LookupNo Should be integer.\n"
			+ "No = 0 means you get all predefine selected data,\n"
			+ "No = 1 means Color,\n"
			+ "No = 2 means Count,\n"
			+ "No = 3 means Yarn Type,\n"
			+ "No = 4 means Rubber Type")
	public ResponseEntity<List<LookupDTLModel>> getAllLookUpInfoByLookUpNo(@PathVariable Integer lookUpNo){
		List<Integer> lookUpNoList = new ArrayList<>();
		List<Integer> preDefinelookUpNo = Arrays.asList(1, 2, 3, 4);
		if(lookUpNo == 0) {
			lookUpNoList = preDefinelookUpNo;
		}else {
			lookUpNoList.add(lookUpNo);
		}
		List<LookupDTLModel> list = service.getLookupDtlInfoByLookUpNo(lookUpNoList);
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(LOOKUP_SAVE_DTL)
	public ResponseEntity<Void> saveOrUpdateLookupDtl(@Valid @RequestBody LookupDtl lookupDtl, BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Look up detail doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			headers.add(ERROR, errorResult);
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		service.saveLookUpDtl(lookupDtl);
		
		headers.add(SUCCESS_MSG, "Look up detail has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lookupDtl.getLookupDtlNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}
	
	@PostMapping(LOOKUP_SAVE_MST)
	public ResponseEntity<Void> saveOrUpdateLookup(@Valid @RequestBody LookUp lookup, BindingResult result){
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Look up doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			headers.add(ERROR, errorResult);
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		lookUpService.saveLookUp(lookup);
		
		headers.add(SUCCESS_MSG, "Look up has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(lookup.getLookupNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}
	
	@GetMapping(LOOKUP_GET_ALL_LOOKUP_MST)
	public ResponseEntity<List<LookUp>> getAllLookUpInfo(){
		List<LookUp> lookUpInfos= lookUpService.getAllLookUpInfo();
		if(lookUpInfos == null || lookUpInfos.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Lookup info " + NOT_FOUND);
			
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(lookUpInfos, HttpStatus.OK);
	}
}
