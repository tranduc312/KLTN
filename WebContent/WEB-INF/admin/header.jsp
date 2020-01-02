<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <div class="container body">
      <div class="main_container">
        <div class="col-md-3 left_col">
          <div class="left_col scroll-view">
            <div class="navbar nav_title" style="border: 0;">
              <a href="#" class="site_title"> <span>Giao Hàng</span></a>
            </div>

            <div class="clearfix"></div>

            <!-- menu profile quick info -->
            <div class="profile clearfix">
              <div class="profile_info">
                <span>Xin Chào</span>
                <h2>${loginuser.ten_User}</h2>
              </div>
            </div>
            <!-- /menu profile quick info -->

            <br />

            <!-- sidebar menu -->
            <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">
              <div class="menu_section">
                <h3>Tổng quan</h3>
                <ul class="nav side-menu">
                  <li><a href="listshop"><i class="fa fa-list-alt"></i> Quản Lý Shop <span></span></a>
                  </li>
                  <li><a href="listdonhang"><i class="fa fa-list-alt"></i> Quản Lý Đơn Hàng <span ></span></a>
                  </li>
                  <li><a><i class="fa fa-reorder"></i> Quản Lý Điều phối <span class="fa fa-chevron-down"></span></a>
                    <ul class="nav child_menu">
                      <li><a href="listlayhang">Nhận Hàng</a></li>    
                      <li><a href="listgiaohang">Giao Hàng</a></li>
                    </ul>
                  </li>
                  <li><a ><i class="fa fa-users"></i> Quản Lý Tài Khoản <span class="fa fa-chevron-down"></span></a>
                  	 <ul class="nav child_menu">
                      <li><a href="listuser">Nhân Viên</a></li>    
                      <li><a href="listusershop">Shop</a></li>
                    </ul>
                  </li>
                   <li><a href="#"><i class="fa fa-list-alt"></i> Quản Lý Giao Dịch <span></span></a>
                  </li>
                  <!-- <li><a href="#"><i class="fa fa-bar-chart"></i> Thống Kê<span ></span></a> -->
                </ul>
              </div>

            </div>
            <!-- /sidebar menu -->

            <!-- /menu footer buttons -->
            <div class="sidebar-footer hidden-small">
              <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-minu" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-minu" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-minu" aria-hidden="true"></span>
              </a>
              <a data-toggle="tooltip" data-placement="top" title="Logout" href="login.html">
                <span class="glyphicon glyphicon-minu" aria-hidden="true"></span>
              </a>
            </div>
            <!-- /menu footer buttons -->
          </div>
        </div>

        <!-- top navigation -->
        <div class="top_nav">
          <div class="nav_menu">
            <nav>
              <div class="nav toggle">
                <a id="menu_toggle"><i class="fa fa-bars"></i></a>
              </div>
              <ul class="nav navbar-nav navbar-right">
                <li class="">
                  <a href="javascript:;" class="user-profile dropdown-toggle" data-toggle="dropdown" aria-expanded="false">
                   ${loginuser.ten_User}
                    <span class=" fa fa-angle-down"></span>
                  </a>
                  <ul class="dropdown-menu dropdown-usermenu pull-right">
                    <li><a href="profile"> Hồ sơ</a></li>
                    <li><a href="logout"><i class="fa fa-sign-out pull-right"></i> Đăng xuất</a></li>
                  </ul>
                </li>
              </ul>
            </nav>
          </div>
        </div>
        <!-- /top navigation -->