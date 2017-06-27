<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page import="com.proeduka.productos.Productos" %><%--
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
            border-bottom:solid #F00 1px;
        }

    </style>
</head>
<%
    //obtiene los productos del controlador Servlet
    List<Productos> losProductos= (List<Productos>) request.getAttribute("listaProductos");
%>
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
    </tr>

    <%for (Productos tempPro : losProductos){ %>
        <tr>

            <td><%=tempPro.getcArt()%></td>
            <td><%=tempPro.getSeccion()%></td>
            <td><%=tempPro.getNombreArt()%></td>
            <td><%=tempPro.getPrecio()%></td>
            <td><%=tempPro.getFecha()%></td>
            <td><%=tempPro.getImportado()%></td>
            <td><%=tempPro.getPaisOrigen()%></td>

        </tr>

        <%}%>
</table>

</body>
</html>
