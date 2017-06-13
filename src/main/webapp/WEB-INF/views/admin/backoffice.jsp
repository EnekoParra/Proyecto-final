<%@ include file="../includes/header.jsp"%>

<div class="container">
<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">

			<p>Listado de cursos</p>
		</div>
		<ul class="nav navbar-nav navbar-right">
				<li><a href="admin/migrar">Migrar datos</a></li>
			</ul>
	</div>
	<!-- /.container-fluid -->
</nav>


<a href="admin/curso/-1"><img id="crearimg" src="resources/img/crear.png"></a>
<a href="logout"><img id="volverpng" src="resources/img/logout.png"></a>

<p>${msg}</p>

<table class="responstable" id="tabla">
	<thead>
		<tr>
			<th>Nombre</th>
			<th>Codigo</th>
			<th>
			<input type="text" id="buscador" onkeyup="buscador()" placeholder="Busca por nombre.."> 
			 </th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${curso}" var="c">
			<tr>
				<td >${c.nombre}</td>
				<td >${c.codigo}</td>
				<td><a href="admin/curso/${c.id}"><img id="modificarimg" src="resources/img/modificar.png"></a>
				<a href="admin/eliminar/${c.id}"><img id="eliminarimg" src="resources/img/eliminar.png"></a></td>
			</tr>
			</c:forEach>
		</tbody>
	
</table>

<c:if test="${empty curso}"><td><p>No hay cursos disponibles</p></td></c:if>

<button onclick="subir()" id="subir">Subir</button>

</div>
<%@ include file="../includes/footer.jsp"%>