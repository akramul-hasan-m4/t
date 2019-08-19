package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.LookupDtl;
import com.harnest.inventory.ws.model.LookupDTLModel;

@Service
public interface LookupDtlService {

	@Transactional
	List<LookupDTLModel> getLookupDtlInfo();
	
	@Transactional
	List<LookupDTLModel> getLookupDtlInfoByLookUpNo(List<Integer> lookUpNo);
	
	@Transactional
	void saveLookUpDtl(LookupDtl lookupDtl);
	
}
