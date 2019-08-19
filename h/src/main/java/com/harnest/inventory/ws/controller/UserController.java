package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.GET_USER_INFO;
import static com.harnest.inventory.ws.commons.URIConstants.USER;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.model.UserInfo;
import com.harnest.inventory.ws.service.UserService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + USER)
public class UserController {
	
	@Autowired private UserService service;
	
	@PostMapping(GET_USER_INFO)
	public ResponseEntity<UserInfo> getUserInfo(@PathVariable String username) {
		UserInfo user = service.getUserInfo(username);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, "User " + NOT_FOUND);
		
		if(user == null) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
}
