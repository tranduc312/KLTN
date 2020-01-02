<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">

    <title>Giao Hang </title>

    <!-- Bootstrap -->
    <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    
    <!-- Custom Theme Style -->
    <link href="../admin/build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Thông tin User</h3>
              </div>

              
            </div>
            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">

                    <form class="form-horizontal form-label-left">
						
                     
                      <span class="section"> 
                      		User: ${user.ten_User}
                      		<br/>
                      		Vai Trò:
                      		<c:forEach items="${listvaitro}" var="vaitro">
	                        <c:if test="${vaitro.ID_Role==user.ID_Role}">
	                           ${vaitro.vai_Tro}
	                        </c:if>
	                        </c:forEach>
                       </span>
                       <div style="float:left;">
                       <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                       </div>
                       
                       <div style="float:right; ">
                        
                        <button  id="send" class = "btn btn-success" ><a href="editprofile">Thay đổi thông tin</a></button>
                      	<button class="btn btn-success"  type="submit"  ><a href="changematkhau">Thay đổi mật khẩu</a></button>
                       </div>
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="ID_User"  type="hidden" value="${user.ID_User}" readonly>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên User: 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Ten_User"   value="${user.ten_User}" readonly>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Địa Chỉ:
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Dia_Chi"    value="${user.dia_Chi}" readonly>
                        </div>
                      </div>
						
						<div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Số Điện Thoại:
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="SDT"   value="${user.SDT}" readonly>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Email:
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Email"  value="${user.email}" readonly>
                        </div>
                      </div>
                      
                     <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Vai Trò:
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <c:forEach items="${listvaitro}" var="vaitro">
                        <c:if test="${vaitro.ID_Role==user.ID_Role}">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="ID_Role"   value="${vaitro.vai_Tro}" readonly>
                        </c:if>
                        </c:forEach>
                        </div>
                      </div>
                     
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                        </div>
                      </div>
                    </form>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!-- /page content -->

 	<!-- jQuery -->
	<script src="../admin/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../admin/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../admin/vendors/nprogress/nprogress.js"></script>
    <!-- validator -->
<!--     <script src="../admin/vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../admin/build/js/custom.min.js"></script>
</body>
</html>