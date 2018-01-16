package com.webScanner.app.convertor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.webScanner.app.dao.URLScanInfo;
import com.webScanner.app.dto.HostInfo;
import com.webScanner.app.utility.AppConstants;
import com.webScanner.app.utility.DateUtil;

@Component
public class BeanConvertor {

	public  URLScanInfo dtoToDaoConvertor(HostInfo hostInfo){
		URLScanInfo urlScanInfo = new URLScanInfo();
		urlScanInfo.setHostname(hostInfo.getHostname());
		urlScanInfo.setIpAddress(hostInfo.getIpAddress());
		urlScanInfo.setRedirectUrl(hostInfo.getRedirectUrl());
		urlScanInfo.setWebSiteTitle(hostInfo.getWebSiteTitle());
		urlScanInfo.setBodyContent(hostInfo.getBodyContent());
		urlScanInfo.setLinksCount(hostInfo.getLinksCount());
		urlScanInfo.setImageCount(hostInfo.getImageCount());
		urlScanInfo.setStatus(hostInfo.getStatus());
		urlScanInfo.setSubmittedDate(DateUtil.StringToTimeStamp(hostInfo.getSubmittedDate()));
		return urlScanInfo;
	}
	
	public  HostInfo daoToDtoConvertor(URLScanInfo urlScanInfo){
		HostInfo hostInfo = new HostInfo();
		hostInfo.setHostname(urlScanInfo.getHostname());
		hostInfo.setIpAddress(urlScanInfo.getIpAddress());
		hostInfo.setRedirectUrl(urlScanInfo.getRedirectUrl());
		hostInfo.setWebSiteTitle(urlScanInfo.getWebSiteTitle());
		hostInfo.setBodyContent(urlScanInfo.getBodyContent());
		hostInfo.setLinksCount(urlScanInfo.getLinksCount());
		hostInfo.setImageCount(urlScanInfo.getImageCount());
		hostInfo.setStatus(urlScanInfo.getStatus());
		hostInfo.setSubmittedDate(DateUtil.TimeStampToString(urlScanInfo.getSubmittedDate()));
		return hostInfo;
	}

	public List<HostInfo> daoListToDtoLIstConvertor(List<URLScanInfo> urlScanInfoList) {
		List<HostInfo> listHostInfo = new ArrayList<HostInfo>();
		for (URLScanInfo urlScanInfo : urlScanInfoList) {
			listHostInfo.add(daoToDtoConvertor(urlScanInfo));
		}
		return listHostInfo;
	}

	public List<String> retrieveUrlFromList(List<URLScanInfo> urlScanInfoList) {
		List<String> urlsList = new ArrayList<String>();
			for (URLScanInfo urlScanInfo : urlScanInfoList) {
				urlsList.add(urlScanInfo.getHostname());
			}
		return urlsList;
	}
}
