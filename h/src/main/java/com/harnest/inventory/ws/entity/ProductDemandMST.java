package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_PR_DMDMST")
@Data
public class ProductDemandMST implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator= "SEQ_PR_Demand_no")
	@Column(name ="PR_DEMAND_NO")
	private Integer prDemandNo;
	
	@Column(name ="UD_DEMAND_NO")
	private String udDemandNo;
	
	@Column(name ="DEMAND_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate demandDate;
	
	@Column(name ="DEMANDFOR_DEPT")
	private BigInteger demandForDept;
	
	@Column(name ="DEMANDTO_DEPT")
	private BigInteger demandToDept;
	
	@Column(name ="HR_REF_NO")
	private Integer hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private Integer mkrRefNo;
	
	@Column(name ="MACHINE_REF")
	private Integer machineRef;
	
	@Column(name ="BUYER_NO")
	private Integer buyerNo;
	
	@Column(name ="MACHINE_SEC")
	private String machineSec;
	
	@Column(name ="OPT_BY_NO")
	private Integer optByNo;
	
	@Column(name ="COLLT_BY")
	private Integer collectBy;
	
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
	
	@Column(name ="F_GOODS_TYPE")
	private Integer finishGoodsType;
	
	@Column(name ="F_GOODS_QTY")
	private Integer finishGoodsQty;
	
	@Column(name ="F_GOODS_UOM_NO")
	private Integer finishGoodsUOMNo;
	
	@JsonInclude()
	@Transient
	private List<ProductDemandCHD> demandCHDitems;
	
}
