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

import lombok.Data;

@Entity
@Table(name = "INIT_SAMPLE_MST")
@Data
public class InitSampleMST implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_PR_Demand_no")
	@Column(name ="SAMPLE_MST_ID")
	private Integer sampleMstId;
	
	@Column(name ="GARMENTS_ID")
	@NotNull
	private Integer garmentsId;
	
	@Column(name ="CRE_BY")
	@NotNull
	private Integer createdBy;
	
	@Column(name ="CRE_DT", insertable = false, updatable = false)
	private LocalDate createDate;
	
	@Column(name ="UPD_BY")
	private Integer updateBy;
	
	@Column(name ="UPD_DT")
	private LocalDate updateDate;
	
	@Column(name ="REMARK")
	private String remark;

}
