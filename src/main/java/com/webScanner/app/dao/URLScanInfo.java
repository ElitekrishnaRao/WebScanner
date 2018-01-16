package com.webScanner.app.dao;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "URLSCAN_INFO")
public class URLScanInfo {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "HOSTNAME")
	private String hostname;
	@Column(name = "REDIRECT_URL")
	private String redirectUrl;
	@Column(name = "IP_ADDRESS")
	private String ipAddress;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "WEB_SITE_TITLE")
	private String webSiteTitle;
	@Column(name = "SUBMITTED_DATE")
	private Timestamp submittedDate;
	@Column(name = "BODY_CONTENT",columnDefinition="TEXT")
	private String bodyContent;
	@Column(name = "IMAGE_COUNT")
	private long imageCount;
	@Column(name = "LINKS_COUNT")
	private long linksCount;
	
	public String getStatus() {
		return status;
	}
	public Timestamp getSubmittedDate() {
		return submittedDate;
	}
	public void setSubmittedDate(Timestamp submittedDate) {
		this.submittedDate = submittedDate;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getBodyContent() {
		return bodyContent;
	}
	public void setBodyContent(String bodyContent) {
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
}
