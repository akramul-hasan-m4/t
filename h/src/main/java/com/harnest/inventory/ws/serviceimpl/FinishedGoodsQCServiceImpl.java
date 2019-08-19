package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.FinishedGoodsQC;
import com.harnest.inventory.ws.repository.FinishedGoodsQCRepo;
import com.harnest.inventory.ws.service.FinishedGoodsQCService;

public class FinishedGoodsQCServiceImpl implements FinishedGoodsQCService{
	
	private @Autowired FinishedGoodsQCRepo repo;

	@Override
	public void saveFinishedGoodsQC(FinishedGoodsQC fgqc) {
		repo.save(fgqc);
	}

	@Override
	public List<FinishedGoodsQC> findAllByPreQcFlag(String preQcFlag) {
		return repo.findAllByPreQcFlag(preQcFlag);
	}

	@Override
	public List<FinishedGoodsQC> findAllByqcAProveFlag(String qcApproveFlag) {
		return repo.findAllByqcAProveFlag(qcApproveFlag);
	}

}
