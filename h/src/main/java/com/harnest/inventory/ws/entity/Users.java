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

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "SA_USERS")
@Data
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Integer userId;

	@Column(name = "ID_NO")
	private String idNo;

	@Column(name = "DESIGNATION_ID")
	private Integer designationId;

	@Column(name = "USERNAME")
	private String username;

	@Column(name = "RANK")
	private String rank;

	@Column(name = "USERPW")
	private String userpw;

	@Column(name = "EXPR_DT")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate exprDt;

	@Column(name = "ORG_ID")
	private Integer orgId;

	@Column(name = "USERGRP_ID")
	private Integer usergrpId;

	@Column(name = "USERLVL_ID")
	private Integer userlvlId;

	@Column(name = "HOSTSTR")
	private String hoststr;

	@Column(name = "USERTYPE")
	private String usertype;

	@Column(name = "SALUTATION_ID")
	private String salutationId;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "FULL_NAME")
	private String fullName;

	@Column(name = "JOBROLE_ID")
	private Integer jobroleId;

	@Column(name = "DEPT_ID")
	private Integer deptId;

	@Column(name = "DESIG_ID")
	private Integer desigId;

	@Column(name = "AREA_ID")
	private Integer areaId;

	@Column(name = "ROAD_ID")
	private Integer roadId;

	@Column(name = "HOLDING_ID")
	private Integer holdingId;

	@Column(name = "FLAT_ID")
	private Integer flatId;

	@Column(name = "EMP_ID")
	private Integer empId;

	@Column(name = "MOBILE")
	private String mobile;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "UNT_ID")
	private Integer untId;

	@Column(name = "USERIMG")
	private String userimg;

	@Column(name = "ACTIVE_STATUS")
	private Integer activeStatus;

	@Column(name = "PUBIC_FLAG")
	private Integer pubicFlag;

	@Column(name = "CREATE_DATE", insertable = false, updatable = false)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate createDate;

	@Column(name = "CREATED_BY")
	private BigInteger createdBy;

	@Column(name = "UPDATE_DATE")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate updateDate;

	@Column(name = "UPDATED_BY")
	private BigInteger updatedBy;

	@Column(name = "USER_TYPE")
	private Integer userTypeNo;

	@Column(name = "SUB_PROJ_ID")
	private Integer subProjId;

	@Column(name = "PROFILE_PIC_NAME")
	private String profilePicName;

	@Column(name = "GENDER")
	private String gender;

	@Column(name = "IS_ADMIN")
	private String isAdmin;

	@Column(name = "UPDATE_BY")
	private Integer updateBy;

	@Column(name = "EMP_NO")
	private String empNo;

}
