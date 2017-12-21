<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/common/header.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Insert title here</title>
</head>
<body>
	
	<div class="container">
		<table id="table" data-height="450"
			class="table table-bordered table-hover">
			<tbody id="result_tbody"></tbody>
			<tr>
				<td>부서번호</td>
				<td>${depart.diNo}</td>
			</tr>
			<tr>
				<td>부서이름</td>
				<td>${depart.diName}</td>
			</tr>
			<tr>
				<td>부서설명</td>
				<td>${depart.didEsc}</td>
			</tr>
		</table>
	</div>

</body>

</html>