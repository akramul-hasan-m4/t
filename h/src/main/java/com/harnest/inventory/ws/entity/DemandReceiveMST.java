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
@Table(name = "INV_DMDRCVMST")
@Data
public class DemandReceiveMST implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="DMDRCV_NO")
	private Integer demandRcvNo;
	
	@Column(name ="ISSUEFROM_DEPT")
	private Integer issueFromDept;
	
	@Column(name ="RECEIVED_DEPT")
	private Integer receivedDept;
	
	@Column(name ="ISSUE_NO")
	private Integer issueNo;
	
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
	
	@Column(name ="RCV_DATE")
	private LocalDate receiveDate;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	private LocalDate updateDate;

}
