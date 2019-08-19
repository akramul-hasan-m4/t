package com.harnest.inventory.ws.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Entity
@Table(name = "PRODORDER_MST")
@Data
public class ProdOrderDTLMST implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "REFERENCE_NO")
	private String referenceNo;

	@Column(name = "ORDER_NO")
	private String orderNo;

	@Column(name = "PO_NO")
	private String poNo;

	@Column(name = "ORDER_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate orderDate;

	@Column(name = "GRMM_ID")
	private String grmmId;

	@Column(name = "CONTACT_PERSON")
	private String contactPerson;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "DELIVERY_DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate deliveryDate;

	@Column(name = "SMPLE_NO")
	private String sampleNo;

	@Column(name = "FILE_NO")
	private String fileNo;

	@Column(name = "LABEL_NAME")
	private String labelName;

	@Column(name = "TOTAL_PICK")
	private Integer totalPick;

	@Column(name = "TOTAL_CUTT")
	private Integer totalCutt;

	@Column(name = "CONT_RATE")
	private Double contRate;

	@Column(name = "UNIT_PRICE")
	private Double unitPrice;

	@Column(name = "TOTAL_QTY")
	private Integer totalQty;

	@Column(name = "PROD_STAT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate prodStat;

	@Column(name = "ORDER_KEY")
	private String orderKey;

	@Column(name = "SAMPLE_KEY")
	private String sampleKey;

	@Column(name = "DELIVERY_COMP")
	@Size(max = 1)
	private String deliveryComp;

	@Column(name = "PO_CANCEL")
	@Size(max = 1)
	private String poCancel;

	@Column(name = "TOTAL_AMTUS")
	private Double tatalAmtus;

	@Column(name = "TOTAL_AMT")
	private Double tatalAmount;

	@Column(name = "MACHINE_NO")
	private String machineNo;

	@Column(name = "MARK_EXE")
	private String markExe;

	@Column(name = "UNIT")
	@Size(max = 5)
	private String unit;

	@Column(name = "PAYMENT_MODE")
	@Size(max = 10)
	private String paymentMode;

	@Column(name = "PRODUCTION_START")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate productionStart;

	@Column(name = "PK_REPEAT")
	private Integer pkRepeat;

	@Column(name = "LEN_REPEAT")
	private Integer lenRepeat;

	@Column(name = "PK3INCH")
	private Integer pk3Inch;

	@Column(name = "REMARKS")
	private String remarks;

	@Column(name = "CRE_BY")
	@ApiModelProperty(example = "E011006000620")
	private String createBy;

	@Column(name = "CRE_DT", insertable = false, updatable = false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate createDate; // DEFAULT SYSDATE

	@Column(name = "UPD_BY")
	private String updateBy;

	@Column(name = "UPD_DT")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate updateDate;

	@Column(name = "CAOWN")
	private String caown;

	@Column(name = "SAMPLE_IMAGE")
	private String sampleImage;

	@Column(name = "CUTFOLD_PRICE")
	private String cutFoldPrice;

	@Column(name = "GR_GRMM_ID")
	private Integer grGrmmId;

	@Column(name = "SORT_DELIVERY")
	private String sortDelivery = "1"; // DEFAULT 1

	@Column(name = "BUYER_ID")
	private Integer buyerId;

	@Column(name = "PI_STATUS")
	private Integer piStatus = 0; // DEFAULT 0

	@Column(name = "BILL_STATUS")
	private Integer billStatus = 0; // DEFAULT 0

	@Column(name = "LC_STATUS")
	private Integer lcStatus = 0; // DEFAULT 0

	@Column(name = "BUYCD")
	private Integer buyCD;

	@Column(name = "ACTIVE_STATUS")
	private Integer activeStatus = 1; // DEFAULT 1,

	@Column(name = "RATE_QUOTE")
	private Double rateQuote;

	@Column(name = "TA_SATION")
	private Integer taStation = 0; // DEFAULT 0

	@Column(name = "CHALLAN_STATUS")
	private Integer challanStatus = 0; // DEFAULT 0

	@Column(name = "ORDER_CAN_DATE")
	private LocalDate orderCanDate;

	@Column(name = "ORDER_CAN_USER")
	private Integer orderCanUser;

	@Column(name = "FINISHID_CHALLAN")
	private Integer finishedChallan = 0; // DEFAULT 0
	
	@Column(name = "PI_DELETE_BY_USER")
	private String piDeleteByUser = "0"; // DEFAULT 0
	
	@Transient
	private String garmentName;
	
	@Transient
	private String exeName;
	
	@Transient
	private String createdByName;
	
}
