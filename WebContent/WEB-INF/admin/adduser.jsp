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
                <h3>Thêm User</h3>
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

                    <form action="adduser" method="post" class="form-horizontal form-label-left" novalidate>

                      
                      <span class="section">Thông Tin Tài Khoản</span>
                      <div>
                          <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                      </div>
                      <div class="item form-group">
                      </div>

                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên Tài Khoản
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input  class="form-control col-md-7 col-xs-12" name="Ten_User"  required="required" type="text">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Email
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="email"  name="Email" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label  class="control-label col-md-3">Mật Khẩu
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input  type="password" name="Mat_Khau"  class="form-control col-md-7 col-xs-12" required="required">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Số Điện Thoại
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input type="tel"  name="SDT" required="required"  class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Địa Chỉ
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input name="Dia_Chi" class="form-control col-md-7 col-xs-12">
                        </div>
                      </div>
                       <div class="item form-group">
                       <label class="control-label col-md-3 col-sm-3 col-xs-12" >Vai Trò
                        </label>
                      <div class="col-md-6 col-sm-6 col-xs-12">
                          <select name="ID_Role" class="optional form-control col-md-7 col-xs-12">
                            <option>Chọn vai trò</option>
                            <option value="2">Cửa hàng</option>
                            <option value="3">Nhân viên giao nhận hàng</option>
                            <option value="4">Nhân viên điều phối</option>
                            <option value="5">Nhân viên kế toán</option>
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
    <!-- validator -->
<!--     <script src="../admin/vendors/validator/validator.js"></script> -->

    <!-- Custom Theme Scripts -->
    <script src="../admin/build/js/custom.min.js"></script>
</body>
</html>