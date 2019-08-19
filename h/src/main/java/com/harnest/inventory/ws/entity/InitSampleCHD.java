package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "INIT_SAMPLE_CHD")
@Data
public class InitSampleCHD implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_PR_Demand_no")
	@Column(name ="SAMPLE_CHD_ID")
	private Integer sampleChdId;
	
	@Column(name ="SAMPLE_MST_ID")
	@NotNull
	private Integer sampleMstId;
	
	@Column(name ="BUYER_ID")
	@NotNull
	private Integer buyerId;
	
	@Column(name ="QTY")
	private Integer qty;
	
	@Column(name ="LABEL_TYPE")
	private Integer labelType;
	
	@Column(name ="REMARK")
	private String remarks;
	
	@Column(name ="EXP_DLVRY_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate expDeliveryDate;
	
	@Column(name ="ACTIVE_STATUS")
	private Integer activeStatus = 1;  //DEFAULT 1 
	
	@Column(name ="CONTACT_PERSON")
	private String contactPerson;
	
	@Column(name ="CONTACT_NO")
	private String contactNo;
	
	@Column(name ="DEVELOP_STATUS")
	private Integer developStatus = 0;  //DEFAULT 0
	
	@Column(name ="VERIFY_STATUS")
	private Integer verifyStatus = 0;  //DEFAULT 0
	
	@Column(name ="FINAL_SAMPLE_STATUS")
	private Integer finalSampleStatus = 0;  //DEFAULT 0
	
}
