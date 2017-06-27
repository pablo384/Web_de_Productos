package com.proeduka.productos;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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

        //Leer el parametro que llega
        String elComando = request.getParameter("instruccion");

        //sino se envia el parametro listar productos
        if (elComando==null) elComando="listar";

        switch (elComando){
            case "listar":obtenerProductos(request,response);
            break;

            case "insertarBBDD":
                agregarProductos(request,response);
            break;

            default:obtenerProductos(request,response);
            break;
        }

        //Redirigir el flujo de ejecucion a metodo adecuado


    }

    private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {

        //leer la infromacion del producto que viene del formulario
        String codArticulo=request.getParameter("cArt");
        String seccion=request.getParameter("cArt");
        String nombreArt=request.getParameter("cArt");
        String precio=request.getParameter("cArt");
        String fecha=request.getParameter("cArt");
        String importado=request.getParameter("cArt");
        String paisOrigen=request.getParameter("cArt");

        //crea run objeto de tipo producto

        //enviar el objeto al modelo

        //insertar el obj producto en la BBDD

        //volver al listado de ptroductos
    }

    private void obtenerProductos(ServletRequest request, ServletResponse response) {
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
