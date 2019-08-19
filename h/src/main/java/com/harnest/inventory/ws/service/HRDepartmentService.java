package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.harnest.inventory.ws.entity.HRDepartment;

@Service
public interface HRDepartmentService {

	@Transactional
	List<HRDepartment> getAllHRDepartmentInfo();
}
