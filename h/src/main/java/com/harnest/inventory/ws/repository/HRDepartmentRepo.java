package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.harnest.inventory.ws.commons.StringQuery.*;

import java.util.List;

import com.harnest.inventory.ws.entity.HRDepartment;

@Repository
public interface HRDepartmentRepo extends JpaRepository<HRDepartment, Integer>{

	@Query(value= REPORT_QUERY, nativeQuery = true)
	List<Object[]> getReportFromView(@Param("ITEMNO") String itemNo,
							  @Param("DEPTNO") String deptNo,
							  @Param("START_DATE") String startDate,
							  @Param("END_DATE") String endDate,
							  @Param("UDITEMNO") String udItemNo,
							  @Param("GROUPNO") String groupNo,
							  @Param("ITEMNAME") String itemName
							);
	
}
