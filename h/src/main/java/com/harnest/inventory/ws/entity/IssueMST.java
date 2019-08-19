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

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_ISSMST")
@Data
public class IssueMST implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUST_ISSUE_NO")
	@SequenceGenerator(sequenceName = "SEQ_ISSUE_NO", allocationSize = 1, name = "CUST_ISSUE_NO")
	@Column(name ="ISSUE_NO")
	private Integer issueNo;
	
	@Column(name ="UD_ISSUE_NO")
	private String udIssueNo;
	
	@Column(name ="ISSUEFROM_DEPT")
	private Integer issueFromDept;
	
	@Column(name ="ISSUETO_DEPT")
	private Integer issueToDept;
	
	@Column(name ="DEMAND_NO")
	private Integer demandNo;
	
	@Column(name ="HR_REF_NO")
	private Integer hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private Integer mkrRefNo;
	
	@Column(name ="MACHINE_REF")
	private Integer machineRef;
	
	@Column(name ="MACHINE_SEC")
	private String machineSec;
	
	@Column(name ="OPT_BY_NO")
	private Integer optByNo;
	
	@Column(name ="COLLT_BY")
	private Integer collectBy;
	
	@Column(name ="ISSUE_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate issueDate;
	
	@Column(name ="ISSUE_TYPE")
	private String issueType;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
	@Column(name = "SP_FLAG", columnDefinition= "CHAR(1 BYTE) DEFAULT 'P'")
	private String spFlag = "P";
	
	@Transient
	private List<IssueCHD> issueCHDList;
	
}
