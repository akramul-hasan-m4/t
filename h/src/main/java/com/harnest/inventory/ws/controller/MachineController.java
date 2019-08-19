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

import com.harnest.inventory.ws.entity.MachineInfo;
import com.harnest.inventory.ws.service.MachineService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + MACHINE)
public class MachineController {
	
	@Autowired private MachineService service;
	
	@PostMapping(GET_ALL_MACHINE)
	public ResponseEntity<List<MachineInfo>> getAllMachine(){
		List<MachineInfo> machineList = service.getAllMaqchine();
		
		if(machineList == null || machineList.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Machine " + NOT_FOUND);
			
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(machineList, HttpStatus.OK);
	}

}
