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
                <h3>Tạo Đơn Hàng</h3>
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

                    <form action="adddonhang" method="post" class="form-horizontal form-label-left" novalidate>

                      
                      <span class="section">Thông Tin Đơn Hàng</span>
                      <div>
                          <input class="btn btn-primary" type="button" value="Quay lại" onclick="history.go(-1);" />
                      </div>
					  <div class="item form-group">
                      </div>
                      
                       <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên Shop 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <select class="optional form-control col-md-7 col-xs-12" name="ID_Shop" >
								<option >Chọn Shop</option>
								<%
								if(request.getAttribute("listshop_user")!=null){
									ArrayList<Shop> listshop_user = (ArrayList)request.getAttribute("listshop_user");
									for(Shop shop : listshop_user){
								%>
								<option value="<%=shop.getID_Shop()%>"><%=shop.getTen_Shop()%></option>
								<%}}%>
							</select>
                     	</div>
                      	</div>
                      
                     <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tên Người Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Ten_Nguoi_Nhan"  required="required" type="text" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >SĐT người nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="SDT_Nhan"  required="required" type="text" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Địa Chỉ Nhận 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="DC_Nhan"  required="required" type="text" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Khối Lượng
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Khoi_Luong" placeholder="...kg"  required="required" type="number" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Cao 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Cao" placeholder="...cm"  required="required" type="number" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Rộng 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" 
                          name="Rong" placeholder="..cm" required="required" type="number" >
                        </div>
                      </div>
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Tiền Thu Hộ 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Tien_Thu_Ho"  required="required" type="number" >
                        </div>
                      </div>
                      
                      <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" > Dịch Vụ
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                         <select name="Cuoc_Phi" class="optional form-control col-md-7 col-xs-12">
                         <option >chọn dịch vụ</option>
                         <option value="20000">Giao tiết kiệm</option>
                         <option value="30000">Giao nhanh</option>
                         </select>
                        </div>
                      </div>
                      
                      <!-- <div class="item form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" >Cước Phí 
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12"  
                          name="Cuoc_Phi"  required="required" value="30000" readonly>
                        </div>
                      </div> -->
                     <!--  <div class="item form-group">
                      <div class="col-md-6 col-sm-6 col-xs-12">
                          <input class="form-control col-md-7 col-xs-12" data-validate-length-range="6" data-validate-words="2" 
                          name="Tinh_Trang"  required="required" type="hidden" value="1">
                       </div>
                       </div> -->
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