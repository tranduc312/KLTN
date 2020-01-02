<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.Don_Hang" %>
<%@page import="model.bean.User" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">

    <title>Giao Hangg </title>

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
                <h3>Thay đổi thông tin Nhận Hàng</h3>
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

                    <form method="post" action="editlayhang" class="form-horizontal form-label-left">
						
                     
                      <span class="section">Thông Tin Nhận Hàng </span>
                      
                      <div>
                          <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                      </div>
                      <div class="item form-group">
                      	
                      </div>
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >ID
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="ID_LH"  required="required" type="text" value="${layhang.ID_LH}" readonly>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Nhân Viên Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="optional form-control col-md-7 col-xs-12" name="ID_User" >
                          		<option >Chọn</option>
                            <c:forEach items="${listuser}" var="user">
                            <c:if test="${user.ID_Role==3}">
								<option value="${user.ID_User}">${user.ten_User}</option>
							</c:if>
							</c:forEach>
							</select>
                     </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Thời Gian Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date"  name="Ngay_Lay"  required="required"  class="form-control col-md-7 col-xs-12"
                          value="${layhang.ngay_Lay}">
                        </div>
                      </div>
                      <div class="item form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12" >ID Đơn Hàng
                        </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="optional form-control col-md-7 col-xs-12" name="ID_DH" >
								<option >Chọn</option>
								<c:forEach items="${listdonhang}" var="donhang">
								<c:if test="${donhang.tinh_Trang==1}">
								<option value="${donhang.ID_DH}">${donhang.ID_DH}</option>
								</c:if>
								</c:forEach>
							</select>
                     </div>
                     </div>
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button id="send" class = "btn btn-success" type="submit" name="submit" value="submit"  >Lưu</button>
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