package com.webScanner.app.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.service.ScannerService;

@Controller
@RequestMapping("/web")
public class ScannerWebController {
	private static final Logger LOGGER = Logger.getLogger(ScannerWebController.class.getName());
	@Autowired
	private ScannerService scannerService;
	
	@RequestMapping("/home")
	public String welcome(ModelMap map) { 
		List<HostInfo> hostInfoList = scannerService.getMostRecentAccessedHostInfo();
		map.put("hostInfoList",hostInfoList);
		return "ScannerHome";
	}
	
	@RequestMapping("/performScan")
	public String initiateScan(@RequestParam("url") String URL, ModelMap map) { 
		LOGGER.log(Level.INFO, "URL :-" + URL);
		HostInfo hostInfo = null;
		try {
			hostInfo = scannerService.scanURL(URL);
		} catch (ScannerException e) {
			map.put("Error",e.getMessage()+" Invalid Hostname");
		}
		map.put("hostInfo",hostInfo);
		return "ScannerReport";
	}
	
}
