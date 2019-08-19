package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_LOOKUPDTL")
@Data
public class LookupDtl implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="CUST_LOOKUPDTL_NO_SEQ")
	@SequenceGenerator(sequenceName = "SEQ_LOOKUPDTL_NO", allocationSize = 1, name = "CUST_LOOKUPDTL_NO_SEQ")
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	@Column(name ="LOOKUPDTL_NO")
	private Integer lookupDtlNo;
	
	@Column(name ="LOOKUP_NO")
	@NotNull
	private Integer lookupNo;
	
	@Column(name ="DTL_NAME")
	@NotNull
	private String dtlName;
	
	@Column(name ="ORDER_NO")
	private Integer orderNo;
	
	@Column(name ="CHANGEABLE" , columnDefinition = "Integer DEFAULT 0")
	@ApiModelProperty(example = "0")
	private Integer changeable = 0;
	
	@Column(name ="ACTIVE_FLAG" , columnDefinition = "Integer DEFAULT 1")
	@ApiModelProperty(example = "1")
	private Integer activeFlag = 1;
	
	@Column(name ="REMARKS")
	@ApiModelProperty(example = "Test Remarks")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	@ApiModelProperty(example = "No need to insert")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a")
	private LocalDateTime createDate;  //DEFAULT SYSDATE
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@ApiModelProperty(example = "2019-01-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
}
