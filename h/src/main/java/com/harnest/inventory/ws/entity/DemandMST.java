package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_DMDMST")
@Data
public class DemandMST implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="CUST_DEMAND_NO_SEQ")
	@SequenceGenerator(sequenceName = "SEQ_DEMAND_NO", allocationSize = 1, name = "CUST_DEMAND_NO_SEQ")
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	@Column(name ="DEMAND_NO")
	private Integer demandNo;
	
	@Column(name ="UD_DEMAND_NO") 
	@ApiModelProperty(example = "It is unique property, if don't need , just ignore it")
	private String udDemandNo;
	
	@Column(name ="HR_REF_NO")
	private Integer hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private Integer mkrRefNo;
	
	@Column(name ="BUYER_NO")
	private Integer buyerNo;
	
	@Column(name ="MACHINE_REF")
	private Integer machineRef;
	
	@Column(name ="MACHINE_SEC")
	private String machineSec;
	
	@Column(name ="OPT_BY_NO")
	private Integer optByNo;
	
	@Column(name ="COLLT_BY")
	private Integer collectBy;
	
	@Column(name ="DEMAND_DATE")
	@ApiModelProperty(example = "2019-08-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate demandDate;
	
	@Column(name ="DEMANDFOR_DEPT")
	private Integer demandForDept;
	
	@Column(name ="DEMANDTO_DEPT")
	private Integer demandToDept;
	
	@Column(name ="EXPCTD_DLVRY_DATE")
	@ApiModelProperty(example = "2019-05-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expectedDeliveryDate;
	
	@Column(name ="DEMAND_TYPE")
	@ApiModelProperty(example = "S")
	@Size(max = 1)
	private String demandType;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "current logdin user code")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	@ApiModelProperty(example = "Do not need for insert, just ignore it")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@ApiModelProperty(example = "2019-05-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
	@Column(name = "SP_FLAG", columnDefinition= "CHAR(1 BYTE) DEFAULT 'P'")
	private String spFlag = "p";
	
	@Transient
	@JsonInclude
	private String status;
	
	@Transient
	private List<DemandCHD> demandCHDList;
	
}
