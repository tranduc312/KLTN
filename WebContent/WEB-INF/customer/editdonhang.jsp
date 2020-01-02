<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.Shop" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">

    <title>Giao Hang</title>

    <!-- Bootstrap -->
    <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    
    <!-- Custom Theme Style -->
    <link href="../admin/build/css/custom-customer.min.css" rel="stylesheet">
</head>
<body class="nav-md">
	<!-- page content -->
        <div class="right_col" role="main">
          <div class="">
            <div class="page-title">
              <div class="title_left">
                <h3>Thay đổi thông tin Đơn Hàng</h3>
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

                    <form method="post" action="editdonhang" class="form-horizontal form-label-left">
                    
                    <span class="section">Thông Tin Đơn Hàng</span>
                    <div>
                        <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                    </div>
                    <div class="item form-group">
                    </div>
						
                     
					  <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >ID Đơn Hàng
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="ID_DH"  required="required" value="${donhang.ID_DH}" readonly>
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên Shop 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                        <c:forEach items="${listshop}" var="shop">
                        <c:if test="${shop.ID_Shop==donhang.ID_Shop}">
                          <input class="form-control col-md-7 col-xs-12" name="ID_Shop" value="${shop.ten_Shop}" readonly>
                     	</c:if>
                     	</c:forEach>	
                     	</div>
                      	</div>
                      	<div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Ngày Tạo
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name=""  required="required" type="text" value="${donhang.ngay_Lap}" readonly>
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên Người Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Ten_Nguoi_Nhan"  required="required" type="text" value="${donhang.ten_Nguoi_Nhan}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >SĐT người nhận
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="SDT_Nhan"  required="required" type="text" value="${donhang.SDT_Nhan}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Địa Chỉ Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"
                          name="DC_Nhan"  required="required" type="text" value="${donhang.DC_Nhan}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Khối Lượng 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Khoi_Luong" placeholder="...kg"  required="required" type="number" value="${donhang.khoi_Luong}" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Cao 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Cao" placeholder="...cm"  required="required" type="number" value="${donhang.cao}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Rộng 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Rong" placeholder="..cm" required="required" type="number" value="${donhang.rong}">
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tiền Thu Hộ
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Tien_Thu_Ho"  required="required" type="number" value="${donhang.tien_Thu_Ho}">
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