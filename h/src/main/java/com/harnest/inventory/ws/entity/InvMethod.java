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
@Table(name = "INV_METHOD")
@Data
public class InvMethod implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="METHOD_NO")
	private Integer methodNo;
	
	@Column(name ="UD_METHOD_NO")
	private String udMethodNo;
	
	@Column(name ="METHOD_NAME")
	private String methodName;
	
	@Column(name ="METHOD_DESC")
	private String methodDescription;
	
	@Column(name ="METHOD_KEY")
	private String methodKey;
	
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
