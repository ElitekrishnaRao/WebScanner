package com.webScanner.app.engine.test;

import static org.junit.Assert.assertEquals;

import java.net.UnknownHostException;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.webScanner.app.engine.HtmlParseEngine;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.utility.AppConstants;

@RunWith(SpringRunner.class)
public class EngineTest {
	private static final Logger LOGGER = Logger.getLogger(EngineTest.class.getName());

	@Test
	public void testCaseScanGoogle() throws UnknownHostException {
		HtmlParseEngine htmlParseEngine = new HtmlParseEngine();
		htmlParseEngine.setUrl("https://www.google.co.in");
		htmlParseEngine.configureEngine(AppConstants.tags, AppConstants.nOftags);
		try {
			assertEquals(htmlParseEngine.ScanAndExtractElements().getWebSiteTitle(), "Google");
			assertEquals(htmlParseEngine.ScanAndExtractElements().getLinksCount(), 30);
			assertEquals(htmlParseEngine.ScanAndExtractElements().getImageCount(), 1);
		} catch (ScannerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testCaseScanQualys() throws UnknownHostException {
		HtmlParseEngine htmlParseEngine = new HtmlParseEngine();
		htmlParseEngine.setUrl("https://www.qualys.com/");
		htmlParseEngine.configureEngine(AppConstants.tags, AppConstants.nOftags);
		try {
			assertEquals(htmlParseEngine.ScanAndExtractElements().getWebSiteTitle(),
					"Information Security and Compliance | Qualys, Inc.");
			assertEquals(htmlParseEngine.ScanAndExtractElements().getLinksCount(), 252);
			assertEquals(htmlParseEngine.ScanAndExtractElements().getImageCount(), 19);
		} catch (ScannerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testCaseScanFB() throws UnknownHostException {
		HtmlParseEngine htmlParseEngine = new HtmlParseEngine();
		htmlParseEngine.setUrl("https://www.facebook.com");
		try {
			htmlParseEngine.configureEngine(AppConstants.tags, AppConstants.nOftags);
			assertEquals(htmlParseEngine.ScanAndExtractElements().getLinksCount(), 58);
			assertEquals(htmlParseEngine.ScanAndExtractElements().getImageCount(), 5);
		} catch (ScannerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
