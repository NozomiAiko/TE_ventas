package com.emergentes.controlador;

import com.emergentes.dao.ClienteDAO;
import com.emergentes.dao.ClienteDAOimp;
import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimp;
import com.emergentes.dao.VentaDAO;
import com.emergentes.dao.VentaDAOimp;
import com.emergentes.modelo.Cliente;
import com.emergentes.modelo.Producto;
import com.emergentes.modelo.Venta;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VentaControlador", urlPatterns = {"/VentaControlador"})
public class VentaControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            VentaDAO dao = new VentaDAOimp();
            ProductoDAO daoProducto = new ProductoDAOimp();
            ClienteDAO daoCliente = new ClienteDAOimp();
            int id;
            List<Producto> lista_productos = null;
            List<Cliente> lista_clientes = null;
            Venta venta = new Venta();
            Venta ven = new Venta();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            lista_productos = daoProducto.getAll();
            lista_clientes = daoCliente.getAll();
            switch (action) {
                case "add":
                    //enviar registros de cliente y productos
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);

                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    ven = dao.getById(id);
                    request.setAttribute("lista_productos", lista_productos);
                    request.setAttribute("lista_clientes", lista_clientes);
                    request.setAttribute("venta", ven);
                    request.getRequestDispatcher("frmVenta.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("VentaControlador");
                case "view":
                    List<Venta> lista = dao.getAll();
                    request.setAttribute("ventas", lista);
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN CLIENTE_CONTROLADOR:" + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id =Integer.parseInt(request.getParameter("id"));
        int producto_id =Integer.parseInt(request.getParameter("producto_id"));
        int cliente_id =Integer.parseInt(request.getParameter("cliente_id"));
        String fecha= request.getParameter("fecha");
        Venta venta= new Venta();
        venta.setId(id);
        venta.setProducto_id(producto_id);
        venta.setCliente_id(cliente_id);
        venta.setFecha(fecha);
        if (id==0) {
            try {
                VentaDAO dao= new VentaDAOimp();
                dao.insert(venta);
            } catch (Exception ex) {
                Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            VentaDAO dao= new VentaDAOimp();
            try {
                dao.update(venta);
            } catch (Exception ex) {
                Logger.getLogger(VentaControlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        response.sendRedirect("VentaControlador");
    }
    

}
