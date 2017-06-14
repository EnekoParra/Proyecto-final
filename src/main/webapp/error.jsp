<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ page session="false" %>

<html>
<head>
	<title>Curso</title>
	<base href="/formacion/" />
	<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
	<link href="http://getbootstrap.com/dist/css/bootstrap.min.css" rel="stylesheet" />
	
	<!-- Custom -->
	<link href="resources/css/custom.css" rel="stylesheet">
</head>
<body>
<body class="login_bg">
<div class="container">
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<p>Admin Backoffice</p>
		</div>
		<ul class="nav navbar-nav navbar-right">
			</ul>
	</div>
	<!-- /.container-fluid -->
</nav>
<p> El usuario y/o password son incorrectos. Vuelve a intentarlo.</p>
	<form action="login" method="post" class="form-horizontal">
	
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
	
		<label for="usuario">Usuario</label>
		<input type="text" id="usuario" name="usuario" class="form-control">
		
		<label for="clave">Password</label>
		<input type="password" id="clave" name="clave" class="form-control">
		
		<br>
		<a href="" class="btn btn-primary">Volver</a>
		<input type="submit"  class="btn btn-default" value="Login">
	</div>
	</div>
</form>
</div>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
 <script src="http://getbootstrap.com/dist/js/bootstrap.min.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script src="resources/js/curso.js"></script>
</body>
</html>