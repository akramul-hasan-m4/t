package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_UOMCONVERSION")
@Data
public class UOMConversion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CONVERT_NO")
	private Integer convertNo;
	
	@Column(name ="UD_CONVERT_NO")
	private String udConvertNo;
	
	@Column(name ="CONVERT_FROM")
	private Integer convertFrom;
	
	@Column(name ="CONVERT_TO")
	private Integer convertTo;
	
	@Column(name ="CONVERT_QTY")
	private Integer convertQty;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ACTIVE_FG")
	private Integer activeFG = 1; //DEFAULT 1
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDT;
	
	@Column(name ="UPD_DT")
	private LocalDate updDT;
	
	@Column(name ="UPD_BY")
	private String updBy;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
}
