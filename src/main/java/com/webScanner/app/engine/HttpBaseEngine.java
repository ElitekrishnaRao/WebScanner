package com.webScanner.app.engine;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.SocketException;
import java.net.URL;
import java.net.URLConnection;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.webScanner.app.exceptions.ScannerException;
import com.webScanner.app.utility.AppConstants;

public class HttpBaseEngine {
	private static final Logger LOGGER = Logger.getLogger(HttpBaseEngine.class.getName());

	public  URLConnection connect(String connectionString) throws ScannerException {
		URL url;
		URLConnection conn = null;
		try {
			url = new URL(formattedURL(connectionString));
			conn = url.openConnection();
		} catch (MalformedURLException e) {
			throw new ScannerException("Malformed URL please reconfirm it");
		} catch(ConnectException e){
			throw new ScannerException("Invalid host name please reconfirm it");
		} catch (IOException e) {
			throw new ScannerException(e.getMessage(), e.getCause());
		}
		return conn;
	}

	public  BufferedReader getStream(URLConnection con) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				con.getInputStream()));
		return in;
	}

	public  StringBuilder parse(BufferedReader in) {
		StringBuilder sb = new StringBuilder();
		String inputLine;
		try {
			while ((inputLine = in.readLine()) != null)
				sb.append(inputLine);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb;
	}

	public  StringBuilder invokeScanEngine(URLConnection con, String url) {
		try {
			BufferedReader in = getStream(con);
			if (in != null) {
				return parse(in);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String formattedURL(String connectionString){
		if(!(connectionString.contains(AppConstants.HTTP) || connectionString.contains(AppConstants.HTTPS))){
			connectionString=AppConstants.SECURE_PROTOCOL+connectionString;
		}
		LOGGER.log(Level.INFO, connectionString);
		return connectionString;
	}
}