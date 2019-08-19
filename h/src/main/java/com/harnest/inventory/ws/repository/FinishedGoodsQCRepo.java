package com.harnest.inventory.ws.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.FinishedGoodsQC;

@Repository
public interface FinishedGoodsQCRepo extends JpaRepository<FinishedGoodsQC, BigInteger>{

	List<FinishedGoodsQC> findAllByPreQcFlag(String preQcFlag);
	
	List<FinishedGoodsQC> findAllByqcAProveFlag(String qcApproveFlag);
	
}
