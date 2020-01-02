<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <title>Giao Hang</title>

  <!--  <link href="../customer/css/bootstrap4.1.1.min.css" rel="stylesheet" >
   <link href="../customer/css/styleprofile.css" rel="stylesheet"> -->
   <link href="../customer/css/styleprofile.css" rel="stylesheet">
   	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="http://maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
	<script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    
</head>
<body>
<!------ Include the above in your HEAD tag ---------->

<div class="container emp-profile">
            <form method="post">
                <div class="row">
                    <div class="col-md-4">
                        <div class="profile-img">
                            <img src="profile.png" alt=""/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="profile-head">
                                    <h5>
                                        ${user.ten_User}
                                    </h5>
                                    <h6>
                                        <c:forEach items="${listvaitro}" var="vaitro">
                                        <c:if test="${vaitro.ID_Role==user.ID_Role}">
                                           ${vaitro.vai_Tro}
                                        </c:if>
                                        </c:forEach>
                                    </h6> <br><br><br>
                            <ul class="nav nav-tabs" id="myTab" role="tablist">
                                <li class="nav-item">
                                    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Thông Tin</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="col-md-2">
                        <input type="submit" class="profile-edit-btn" name="btnAddMore" value="Edit Profile"/>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4">
                        <!-- khoang trong -->
                    </div>
                    <div class="col-md-8">
                        <div class="tab-content profile-tab" id="myTabContent">
                            <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                                        <input 
                                        name="ID_User"  required="required" type="hidden" value="${user.ID_User}" readonly>

                                        <div class="row">
                                        <div class="col-md-6">
                                            <label>Tên User</label>
                                        </div>
                                            <div class="col-md-6">
                                              <input class="col-md-6" 
                                              name="Ten_User"  required="required" value="${user.ten_User}" readonly>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Địa Chỉ</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input class="col-md-6" name="Dia_Chi"  required="required" value="${user.dia_Chi}" readonly>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Số Điện Thoại</label>
                                            </div>
                                            <div class="col-md-6">
                                                 <input class="col-md-6" name="SDT"  required="required"  value="${user.SDT}" readonly>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Email</label>
                                            </div>
                                            <div class="col-md-6">
                                                <input class="col-md-6"  name="Email"  required="required" value="${user.email}" readonly>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col-md-6">
                                                <label>Vai Trò</label>
                                            </div>
                                            <div class="col-md-6">
                                                <c:forEach items="${listvaitro}" var="vaitro">
                                                <c:if test="${vaitro.ID_Role==user.ID_Role}">
                                                  <input class="col-md-6" 
                                                  name="ID_Role"  required="required"  value="${vaitro.vai_Tro}" readonly>
                                                </c:if>
                                                </c:forEach>
                                            </div>
                                        </div>
                            </div>
                        </div>
                    </div>
                </div>
            </form>           
        </div>
        <!-- 
   <script src="../customer/js/bootstrap4.1.1.min.js"></script>
   <script src="../customer/js/query3.2.1.min.js"></script> -->
</body>
</html>