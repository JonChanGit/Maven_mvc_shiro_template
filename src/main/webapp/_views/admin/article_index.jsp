<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="linkfile/tag.jsp"%>
<%
// String path = request.getContextPath();
// String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
// //相对于主站位置
%>
<!DOCTYPE html>
<html>
  <head> 
    <base href="<%=basePath %>" />
<%@include file="linkfile/headerInfo.jsp" %>
     <title>仪表板</title>
  </head>
  <body class="skin-black">
    <div class="wrapper">
<%@include file="linkfile/headNav.jsp" %>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        
		<!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            仪表板
            <small>文章管理</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="admin_access/index.do"><i class="fa fa-dashboard"></i> Home</a></li>
            <li class="active">文章管理</li>
          </ol>
        </section>
        <!-- Main content -->
        <section class="content"> 
            <div class="jumbotron">
              <h1>文章管理</h1>
              <p>欢迎回来！</p>
              
            </div>
			 <div class="btn-group">
			  <button type="button" class="btn btn-danger">权限测试按钮组</button>
			  <button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    <span class="caret"></span>
			    <span class="sr-only">Toggle Dropdown</span>
			  </button>
			  <ul class="dropdown-menu">
			  	<shiro:hasPermission name="article:update">
<!-- 			  		有权限就显示，没有就不显示 -->
			  		<li><a href="#">修改</a></li>
			  	</shiro:hasPermission>
			  	<shiro:hasPermission name="article:query">
			   		<li><a href="#">查询</a></li>
			    </shiro:hasPermission>
			    <li role="separator" class="divider"></li>
			    <li><a href="#">Separated link</a></li>
			  </ul>
			</div>
        </section><!-- /.content -->

      </div><!-- /.content-wrapper -->
<%@include file="linkfile/foot.jsp" %>
    </div><!-- ./wrapper -->
   
  </body>
<%@include file="linkfile/footInfo.jsp" %>
    <script type="text/javascript"> 
    </script>
</html>