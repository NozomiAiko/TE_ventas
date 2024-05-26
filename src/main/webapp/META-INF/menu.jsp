<%
    String opcion = request.getParameter("opcion");
%> 
<link rel="stylesheet" href="mystyle.css"/>
<div id="nav">
    <ul >
        <li >
            <a id="navLi" <%= (opcion.equals("productos") ? "active" : "")%>" aria-current="page" href="ProductoControlador">Productos</a>
        </li>
        <li >
            <a id="navLi" <%= (opcion.equals("clientes") ? "active" : "")%>" href="ClienteControlador">Clientes</a>
        </li>
        <li >
            <a id="navLi"  <%= (opcion.equals("ventas") ? "active" : "")%>" href="VentaControlador">Ventas</a>
        </li>
        <li >
            <a id="navLi"  <%= (opcion.equals("usuarios") ? "active" : "")%>" aria-current="page" href="UsuarioControlador">Usuarios</a>
        </li>
    </ul>
      <a id="btnSalir" href="Logout" >SALIR</a>
      
</div>


