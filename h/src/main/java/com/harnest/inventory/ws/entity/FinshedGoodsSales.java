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
@Table(name = "INV_FG_SALES")
@Data
public class FinshedGoodsSales implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="SALES_NO")
	private Integer salesNo;
	
	@Column(name ="UD_SALES_NO")
	private String udSalesNo;
	
	@Column(name ="SALES_DATE")
	private LocalDate salesDate;
	
	@Column(name ="SALES_DEPT")
	private Integer salesDept;
	
	@Column(name ="BUYER_NO")
	private Integer buyerNo;
	
	@Column(name ="HR_REF_NO")
	private Integer hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private Integer mkrRefNo;
	
	@Column(name ="MEMO_NO")
	private String memoNo;

	@Column(name ="ITEM_NO")
	private Integer itemNo;
	
	@Column(name ="SALES_UNIT_PRICE")
	private Double salesUnitPrice;
	
	@Column(name ="VAT_PCT")
	private Double vatPercentage;
	
	@Column(name ="VAT_AMT")
	private Double vatAmount;
	
	@Column(name ="DISC_PCT")
	private Double discountPercentage;
	
	@Column(name ="DISC_AMT")
	private Double discountAmount;
	
	@Column(name ="SALES_QTY")
	private Integer salesQty;
	
	@Column(name ="UOM_NO")
	private Integer uomNo;
	
	@Column(name ="VERIFY_FLAG")
	private String verifyFlag;
	
	@Column(name ="VERIFY_BY")
	private String verifyBy;
	
	@Column(name ="VERIFY_DATE")
	private LocalDate verifyDate;
	
	@Column(name ="VERIFY_QTY")
	private Integer verifyQty;
	
	@Column(name ="VERIFY_UOM_NO")
	private Integer verifyUomNo;
	
	@Column(name ="REMARKS")
	private String remarks;
	
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
