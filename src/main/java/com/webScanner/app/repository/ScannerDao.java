package com.webScanner.app.repository;

import java.util.List;

import com.webScanner.app.dto.HostInfo;

public interface ScannerDao {
 
	boolean save(HostInfo hostInfo);

	List<HostInfo> getScanRecordsByDateOrder();

	List<String> getScanRecordsUrlList(int count, String fromDate, String toDate);
}
