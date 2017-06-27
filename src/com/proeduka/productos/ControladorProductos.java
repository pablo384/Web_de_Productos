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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        String seccion=request.getParameter("seccion");
        String nombreArt=request.getParameter("nombreArt");
        double precio= Double.parseDouble(request.getParameter("precio"));

        SimpleDateFormat formatDate = new SimpleDateFormat("YYYY/MM/dd");
        Date fecha = null;
        try {
            fecha= formatDate.parse(request.getParameter("fecha"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String importado=request.getParameter("importado");
        String paisOrigen=request.getParameter("paisOrigen");

        //crea run objeto de tipo producto
        Productos miProducto = new Productos(
                codArticulo,seccion,
                nombreArt,precio,fecha,
                importado,paisOrigen);

        //enviar el objeto al modelo insertar el obj producto en la BBDD
        modeloProductos.agregarElNuevoProducto(miProducto);

        //volver al listado de ptroductos

        obtenerProductos(request,response);
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
