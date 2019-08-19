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
@Table(name = "INV_COUNTRY")
@Data
public class Country implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="COUNTRY_CODE")
	private Integer countryCode;
	
	@Column(name ="UD_COUNTRY_CODE")
	private String udCountryCode;
	
	@Column(name ="COUNTRY_NAME")
	private String countryName;
	
	@Column(name ="MAIN_CURRUNCY")
	private String mainCurrency;
	
	@Column(name ="MAIN_LANGIAGE")
	private String mainLanguage;
	
	@Column(name ="TOTAL_PEPOLE")
	private Integer totalPeople;
	
	@Column(name ="GOVT_CODE")
	private Integer govtCode;
	
	@Column(name ="NATIONALITY")
	private String nationality;
	
	@Column(name ="REMARKS")
	private String remarks;
	
	@Column(name ="ACTIVE_FG")
	private Integer activeFlag;
	
	@Column(name ="ENTRY_DT", insertable = false, updatable = false)
	private LocalDate entryDate;   //DEFAULT sysdate,
	
	@Column(name ="UPD_DT")
	private LocalDate updateDate;
	
	@Column(name ="ENTRY_BY")
	private String entryBy;
	
	@Column(name ="UPD_BY")
	private String updateBy;
	
}
