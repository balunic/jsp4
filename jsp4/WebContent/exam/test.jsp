<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ include file="/common/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
저는 테스트1입니다.
<%                       //변환시에 만들어지는 자바파일을 가르킨다.
RequestDispatcher reqD = this.getServletContext().getRequestDispatcher("/exam/test2.jsp");
request.setAttribute("jsp4", "화이팅!");

reqD.forward(request, response);  //페이지에서 페이지 이동할 때 쓸수 있고 다른 페이지에서 쓸때는 못쓴다? 

%>

</body>
</html>