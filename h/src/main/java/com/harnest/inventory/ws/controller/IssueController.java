package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.ISSUE;
import static com.harnest.inventory.ws.commons.URIConstants.ISSUE_SAVE;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;

import java.net.URI;
import java.time.LocalDate;
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

import com.harnest.inventory.ws.entity.IssueMST;
import com.harnest.inventory.ws.service.IssueCHDService;
import com.harnest.inventory.ws.service.IssueMSTService;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + ISSUE)
public class IssueController {
	
	private @Autowired IssueMSTService mstService;
	private @Autowired IssueCHDService chdService;
	
	@PostMapping(ISSUE_SAVE)
	public ResponseEntity<Void> saveIssue(@Valid @RequestBody IssueMST issueMST, BindingResult result){
		
		HttpHeaders headers = new HttpHeaders();
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Isuue doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		
		issueMST.setUdIssueNo(String.valueOf(System.currentTimeMillis()));
		issueMST.setIssueDate(LocalDate.now());
		
		mstService.saveIssueMST(issueMST);
		Integer issueMstId = issueMST.getIssueNo();
	
		if(issueMST != null && !issueMST.getIssueCHDList().isEmpty()) {
			issueMST.getIssueCHDList().forEach(chd -> {
				chd.setIssueNo(issueMstId);
				chdService.saveIssueCHDData(chd);
			});
		}
		headers.add(SUCCESS_MSG, "Issue has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(issueMstId).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
	}

}
