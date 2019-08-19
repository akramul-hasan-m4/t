package com.harnest.inventory.ws.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LookupDTLModel {
	
	private BigDecimal lookupDtlNo;
	private BigDecimal lookupNo;
	private String lookupName;
	private String dtlName;
	private BigDecimal orderNo;
	private BigDecimal changeable;
	private BigDecimal activeFlag;
}
