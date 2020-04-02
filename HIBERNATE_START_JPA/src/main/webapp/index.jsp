<html>
<head>
	<meta charset="UTF-8">
	<title>P3</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>
	<h2 align="center">Agregar Datos</h2>
	<table align="center">
		<thead>			
		</thead>
		<tbody>
			<tr>
				<td>
					<form action="servletControler" method="post">
						<p>Id: </p><input type="text" name="Id">
						<p>Nombre del Producto: </p><input type="text" name="nProducto">
						<p>Precio del Producto: </p><input type="text" name="pProducto">
						<p>Cantidad del Producto: </p><input type="text" name="cProducto">
						<p>Total del Producto: </p><input type="text" name="tProducto">
						<br>
						<br>
						<input type="submit" name="" value="Enviar Datos" class="btn btn-info">
					</form>
				</td>
			</tr>
		</tbody>
	</table>
</body>
</html>
