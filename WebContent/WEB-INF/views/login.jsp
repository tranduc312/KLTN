<%@page import="common.StringProcess"%>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html >
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Giao Hang</title>

    <!-- Bootstrap -->
    <link href="admin/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="admin/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="admin/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- Animate.css -->
    <link href="admin/vendors/animate.css/animate.min.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="admin/build/css/custom.min.css" rel="stylesheet">
  </head>

  <body class="login">
    <div>
      <a class="hiddenanchor" id="signup"></a>
      <a class="hiddenanchor" id="signin"></a>

      <div class="login_wrapper">
        <div class="animate form login_form">
          <section class="login_content">
            <form action="login" method="post">
              <h1>ĐĂNG NHẬP</h1>
              <div>
                <input type="text" class="form-control" placeholder="Email" name="Email" required="" />
              </div>
              <div>
                <input type="password" class="form-control" placeholder="Mật Khẩu" name="Mat_Khau" required="" />
              </div>
              <div>
                <p style="color: red;"><%=StringProcess.getVaildString((String)request.getAttribute("thongbao")) %></p>
              </div>
              <div>
                <button class="btn btn-primary" type="submit" value="submit" name="submit">Đăng nhập</button>
              </div>

              <div class="clearfix"></div>

            </form>
          </section>
        </div>

        
        </div>
      </div>
    </div>
  </body>
</html>
