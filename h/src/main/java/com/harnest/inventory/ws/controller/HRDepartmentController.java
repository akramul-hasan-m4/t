package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.entity.HRDepartment;
import com.harnest.inventory.ws.service.HRDepartmentService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + DEPARTMENT)
public class HRDepartmentController {
	
	private @Autowired HRDepartmentService service;
	
	@GetMapping(GET_ALL_DEPARTMENT_INFO)
	public ResponseEntity<List<HRDepartment>> getAllDepartment(){
		List<HRDepartment> list = service.getAllHRDepartmentInfo();
		
		
		if(list == null || list.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Department " + NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
