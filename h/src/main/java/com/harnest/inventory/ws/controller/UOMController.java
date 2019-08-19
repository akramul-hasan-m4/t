package com.harnest.inventory.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.UnitofMeasure;
import com.harnest.inventory.ws.service.UOMService;
import static com.harnest.inventory.ws.commons.URIConstants.*; 
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + UOM)
public class UOMController {
	
	@Autowired private UOMService service;

	@GetMapping(GET_ALL_ACTIVE_UOM)
	public ResponseEntity<List<UnitofMeasure>> getAllUOM(){
		List<UnitofMeasure> list = service.findAllByActiveFgAndMobileFG(1, 1);
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list,HttpStatus.OK);
	}
}
