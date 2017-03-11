<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script src="js/jquery-1.7.2.min.js"></script>
<script type="text/javascript">
 $(function(){
	$("#button1").bind("click",function(){
		var imgpath=$("img:eq(0)").attr("src");
	  $.ajax({
				 url:"day03",
				type:"post",
				dataType:"text",
				data:"path="+imgpath,
				success:function(data)	
			{
					alert("下载成功!");
					window.location.href="success.jsp";
			}
	  ,
	  error:function(){
		  alert("error!");
	  }
	  })
	}) 
 })
</script>
<body>
欢迎<%=session.getAttribute("username")%><br>
<div align="center">
<img src="imgs/1.jpg" style="width:200px; height:200px"/>
<br>

<input type="button"  value="下载" id="button1" style="width:100px;height:40px"/>
</div>
</body>
</html>