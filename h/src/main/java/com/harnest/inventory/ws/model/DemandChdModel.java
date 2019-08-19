package com.harnest.inventory.ws.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandChdModel {

	private Integer demandChdNo;
	private Integer itemNo;
	private String itemName;
	private Integer uomNo;
	private String uomName;
	private Boolean isChecked;
	private Boolean isApproved;
	private Integer demandQty;
	private Integer checkQty;
	private Integer approveQty;
}
