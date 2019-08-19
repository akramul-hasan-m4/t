package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_PR_DMDCHD")
@Data
public class ProductDemandCHD implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_PR_DEMANDCHD_NO")
	@Column(name ="DEMANDCHD_NO")
	private Integer demandChdNo;
	
	@Column(name = "PR_DEMAND_NO")
	private Integer prDemandNo;
	
	@Column(name ="ITEM_NO")
	private Integer itemNo;
	
	@Column(name ="DEMAND_QTY")
	private Integer demandQty;
	
	@Column(name ="UOM_NO")
	private Integer uomNo;
	
	@Column(name ="BASE_QTY")
	private Integer baseQty;
	
	@Column(name ="PO_COM_FLAG")
	private String poComFlag;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	

	
}
