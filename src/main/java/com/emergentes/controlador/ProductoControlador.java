/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.emergentes.controlador;

import com.emergentes.dao.ProductoDAO;
import com.emergentes.dao.ProductoDAOimp;
import com.emergentes.modelo.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author 999ma
 */
@WebServlet(name = "ProductoControlador", urlPatterns = {"/ProductoControlador"})
public class ProductoControlador extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         try {
            ProductoDAO dao = new ProductoDAOimp();
            String action = (request.getParameter("action") != null) ? request.getParameter("action") : "view";
            int id;
            Producto pro = new Producto();
            switch (action) {
                case "add":
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);
                    break;
                case "edit":
                    id = Integer.parseInt(request.getParameter("id"));
                    pro = dao.getById(id);
                    request.setAttribute("producto", pro);
                    request.getRequestDispatcher("frmProducto.jsp").forward(request, response);

                    break;
                case "delete":
                    id = Integer.parseInt(request.getParameter("id"));
                    dao.delete(id);
                    response.sendRedirect("ProductoControlador");
                case "view":
                    List<Producto> lista = dao.getAll();
                    request.setAttribute("productos", lista);
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
                    break;
                default:
                    break;

            }

        } catch (Exception ex) {
            System.out.println("ERROR EN producto_CONTROLADOR:" + ex.getMessage());
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nombre = request.getParameter("nombre");
        String descripcion = request.getParameter("descripcion");
        Float precio = Float.parseFloat(request.getParameter("precio"));
        Producto pro = new Producto();
        pro.setId(id);
        pro.setNombre(nombre);
        pro.setDescripcion(descripcion);
        pro.setPrecio(precio);
        ProductoDAO dao = new ProductoDAOimp();
        if (id == 0) {
            try {
                //nuevo registro
                dao.insert(pro);
                

            } catch (Exception ex) {
                System.out.println("ERros al insertar:" + ex.getMessage());
            }
        } else if (id != 0) {
            try {

                dao.update(pro);
               

            } catch (Exception ex) {
                System.out.println("ERROR_al editar:" + ex.getMessage());
            }
        }
        response.sendRedirect("ClienteControlador");


    }

}
