<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
	<form action="performScan">
		Hostname:<br> <input type="text" name="url"> <br> <br>
		<input type="submit">
	</form>

	<p>List of the most recent 10 assessed hostnames.</p>
	<table>
		<tr>
			<th>Hostname/URL</th>
			<th>Status</th>
			<th>IP address</th>
			<th>Website title</th>
			<th>Submitted On</th>
		</tr>
		<c:forEach var="hostInfo" items="${hostInfoList}">
		 <tr>
			<td>${hostInfo.hostname}</td>
			<td>${hostInfo.status}</td>
			<td>${hostInfo.ipAddress}</td>
			<td>${hostInfo.webSiteTitle}</td>
			<td>${hostInfo.submittedDate}</td>
		</tr>	
		</c:forEach>
	</table>

</body>
</html>
