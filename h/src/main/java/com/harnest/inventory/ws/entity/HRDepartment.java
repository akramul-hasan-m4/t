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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "HR_DEPT")
@Data
public class HRDepartment implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_PR_Demand_no")
	@Column(name ="DEPT_NO")
	private Integer deptNo;
	
	@Column(name ="DEPT_NAME")
	@NotNull
	private String deptName;
	
	@Column(name ="HR_ORGANID")
	@NotNull
	private Integer hrOrganId;
	
	@Column(name ="PARENT_DEPT")
	private Integer parentDept;
	
	@Column(name ="LOCATION")
	private Integer location;
	
	@Column(name ="ACTIVE_FLAG")
	private String activeFlag;
	
	@Column(name ="SUPERVISOR")
	private String supervisor;
	
	@Column(name ="EFFECTIVE_DATE")
	private LocalDate effectiveDate;

	@Column(name ="POSTING_PTO")
	private String postingPTO;
	
	@Column(name ="ENTERED_BY")
	@ApiModelProperty(example = "E011006000620")
	private String enteredBy;
	
	@Column(name ="ENTRY_TIMESTAMP", insertable = false, updatable = false)
	private LocalDate entryTimestamp; //DEFAULT SYSDATE,
	
	@Column(name ="UPDATE_BY")
	private String updatedBy;
	
	@Column(name ="UPDATED_TIMESTAMP")
	private LocalDate updatedTimestamp;

	@Column(name ="NO_OFUPDATION")
	private Integer noOfUpdation;
	
	@Column(name ="AREA_TYPE_NO")
	private Integer areaTypeNo;
	
	@Column(name ="OLD_DEPTNO")
	private String oldDeptNo;
	
	@Column(name ="DEPT_TYPE")
	private String deptType;
	
	@Column(name ="DEPT_DESC")
	private String deptDesc;
	
	@Column(name ="TOTAL_STRENGTH_NEEDED")
	private Integer totalStrengthNeeded;
	
	@Column(name ="USER_DEFINE_DEPT_NO")
	private String userDefineDeptNo;
	
	@Column(name ="PR_FLAG")
	private String prFlag;
	
	@Column(name ="PR_RCV_FLAG")
	private String prRcvFlag;
	
	@Column(name ="PO_FLAG")
	private String poFlag;
	
	@Column(name ="COMPANY_NO")
	private String companyNo;
	
	@Column(name ="AUTO_COST_CENTER_NO")
	private String autoCostCenterNo;
	
	@Column(name ="RATECNTR_CODE")
	private Integer ratecntrCode;

}
