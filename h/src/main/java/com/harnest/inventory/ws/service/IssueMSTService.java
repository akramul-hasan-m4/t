package com.harnest.inventory.ws.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.IssueMST;

@Service
public interface IssueMSTService {
	
	@Transactional
	void saveIssueMST(IssueMST issueMst	);
	
	@Transactional
	IssueMST findByDemandNo(Integer demandNo);
}
