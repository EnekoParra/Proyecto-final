<%@ include file="../includes/header.jsp"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<p>Listado de cursos</p>
		</div>
	</div>
	<!-- /.container-fluid -->
</nav>


<a href="admin/curso/-1"><img id="crearimg" src="resources/img/crear.png"></a>
	

<table class="responstable">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Codigo</th>
			<th></th>
		</tr>
	</thead>
	<c:forEach items="${curso}" var="c">
		<tbody>
			<tr>
				<td>${c.nombre}</td>
				<td>${c.codigo}</td>
			</tr>
		</tbody>
	</c:forEach>
</table>



<%@ include file="../includes/footer.jsp"%>