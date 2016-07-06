<html>
	<meta charset="utf-8">
 	 <!-- Bootstrap core CSS -->
    <link href="../dist/css/bootstrap.css" rel="stylesheet">
<body>
<div class="jumbotron">
  <h1>Hello, FileUpload!</h1>
  <p>${result}</p>
  <p>
  	<form class="form-inline" method="post" action="upload" enctype="multipart/form-data">
  		 <div class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" name="file">
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
  	
	  <button type="submit" class="btn btn-primary btn-lg">submit</button>
	</form>
	
	<form class="form-inline" method="post" action="upload2" enctype="multipart/form-data">
  		 <div class="form-group">
		    <label for="exampleInputFile">File input</label>
		    <input type="file" name="file">
		    <p class="help-block">Example block-level help text here.</p>
		  </div>
  	
	  <button type="submit" class="btn btn-primary btn-lg">submit</button>
	</form>
	
  </p>
  <p><a class="btn btn-primary btn-lg" href="test2" role="button">#</a></p>
</div>
</body>
   <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="dist/js/jquery.min.js"></script>
    <script src="dist/js/bootstrap.min.js"></script>
</html>
