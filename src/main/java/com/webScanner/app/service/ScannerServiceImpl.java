package com.webScanner.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.engine.EngineHelper;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.repository.ScannerDao;

@Service
public class ScannerServiceImpl implements ScannerService {
	@Autowired
	private EngineHelper engineHelper;
	@Autowired
	private ScannerDao scannerDao;

	@Override
	public HostInfo scanURL(String url) throws ScannerException {
		HostInfo hostInfo = engineHelper.ScanOutput(url);
		scannerDao.save(hostInfo);
		return hostInfo;
	}
	
	@Override
	public List<HostInfo> getMostRecentAccessedHostInfo() {
		return  scannerDao.getScanRecordsByDateOrder();
	}
	
	@Override
	public List<String> listUrlsScan(int count, String fromDate,String toDate){
		return scannerDao.getScanRecordsUrlList(count, fromDate, toDate);
	}

}
