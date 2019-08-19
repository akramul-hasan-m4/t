package com.harnest.inventory.ws.repository;


import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, BigInteger>{

	@Query(value = "SELECT FNC_DEPTWSTOCK(:ITEM_NO , :DEPT_NO) FROM DUAL", nativeQuery= true)
	Integer checkQuantity(@Param("ITEM_NO") Integer itemNo, @Param("DEPT_NO") Integer deptNo);
	
}
