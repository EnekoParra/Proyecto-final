<%@ include file="../includes/header.jsp"%>

<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<p>Listado de cursos</p>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a data-toggle="modal" href="#modal-migrar">Migrar
						datos</a></li>
			</ul>
		</div>
		<!-- /.container-fluid -->
	</nav>

	<a href="admin/curso/-1"><img id="crearimg" alt="imagen de crear"
		src="resources/img/crear.png"></a> <a href="logout"><img
		id="volverpng" alt="Imagen de desconectar"
		src="resources/img/logout.png"></a>

	<p>${msg}</p>

	<table class="responstable" id="tabla">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Codigo</th>
				<th><label for="buscar"><input type="text"
						name="buscar" id="buscador" onkeyup="buscador()"
						placeholder="Busca por nombre.."></input>
				</label></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${curso}" var="c">
				<tr>
					<td>${c.nombre}</td>
					<td>${c.codigo}</td>
					<td><a href="admin/curso/${c.id}"><img id="modificarimg"
							alt="Imagen para modificar" src="resources/img/modificar.png"></a>
						<a href="admin/eliminar/${c.id}"><img id="eliminarimg"
							alt="Imagen para borrar" src="resources/img/eliminar.png"></a></td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<c:if test="${empty curso}">
		<td><p>No hay cursos disponibles</p></td>
	</c:if>

	<button onclick="subir()" id="subir">Subir</button>

</div>

<!--  Modal de validacion para migrar datos -->
<div id="modal-migrar" class="modal fade" role="dialog">
	<div class="modal-dialog">

		<!-- Modal content-->
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h4 class="modal-title">Migración</h4>
			</div>
			<div class="modal-body">
				<p>¿Esta seguro que desea migrar el archivo?</p>
				<p>El proceso de migración de datos puede tardar varios
					segundos.</p>
				<p>Por favor, tenga paciencia.</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-info" data-dismiss="modal"
					onclick="location.href='admin/migrar'">Migrar</button>
				<button type="button" class="btn btn-info" data-dismiss="modal">Cancelar</button>
			</div>
		</div>
	</div>
</div>
<%@ include file="../includes/footer.jsp"%>