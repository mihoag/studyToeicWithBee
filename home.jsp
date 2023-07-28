<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
    
    <link href="Template/Frontend/css/bootstrap.css" rel="stylesheet">
    <link href="Template/Frontend/css/bootstrap-responsive.css" rel="stylesheet">
    <link href="Template/Frontend/css/style.css" rel="stylesheet"> 
    
   
   	<!-- font -->
	<link rel="stylesheet" href="Template/Frontend/font/font-awesome.min.css"/>
    <script src="Template/Frontend/js/jquery-1.js"></script>
    <script src="Template/Frontend/js/bootstrap.min.js"></script>
    
  
  <script type="text/javascript">
		
				function Search()
				{
					var xhttp;
					var grammarname = document.myform.grammarname.value;
					
					if (grammarname != "")
					{
						var url = "Searchcontroller?grammarname="+grammarname;
						
						if (window.XMLHttpRequest) 
						{          
						           xhttp = new XMLHttpRequest();
						} 
						else
						{        
							xhttp = new ActiveXObject("Microsoft.XMLHTTP");
						}
						
						xhttp.onreadystatechange = function()
						{
							if(xhttp.readyState == 4)
							{
								var data = xhttp.responseText;
								document.getElementById("searchresult").innerHTML = data;
							}			
							
						}	
						xhttp.open("POST",url,true);
						xhttp.send();	
					}
					else 
					{
						document.getElementById("searchresult").innerHTML = "Quay lại trang chủ bằng cách click vào logo website";
					}
				}
	</script>
  
</head>
<body>

   <jsp:include page="header.jsp"/>
    <br/>
       <br/>
   <div class="container">
  	  		<div class="row">
  	  			
  	  			<div class="span6">
			
					<div id="size">
						<form name="myform">
							<input type="text" class="form-control" placeholder="Tìm kiếm bài ngữ pháp" style="width:500px" name="grammarname" onkeyup="Search()">							
						</form>
					</div>
			
				</div>
  	  		</div>
	  </div>

  <!--Carousel
  ==================================================-->
  <div class="container" id="searchresult">
  <div id="myCarousel" class="carousel slide">
    <div class="carousel-inner">

      <div class="active item">
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>Học từ vựng, ngữ pháp</h1>
                      <p class="lead">Cung cấp cho bạn những kiến thức căn bản, cấu trúc, ngữ pháp, từ vựng để bạn có kiến thức nền tảng</p>
                      <a class="btn btn-large btn-primary" href="#">Vào học ngay</a>
                </div>

              </div>

                <div class="span6"> <img src="Template/Frontend/img/slide/slide1.jpg"></div>

          </div>
        </div>
      </div>


      <c:forEach items= "${arrSlideBanner}" var = "list">
      <div class="item">
       
        <div class="container">
          <div class="row">
            
              <div class="span6">

                <div class="carousel-caption">
                      <h1>${list.slidename}</h1>
                      <p class="lead">${list.slidecontent}</p>
                      <a class="btn btn-large btn-primary" href="#">Vào học ngay</a>
                </div>

              </div>

                <div class="span6"> <img src="Template/Frontend/img/slide/${list.slideimage}"></div>

          </div>
        </div>

      </div>
      </c:forEach>




    </div>
       <!-- Carousel nav -->
      <a class="carousel-control left " href="#myCarousel" data-slide="prev"><i class="icon-chevron-left"></i></a>
      <a class="carousel-control right" href="#myCarousel" data-slide="next"><i class="icon-chevron-right"></i></a>
        <!-- /.Carousel nav -->

  </div>
    <!-- /Carousel -->



<!-- Feature 
  ==============================================-->


  <div class="row feature-box">
      <div class="span12 cnt-title">
       <h1>Học toeic cùng với các chuyên gia top 1 server miền trung</h1> 
        <span>Học thử -- Làm bài tập -- Thi thử</span>        
      </div>

      <div class="span4">
        <img src="Template/Frontend/Image/guideline.png">
        <h2>Hướng dẫn học</h2>
        <p>
            Cung cấp kiến thức cơ bản, các tip học tốt toeic
        </p>

        <a href="#" data-toggle="modal" data-target="#myModal">Chi tiết &rarr;</a>

      </div>

      <div class="span4">
        <img src="Template/Frontend/Image/exercises.png">
        <h2>Làm bài tập</h2>
        <p>
           Cung cấp bài tập để củng cố kiến thức
        </p>   
          <a href="#" data-toggle="modal" data-target="#myModal1">Chi tiết &rarr;</a> 
      </div>

      <div class="span4">
        <img src="Template/Frontend/Image/thitoeic.png">
        <h2>Thi thử</h2>
        <p>
          Cung cấp những bài thi thử cực sát với đề thi thật
        </p>
          <a href="LamdethiFoward?pageid=1">Đọc thêm &rarr;</a>
      </div>
  </div>

</div>
<!-- /.Feature -->

  <div class="hr-divider"></div>

<!-- Row View -->


  <jsp:include page="footer.jsp"/> 

<!-- /.Row View -->

<!-- start Modal -->
		  <div class="modal fade" id="myModal" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">DANH SÁCH LOẠI BÀI HƯỚNG DẪN</h4>
		        </div>
		        <div class="modal-body">
	         	
						<div class="media">
							<a class="pull-left"><img src="Template/Frontend/Image/loaibtnghe.png" class="media-object" alt='' /></a>
							<div class="media-body">
								<h4>
									<a href="Hienthidshdtuvung?pageid=1">Bài hướng dẫn từ vựng</a>
								</h4> 					
							</div>
						</div>
					
			          	<div class="media">
							<a class="pull-left"><img src="Template/Frontend/Image/loaibtdoc.png" class="media-object" alt='' /></a>
							<div class="media-body">
								<h4>
									<a href="Dsbaihdnguphapforward?pageid=1">Bài hướng dẫn phần ngữ pháp</a>
								</h4> 					
							</div>
						</div>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>
		  <!-- end modal -->
		  
		   <!-- start Modal làm bt -->
		  <div class="modal fade" id="myModal1" role="dialog">
		    <div class="modal-dialog">
		    
		      <!-- Modal content-->
		      <div class="modal-content">
		        <div class="modal-header">
		          <button type="button" class="close" data-dismiss="modal">&times;</button>
		          <h4 class="modal-title">DANH SÁCH LOẠI BÀI TẬP</h4>
		        </div>
		        <div class="modal-body">
	         	
						<div class="media">
							<a class="pull-left"><img src="Template/Frontend/Image/loaibtnghe.png" class="media-object" alt='' /></a>
							<div class="media-body">
								<h4>
									<a href="Hienthidsbtnghe?pageid=1">Bài tập phần nghe</a>
								</h4> 					
							</div>
						</div>
					
			          	<div class="media">
							<a class="pull-left"><img src="Template/Frontend/Image/loaibtdoc.png" class="media-object" alt='' /></a>
							<div class="media-body">
								<h4>
									<a href="Hienthidsbtphandoc?pageid=1">Bài tập phần đọc</a>
								</h4> 					
							</div>
						</div>
		        </div>
		        <div class="modal-footer">
		          <button type="button" class="btn btn-default" data-dismiss="modal">Thoát</button>
		        </div>
		      </div>
		      
		    </div>
		  </div>
		  <!-- end modal -->




<!--Footer

<!--/.Footer-->

</body>
</html>