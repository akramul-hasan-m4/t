package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.FinishedGoodsQC;

@Service
public interface FinishedGoodsQCService {
	
	void saveFinishedGoodsQC(FinishedGoodsQC fgqc);
	
	List<FinishedGoodsQC> findAllByPreQcFlag(String preQcFlag);
	
	List<FinishedGoodsQC> findAllByqcAProveFlag(String qcApproveFlag);

}
