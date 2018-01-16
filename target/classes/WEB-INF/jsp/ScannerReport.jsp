<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<h1> ${Error} </h1>
<table>
  <tr>
    <th>URL</th>
    <th>Redirection URL</th>
    <th>Submitted On</th>
    <th>Website title</th>
    <th>Website Body Content</th>
    <th>Image Count</th>
    <th>Links Count</th>
  </tr>
  <tr>
    <td>${hostInfo.hostname}</td>
    <td>${hostInfo.redirectUrl}</td>
    <td>${hostInfo.submittedDate}</td>
    <td>${hostInfo.webSiteTitle}</td>
    <td>${hostInfo.bodyContent}</td>
    <td>${hostInfo.imageCount}</td>
    <td>${hostInfo.linksCount}</td>
  </tr>
</table>
</body>
</html>
