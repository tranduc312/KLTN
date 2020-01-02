<%@page import="model.bean.CTGD"%>
<%@page import="model.bean.Giao_Dich"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList"%>
<%@page import="model.bean.User" %>
<%@page import="model.bean.Shop" %>
<%@page import="model.bean.Giao_Dich" %>
<%@page import="model.bean.Don_Hang" %>
<%@page import="model.bean.CTGD" %>
<%@page import="common.StringProcess" %>
 
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
    <link href="../admin/build/css/custom.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<!-- header -->
<jsp:include page="header.jsp"></jsp:include>
<div class="right_col" role="main">
          <div class="">
            <div class="page-title">

              
              </div>
            </div>

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                  
                    <div class="nav navbar-right panel_toolbox">
	                  	<button class="btn btn-success btn-lg"><a href="addctgd"><i class="fa fa-plus-square"> Thêm CTGD</i></a>
	                  	</button>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    <h2>Danh sách giao dịch <small></small></h2>
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Giao Dịch</th>
                          <th>Người Lập</th>
                          <th>Tên Shop</th>
                          <th>Ngày Trả</th>
                        </tr>
                      </thead>


                      <tbody>
							<c:forEach items="${listuser }" var="user">
							<c:forEach items="${listshop }" var="shop">
							<c:if test="${user.ID_User==giaodich_id.ID_User && giaodich_id.ID_Shop==shop.ID_Shop}">
								<tr>
									<td>${giaodich_id.ID_GD }</td>
									<td>${user.ten_User }</td>
									<td>${shop.ten_Shop}</td>
									<td>${giaodich_id.ngay_Tra }</td>
								</tr>
								</c:if>
								</c:forEach>
								</c:forEach>
                      </tbody>
                    </table>
                    <h2>Danh sách chi tiết giao dịch <small></small></h2>
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Giao Dịch</th>
                          <th>ID Đơn Hàng</th>
                          <th>Thành Tiền</th>
                        </tr>
                      </thead>
                      <tbody>
							<%
								ArrayList<CTGD> listctgd = (ArrayList) request.getAttribute("listctgd");
								ArrayList<Don_Hang> listdonhang = (ArrayList) request.getAttribute("listdonhang");
								int tienthuho = 0;
								for(CTGD ctgd : listctgd){
									for(Don_Hang donhang : listdonhang){
										if(donhang.getID_DH()==ctgd.getID_DH()){
										tienthuho=donhang.getTien_Thu_Ho();
							%>
							<tr>
								<td><%=ctgd.getID_GD() %></td>
								<td><%=ctgd.getID_DH() %></td>
								<td><%=tienthuho %></td>
								
							</tr>
							<%}}} %>
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
<script>
function xoa() {
  confirm("Xác nhận");
}
</script>
</body>
</html>