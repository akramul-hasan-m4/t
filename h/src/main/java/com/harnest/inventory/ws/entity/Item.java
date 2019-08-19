package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "INV_ITEM")
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Item implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="CUST_ITEM_NO_SEQ")
	@SequenceGenerator(sequenceName = "SEQ_ITEM_NO", allocationSize = 1, name = "CUST_ITEM_NO_SEQ")
	@ApiModelProperty(example = "Do not need to insert, just ignore it")
	@Column(name ="ITEM_NO")
	private Integer itemNo;
	
	@Column(name ="UD_ITEM_NO")
	private String udItemNo;
	
	@Column(name ="ITEM_NAME")
	private String itemName;
	
	@Column(name ="DESCRIPTION")
	private String description;
	
	@Column(name ="BATCH_REQUIRED")
	private Integer batchRequired;
	
	@Column(name ="EXPIREABLE")
	private Integer expirable;
	
	@Column(name ="REPLACEABLE")
	private Integer replaceable;
	
	@Column(name ="REPAIRABLE")
	private Integer repairable;
	
	@ApiModelProperty(example = "G")
	@Column(name ="IDENTIFY_TYPE", columnDefinition = "VARCHAR2(1 BYTE) DEFAULT 'G'")
	private String identityType = "G"; // DEFAULT 'G'
	
	@Column(name ="PARENT_ITEM_NO")
	private Integer parentItemNo;
	
	@Column(name ="UOM_NO")
	private Integer uomNo;
	
	@Column(name ="METHOD_NO")
	private Integer methodNo;
	
	@Column(name ="GROUP_NO")
	private Integer groupNo;
	
	@Column(name ="SUPPLIER_NO")
	private Integer supplierNo;
	
	@Column(name ="COUNTRY_NO")
	private Integer countryNo;
	
	@Column(name ="BRAND_NAME")
	private String brandName;
	
	@Column(name ="MODEL_NAME")
	private String modelName;
	
	@Column(name ="MIN_LEVEL")
	private Integer minLevel;
	
	@Column(name ="MAX_LEVEL")
	private Integer maxLevel;
	
	@Column(name ="REORDER_LEVEL")
	private Integer reorderLevel;
	
	@Column(name ="REORDER_DAYS")
	private Integer reorderDays;
	
	@Column(name ="LEAD_DAYS")
	private Integer leadDays;
	
	@Column(name ="SHELF_LIFE")
	private Integer shelfLife;
	
	@Column(name ="ALERT_DAYS")
	private Integer alertDays;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@ApiModelProperty(example = "0")
	@Column(name ="ITEM_FG", columnDefinition = "NUMBER(1) DEFAULT 0")
	private Integer itemFG = 0; 	//DEFAULT 0,
	
	@ApiModelProperty(example = "1")
	@Column(name ="ACTIVE_FG", columnDefinition = " NUMBER(1) DEFAULT 1")
	private Integer activeFG = 1; 	//DEFAULT 1,
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDT; 	//DEFAULT sysdate,
	
	@Column(name ="UPD_DT")
	private LocalDate updDT; 
	
	@Column(name ="UNIT_PRICE")
	private Double unitPrice; 
	
	@Column(name ="MRP_PRICE")
	private Double mrpPrice; 
	
	@Column(name ="UPD_BY")
	private String updBy; 
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy; 
	
	@Column(name ="ITEM_TYPE")
	private String itemType; 
	
	@Column(name ="CATEGORY_ID")
	private Integer categoryId; 
	
	@Column(name ="ITEM_TYPE_FLAG")
	@Size(max = 1)
	private String itemTypeFlag = "R"; 
	
	@Column(name ="ITEM_COLOR")
	private String itemColor; 
	
	@Column(name ="ITEM_COUNT")
	private String itemCount; 
	
	@Column(name ="ITEM_DEPT")
	private BigInteger itemDept; 
	
}
