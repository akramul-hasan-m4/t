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
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_UOM")
@Data
public class UnitofMeasure implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="UOM_NO")
	private Integer uomNo;
	
	@Column(name ="UD_UOM_NO")
	private String udUomNo;
	
	@Column(name ="UOM_NAME")
	private String uomName;
	
	@Column(name ="UOM_CODE")
	private String uomCode;
	
	@Column(name ="UOMCLASS_NO")
	private BigInteger udmclassNo;
	
	@Column(name ="PACKSIZE")
	private String packsize;
	
	@Column(name ="PACKSIZE_VALUE")
	private Integer packsizeValue;
	
	@Column(name ="PACKTYPE_FLAG")
	private String packtypeFlag;
	
	@Column(name ="FRACTION_FLAG")
	private String fractionFlag = "N"; //DEFAULT 'N'
	
	@Column(name ="STRENGTH_FLAG")
	private String strengthFlag;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ACTIVE_FG")
	private Integer activeFg = 1; //DEFAULT 1
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDT; //DEFAULT sysdate,
	
	@Column(name ="UPD_DT")
	private LocalDate updDT; //DEFAULT sysdate,
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="UPD_BY")
	private String updBy;
	
	@Column(name ="MOBILE_FG", columnDefinition= "integer(1) default 0")
	@Size(max = 1)
	private Integer mobileFG = 0;  // default 0
	
}
