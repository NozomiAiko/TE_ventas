<%
//codigo en java
if(session.getAttribute("loginUser") != "ok"){
    response.sendRedirect("Login");
    }
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Bootstrap demo</title>
            <link rel="stylesheet" href="mystyle.css"/>
    </head>
    <body>
        <br><br><br>
        <jsp:include page="META-INF/menu.jsp" >
            <jsp:param name="opcion" value="clientes" />
        </jsp:include >
        <c:if test="${venta.id == 0}">
        <h1>Nuevo Registro de Venta</h1>        
        </c:if>
        <c:if test="${venta.id != 0}">
        <h1>EditarRegistro de una venta</h1>  
        </c:if>
        <br>
        <form action="VentaControlador" method="post">
            <div>
                <input type="hidden" name="id" value="${venta.id}">
            </div>   
            <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label" >Cliente</label><br>
                <select name="cliente_id" class="mb-3">
                    <option value="">---Seleccione---</option>
                    <c:forEach var="item" items="${lista_clientes}">
                        <option value="${item.id}" <c:if test="${venta.cliente_id == item.id}">selected</c:if>>${item.nombre}</option>
                    </c:forEach>
                </select>
            </div>
           <div class="mb-3">
                <label for="exampleInputEmail1" class="form-label" >Producto</label><br>
                <select name="producto_id" class="mb-3">
                    <option value="">---Seleccione---</option>
                    <c:forEach var="item" items="${lista_productos}">
                        <option value="${item.id}" <c:if test="${venta.producto_id == item.id}">selected</c:if> >${item.nombre}</option>
                    </c:forEach>
                
                </select>
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label" >Fecha</label><br>
                <input type="date" class="form-control" value="${venta.fecha}" name="fecha">
            </div>
            <button type="submit" id="btnSave">GUARDAR</button>
        </form>
           


    </div>
</body>
</html>
