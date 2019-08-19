package com.harnest.inventory.ws.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.entity.DemandCHD;
import com.harnest.inventory.ws.repository.DemandCHDRepo;
import com.harnest.inventory.ws.service.DemandCHDService;

public class DemandCHDServiceImpl implements DemandCHDService{
	
	private @Autowired DemandCHDRepo repo;

	@Override
	public void saveDemandCHDData(DemandCHD dmdchd) {
		repo.save(dmdchd);
	}

	@Override
	public List<DemandCHD> findAllByDemandNo(Integer demandNo) {
		return repo.findAllByDemandNo(demandNo);
	}

	@Override
	public List<DemandCHD> findAllByApprovedByNotNull() {
		return repo.findAllByApprovedByNotNull();
	}

	@Override
	public DemandCHD findByDemandChildNo(Integer demandChildNo) {
		return repo.findByDemandChildNo(demandChildNo);
	}

	@Override
	public List<DemandCHD> findAllByEntryBy(String entryBy) {
		return repo.findAllByEntryBy(entryBy);
	}

	@Override
	public List<DemandCHD> findAllCheckable() {
		return repo.findAllCheckable();
	}

	@Override
	public List<DemandCHD> findAllApprovable() {
		return repo.findAllApprovable();
	}

}
