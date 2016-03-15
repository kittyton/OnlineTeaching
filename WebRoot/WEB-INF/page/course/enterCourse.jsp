<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'enterCourse.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="jquery-1.7.2.min.js"></script>
	<script>
	
	function getUnRead(){
          $(document).ready(function(){
          	$.ajax({
          	 	url :"json/unReadReply", 
          	 	type:"GET",
          	 	async:false,
          	 	dataType:"json",
          	 	error: function(){
          	 	alert("fail");
          	 	},
          	 	success: function(json){
          	 		if(json.questionID != 0){
          	 			document.getElementById("unRead").innerText = "new reply!";
          	 			document.getElementById("unRead").href="question/enterQuestion?questionID=" + json.questionID;
          	 		}
          	 	}
          	});
          }); 
     }
     setInterval("getUnRead();",5000);
	</script>
  </head>
  
  <body>
    <div> <br>
    	<center><a href="" id="unRead">noReply</a></center>
    </div>

    <a href="question/questionByCourseID?courseID=1">questions</a>
  </body>
</html>
