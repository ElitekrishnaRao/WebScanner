package com.webScanner.app.dto;

import org.apache.commons.text.StringEscapeUtils;

import com.webScanner.app.utility.AppConstants;

public class HostInfo {
	private String hostname;
	private String redirectUrl;
	private String status ;
	private String ipAddress;
	private String webSiteTitle;
	private String submittedDate;
	private String bodyContent;
	private long imageCount;
	private long linksCount;
	
	public HostInfo(){
		this.redirectUrl = AppConstants.NONE;
		this.status = AppConstants.SUCCESS;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getRedirectUrl() {
		return redirectUrl;
	}
	public void setRedirectUrl(String redirectUrl) {
		this.redirectUrl = redirectUrl;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String string) {
		this.status = string;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getWebSiteTitle() {
		return webSiteTitle;
	}
	public void setWebSiteTitle(String webSiteTitle) {
		this.webSiteTitle = webSiteTitle;
	}
	public String getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(String submittedDate) {
		this.submittedDate = submittedDate;
	}
	public String getBodyContent() {
		return bodyContent;
	}
	public void setBodyContent(String bodyContent) {
		bodyContent = StringEscapeUtils.escapeHtml4(bodyContent);
		this.bodyContent = bodyContent;
	}
	public long getImageCount() {
		return imageCount;
	}
	public void setImageCount(long imageCount) {
		this.imageCount = imageCount;
	}
	public long getLinksCount() {
		return linksCount;
	}
	public void setLinksCount(long linksCount) {
		this.linksCount = linksCount;
	}

	public String toString() {
		return String.format("{webSiteTitle=%d, bodyContent=%d, linksCount=%d, imageCount=%d}", webSiteTitle, bodyContent, imageCount);
	}

}
