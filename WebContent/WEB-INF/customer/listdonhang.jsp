<%@page import="model.bean.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="common.StringProcess" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.bean.Shop"%>
<%@page import="model.bean.Don_Hang"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="images/favicon.ico" type="image/ico" />

    <title>Giao Hang </title>
    <!-- css-customer -->
    <link rel="stylesheet" type="text/css" href="../admin/build/css/style-customer.css">
    <!-- Bootstrap -->
    <link href="../admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="../admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="../admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="../admin/vendors/iCheck/skins/flat/green.css" rel="stylesheet">
    
    <!-- bootstrap-progressbar -->
    <link href="../admin/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css" rel="stylesheet">
    <!-- JQVMap -->
    <link href="../admin/vendors/jqvmap/dist/jqvmap.min.css" rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="../admin/vendors/bootstrap-daterangepicker/daterangepicker.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="../admin/build/css/custom-customer.min.css" rel="stylesheet">
</head>
<body class="nav-md">
<jsp:include page="header.jsp"></jsp:include>
<div class="right_col" role="main">
        <button class="tablink" onclick="openPage('ALL', this, 'orange')">Tất cả</button>
        
        <button class="tablink" onclick="openPage('DangXuLy', this, 'orange')" >Đang Xử Lý</button>
        <button class="tablink" onclick="openPage('DangNhan', this, 'orange')">Đang Nhận</button>
        <button class="tablink" onclick="openPage('DangGiao', this, 'orange')">Đang Giao</button>
        <button class="tablink" onclick="openPage('ThanhCong', this, 'orange')">Thành công</button>
        <button class="tablink" onclick="openPage('Huy', this, 'red')">Đã Hủy</button>
        <button class="btn btn-success btn-lg"><a href="adddonhang" title="Tạo đơn hàng mới"><i class="fa fa-plus-square"></i> Tạo</a></button>
        
        <div id="ALL" class="tabcontent">
          <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Tất Cả Đơn Hàng<small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                        <!--   <th>Tình Trạng</th> -->
                        </tr>
                      </thead>


                      <tbody>
							<%
								ArrayList<User> listuser = (ArrayList) request.getAttribute("listuser");
								ArrayList<Shop> listshop = (ArrayList) request.getAttribute("listshop");
								ArrayList<Don_Hang> listdonhang = (ArrayList) request.getAttribute("listdonhang");
								ArrayList<Don_Hang> listdonhang_user = (ArrayList) request.getAttribute("listdonhang_user");
								/* ArrayList<Don_Hang> listdonhang_tinhtrang = (ArrayList) request.getAttribute("listdonhang_tinhtrang"); */
								String tenuser="";
								String tenshop = "";
								String tinhtrang="";
								for(Shop shop : listshop){
									for(Don_Hang donhang_user : listdonhang_user){
										if(shop.getID_Shop()==donhang_user.getID_Shop()){
											tenshop=shop.getTen_Shop();
										/* switch(donhang_user.getTinh_Trang()){
										case 1:
											tinhtrang="Đang Xử Lý ";
										case 2:
											tinhtrang="Đang Nhận";
										case 3:
											tinhtrang="Đang Giao";
										case 4:
											tinhtrang="Thành Công";
										case 5:
											tinhtrang="Hủy"; */
										
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<%-- <td><%=tinhtrang %></td> --%>
								</tr>
							<%}}}%>
                      </tbody>
                    </table>
                  </div>
                </div>
        </div>

        <div id="DangXuLy" class="tabcontent">
                    <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Đơn Hàng Đang Xử Lý<small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                          <th>Tình Trạng</th>
                          <th colspan="2">Tủy Chỉnh</th>	
                        </tr>
                      </thead>


                      <tbody>
                     		<% 
							for(Shop shop : listshop){
								for(Don_Hang donhang_user : listdonhang_user ){
									if(  donhang_user.getID_Shop()==shop.getID_Shop() && donhang_user.getTinh_Trang()==1 ){
										tenshop=shop.getTen_Shop();
										tinhtrang="Đang xử lý";
											
										
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<td><%=tinhtrang %></td>
									<td>
										<button>
										<a href="editdonhang?ID_DH=<%=donhang_user.getID_DH()%>" title="Sửa"><i class="fa fa-edit"></i></a>
										</button>
									</td>
									<td>
										<button onclick="xoa()">
										<a href="canceldonhang?ID_DH=<%=donhang_user.getID_DH()%>" title="Hủy"><i class="fa fa-times"></i></a>
										</button>
									</td>
								</tr>
							<%}}} %>
                      </tbody>
                    </table>
                  </div>
                </div>
          
        </div>

        <div id="DangNhan" class="tabcontent">
                    <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Đơn Hàng Đang Nhận <small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                          <th>Tình Trạng</th>	
                        </tr>
                      </thead>


                      <tbody>
							<%
							for(Shop shop : listshop){
								for(Don_Hang donhang_user : listdonhang_user ){
									if(  donhang_user.getID_Shop()==shop.getID_Shop() && donhang_user.getTinh_Trang()==2 ){
										tenshop=shop.getTen_Shop();
										tinhtrang="Đã Nhận";
										
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<td><%=tinhtrang%></td>
								</tr>
							<%}}} %>
                      </tbody>
                    </table>
                  </div>
                </div>
          
        </div>
		
		 <div id="DangGiao" class="tabcontent">
                    <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Đơn Hàng Đang Giao <small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>	
                          <th>Tình Trạng</th>
                        </tr>
                      </thead>


                      <tbody>
                     		<% 
							for(Shop shop : listshop){
									for(Don_Hang donhang_user : listdonhang_user ){
										if(  donhang_user.getID_Shop()==shop.getID_Shop() && donhang_user.getTinh_Trang()==3 ){
											tenshop=shop.getTen_Shop();
											tinhtrang="Đang Giao";
											
										
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<td><%=tinhtrang %></td>
								</tr>
							<%}}} %>
                      </tbody>
                    </table>
                  </div>
                </div>
          
        </div>
		
        <div id="ThanhCong" class="tabcontent">
                    <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Đơn Hàng Đã Giao Thành Công <small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                          <th>Tình Trạng</th>	
                        </tr>
                      </thead>


                      <tbody>
							<%
								
							for(Shop shop : listshop){
								for(Don_Hang donhang_user : listdonhang_user ){
									if(  donhang_user.getID_Shop()==shop.getID_Shop() && donhang_user.getTinh_Trang()==4 ){
										tenshop=shop.getTen_Shop();
										tinhtrang="Thành Công";
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<td><%=tinhtrang%></td>
								</tr>
							<%}}} %>
                      </tbody>
                    </table>
                  </div>
                </div>
          
        </div>
        <div id="Huy" class="tabcontent">
                    <div class="x_panel">
                  <div class="x_title">
                    <h2>Danh Sách Đơn Hàng Đã Hủy <small></small></h2>
                    <div class="clearfix"></div>
                  </div>
                  <div class="x_content">
                    
                    <table id="datatable" class="table table-striped table-bordered">
                      <thead>
                        <tr>
                          <th>ID Đơn Hàng</th>
                          <th>Tên Shop</th>
                          <th>Tên Người Nhận</th>
                          <th>SDT Người nhận</th>
                          <th>Địa Chỉ nhận</th>
                          <th>Ngày Tạo</th>
                          <th>Tiền Thu Hộ</th>
                          <th>Cước Phí</th>
                          <th>Tổng Tiền</th>
                          <th>Tình Trạng</th>
                          <th>Tùy Chỉnh</th>
                        </tr>
                      </thead>


                      <tbody>
							<%
							for(Shop shop : listshop){
								for(Don_Hang donhang_user : listdonhang_user ){
									if(  donhang_user.getID_Shop()==shop.getID_Shop() && donhang_user.getTinh_Trang()==5 ){
										tenshop=shop.getTen_Shop();
										tinhtrang="Hủy";
							%>
								<tr>
									<td><%=donhang_user.getID_DH() %></td>
									<td><%=tenshop %></td>
									<td><%=donhang_user.getTen_Nguoi_Nhan() %></td>
									<td><%=donhang_user.getSDT_Nhan() %></td>
									<td><%=donhang_user.getDC_Nhan() %></td>
									<td><%=donhang_user.getNgay_Lap() %></td>
									<td><%=donhang_user.getTien_Thu_Ho() %></td>
									<td><%=donhang_user.getCuoc_Phi() %></td>
									<td><%=donhang_user.getCuoc_Phi()+donhang_user.getTien_Thu_Ho() %></td>
									<td><%=tinhtrang %></td>
									<td>
										<button><a href="undodonhang?ID_DH=<%=donhang_user.getID_DH()%>" title="Hoàn Tác"><i class="fa fa-undo"></i></a>
										
										</button>
									</td>
								</tr>
							<%}}} %>
                      </tbody>
                    </table>
                  </div>
                </div>
          
        </div>
        </div>
        <!-- /page content -->

<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript" src="../admin/build/js/style-customer.js"></script>
    <!-- jQuery -->
    <script src="../admin/vendors/jquery/dist/jquery.min.js"></script>
    <!-- Bootstrap -->
    <script src="../admin/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
    <!-- FastClick -->

    <!-- Skycons -->
    <script src="../admin/vendors/skycons/skycons.js"></script>
    <!-- DateJS -->
    <script src="../admin/vendors/DateJS/build/date.js"></script>
    <!-- bootstrap-daterangepicker -->
    <script src="../admin/vendors/moment/min/moment.min.js"></script>
    <script src="../admin/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

    <!-- Custom Theme Scripts -->
    <script src="../admin/build/js/custom.min.js"></script>
<script>
function xoa() {
  confirm("Xác nhận xóa");
}
</script>
</body>
</html>