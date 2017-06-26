package com.proeduka.productos;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import javax.naming.*;



/**
 * Created by pablo on 23/6/2017.
 */
@WebServlet(name = "ServletPruebas", urlPatterns = {"/ServletPruebas"})
public class ServletPruebas extends HttpServlet {
    private static final long serialVersionUID=1L;

    //definir DataSource
    @Resource(name = "jdbc/Productos")
    private DataSource miPool;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter salida = response.getWriter();
        response.setContentType("text/plain");

        //crear conexion con BBDD
        Connection miConnection=null;
        Statement miStatement=null;
        ResultSet miRs=null;

        try {
//            Context initContext = new InitialContext();
//            Context envContext  = (Context)initContext.lookup("java:/comp/env");
//            DataSource ds = (DataSource)envContext.lookup("jdbc/Productos");
//            Connection conn = ds.getConnection();

//            Class.forName("com.mysql.jdbc.Driver");
//            miConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/cursosql", "root", "");
            miConnection= new GetConnection().getSimpleConnection();
            String miSql="SELECT * FROM PRODUCTOS";
            miStatement=miConnection.createStatement();
            miRs=miStatement.executeQuery(miSql);

            while (miRs.next()){
                String nombreArt=miRs.getString(3);
                salida.println(nombreArt);
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }
}

