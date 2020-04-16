<html>
<head>
	<meta charset="UTF-8">
	<title>P3</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script type="text/javascript">
		$(document).ready(function(){
			let btn = $('charge').val();
			$.post('servletControler', {
				
			}, function(respose){
				let datos = JSON.parse(respose);
				
				let tablaDatos = document.getElementById('tablaDatos');
				for(let item of datos){
					tablaDatos.innerHTML += `
						<tr>
							<td>${item.id}</td>
							<td>${item.nombreProducto}</td>
							<td>${item.precioProducto}</td>
							<td>${item.cantidadProducto}</td>
							<td>${item.totalProducto}</td>
							<td>
								<a href="addPrd.jsp?idBus=${item.id}&nPr=${item.nombreProducto}&pPr=${item.precioProducto}&cPr=${item.cantidadProducto}&tPr=${item.totalProducto}" class="btn btn-warning">Editar</a>
								<a href="servletControler?btn=ELIMINAR&Id=${item.id}" class="btn btn-danger">Eliminar</a>
							</td>
						</tr>
					`
				}
			});
		});
	</script>
</head>
<body>
	<h2 align="center">Listado de Productos</h2>
	<a href="addPrd.jsp" class="btn btn-info" align="center">Agregar producto nuevo</a>
	<table class="table table-dark" id="tablaDatos">
		<thead>
			<th>ID</th>
			<th>NOMBRE</th>
			<th>PRECIO</th>
			<th>CANTIDAD</th>
			<th>TOTAL</th>
			<th>OPCIONES</th>
		</thead>
		<tbody>
			
		</tbody>
	</table>
</body>
</html>
