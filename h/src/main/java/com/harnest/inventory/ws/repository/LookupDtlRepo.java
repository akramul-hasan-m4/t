package com.harnest.inventory.ws.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.harnest.inventory.ws.commons.StringQuery.*;

import com.harnest.inventory.ws.entity.LookupDtl;


@Repository
public interface LookupDtlRepo extends JpaRepository<LookupDtl, Integer>{
	
	@Query(value = GET_LOOK_UP_INFO , nativeQuery = true)
	List<Object[]> getLookupDtlInfo();
	
	@Modifying
	@Query(value = GET_LOOK_UP_INFO_BY_ID , nativeQuery = true)
	List<Object[]> getLookupDtlInfoByLookUpNo(@Param("lookUpNo") List<Integer> lookUpNo);

}
