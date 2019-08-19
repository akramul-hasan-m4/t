package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
@Table(name = "INV_FG_QC")
@Data
public class FinishedGoodsQC implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="CUST_SEQ_FG_NO")
	@SequenceGenerator(sequenceName = "SEQ_FG_NO", allocationSize = 1, name = "CUST_SEQ_FG_NO")
	@Column(name ="FG_NO")
	@ApiModelProperty(example = "pK No need to send just remove it")
	private BigInteger fgNo;
	
	@Column(name ="UD_FG_NO")
	@ApiModelProperty(example = "This is uniq user define key")
	private String udFgNo;
	
	@Column(name ="FG_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(example = "2019-01-15")
	private LocalDate fgDate;
	
	@Column(name ="FROM_DEPT")
	private Integer fromDept;
	
	@Column(name ="TO_DEPT")
	private Integer toDept;
	
	@Column(name ="HR_REF_NO")
	private BigInteger hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private BigInteger mkrRefNo;
	
	@Column(name ="MACHINE_REF")
	private BigInteger machineRef;
	
	@Column(name ="MACHINE_SEC")
	private String machineSec;
	
	@Column(name ="OPT_BY_NO")
	private BigInteger optByNo;
	
	@Column(name ="COLLT_BY")
	private BigInteger collectBy;
	
	@Column(name ="ITEM_NO")
	private BigInteger itemNo;
	
	@Column(name ="UOM_NO")
	private BigInteger uomNo;
	
	@Column(name ="ISSUE_QTY")
	private Integer issueQty;
	
	@Column(name ="PRE_QC_FLAG")
	@ApiModelProperty(example = "Y")
	private String preQcFlag;
	
	@Column(name ="PRE_QC_BY")
	private String preQcBy;
	
	@Column(name ="PRE_QC_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@ApiModelProperty(example = "2019-01-15")
	private LocalDate preQcDate;
	
	@Column(name ="PRE_QC_QTY")
	private Integer preQcQty;
	
	@Column(name ="PRE_QCUOM_NO")
	private BigInteger preQcuomNo;
	
	@Column(name ="QC_APV_FLAG")
	@ApiModelProperty(example = "N")
	private String qcAProveFlag;
	
	@Column(name ="QC_APV_BY")
	private String qcAProveBy;
	
	@Column(name ="QC_APV_DATE")
	@ApiModelProperty(example = "2019-01-15")
	private LocalDate qcAProveDate;
	
	@Column(name ="QC_APV_QTY")
	private Integer qcAProveQty;
	
	@Column(name ="QC_APVUOM_NO")
	private BigInteger qcApvuomNo;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ENTRY_BY")
	@ApiModelProperty(example = "E011006000620")
	private String entryBy;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	@ApiModelProperty(example = "No need to send remove it")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a")
	private LocalDateTime entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@ApiModelProperty(example = "need when update otherwish remove it")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;

}
