<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ include file= "/common/header.jsp" %>
<link rel="stylesheet" href="<%=rootPath%>/ui/signin.css"/>
<body>

<form class="form-signin">
		<h2 class="form-signin-heading">회원가입</h2>
		<label for="id" class="sr-only">ID</label> <input type="text"
			id="id" name="id" class="form-control" placeholder="ID" required
			> 
			
			<label for="pwd" class="sr-only">Password</label>
		<input type="password" name="pwd" id="pwd" class="form-control"
			placeholder="Password" required>
			
			
			<label for="id" class="sr-only">이름</label> <input type="text"
			id="name" name="name" class="form-control" placeholder="이름" required
			>
			<label for="id" class="sr-only">나이</label> <input type="text"
			id="age" name="age" class="form-control" placeholder="나이" required
			>
			<label for="id" class="sr-only"></label><input type="text"
			id="address" name="address" class="form-control" placeholder="주소" required
			>
			
		
		<input  class="btn btn-lg btn-primary btn-block"
			type="button" id= "joinBtn" value="회원가입">
	</form>
	
	
	<script >


function afterLogin(obj){
	
	alert(obj.msg);
	if(obj.result=='ok'){
		location.href=obj.url;
	}
}

$('#joinBtn').click(function(){
	var url = "join.user";
	
	var params = {};
	params["userId"] = $("#id").val();
	params["userPwd"] =$("#pwd").val();
	params["userName"] =$("#name").val();
	params["userAge"] =$("#age").val();
	params["userAddress"] =$("#address").val();
	var param = {};
	param["cmd"] = "join";
	param["params"]= JSON.stringify(params);
	$.ajax({
		type : "post", url : url,
		dataType: "json",
		data : param,
		success: afterLogin,
		error : function(xhr,status){
			alert("에러 : " + xhr.responseText);
		}
	});
});
function login(){
	var url = 'list.user';
	var id = document.getElementById("id");
	var pwd = document.getElementById("pwd");
	var param = '?cmd=login&id=' + id.value + '&pwd=' + pwd.value;
	var au = new AjaxUtil(url,param);
	au.changeCallBack(afterLogin);
	au.send();
}
</script>
</body>
</html>