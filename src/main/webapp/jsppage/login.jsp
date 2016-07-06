<%@ page language="java" contentType="text/html; charset=utf-8"  pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>AdminLTE 2 | Log in</title>
    <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
    <!-- Bootstrap 3.3.2 -->
    <link href="dist/css/bootstrap.css" rel="stylesheet" type="text/css" />
    <!-- Font Awesome Icons -->
    <link href="dist/comstomer/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Theme style -->
    <link href="dist/AdminLTE/dist/css/AdminLTE.min.css" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="dist/AdminLTE/plugins/iCheck/square/blue.css" rel="stylesheet" type="text/css" />

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>
  <body class="login-page">
    <div class="login-box">
      <div class="login-logo">
        <a href="#"><img src="dist/img/JonChan.png" height="45px"/></a>
      </div><!-- /.login-logo -->
      <div class="login-box-body">
        <p class="login-box-msg">Sign in to start your session</p>
        <form action="login.do" method="post" id="login-form">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="Email" name="username" id="uemail"/>
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" placeholder="Password" name="password" id="upassword"/>
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="row">
            <div class="col-xs-8">    
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox" name=""> 记住我
                </label>
              </div>                        
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="submit" class="btn btn-primary btn-block btn-flat" id="btn-submit"  >Sign In</button>
            </div><!-- /.col -->
          </div>
        </form>

        <div class="social-auth-links text-center" id="warningdiv" >
          <!--消息提示预留位-->
        </div><!-- /.social-auth-links -->

        <a href="#">忘记密码？</a><br>
        <a href="register.html" class="text-center">没有账号？</a>

      </div><!-- /.login-box-body -->
    </div><!-- /.login-box -->
    
    

    <!-- jQuery 2.1.3 -->
    <script src="dist/js/jquery.min.js"></script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="dist/js/bootstrap.min.js" type="text/javascript"></script>
    <!-- iCheck -->
    <script src="dist/AdminLTE/plugins/iCheck/icheck.min.js" type="text/javascript"></script>
    <script>
      $(function () {
        $('input').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
      });
	  
	  
	  var reg = /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/;
	  
	  function loginClick() // 函数定义语句
		{
			var uemail = $("#uemail").val();
			var regEmail = reg.test(uemail);
			var uPassword =  $("#upassword").val();
			var reguPassword = uPassword!= "";
			var tmpStr = "";
			if(!regEmail){
				tmpStr += "邮箱格式不正确";
			}else if(!reguPassword){
				tmpStr += "密码不能为空";
			}
			if((!regEmail) || (!reguPassword)){
				var warningdiv = '<div class="alert alert-danger alert-dismissible" role="alert" id="warningdivC" style="display:none;">              <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>              <strong>警告！</strong>  '+tmpStr+'   </div>';
				
				$("#warningdiv").html(warningdiv);
				
				$("#warningdivC").slideDown("slow");
			}else{
				$("#warningdivC").slideUp("slow");
				$.ajax({
				  url: "server/login.php",
				  cache: false,
				  type:"POST",
				  data:"uEmali='"+uemail+"'&uPassword='"+uPassword+"'",
				  success: function(html){
					warningdiv = '<div class="alert alert-success alert-dismissible" role="alert" id="warningdivC" style="display:none;">              <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>              <strong>成功！</strong>  '+html+'   </div>';
					$("#warningdiv").html(warningdiv);
				
					$("#warningdivC").slideDown("slow");
				  }
				});
			}
			
			return false;
		} 

    </script>
  </body>
</html>