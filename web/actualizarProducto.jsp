<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 27/6/2017
  Time: 6:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar Producto</title>
</head>
<body>
<h1 style="text-align: center ">Insertar Registros</h1>
<form name="forml" method="get" action="ControladorProductos">
    <input type="hidden" name="instruccion" value="actBBDD">
    <input type="hidden" name="cArt" value="${ProductoActualizar.cArt}">
    <table width="50%" border="0">
        <%--<tr>--%>
            <%--<td width="27%">Codigo Articulo</td>--%>
            <%--<td width="27%"> <label for="cArt"></label>--%>
            <%--<input type="text" name="cArt" id="cArt"></td>--%>
        <%--</tr>--%>

        <tr>
            <td width="27%">Seccion</td>
            <td width="27%"> <label for="seccion"></label>
                <input type="text" name="seccion" id="seccion" value="${ProductoActualizar.seccion}"></td>
        </tr>

        <tr>
            <td width="27%">Nombre Articulo</td>
            <td width="27%"> <label for="nombreArt"></label>
                <input type="text" name="nombreArt" id="nombreArt" value="${ProductoActualizar.nombreArt}"></td>
        </tr>

        <tr>
            <td width="27%">Precio</td>
            <td width="27%"> <label for="precio"></label>
                <input type="text" name="precio" id="precio" value="${ProductoActualizar.precio}"></td>
        </tr>

        <tr>
            <td width="27%">Fecha</td>
            <td width="27%"> <label for="fecha"></label>
                <input type="text" name="fecha" id="fecha" value="${ProductoActualizar.fecha}"></td>
        </tr>

        <tr>
            <td width="27%">Importado</td>
            <td width="27%"> <label for="importado"></label>
                <input type="text" name="importado" id="importado" value="${ProductoActualizar.importado}"></td>
        </tr>

        <tr>
            <td width="27%">Pais de Origen</td>
            <td width="27%"> <label for="paisOrigen"></label>
                <input type="text" name="paisOrigen" id="paisOrigen" value="${ProductoActualizar.paisOrigen}"></td>
        </tr>

        <td><input type="submit" name="envio" id="envio" value="Enviar"></td>
        <td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>


    </table>
</form>
</body>
</html>
