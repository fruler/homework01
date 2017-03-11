<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录</title>
<script src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	//$("#fsubmit").bind("click",function(){
		
		$("#fsubmit").click(function(){
			alert("FF");
		$.ajax({
			 url:"Day02",
			type:"post",
			dataType:"text",
			data:{"username":$("table tr td input:eq(0)").val(),"password":$("table tr td input:eq(1)").val()},
			success:function(data)	
		{
				alert(data);
			if(data=="T")	
				{
				alert("登录成功!")
				window.location.href="show1.jsp";
				}
			else{
				alert("账号或者密码不正确!")
				$("table tr td input:eq(0)").val("");	
				$("table tr td input:eq(1)").val("");
			}
				
		},
			
error:function(){
				alert("error");
			}
			
		})
	})
});
</script>
<style type="text/css">
table.collapse {
	border: 1px solid black;
	border-collapse: collapse;
}

td {

   font-size:30px;
	text-align: center;
	width: 250px;
	height: 50px;
	border: 1px solid black;
}

.text {
	width: 150px;
}
 .text:focus{
 width: 200px;
 height:35px;
 color:black;
 background-color:red;
 }
.button {
	width: 100px;
	 height:40px; 
}

.button:hover {
	color: red;
}
</style>
</head>

<body>
<br><br><br><br><br><br>
<form action="" method="post" >
<div  align="center">
       <table class="collapse">
       <caption style="font-weight: bold;font-size:50pt;">用户登录</caption>
       <tr>
          <td>用户名:</td>
          <td><input type="text" class="text" name="username"/></td>
        </tr>
        <tr>
           <td>密码:</td>
           <td><input type="password" name="password" class="text"></td>
        </tr>  
       </table>
       <input type="button" class="button" value="登录" id="fsubmit"/><input type="reset" value="重置" class="button"> 
</div>
</form>
</body>
</html>