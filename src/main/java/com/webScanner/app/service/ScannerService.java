package com.webScanner.app.service;

import java.util.List;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.exceptions.ScannerException;

public interface ScannerService {

	 public HostInfo scanURL(String url) throws ScannerException;

	List<HostInfo> getMostRecentAccessedHostInfo();

	List<String> listUrlsScan(int count, String fromDate, String toDate);
}
