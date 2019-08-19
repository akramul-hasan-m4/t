package com.harnest.inventory.ws.controller;

import static com.harnest.inventory.ws.commons.CommonConstants.*;
import static com.harnest.inventory.ws.commons.CommonConstants.REQUISITION_ITEM_TYPE;
import static com.harnest.inventory.ws.commons.URIConstants.API;
import static com.harnest.inventory.ws.commons.URIConstants.ERROR_MSG;
import static com.harnest.inventory.ws.commons.URIConstants.GET_ALL_ITEM;
import static com.harnest.inventory.ws.commons.URIConstants.*;
import static com.harnest.inventory.ws.commons.URIConstants.GET_ITEM_BY_TYPE;
import static com.harnest.inventory.ws.commons.URIConstants.ITEM;
import static com.harnest.inventory.ws.commons.URIConstants.NOT_FOUND;
import static com.harnest.inventory.ws.commons.URIConstants.SAVE_ITEM;
import static com.harnest.inventory.ws.commons.URIConstants.SUCCESS_MSG;

import java.net.URI;
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

import com.harnest.inventory.ws.entity.Item;
import com.harnest.inventory.ws.service.ItemService;

import io.swagger.annotations.ApiOperation;
/**
 * @author Akramul
 * @since 25 jul 2019
 * @version 1.0.0
 */

@RestController
@RequestMapping(API + ITEM)
public class ItemController {
	
	@Autowired private ItemService service;
	
	@GetMapping(GET_ALL_ITEM)
	public ResponseEntity<List<Item>> getAllitems(){
		List<Item> list = service.getAllItems();
		HttpHeaders headers = new HttpHeaders();
		headers.add(ERROR_MSG, NOT_FOUND);
		
		if(list == null || list.isEmpty()) {
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@PostMapping(GET_ITEM_BY_TYPE_FLAG)
	@ApiOperation(value= "getitemByProductType", notes ="Item Flag will be F or R")
	public ResponseEntity<List<Item>> getitemByProductType(@PathVariable String flag){
		HttpHeaders headers = new HttpHeaders();
		List<Item> products = service.findByItemTypeFlag(flag);
		
		if(products == null || products.isEmpty()) {
			if(!flag.equals(REQUISITION_ITEM_TYPE) && !flag.equals(FINISHED_ITEM_TYPE)) {
				headers.add(ERROR_MSG, "Your parameter should be " + REQUISITION_ITEM_TYPE + " or " + FINISHED_ITEM_TYPE);
			}else {
				headers.add(ERROR_MSG, "Product " + NOT_FOUND);
			}
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping(GET_ITEM_BY_TYPE)
	@ApiOperation(value= "getitemByItemType", notes ="Item type will be like Nylon, Polyester, Cotton, Rubber etc")
	public ResponseEntity<List<Item>> getitemByItemType(@PathVariable String itemType){
		List<Item> products = service.findByItemType(itemType);
		
		if(products == null || products.isEmpty()) {
			HttpHeaders headers = new HttpHeaders();
			headers.add(ERROR_MSG, "Items " + NOT_FOUND);
			return new ResponseEntity<>(headers, HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(products, HttpStatus.OK);
	}
	
	@PostMapping(SAVE_ITEM)
	@ApiOperation(value= "save Item", notes ="NOTE: It will send void type response, you will find success or error message from headers")
	public ResponseEntity<Void> savePurchaseItem(@Valid @RequestBody Item item, BindingResult result){
		
		HttpHeaders headers = new HttpHeaders();
		
		if (result.hasErrors()) {
			headers.add(ERROR_MSG, "Item doesn't save");
			String errorResult = result.getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining(","));
			headers.add(ERROR, errorResult);
			ResponseEntity.badRequest().body(errorResult);
			return ResponseEntity.noContent().headers(headers).build();
		}
		String itemType = item.getItemType() == null ? "" : item.getItemType();
		String itemCount = item.getItemCount() == null ? "" : item.getItemCount();
		String itemColor = item.getItemColor() == null ? "" : item.getItemColor();
		
		
		String itemName = String.format("%s %s %s", itemType, itemCount, itemColor);
		item.setItemName(itemName);
		service.saveItem(item);
		headers.add(SUCCESS_MSG, "Item has been saved successfully");
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getItemNo()).toUri();
		headers.setLocation(location);
		
		return ResponseEntity.created(location).headers(headers).build();
		
	}
}
