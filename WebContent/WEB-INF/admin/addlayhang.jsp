<%@page import="model.bean.Kho"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.User" %>
<%@page import="model.bean.Don_Hang" %> 
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Giao Hang</title>

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
                <h3>Thêm Nhận Hàng</h3>
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

                    <form action="addlayhang" method="post" class="form-horizontal form-label-left" novalidate>

                      
                      <span class="section">Thông tin Nhận hàng</span>
                      
                      <div style="float:left;">
                      	<input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                      </div>
                      
                      <div class="item form-group">
                      
                      </div>

                      <div class="item form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12" >Nhân Viên Nhận 
                        </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="optional form-control col-md-7 col-xs-12" name="ID_User" >
								<option >Chọn</option>
								<%
								if(request.getAttribute("listuser")!=null){
									ArrayList<User> listuser = (ArrayList)request.getAttribute("listuser");
									for(User user : listuser){
										if(user.getID_Role()==3){
								%>
								<option value="<%=user.getID_User()%>"><%=user.getTen_User()%></option>
								<%}}}%>
							</select>
                     </div>
                     </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Thời Nhận Hàng 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="date"  name="Ngay_Lay" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      
                      <div class="item form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12" >ID Đơn Hàng 
                        </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="optional form-control col-md-7 col-xs-12" name="ID_DH" >
								<option >Chọn</option>
								<%
								if(request.getAttribute("listdonhang")!=null){
									ArrayList<Don_Hang> listdonhang = (ArrayList)request.getAttribute("listdonhang");
									for(Don_Hang donhang : listdonhang){
										if(donhang.getTinh_Trang()==1){
								%>
								<option value="<%=donhang.getID_DH()%>"><%=donhang.getID_DH()%></option>
								<%}}}%>
							</select>
                     </div>
                     </div>
                     
                       
                     
                      <div class="ln_solid"></div>
                      <div class="form-group">
                        <div class="col-md-6 col-md-offset-3">
                          <button id="send" type="submit" name="submit" value="submit"  class="btn btn-success">Tạo</button>
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
    <!-- datetimepick -->
    <script src="../admin/build/js/style-customer.js"></script>
    <!-- validator -->
<!--     <script src="../admin/vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../admin/build/js/custom.min.js"></script>
</body>
</html>