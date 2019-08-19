package com.harnest.inventory.ws.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DemandMstModel {
	
	private Integer demandMstId;
	private Integer buyerId;
	private String buyerName;
	private Integer labelId;
	private String labelName;
	private Integer executiveId;
	private String executiveName;
	private Integer machineRef;
	private String machineSec;
	private List<DemandChdModel> chdList;

}
