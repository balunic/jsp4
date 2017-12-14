<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/header.jsp"%>
<script>

	function afterLogin(result){
		var ths = $("table[id ='table'] thead tr th")
		var str = "";
		for (var i = 0; i < result.length; i++) {
			str+= "<tr>";
			for(var j = 0 ; j<ths.length; j ++){
				var th = ths[j].getAttribute("data-field");
				str += "<td class = 'text-center'>"+ result[i][th]+"</td>";
			}
		}
		$("#result_tbody").html(str);
	}
	$(document).ready(function(){
		var url = "join.user";
		var param = {};
		param["cmd"] = "list";
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
</script>
<body>
	<div class="container">
		<table id="table" data-height="460"
			class="table table-bordered table-hover">
			<thead>
				<tr>
					<th class="text=center"data-field ="userNo">No</th>
					<th class="text=center"data-field ="userId">ID</th>
					<th class="text=center"data-field ="userName">Name</th>
					<th class="text=center"data-field ="userAge">Age</th>
					<th class="text=center"data-field ="userAddress">Address</th>
				</tr>
			</thead>
			<tbody id="result_tbody"></tbody>
		</table>
	</div>
</body>
</html>