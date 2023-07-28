<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Danh sách bài tập đọc</title>
	<link href="Template/Frontend/css/bootstrap.css" rel="stylesheet">
    <link href="Template/Frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="Template/Frontend/css/style.css" rel="stylesheet"> 
    
   
   	<!-- font -->
	<link rel="stylesheet" href="Template/Frontend/font/font-awesome.min.css" />
    
    <script src="Template/Frontend/js/jquery-1.js"></script>
    <script src="Template/Frontend/js/bootstrap.min.js"></script>
    
    <style type="text/css">
    
    	#para1
    	{
    		padding-top:50px;
    	}
    
    </style>
</head>
<body>
	<!--HEADER ROW-->
	  	<jsp:include page="header.jsp"></jsp:include>
	 <!-- /HEADER ROW -->
	 
		<div class="container">
			  <!--PAGE TITLE-->
		
			<div class="row">
				<div class="span12">
						<div class="page-header">
							<h3>
								Danh sách bài tập đọc
							</h3>
						</div>
				</div>
				
			</div>
		
		  <!-- /. PAGE TITLE-->
		  
			<div class="row">	
					<c:forEach items="${list}" var="list">
						<div class="span6">			
								<div class="media">
									 <a href="#" class="pull-left"><img src="${list.readimage}" class="media-object" alt='' width="128px" height="128px"/></a>
									<div class="media-body">
										 
										<p>
											${list.readname}
										</p>
										<a href="lambtdoc?readexerciseid=${list.readexerciseid}&pageid=1" class="btn" type="button">Chi tiết</a>
					
					
									</div>
								</div>						
						</div>	
					</c:forEach>				
			</div>
			
			
			<!--Pagination-->
			<div class="row">
				<div class="span6">
					
					<div class="pagination">
						<ul>
							<c:if test="${pageid == 1}">
							   <li class = "disabled"><a href = "#">Prev</a></li>
							  
							   <li><a href = "Hienthidsbtphandoc?pageid=${pageid+1}">Next</a></li>
						   </c:if>
						   <c:if test="${pageid == maxpageid}">
							   <li><a href = "Hienthidsbtphandoc?pageid=${pageid-1}">Prev</a></li>
							  
							   <li class = "disabled"><a href ="#">Next</a></li>
						   </c:if>
						   
						   <c:if test="${pageid > 1 && pageid < maxpageid}">
							   <li><a href = "Hienthidsbtphandoc?pageid=${pageid-1}">Prev</a></li>
							   
							   <li><a href = "Hienthidsbtphandoc?pageid=${pageid+1}">Next</a></li>
						   </c:if>
						</ul>
					</div>	
					
			 	</div>
			</div>
			<!--/.Pagination-->
			
		</div>
		
</body>

</html>