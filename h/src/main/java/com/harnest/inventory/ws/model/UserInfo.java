package com.harnest.inventory.ws.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {

	private BigDecimal userId;
	private String username;
	private BigDecimal usergrpId;
	private BigDecimal userlvlId;
	private String roleName;
	private String empName;
	private BigDecimal desigId;
	private BigDecimal areaId;
	private String empNo;
	private String email;
	
	@JsonIgnore
	private String password;
}
