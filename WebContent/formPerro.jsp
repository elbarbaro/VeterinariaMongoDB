<%@ include file="header.jsp"%>
<div class="container">
	<div class="row">
		<div class="col-6">
			<h4>${message} un perro</h4>
			<form action="${action}" method="post">
				<c:if test="${perro != null}">
					<input type="hidden" name="id" value="${perro.id}">
				</c:if>
				<div>
					<input class="form-control" type="text" name="nombre" placeholder="Nombre" value="${perro.nombre}">
				</div>
				<div>
					<input class="form-control" type="text" name="edad" placeholder="Edad" value="${perro.edad}">
				</div>
				<div>
					<input class="form-control" type="text" name="peso" placeholder="Peso" value="${perro.peso}">
				</div>
				<div>
					<input class="form-control" type="text" name="color" placeholder="Color" value="${perro.color}">
				</div>
				<div>
					<input class="form-control" type="text" name="raza" placeholder="Raza" value="${perro.raza}">
				</div>
				<c:if test="${perro != null}">
					<div>
						<c:choose>
							<c:when test="${perro.estaVivo}">
								<input class="form-control" type="radio" value="1" name="estaVivo" checked> Si
								<input class="form-control" type="radio" value="0" name="estaVivo"> No
							</c:when>
							<c:otherwise>
								<input class="form-control" type="radio" value="1" name="estaVivo"> Si
								<input class="form-control" type="radio" value="0" name="estaVivo" checked> No
							</c:otherwise>
						</c:choose>
					</div>
				</c:if>
				<input class="btn btn-primary" type="submit" value="Agregar">
			</form>
		</div>
	</div>
</div>
</body>
</html>