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
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "INV_MSTOCK")
@Data
public class Stock implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="STOCK_NO")
	private BigInteger stockNo;
	
	@Column(name ="TRAN_ID")
	private BigInteger transectionId;
	
	@Column(name ="TRAN_DATE")
	private LocalDate transectionDate;
	
	@Column(name ="TRAN_FLAG")
	private String transectionFlag;
	
	@NotNull
	@Column(name ="DEPT_NO")
	private BigInteger deptNo;
	
	@NotNull
	@Column(name ="ITEM_NO")
	private BigInteger itemNo;
	
	@Column(name ="EXPIRE_DATE")
	private LocalDate expireDate;
	
	@Column(name ="BATCH_NO")
	private String batchNo;
	
	@Column(name ="UNIT_PRICE")
	private Double unitPrice;
	
	@Column(name ="MRP_PRICE")
	private Double mrpPrice;
	
	@Column(name ="DISC_PCT")
	private Double discountPercentage;
	
	@Column(name ="DISC_AMT")
	private Double discountAmount;
	
	@Column(name ="VAT_PCT")
	private Double vatPercentage;
	
	@Column(name ="VAT_AMT")
	private Double vatAmount;
	
	@Column(name ="QTY")
	private Integer qty;
	
	@Column(name ="RSTOCK_NO")
	private BigInteger rstockNo;
	
	@Column(name ="PSTOCK_NO")
	private BigInteger pstockNo;
	
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
