package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_DMDCHD")
@Data
public class DemandCHD implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="CUST_SEQ")
	@SequenceGenerator(sequenceName = "SEQ_DEMANDCHD_NO", allocationSize = 1, name = "CUST_SEQ")
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	@Column(name = "DEMANDCHD_NO")
	private Integer demandChildNo;

	@Column(name = "DEMAND_NO")
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	private Integer demandNo;
	 
	@Column(name = "ITEM_NO")
	private Integer itemNo;

	@Column(name = "DEMAND_QTY")
	private Integer demandQty;

	@Column(name = "UOM_NO")
	private Integer uomNo;

	@Column(name = "BASE_QTY")
	private Integer baseQty;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "ENTRY_BY")
	@ApiModelProperty(example = "Current Logdin user code")
	private String entryBy;

	@Column(name = "ENTRY_DT", insertable = false, updatable = false)
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate entryDate; // DEFAULT sysdate,

	@Column(name = "UPD_BY")
	private String updateBy;

	@Column(name = "UPD_DT")
	@ApiModelProperty(example = "2019-05-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
	@Column(name = "CHECK_QTY")
	private Integer checkQty;
	
	@Column(name = "CHECK_BY")
	private String checkBy;
	
	@Column(name = "CHECK_DT")
	@ApiModelProperty(example = "2019-05-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate checkDate;
	
	@Column(name = "APPROVED_QTY")
	private Integer approvedQty;
	
	@Column(name = "APPROVED_BY")
	private String approvedBy;
	
	@Column(name = "APPROVED_DT")
	@ApiModelProperty(example = "2019-05-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate approvedDate;
	
}
