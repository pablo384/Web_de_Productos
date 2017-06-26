package com.proeduka.productos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by pablo on 25/6/2017.
 */
@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    private ModeloProductos modeloProductos;

    @Override
    public void init() throws ServletException {
        super.init();
        try {
            modeloProductos = new ModeloProductos(new GetConnection().getSimpleConnection());
        } catch (Exception e) {
            throw new ServletException(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //obteniendo Lista de Productos
        try {
            List<Productos> productos = modeloProductos.getProductos();

            //agregar lista de productos al request
            request.setAttribute("listaProductos", productos);
            //enviar request a pagina JSP
            RequestDispatcher miDispatcher = request.getRequestDispatcher("/ListaProductos.jsp");
            miDispatcher.forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
