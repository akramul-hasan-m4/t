package com.harnest.inventory.ws.model;

import java.math.BigDecimal;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BalanceReport {
	
	private BigDecimal deptNo;
	
	private String deptName;
	
	private BigDecimal itemNo;
	
	private String itemName;
	
	private String udItemNo;
	
	private BigDecimal groupNo;
	
	private String groupName;
	
	private BigDecimal opBalance;
	
	private BigDecimal prBalance;
	
	private BigDecimal clBalance;
	
	private BigDecimal inQty;
	
	private BigDecimal outQty;
	
	private String rcShow;
	
	private String uomName;
	
	private List<BalanceReport> deptlist;

}
