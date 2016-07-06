<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<html>
	<meta charset="utf-8">
 	 <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.css" rel="stylesheet">
<body>
<div class="jumbotron">
  <h1>Hello, UserAnnotation!</h1>
  <p>${result}</p>
  <p>
  	<form action="addUser.do" method="post">
	  <div class="form-group">
	    <label for="exampleInputEmail1">Email address</label>
	    <input type="text" class="form-control" id="exampleInputEmail1" placeholder="Email" name="email">
	  </div>
	  <div class="form-group">
	    <label for="exampleInputPassword1">Password</label>
	    <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password" name="pwd">
	  </div>
	  <button type="submit" class="btn btn-default">Submit</button>
	</form>
  </p>
  <p><a class="btn btn-primary btn-lg" href="#" onclick="add();" role="button">Ajax</a></p>
</div>

<div class="panel panel-info">
	<div class="panel-heading">查找</div>
	<div class="panel-body">
		<div class="input-group input-group-lg">
		  <span class="input-group-addon" id="sizing-addon1">@</span>
		  <input type="text" class="form-control" placeholder="Username" aria-describedby="sizing-addon1">
		  <span class="input-group-btn">
	        <button class="btn btn-default" type="button">Find!</button>
	      </span>
		</div>
	</div>
</div>
<table class="table table-striped">
	<tr>
		<th>ID</th>
		<th>Name</th>
		<th>Pwd</th>
		<th>操作</th>
	</tr>
	<c:if test="${!empty list}">
		<c:forEach items="${list}" var="it">
			<tr>
				<td>${it.id}</td>
				<td>${it.email}</td>
				<td>${it.pwd}</td>
				<td>
					<div class="btn-group" role="group" aria-label="...">
						<button type="button" class="btn btn-primary" onclick="getUser(${it.id});">修改</button>
						<button type="button" class="btn btn-danger"  onclick="deleteUser(${it.id});">删除</button>
					</div>
				</td>
			</tr>
		</c:forEach>
	</c:if>
</table>

<div class="panel panel-default">
  <div class="panel-heading">
    <h3 class="panel-title">修改单个<small>从上面选择</small></h3>
  </div>
  <div class="panel-body">
	<div class="input-group input-group-lg">
	  <span class="input-group-addon" >ID</span>
	  <input type="text" class="form-control" id="userId" placeholder="Username" aria-describedby="sizing-addon1" readonly="readonly">
	</div>
	<div class="input-group input-group-lg">
	  <span class="input-group-addon"  >UserName</span>
	  <input type="text" class="form-control" id="UserName" placeholder="PWD" aria-describedby="sizing-addon1">
	</div>
	<div class="input-group input-group-lg">
	  <span class="input-group-addon" >PWD</span>
	  <input type="text" class="form-control" id="UserPwd" placeholder="PWD" aria-describedby="sizing-addon1">
	</div>
	<div class="btn-group" role="group" aria-label="...">
	  <button type="button" class="btn btn-primary" onclick="updateUser();">提交</button>
	  <button type="button" class="btn btn-info" onclick="cleanData();">清除</button>
	</div>
  </div>
</div>

</body>
   <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../dist/js/jquery.min.js"></script>
    <script src="../dist/js/bootstrap.min.js"></script>
    <script type="text/javascript">
		    
    function deleteUser(id){
    	$.ajax({
	    	type: "POST",
	    	url:"deleteUser.do",
	    	data:{'userId':id},
	    	dataType:'json',
	    	cache: false,
	    	success:function(data){
	    		alert(data + "_");
	    		window.location.reload();
	    	},
	    	timeout:(10000),
	    	error:function(){
	    		appendAlertDanger("alertDivSID","查询失败!请查看网络是否正常！");
	    		$('#modalDefault #submitLink').removeClass("disabled");
	    	}
	    });
    }
    
    function getUser(id){
    	$.ajax({
	    	type: "POST",
	    	url:"getUser.do",
	    	data:{'userId':id},
	    	dataType:'json',
	    	cache: false,
	    	success:function(data){
	    		if(data != false){
	    			$("#userId").val(data.id);
	    			$("#UserName").val(data.email);
	    			$("#UserPwd").val(data.pwd);
	    		}
	    	},
	    	timeout:(10000),
	    	error:function(){
	    		appendAlertDanger("alertDivSID","查询失败!请查看网络是否正常！");
	    		$('#modalDefault #submitLink').removeClass("disabled");
	    	}
	    });
    }
    
    function updateUser(){
    	$.ajax({
	    	type: "POST",
	    	url:"updateUser.do",
	    	data:{'id':$("#userId").val(),'email':$("#UserName").val(),'pwd':$("#UserPwd").val()},
	    	dataType:'json',
	    	cache: false,
	    	success:function(data){
	    		if(data != false){
	    			alert(data);
	    			window.location.reload();
	    		}
	    	},
	    	timeout:(10000),
	    	error:function(){
	    		appendAlertDanger("alertDivSID","查询失败!请查看网络是否正常！");
	    		$('#modalDefault #submitLink').removeClass("disabled");
	    	}
	    });
    }
    
    
    function cleanData(){
    	$("#userId").val("");
		$("#UserName").val("");
		$("#UserPwd").val("");
    }
    
    </script>
</html>
