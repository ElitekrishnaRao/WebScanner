package com.webScanner.app.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.service.ScannerService;

@RestController
@RequestMapping("/rest")
public class ScannerRestController {
	private static final Logger LOGGER = Logger.getLogger(ScannerRestController.class.getName());
	@Autowired
	private ScannerService scannerService;

	@RequestMapping(value = "/submit/{url:.+}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<HostInfo> scanReport(@PathVariable String url) {
		LOGGER.log(Level.INFO, "Restcontroller :- " + url);
		HostInfo hostInfo= null;
		try {
			hostInfo = scannerService.scanURL(url);
		} catch (ScannerException e) {
			return new ResponseEntity<>(hostInfo,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(hostInfo,HttpStatus.OK);
	}

	@RequestMapping("list")
	public List<String> queryList(@RequestParam(value = "count", defaultValue = "50") int count,
			@RequestParam(value = "fromDate", required = false) String fromDate,
			@RequestParam(value = "toDate", required = false) String toDate) {
		return scannerService.listUrlsScan(count, fromDate, toDate);
	}
}
