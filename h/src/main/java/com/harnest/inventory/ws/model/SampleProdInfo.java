package com.harnest.inventory.ws.model;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleProdInfo {

	private Integer sampleChdId;
	private Integer sampleMstId;
	private Integer buyerNo;
	private String buyerName;
	private Integer qty;
	private Integer exeId;
	private String exeName;
	private Integer labelId;
	private String labelName;
	private LocalDate deliveryDate;
}
