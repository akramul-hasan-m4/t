package com.harnest.inventory.ws.service;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.IssueCHD;

@Service
public interface IssueCHDService {
	
	void saveIssueCHDData(IssueCHD issueCHD);

}
