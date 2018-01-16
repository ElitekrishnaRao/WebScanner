package com.webScanner.app.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.webScanner.app.convertor.BeanConvertor;
import com.webScanner.app.dao.URLScanInfo;
import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.utility.DateUtil;

@Component
public class ScannerDaoImpl implements ScannerDao {
	@Autowired
	ScanRepository scanRepository;
	@Autowired
	BeanConvertor beanConvertor;

	@Override
	public boolean save(HostInfo hostInfo) {
		URLScanInfo urlScanInfo = beanConvertor.dtoToDaoConvertor(hostInfo);
		scanRepository.save(urlScanInfo);
		return true;
	}
	
	@Override
	public List<HostInfo> getScanRecordsByDateOrder(){
		List<URLScanInfo> urlScanInfoList = scanRepository.findTop10ByOrderBySubmittedDateDesc();
		List<HostInfo> hostInfoList = beanConvertor.daoListToDtoLIstConvertor(urlScanInfoList);
		return hostInfoList;
	}
	
	@Override
	public List<String> getScanRecordsUrlList(int count,String fromDate,String toDate){
		Pageable  pageable = new PageRequest(0, count);
		List<URLScanInfo> urlScanInfoList = null;
		if(fromDate!=null && toDate!=null){
			urlScanInfoList = scanRepository.findBySubmittedDateBetween(DateUtil.QueryStringToTimeStamp(fromDate), DateUtil.QueryStringToTimeStamp(toDate), pageable).getContent();
		}else{
			urlScanInfoList = scanRepository.findAll(pageable).getContent();
		}	
		List<String> hostList = beanConvertor.retrieveUrlFromList(urlScanInfoList);
		return hostList;
	}
}
