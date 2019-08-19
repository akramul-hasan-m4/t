package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.EXECUTIVE;
import static com.harnest.inventory.ws.commons.URIConstants.GET_ALL_EXECUTIVE;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.ExecutiveInfo;
import com.harnest.inventory.ws.service.ExecutiveInfoService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + EXECUTIVE)
public class ExecutiveInfoController {
	
	@Autowired private ExecutiveInfoService service;
	
	@PostMapping(GET_ALL_EXECUTIVE)
	public ResponseEntity<List<ExecutiveInfo>> getAllExecutive(){
		List<ExecutiveInfo> exeList = service.getAllExecutiveInfo();
		
		if(exeList == null || exeList.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Executive " +NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(exeList, HttpStatus.OK);
	}

}
