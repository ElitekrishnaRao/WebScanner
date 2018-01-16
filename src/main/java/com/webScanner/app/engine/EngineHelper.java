package com.webScanner.app.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.utility.AppConstants;

@Component
public class EngineHelper {
	@Autowired
	public HtmlParseEngine htmlParseEngine;

	public HostInfo ScanOutput(String url) throws ScannerException {
		htmlParseEngine.setUrl(url);
		htmlParseEngine.configureEngine(AppConstants.tags, AppConstants.nOftags);
		HostInfo hostInfo = null;
		hostInfo = htmlParseEngine.ScanAndExtractElements();
		return hostInfo;
	}
}
