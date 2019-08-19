package com.harnest.inventory.ws.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.entity.DemandCHD;

@Service
public interface DemandCHDService {
	
	@Transactional
	void saveDemandCHDData(DemandCHD dmdchd);
	
	@Transactional
	List<DemandCHD> findAllByDemandNo(Integer demandNo);
	
	@Transactional
	List<DemandCHD> findAllByApprovedByNotNull();
	
	@Transactional
	DemandCHD findByDemandChildNo(Integer demandChildNo);
	
	@Transactional
	List<DemandCHD> findAllByEntryBy(String entryBy);
	
	@Transactional
	List<DemandCHD> findAllCheckable();
	
	@Transactional
	List<DemandCHD> findAllApprovable();

}
