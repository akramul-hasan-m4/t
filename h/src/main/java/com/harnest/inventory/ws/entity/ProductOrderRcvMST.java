package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_PO_RCVMST")
@Data
@ApiModel(description="All details about purchase receive master table")
public class ProductOrderRcvMST implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="CUST_SEQ")
	@SequenceGenerator(sequenceName = "SEQ_RCV_NO", allocationSize = 1, name = "CUST_SEQ")
	@Column(name ="RCV_NO")
	private Integer rcvNo;
	
	@Column(name ="ORDER_NO")
	private BigInteger orderNo;
	
	@Column(name ="HR_REF_NO")
	private BigInteger hrRefNo;
	
	@Column(name ="MKR_REF_NO")
	private BigInteger mkrRefNo;
	
	@NotNull
	@Column(name ="CHALAN_NO")
	private String chalanNo;
	
	@Column(name ="RCV_DATE")
	@ApiModelProperty(example = "2019-01-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate rcvDate;
	
	@Column(name ="RCV_DEPT")
	private BigInteger rcvDept;
	
	@ApiModelProperty(notes="rcvType should have Max 1 characters", example = "P", required = true, position = 1)
	@Column(name ="RCV_TYPE")
	private String rcvType;
	
	@Column(name ="SUPPLIER_NO")
	private BigInteger supplierNo;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="CRE_BY")
	@ApiModelProperty(example = "E011006000619")
	private String createBy;
	
	@Column(name ="CRE_DT", insertable = false, updatable = false)
	@ApiModelProperty(example = "2019-01-15 09:22:15 AM")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss a")
	private LocalDateTime createDate;  //DEFAULT SYSDATE
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
	@Column(name ="UPD_DT")
	@ApiModelProperty(example = "2019-01-15")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;
	
	@Transient
	private List<ProductOrderRcvCHD> prodOrderChdList;

}
