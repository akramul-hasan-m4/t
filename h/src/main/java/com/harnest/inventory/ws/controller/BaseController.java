package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.BASE_URL;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(BASE_URL)
public class BaseController {
	
	@Autowired private SessionRegistry sessionRegistry;
	
	@GetMapping()
	public String hello(HttpServletRequest request) {
		System.out.println("test ctrl "+request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath());
		return "Harnest Web Service By @ATI Mobile Apps Team"; 
	}
	
	@GetMapping("/user-principle")
	@PreAuthorize("#oauth2.hasScope('read') and hasRole('ROLE_Productions')")
	public Principal  user(Principal  principal) {
		return principal;
	}
	
	@GetMapping("/get-loggedin-user")
	public List<UserDetails> findAllLoggedInUsers() {
		return sessionRegistry
				.getAllPrincipals()
				.stream()
				.filter(principal -> principal instanceof UserDetails)
				.map(UserDetails.class::cast)
				.collect(Collectors.toList());
	}
	
}
