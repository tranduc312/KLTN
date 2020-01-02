<%@page import="common.StringProcess" %>
<%@page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
      <script src="../js/jquery-1.11.1.min.js"></script>
      <script src="../js/bootstrap.min.js"></script>
      <link href="../css/bootstrap.min.css" rel="stylesheet" >
      <link rel="stylesheet" type="text/css" href="../css/login.css">
      <link rel="stylesheet" type="text/css" href="../font-awesome.min.css">
      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Đăng Nhập</title>
</head>
<body>
	<div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title">Đăng Nhập & Đăng Ký</h4>
                </div>               
                
                <div class="modal-body">                                       
                <div class="col-md-6 col-sm-6 no-padng">
                    <div class="model-l">                    
                    <form method="post" action="login" class="log-frm" > 
	                    <ul>                                                     
	                        <li>Email</li>
	                        <li> <input type="text" placeholder="Email"  name="Email" class="form-control" ></li>
	                        <li>Mật Khẩu</li>
	                        <li><input type="password" placeholder="Mật Khẩu"  name="Mat_Khau" class="form-control" ></li>                                                
	                        </br>
	                        <section>
				                <button class="button"><span>Đăng Nhập</span></button>
				                <br><br>
				            </section>
                        </ul>
                    </form>                      
                    <div class="clearfix"></div>
                    <form method="post" id="logFrm1" class="log-frm" name="logFrm1"> 
                       <ul>                                    
                           <li>
                               <a class="for-got" onclick="ayantoggle();" href="javascript:;">Quên Mật Khẩu?</a>
                               <div class="forgot">
	                               <ul>                                          
		                               <li><p>Nhập địa chỉ email của bạn ở đây để nhận liên kết để thay đổi mật khẩu.</p></li>
		                               <li>Email Id</li>
		                               <li><input type="text" placeholder="Your email id" id="forgetemailId" class="form-control" name="forgetemailId"></li>
		                               <li><button type="button" class="btn btn-default" onclick="forgot();">Send Mail</button></li>
                           		   </ul> 
                       			</div>
                   			</li>
               			</ul>
                 	</form>
                    </div>
                    </div>    
                    <div class="col-md-6 col-sm-6 no-padng">
                        <div class="model-r">
                        <div class="o-r">
                        <span>OR</span>
                        </div>
                             <form method="post" action="login" class="log-frm" >  
                            <ul>
                            <li>Email</li>
                            <li><input type="text" placeholder="Email" name="Email1" class="form-control"></li>
                            <li>Mật Khẩu</li>
                            <li><input type="password" placeholder="Password" name="Mat_Khau1" class="form-control"></li>
                            <li>Số Điện Thoại</li>
                            <li><input type="text" placeholder="Số Điện Thoại" name="SDT" class="form-control"></li>
                            <li>Tên cửa hàng/Tên khách hàng</li>
                            <li><input type="text" placeholder="Tên cửa hàng/khách hàng" name="Ten_Shop" class="form-control"></li>
                            <li>Địa Chỉ</li>
                            <li><input type="text" placeholder="Địa chỉ shop" name="Ten_Shop" class="form-control"></li>
                           <br> <button class="button" type="submit" value="submit" name="submit"><span>Đăng Ký</span></button>
                             <div style="display:none;" class="sign greenglow">
                                 <li>   <i class="icon-check"></i><br>
                                     <font color="red"> 
                                     Đăng ký thành công.<br>
                                      Your login Url already send to your email.
                                     
                                     </font></li>
                          </div>
                           <div style="display:none;" id="regnSuc11" class="sign redglow">
                               <li>   <i class="icon-mail"></i><br>
                                   <font color="red">    Email Exist.</font></li>
                          </div> 
                        </ul>
                    </form>
                        </div>
                        </div>
                        
                        <div class="clearfix"></div>
                    </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Đóng</button>
                </div>
            </div>
        </div>
</body>
</html>