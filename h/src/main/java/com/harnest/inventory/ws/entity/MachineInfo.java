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
@Table(name = "MACHINE_INFO")
@Data
public class MachineInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="MACHINE_ID")
	private Integer machineId;
	
	@Column(name ="MACHINE_CODE")
	private String machineCode;
	
	@Column(name ="MACHINE_TYPE")
	private String machineType;
	
	@Column(name ="CREATE_DATE", insertable = false, updatable = false)
	private LocalDate createDate;
	
	@Column(name ="CREATED_BY")
	@ApiModelProperty(example = "E011006000620")
	private Integer createdBy;
	
	@Column(name ="UPDATE_DATE")
	private LocalDate updateDate;
	
	@Column(name ="UPDATED_BY")
	private Integer updatedBy;
	
	@Column(name ="ACTIVE_STATUS")
	private Integer activeStatus;

}
