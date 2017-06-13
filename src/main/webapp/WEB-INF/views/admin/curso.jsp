<%@ include file="../includes/header.jsp"%>

<div class="container">
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">

     <p>Crear/Modificar curso</p>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
      </ul>
      <ul class="nav navbar-nav navbar-right">
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

	<!-- Formulario Crear -->
	<c:if test = "${curso.id == -1}">
				<form:form method="POST" action="admin/crear"
					modelAttribute="curso">
					<div class="modal-body">
					<form:hidden path="id"/>
						<form:label path="nombre">Nombre:</form:label>
						<form:input path="nombre"  class="form-control"></form:input>
						<form:label path="codigo">Codigo:</form:label>
						<form:input path="codigo" class="form-control"></form:input>
					</div>
					<div class="modal-footer">
						<a href="admin" class="btn btn-primary">Volver</a>
						<form:button type="submit" class="btn btn-default">Crear</form:button>
					</div>
				</form:form>
	</c:if>
	<!-- Formulario Modificar -->
	<c:if test = "${curso.id != -1}">
				<form:form method="POST" action="admin/modificar"
					modelAttribute="curso">
					<div class="modal-body">
					<form:hidden path="id"/>
						<form:label path="nombre">Nombre:</form:label>
						<form:input path="nombre"  class="form-control"></form:input>
						<form:label path="codigo">Codigo:</form:label>
						<form:input path="codigo" class="form-control"></form:input>
					</div>
					<div class="modal-footer">
						<a href="admin" class="btn btn-primary">Volver</a>
						<form:button type="submit" class="btn btn-default">Modificar</form:button>
					</div>
				</form:form>
	</c:if>
</div>
<%@ include file="../includes/footer.jsp"%>