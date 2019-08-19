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
@Table(name = "CATEGORY_INFO")
@Data
public class CategoryInfo implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="CATEGORY_ID")
	private Integer categoryId;
	
	@Column(name ="CATEGORY_CODE")
	private String categoryCode;
	
	@Column(name ="CATEGORY_NAME")
	private String categoryName;
	
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
