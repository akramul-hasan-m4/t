package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.DemandCHD;

@Repository
public interface DemandCHDRepo extends JpaRepository<DemandCHD, Integer>{

	List<DemandCHD> findAllByDemandNo(Integer demandNo);
	
	List<DemandCHD> findAllByApprovedByNotNull();
	
	DemandCHD findByDemandChildNo(Integer demandChildNo);
	
	List<DemandCHD> findAllByEntryBy(String entryBy);
	
	@Query(value= "SELECT * FROM LABEL_PRINTING.INV_DMDCHD WHERE CHECK_BY IS NULL AND APPROVED_BY IS NULL", nativeQuery = true)
	List<DemandCHD> findAllCheckable();
	
	@Query(value= "SELECT * FROM LABEL_PRINTING.INV_DMDCHD WHERE CHECK_BY IS NOT NULL AND APPROVED_BY IS NULL", nativeQuery = true)
	List<DemandCHD> findAllApprovable();
	
}
