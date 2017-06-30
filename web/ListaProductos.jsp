<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: pablo
  Date: 25/6/2017
  Time: 11:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Lista Productos</title>
    <style type="text/css">
        .cabecera{
            text-align: center;
            font-size: 1.2em;
            font-weight: bold;
            color: #FFFFFF;
            background-color: blue;
        }
        .filas{
            text-align: center;
            background-color: cornflowerblue;
        }
        table{
            float: left;
        }
        #contenedorBoton{
            margin-left: 1000px;
        }
    </style>
</head>

<body>

<table>
    <tr>
        <td class="cabecera">Codigo Articulo</td>
        <td class="cabecera">Seccion</td>
        <td class="cabecera">Nombre Articulo</td>
        <td class="cabecera">Precio</td>
        <td class="cabecera">Fecha</td>
        <td class="cabecera">Importado</td>
        <td class="cabecera">Pais de Origen</td>
        <td class="cabecera">Accion</td>
        <td class="cabecera">Eliminar</td>
    </tr>

    <c:forEach var="tempPro" items="${listaProductos}">

        <!---Link para cada producto con su campo clave --->
        <c:url var="linkTemp" value="ControladorProductos">
            <c:param name="instruccion" value="cargar"></c:param>
            <c:param name="cArticulo" value="${tempPro.cArt}"></c:param>
        </c:url>
        <c:url var="linkTempEliminar" value="ControladorProductos">
            <c:param name="instruccion" value="eliminar"></c:param>
            <c:param name="cArticulo" value="${tempPro.cArt}"></c:param>
        </c:url>
        <tr>
            <td class="filas">${tempPro.cArt}</td>
            <td class="filas">${tempPro.seccion}</td>
            <td class="filas">${tempPro.nombreArt}</td>
            <td class="filas">${tempPro.precio}</td>
            <td class="filas">${tempPro.fecha}</td>
            <td class="filas">${tempPro.importado}</td>
            <td class="filas">${tempPro.paisOrigen}</td>
            <td class="filas"> <a href="${linkTemp}">Actualizar</a> </td>
            <td class="filas"> <a href="${linkTempEliminar}">Eliminar</a> </td>
        </tr>
    </c:forEach>
</table>

<div id="contenedorBoton">
    <input type="button" value="Insertar Registro" onclick="window.location.href='inserta_producto.jsp'">
</div>

</body>
</html>
