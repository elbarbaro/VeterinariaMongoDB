<%@ include file="header.jsp" %>
<div class="container-fluid">
	<c:if test="${success}">
		<div class="alert alert-success alert-dismissible fade show" role="alert">
  			${message}
  			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
    			<span aria-hidden="true">&times;</span>
  			</button>
		</div>
	</c:if>
	<div class="row">
		<div class="col-3">
			<h3>Bienvenido</h3>
			<a class="btn btn-primary" href="perro">Agregar perro</a>
		</div>
		<div class="col-9">
			<table class="table">
				<thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Nombre</th>
				      <th scope="col">Raza</th>
				      <th scope="col">Color</th>
				      <th scope="col">Edad</th>
				      <th scope="col">Peso</th>
				      <th scope="col">Esta vivo</th>
				      <th scope="col">Acciones</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach var="perro" items="${listPerros}" varStatus="status">
				  		<tr>
				  			<td>${status.count}</td>
				  			<td>${perro.nombre}</td>
				  			<td>${perro.raza}</td>
				  			<td>${perro.color}</td>
				  			<td>${perro.edad}</td>
				  			<td>${perro.peso}</td>
				  			<td>
				  				<c:choose>
				  					<c:when test="${perro.estaVivo}">
				  						Si
				  					</c:when>
				  					<c:otherwise>
				  						No
				  					</c:otherwise>
				  				</c:choose>
				  			</td>
				  			<td>
				  				<div class="btn-group" role="group">
				  					<a class="btn btn-primary" href="${pageContext.servletContext.contextPath}/perro/actualizar?id=${perro.id}" title="Editar"><i class="fas fa-pen"></i></a>
					  				<form action="${pageContext.servletContext.contextPath}/perro/eliminar" method="post">
					  					<input type="hidden" name="txtId" value="${perro.id}">
					  					<button class="btn btn-danger" type="submit" title="Eliminar"><i class="fas fa-trash-alt"></i></button>
					  				</form>
				  				</div>
				  			</td>
				  		</tr>
				  	</c:forEach>
				  </tbody>
			</table>
		</div>
	</div>
</div>
</body>
</html>