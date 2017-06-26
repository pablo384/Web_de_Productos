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
</head>
<%
    //obtiene los productos del controlador Servlet
    List<Productos> losProductos= (List<Productos>) request.getAttribute("listaProductos");
%>
<body>

<%= losProductos%>

</body>
</html>
