package com.harnest.inventory.ws.controller;
import static com.harnest.inventory.ws.commons.URIConstants.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.harnest.inventory.ws.service.StockService;

/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + STOCK)
public class StockController {
	
	private @Autowired StockService stockService;
	
	@GetMapping(CHECK_STOCK_QTY)
	public ResponseEntity<Integer> checkStockQuantitity(@RequestParam("itemNo") Integer itemNo, @RequestParam("deptNo") Integer deptNo){
		Integer availableQty = stockService.checkStockQuantity(itemNo, deptNo);
		return new ResponseEntity<>(availableQty, HttpStatus.OK);
	}

}
