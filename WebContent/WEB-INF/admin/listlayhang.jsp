<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.User" %>
<%@page import="model.bean.Lay_Hang" %> 
<%@page import="model.bean.Shop" %> 
<%@page import="model.bean.Don_Hang" %> 
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

            <div class="clearfix"></div>

            <div class="row">
              <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh sách nhận hàng <small></small></h2>
                    <div class="nav navbar-right panel_toolbox">
	                  	<button class="btn btn-success btn-lg"><a href="addlayhang"><i class="fa fa-plus-square"> Thêm mới</i></a>
	                  	</button>
                    </div>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID</th>
                          <th>Tên Nhân Viên Nhận Hàng</th>
                          <th>Tên Shop</th>
                          <th>Địa Chỉ</th>
                          <th>Số Điện Thoại</th>
                          <th>Thời Gian Nhận</th>
                          <th>ID Đơn Hàng Nhận</th>
                          <th colspan="2">Tùy Chỉnh</th>
                        </tr>
                      </thead>


                      <tbody>
						  <%
	                      	ArrayList<User> listuser = (ArrayList) request.getAttribute("listuser");
	                    	ArrayList<Lay_Hang> listlayhang = (ArrayList) request.getAttribute("listlayhang");
                    		ArrayList<Shop> listshop = (ArrayList) request.getAttribute("listshop");
                    		ArrayList<Don_Hang> listdonhang = (ArrayList) request.getAttribute("listdonhang");
	                    	String tenuser="";
	                    	String tenshop="";
	                    	for(User user : listuser){
	                    		for(Lay_Hang layhang : listlayhang){
	                    			for(Shop shop : listshop){
	                    				for(Don_Hang donhang : listdonhang){
	                    					if(shop.getID_Shop()==donhang.getID_Shop()){
	                    						tenshop=shop.getTen_Shop();
	                    						if(donhang.getID_DH()==layhang.getID_DH()){
	                    							if(user.getID_User()==layhang.getID_User()){
	                    								tenuser=user.getTen_User();
	                    							
	                    					
	                      %>
	                      	<tr>
	                      		<td><%=layhang.getID_LH() %></td>
	                      		<td><%=tenuser %></td>
	                      		<td><%=tenshop %></td>
	                      		<td><%=shop.getDia_Chi()%></td>
	                      		<td><%=shop.getSDT()%></td>
	                      		<td><%=layhang.getNgay_Lay()%></td>
	                      		<td><%=layhang.getID_DH() %></td>
	                      		<td>
										<button>
										<a href="editlayhang?ID_LH=<%=layhang.getID_LH()%>"><i class="fa fa-edit"></i></a>
										</button>
									</td>
									<td>
										<button>
										<a href="deletelayhang?ID_LH=<%=layhang.getID_LH() %>"><i class="fa fa-trash-o"></i></a>
										</button>
									</td>
	                      	</tr>
	                      <%}}}}}}}%>	
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