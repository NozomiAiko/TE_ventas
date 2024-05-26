<%
//codigo en java
if(session.getAttribute("loginUser") != "ok"){
    response.sendRedirect("Login");
    }
%>
<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.Venta"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<Venta> ventas = (List<Venta>) request.getAttribute("Venta");
%>
<html lang="en">
    <head>
        <meta charset="utf-8">
            <meta name="viewport" content="width=device-width, initial-scale=1">
                <title>VENTAS</title>
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
                    </head>
                    <body>
                        <br><br><br><br>
                        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
                        <div>
                            <h1>VENTAS</h1>
                            <jsp:include page="META-INF/menu.jsp" >
                                <jsp:param name="opcion" value="ventas" />
                            </jsp:include >
                            <a href="VentaControlador?action=add" id="btnAdd">
                                <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-bag" viewBox="0 0 16 16">
                                    <path d="M8 1a2.5 2.5 0 0 1 2.5 2.5V4h-5v-.5A2.5 2.5 0 0 1 8 1m3.5 3v-.5a3.5 3.5 0 1 0-7 0V4H1v10a2 2 0 0 0 2 2h10a2 2 0 0 0 2-2V4zM2 5h12v9a1 1 0 0 1-1 1H3a1 1 0 0 1-1-1z"/>
                                </svg>Registrar Venta</a>
                            <br><br>
                            <table >
                                
                                    <tr id="cabecera">
                                        <th>ID</th>
                                        <th>PRODUCTO</th>
                                        <th>CLIENTE</th>
                                        <th>FECHA</th>
                                        <th colspan=""2>OPCIONES</th>
                                    </tr>
                                    <c:forEach var="item" items="${ventas}">
                                        <tr>
                                            <td>${item.id}</td>
                                            <td>${item.producto}</td>
                                            <td>${item.cliente}</td>
                                            <td>${item.fecha}</td>
                                            <td><a id="btnEdit" href="VentaControlador?action=edit&id=${item.id}">EDITAR</a></td>
                                            <td><a id="btnDelete" href="VentaControlador?action=delete&id=${item.id}" onclick="return(confirm('SEGURO QUE DESEA ELIMINAR ESTE REGISTRO?'))">ELIMINAR</a></td>
                                        </tr>
                                    </c:forEach>

                            </table>
                        </div>
                    </body>
                    </html>
