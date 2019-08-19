package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
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
@Table(name = "INV_UOMCLASS")
@Data
public class UOMClass implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="UOMCLASS_NO")
	private BigInteger uomClassNo;
	
	@Column(name ="UD_UOMCLASS_NO")
	private String udUomClassNo;
	
	@Column(name ="UOMCLASS_NAME")
	private String uomClassName;
	
	@Column(name ="UOM_METHODNO")
	private BigInteger uomMethod;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ACTIVE_FG")
	private Integer activeFlag;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	private LocalDate updateDate;
	
}
