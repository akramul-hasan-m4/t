package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "GARMENT_INFO")
@Data
public class GarmentInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="GARMENT_INFO_ID")
	private Integer garmentInfoId;
	
	@Column(name ="UD_GARMENT_ID")
	private String udGarmentId;
	
	@Column(name ="GARMENT_NAME")
	private String garmentName;
	
	@Column(name ="ADDRESS")
	private String address;
	
	@Column(name ="MOBILE")
	private String mobile;
	
	@Column(name ="FAX")
	private String fax;
	
	@Column(name ="UD_GRPGARMENT_ID")
	private String udGrpGarmentId;
	
	@Column(name ="UD_EXE_ID")
	private String udExeId;
	
	@Column(name ="UD_BUYER_ID")
	private String udBuyerID;
	
	@Column(name ="UD_ACC_ID")
	private String udAccId;
	
	@Column(name ="ACTIVE_STATUS")
	private Integer activeStatus;
	
	@Column(name ="CREATE_DATE", insertable = false, updatable = false)
	private LocalDate createDate;
	
	@Column(name ="CREATED_BY")
	private Integer createdBy;
	
	@Column(name ="UPDATE_DATE")
	private LocalDate updateDate;
	
	@Column(name ="UPDATED_BY")
	private Integer updateBy;
	
}
