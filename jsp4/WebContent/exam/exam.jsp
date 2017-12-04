<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "java.util.HashMap" %>
<%@ include file= "/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>리스트 테스트</title>
</head>

<body>
<%
ArrayList<HashMap<String,String>> al = new ArrayList<>();


HashMap<String,String> hm = new HashMap<>(); //array는 키를 숫자(배열로)해야하지만, 헤쉬맵은 키를 숫자이외의 모든것을 쓸수 있음.

hm.put("name","홍길동");
hm.put("age","33");
al.add(hm);

//HashMap<String,String> hm1 = new HashMap<>();
hm.put("name","박경훈");
hm.put("age","35");
al.add(hm);
 
%>

 
<table border = "1";>
<tr>
<th><%=str1 %></th>
<th><%=str2 %></th>
</tr>

<% 
for(HashMap<String,String>map : al){
	out.print("<tr>");
	out.print("<td>" + map.get("name")+ "</td>");
	out.print("<td>" + map.get("age")+ "</td>");
	out.print("</tr>");
}

%>
</table>
</body>
</html>