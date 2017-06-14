<%@ include file="includes/header.jsp"%>

<div class="container">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<p>Ultimos cursos</p>
			</div>
			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<div class="navbar-form navbar-center">
						<div class="input-group">
							<span class="input-group-addon"> <span
								class="glyphicon glyphicon-search"></span>
							</span> <input type="text"
								name="autocompletar" id="autocomplete" class="form-control"
								size=70 placeholder="Buscar curso.."></input>
						</div>
					</div>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="admin">Admin</a></li>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
	<c:if test="${empty curso}">
		<h2>No hay cursos disponibles</h2>
	</c:if>
	<ol class="list-group">
		<c:forEach items="${curso}" var="c">
			<li class="list-group-item list-group-item-info"><p>
					${c.nombre}</p></li>
		</c:forEach>
	</ol>
</div>
<%@ include file="includes/footer.jsp"%>
