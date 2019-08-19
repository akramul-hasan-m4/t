package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_ISSCHD")
@Data
public class IssueCHD implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUST_ISSUECHD_NO")
	@SequenceGenerator(sequenceName = "SEQ_ISSUECHD_NO", allocationSize = 1, name = "CUST_ISSUECHD_NO")
	@Column(name ="ISSUECHD_NO")
	private Integer issuechdNo;
	
	@Column(name ="ISSUE_NO")
	private Integer issueNo;
	
	@Column(name ="ITEM_NO")
	private Integer itemNo;
	
	@Column(name ="ISSUE_QTY")
	private Integer issueQty;
	
	@Column(name ="UOM_NO")
	private BigInteger uomNo;
	
	@Column(name ="BASE_QTY")
	private Integer baseQty;

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
	
}
