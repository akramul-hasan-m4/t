package com.harnest.inventory.ws.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import static com.harnest.inventory.ws.commons.StringQuery.*;

import java.util.List;

import com.harnest.inventory.ws.entity.Users;

@Repository
public interface UserRepo extends JpaRepository<Users, Integer> {

	Users findByUsername(String userName);
	
	Users findByEmpNo(String empNo);
	
	@Query(value = USER_INFO , nativeQuery = true)
	List<Object[]> getUserInfo(@Param("UN") String userName);
}
