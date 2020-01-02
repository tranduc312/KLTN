<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.Don_Hang" %>
<%@page import="model.bean.Shop" %> 
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Giao Hang</title>

    <!-- Bootstrap -->
    <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../admin/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    <!-- Datatables -->
    <link href="../admin/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css" rel="stylesheet">
    <link href="../admin/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css" rel="stylesheet">
    <link href="../admin/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css" rel="stylesheet">
    <link href="../admin/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css" rel="stylesheet">
    <link href="../admin/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../admin/build/css/custom-customer.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<!-- header -->
<jsp:include page="header.jsp"></jsp:include>
<div class="right_col" role="main">
<jsp:include page="searchdonhang.jsp"></jsp:include>
          <div class="">
            <div class="page-title">

            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Tên Người Nhận</th>
                          <th>Số Điện Thoại Nhận</th>
                          <th>Địa Chỉ Nhận</th>
                          <th>Ngày giờ giao</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                        </tr>
                      </thead>


                      <tbody>
							<c:forEach items="${listdonhang_search}" var="donhang">
							<%-- <c:forEach items="${listshop}" var="shop">
							<c:if test="${shop.ID_Shop==donhang.ID_Shop}"> --%>
							<tr>
								<td>${donhang.ID_DH}</td>
								<td>${donhang.ten_Nguoi_Nhan}</td>
								<td>${donhang.SDT_Nhan}</td>
								<td>${donhang.DC_Nhan}</td>
								<td>${donhang.ngay_Lap}</td>
								<td>${donhang.tien_Thu_Ho}</td>
								<td>${donhang.cuoc_Phi}</td>
								<td>${donhang.cuoc_Phi + donhang.tien_Thu_Ho}</td>
							</tr>
							<%-- </c:if>
							</c:forEach> --%>
							</c:forEach>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
             </div>
            </div>
           </div>
              
<!-- footer -->
<jsp:include page="footer.jsp"></jsp:include>

<script src="../admin/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->
    <script src="../admin/vendors/fastclick/lib/fastclick.js"></script>
    <!-- NProgress -->
    <script src="../admin/vendors/nprogress/nprogress.js"></script>
    <!-- iCheck -->
    <script src="../admin/vendors/iCheck/icheck.min.js"></script>
    <!-- Datatables -->
    <script src="../admin/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
    <script src="../admin/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
    <script src="../admin/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
    <script src="../admin/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
    <script src="../admin/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
    <script src="../admin/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
    <script src="../admin/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
    <script src="../admin/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
    <script src="../admin/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
    <script src="../admin/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
    <script src="../admin/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
    <script src="../admin/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
    <script src="../admin/vendors/jszip/dist/jszip.min.js"></script>
    <script src="../admin/vendors/pdfmake/build/pdfmake.min.js"></script>
    <script src="../admin/vendors/pdfmake/build/vfs_fonts.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../admin/build/js/custom.min.js"></script>
</body>
</html>