<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
     <c:forEach items="${listcommentgrammar}" var="list">

													 							
		<p style="background-color:powderblue; height:50px ; width:1000px"  class="input-xxlarge">  <b> ${list.name}  </b>   :    
									${list.cmtgrammarcontent}
		</p>
	</c:forEach>
</body>
</html>