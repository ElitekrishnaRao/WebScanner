package com.webScanner.app.engine;

import java.net.InetAddress;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.utility.DateUtil;


@Component
@Scope("prototype")
public class HtmlParseEngine extends HttpBaseEngine implements EngineFeatures {
	private static final Logger LOGGER = Logger.getLogger(HttpBaseEngine.class.getName());
	private List<String> tags;
	private List<String> nOftags;
	private String url;

	public void setUrl(String url) {
		this.url = url;
	}

	public void configureEngine(List<String> tags, List<String> nOftags) {
		this.tags = tags;
		this.nOftags = nOftags;
	}

	public HostInfo ScanAndExtractElements() throws ScannerException {
		HostInfo hostInfo = new HostInfo();
		URLConnection con = connect(url);
		StringBuilder response = invokeScanEngine(con,url);
		hostInfo.setHostname(getHost(con));
		retrieveIp(hostInfo, con);
		hostInfo.setSubmittedDate(DateUtil.getCurrentTime());
		retrieveTitleAndBody(hostInfo, response);
		hostInfo.setImageCount(countTag(response,  nOftags.get(1)));
		hostInfo.setLinksCount(countTag(response, nOftags.get(0)));
		return hostInfo;
	}

	private void retrieveTitleAndBody(HostInfo hostInfo, StringBuilder response) {
		String[] values = tags.get(0).split(",");
		hostInfo.setWebSiteTitle(extractTag(response, values[0],values[1]).trim());
		values = tags.get(1).split(",");
		hostInfo.setBodyContent(extractTag(response, values[0],values[1]).trim());
	}

	private void retrieveIp(HostInfo hostInfo, URLConnection con) throws ScannerException {
		try {
			hostInfo.setIpAddress(getIpAddress(con));
		} catch (UnknownHostException e) {
			LOGGER.log(Level.SEVERE,"Error in extracting IP address");
			throw new ScannerException(e.getMessage(), e.getCause());
		}
	}

	public String getIpAddress(URLConnection con) throws UnknownHostException {
		InetAddress address = InetAddress.getByName(getHost(con));
		String ip = address.getHostAddress();
		return ip;
	}

	public String getHost(URLConnection con) {
		return con.getURL().getHost();
	}

	public String extractTag(StringBuilder sb, String startElement, String endElement) {
		int start = sb.indexOf(startElement);
		if (start<0){
			start = sb.indexOf(startElement.substring(0,startElement.length()-1));
			start = sb.indexOf(">", start)+1;
		}else{
			start = start + startElement.length();
		}
		int end = sb.indexOf(endElement);
		String title = sb.substring(start, end);
		return title;
	}

	public int countTag(StringBuilder sb, String expression) {
		Pattern patternTag = Pattern.compile(expression);
		Matcher matcherTag = patternTag.matcher(sb);
		int count = 0;
		while (matcherTag.find()) {
			count = count + 1;
		}
		return count;
	}
}
