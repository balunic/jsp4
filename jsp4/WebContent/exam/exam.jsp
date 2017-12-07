<%@page import="java.util.Iterator"%>
<%@page import="com.test.jsp.common.ListExam"%>
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

ListExam le = new ListExam();
ArrayList<HashMap<String, String>> userList = le.getUserList();                    

%>
 
<table border = "1";>
<tr>
<th>유저번호</th>
<th><%=str1 %></th>
<th><%=str2 %></th>
<th>주소</th>
<th>아이디</th>
<th>비밀번호</th>
<th>부서번호</th>
<th>부서이름</th>
<th>부서설명</th>
</tr>

<% 
for(HashMap<String,String>map : userList){            //키값을 가져오는 부분
	out.print("<tr>");
 Iterator<String > it = map.keySet().iterator();
 while(it.hasNext()){
	 String key = it.next();
	 out.println("<td>"+ map.get(key)+"</td>");   //어떤키값인지 몰라도 불러낼수 있는 방법--> iterator패턴
 }
	out.print("</tr>");
}

%>
</table>
</body>
</html>