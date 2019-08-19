package com.harnest.inventory.ws.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.ProdOrderDTLMST;

@Service
public interface ProdOrderDTLMSTService {

	@Transactional
	ProdOrderDTLMST findByReferenceNo(String referenceNo);
	
	@Transactional
	List<ProdOrderDTLMST> getFinishGoodsList();
	
}
