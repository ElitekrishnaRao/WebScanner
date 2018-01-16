package com.webScanner.app.engine;

import java.net.URLConnection;
import java.net.UnknownHostException;

public interface EngineFeatures {

	String getIpAddress(URLConnection con) throws UnknownHostException;

	String getHost(URLConnection con);

	String extractTag(StringBuilder sb, String startElement, String endElement);

	int countTag(StringBuilder sb, String expression);

}
