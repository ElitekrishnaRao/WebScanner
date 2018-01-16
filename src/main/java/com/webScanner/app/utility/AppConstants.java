package com.webScanner.app.utility;

import java.util.Arrays;
import java.util.List;

public class AppConstants {
	public static List<String> tags = Arrays.asList("<title>,</title>", "<body>,</body>");
	public static final String HTML_A_TAG_PATTERN = "<a([^>]+)>(.+?)</a>";
	public static final String HTML_IMG_TAG_PATTERN = "<img\\s+(.*?)/?>";
	public static List<String> nOftags = Arrays.asList(HTML_A_TAG_PATTERN,HTML_IMG_TAG_PATTERN);
	public static final String NONE = "none";
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	public static final String CURRENT_DATE = "yyyy.MM.dd HH.mm.ss";
	public static final String INPUT_DATE = "dd-MM-yyy";
	public static final String HTTP ="http";
	public static final String HTTPS ="https";
	public static final String NON_SECURE_PROTOCOL = HTTP+"://";
	public static final String SECURE_PROTOCOL = HTTPS+"://";
}
