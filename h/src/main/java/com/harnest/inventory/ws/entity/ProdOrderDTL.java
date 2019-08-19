package com.harnest.inventory.ws.entity;

import java.io.Serializable;
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
@Table(name = "PRODORDER_DTL")
@Data
public class ProdOrderDTL implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="PROD_ID")
	private String prodId;
	
	@Column(name ="REFERENCE_NO")
	private String referenceNo;
	
	@Column(name ="CATEGORY_CODE")
	private String categoryCode;
	
	@Column(name ="CATEGORY_NAME")
	private String categoryName;
	
	@Column(name ="DESCR")
	private String descr;
	
	@Column(name ="CAOWN")
	private String caown;
	
	@Column(name ="SIZE1")
	private String size1;
	
	@Column(name ="QTY")
	private Integer qty;
	
	@Column(name ="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name ="TOTAL_AMTUS")
	private Double totalAmtus;
	
	@Column(name ="TOTAL_AMT")
	private Double totalAmount;
	
	@Column(name ="DELIVERY_STATUS")
	private String deliveryStatus;
	
	@Column(name ="UNIT")
	private String unit;
	
	@Column(name ="PAYMENT_MODE")
	private String paymentMode;
	
	@Column(name ="PRODUCTION_START")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate productionStart;

	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="CRE_BY")
	@ApiModelProperty(example = "E011006000620")
	private String createBy;
	
	@Column(name ="CRE_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createDate; //DEFAULT SYSDATE
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
	@Column(name ="SAMPL_EIMAGE")
	private String sampleImage;
	
	@Column(name ="ACTIVE_STATUS")
	private Integer activeStatus = 1;  //DEFAULT 1
	
	@Column(name ="UDPSI_NUM")
	private Integer udpsiNum;
	
}
