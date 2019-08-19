package com.harnest.inventory.ws.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.harnest.inventory.ws.model.BalanceParam;
import com.harnest.inventory.ws.model.BalanceReport;

@Service
public interface ReportService {
	
	List<BalanceReport> getBanceReport(BalanceParam param);

}
