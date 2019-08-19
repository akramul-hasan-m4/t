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

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_POCHD")
@Data
public class ProductOrderCHD implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PO_CHDNO")
	private Integer poChdno;
	
	@Column(name ="ORDER_NO")
	private String orderNo;
	
	@Column(name ="ITEM_NO")
	private Integer itemNo;
	
	@Column(name ="PO_QTY")
	private Integer poQty;
	
	@Column(name ="UOM_NO")
	private BigInteger uomNo;
	
	@Column(name ="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name ="BASE_QTY")
	private Integer baseQty;
	
	@Column(name ="DISC_PCT")
	private Double discountPercentage;
	
	@Column(name ="DISC_AMT")
	private Double discountAmount;
	
	@Column(name ="VAT_PCT")
	private Double vatPercentage;
	
	@Column(name ="VAT_AMT")
	private Double vatAmount;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="CRE_BY")
	@ApiModelProperty(example = "E011006000620")
	private String createBy;
	
	@Column(name ="CRE_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createDate;  //DEFAULT SYSDATE
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
}
