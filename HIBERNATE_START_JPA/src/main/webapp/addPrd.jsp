<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<%
	String idBus = request.getParameter("idBus");
	String nPr = request.getParameter("nPr");
	String pPr = request.getParameter("pPr");
	String cPr = request.getParameter("cPr");
	String tPr = request.getParameter("tPr");
	
	if(idBus == null){
		idBus = "";
		nPr = "";
		pPr = "";
		cPr = "";
		tPr = "";
	}
%>
<body>
	<h2 align="center">Agregar Datos</h2>
	
	<form action="servletControler">
		<table align="center">
			<thead>			
			</thead>
			<tbody>
				<tr>
					<td>
						<p>Id: </p><input type="text" name="Id" id="idCarga" value="<%= idBus%>">
						<p>Nombre del Producto: </p><input type="text" name="nProducto" value="<%= nPr%>">
						<p>Precio del Producto: </p><input type="text" name="pProducto" value="<%= pPr%>">
						<p>Cantidad del Producto: </p><input type="text" name="cProducto" value="<%= cPr%>">
						<p>Total del Producto: </p><input type="text" name="tProducto" value="<%= tPr%>">
					</td>
				</tr>
			</tbody>
		</table>
		<input type="submit" class="btn btn-info" value="GUARDAR" name="btn">
		<input type="submit" class="btn btn-info" value="ACTUALIZAR" name="btn">
	</form>
</body>
</html>