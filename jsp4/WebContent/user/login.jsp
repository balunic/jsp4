<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file = "/common/header.jsp" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>

</head>
<script>
 
//function test(){  //function인 애들은 이미 다 읽어놔서 가능함 
//	alsert(1);
//}


function login(){
	var url = "list.user?cmd=list";
	var param ='?cmd = list'
	var au = new AjaxUtil(url,param);
	au.send();
}




</script>

<body>
<form method ="Post" action ="/test.login" >
아이디 : <input type = "text" name = "id" id = "id"><br>
비밀번호 : <input type = "password" name = "pwd" id = "pwd"><br>
<input type="button" value = "login" onclick= "login()">
</form>
</body>
</html>