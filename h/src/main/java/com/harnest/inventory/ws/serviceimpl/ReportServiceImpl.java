package com.harnest.inventory.ws.serviceimpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.harnest.inventory.ws.model.BalanceParam;
import com.harnest.inventory.ws.model.BalanceReport;
import com.harnest.inventory.ws.repository.HRDepartmentRepo;
import com.harnest.inventory.ws.service.ReportService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ReportServiceImpl implements ReportService{

	private @Autowired HRDepartmentRepo repo;
	private String deptName;
	
	@Override
	public List<BalanceReport> getBanceReport(BalanceParam param) {
		
		List<BalanceReport> balanceList = new ArrayList<>();

		String itemNo = param == null || param.getItemNo() == null ? "" : param.getItemNo();
		String deptNo = param == null || param.getDeptNo() == null ? "" : param.getDeptNo();
		String startDate = param == null || param.getStartDate() == null ? "" : param.getStartDate();
		String endDate = param == null || param.getEndDate() == null ? "" : param.getEndDate();
		String udItemNo = param == null || param.getUdItemNo() == null ? "" : param.getUdItemNo();
		String groupNo = param == null || param.getGroupNo() == null ? "" : param.getGroupNo();
		String itemName = param == null || param.getItemName() == null ? "" : param.getItemName();
		
		List<Object[]> reports = repo.getReportFromView(itemNo, deptNo, startDate, endDate, udItemNo, groupNo, itemName);
		
		reports.stream().forEach((record) -> {
			try {
				BalanceReport balance = new BalanceReport();
				balance.setDeptNo((BigDecimal)record[0]);
				balance.setDeptName((String)record[1]);
				balance.setItemNo((BigDecimal)record[2]);
				balance.setUdItemNo((String)record[3]);
				balance.setItemName((String)record[4]);
				balance.setGroupNo((BigDecimal)record[5]);
				balance.setGroupName((String)record[6]);
				balance.setOpBalance((BigDecimal)record[7]);
				balance.setPrBalance((BigDecimal)record[8]);
				balance.setClBalance((BigDecimal)record[9]);
				balance.setInQty((BigDecimal)record[10]);
				balance.setOutQty((BigDecimal)record[11]);
				balance.setRcShow((String)record[12]);
				balance.setUomName((String)record[13]);
				
				balanceList.add(balance);
			}catch (Exception e) {
				log.error(e.getMessage());
			}
		});

		return balanceList.isEmpty() ? balanceList : nestedbalanceListGenerator(balanceList);
	}
	
	private List<BalanceReport> nestedbalanceListGenerator(List<BalanceReport> balanceList){
		
		List<BalanceReport> parentList = new ArrayList<>();
		
		Set<BigDecimal> parentIdList = balanceList.stream().map(BalanceReport::getDeptNo).collect(Collectors.toSet());
		
		parentIdList.stream().forEach(deptNo ->{
			List<BalanceReport> chldList = new ArrayList<>();
			
			balanceList.stream().filter(d -> d.getDeptNo().equals(deptNo)).forEach(report ->{
				if(deptName == null || !deptName.equalsIgnoreCase(report.getDeptName())) {
					deptName = report.getDeptName();
				}
				chldList.add(report);
			});
			BalanceReport report = new BalanceReport();
			report.setDeptNo(deptNo);
			report.setDeptName(deptName);
			report.setDeptlist(chldList);
			
			parentList.add(report);
		});
		
		return parentList;
	}

}
