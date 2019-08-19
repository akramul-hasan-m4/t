package com.harnest.inventory.ws.repository;

import java.util.List;
import java.util.Optional;

import static com.harnest.inventory.ws.commons.StringQuery.FINISH_GOODS_QUERY;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.harnest.inventory.ws.entity.ProdOrderDTLMST;

@Repository
public interface ProdOrderDTLMSTRepo extends JpaRepository<ProdOrderDTLMST, Integer>{

	ProdOrderDTLMST findByReferenceNo(String referenceNo);
	
	@Query(value = FINISH_GOODS_QUERY, nativeQuery = true)
	Optional<List<ProdOrderDTLMST>> getAllFinishGoods();
	
}
