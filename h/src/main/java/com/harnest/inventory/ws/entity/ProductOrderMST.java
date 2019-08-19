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
@Table(name = "INV_POMST")
@Data
public class ProductOrderMST implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="ORDER_NO")
	private Integer orderNo;
	
	@Column(name ="UD_ORDER_NO")
	private String udOrderNo;
	
	@Column(name ="HR_REF_NO")
	private Integer hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private Integer mkrRefNo;
	
	@Column(name ="PR_DEMAND_NO")
	private Integer prDemandNo;
	
	@Column(name ="PO_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate poDate;
	
	@Column(name ="SUPPLIER_NO")
	private Integer supplierNo;
	
	@Column(name ="CRE_BY")
	@ApiModelProperty(example = "E011006000620")
	private String createdBy;
	
	@Column(name ="CRE_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createDate;
	
	@Column(name ="UPD_BY")
	private String updatedBy;
	
	@Column(name ="UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;

}
