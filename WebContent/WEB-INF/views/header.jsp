<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <header class="site-navbar js-sticky-header site-navbar-target" role="banner">

        <div class="container">
          <div class="row align-items-center position-relative">


            <div class="site-logo">
              <a href="index.html" class="text-black"><span class="text-primary">Giao Hàng</a>
            </div>

            <div class="col-12">
              <nav class="site-navigation text-right ml-auto " role="navigation">

                <ul class="site-menu main-menu js-clone-nav ml-auto d-none d-lg-block">
                  <li><a href="#home-section" class="nav-link">Trang Chủ</a></li>
                  <li><a href="#services-section" class="nav-link">Về Tôi</a></li>
                  <li><a href="#services-section" class="nav-link">Liên Hệ</a></li>
                  <button class="btn btn-lg btn-primary">
                  <a href="${pageContext.request.contextPath}/login" style="color:white;">Đăng nhâp</a>
                  </button>
                  <button class="btn btn-lg btn-primary" >
                  <a href="${pageContext.request.contextPath}/register" style="color:white;">Đăng Ký</a>
                  </button>
                </ul>
              </nav>

            </div>

            <div class="toggle-button d-inline-block d-lg-none"><a href="#" class="site-menu-toggle py-5 js-menu-toggle text-black"><span class="icon-menu h3"></span></a></div>

          </div>
        </div>

      </header>