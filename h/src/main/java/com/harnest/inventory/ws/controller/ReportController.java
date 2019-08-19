package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.URIConstants.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.model.BalanceParam;
import com.harnest.inventory.ws.model.BalanceReport;
import com.harnest.inventory.ws.service.ReportService;

import io.swagger.annotations.ApiOperation;


/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + REPORT)
public class ReportController {
	
	private @Autowired ReportService reportService;
	
	@PostMapping(REPORT_BALANCE)
	@ApiOperation(value="get balance report", notes="Which item you want to see, send that item others param will be empty.\n"
			+ "Date format should be dd-MON-yyyy (30-Jul-2019)")
	public ResponseEntity<List<BalanceReport>> getBalanceReport(@RequestBody BalanceParam param){
		
		List<BalanceReport> balanceList = reportService.getBanceReport(param);
		if(balanceList == null || balanceList.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(balanceList, HttpStatus.OK);
	}
}
