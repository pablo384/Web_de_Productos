package com.proeduka.productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by pablo on 24/6/2017.
 */
public class ModeloProductos {
    private Connection origenDatos;

    public ModeloProductos(Connection origenDatos) {
        this.origenDatos = origenDatos;
    }

    public List<Productos> getProductos() throws Exception {
        List<Productos> productos = new ArrayList<>();
        origenDatos = null;
        Statement miStatement = null;
        ResultSet miRs = null;


        //establecer conexion
        origenDatos = new GetConnection().getSimpleConnection();
        //crear sentensia sql
        String miSql = "SELECT * FROM PRODUCTOS";
        miStatement = origenDatos.createStatement();
        //ejecutar query
        miRs = miStatement.executeQuery(miSql);
        //recorrer resultados obtenidos
        while (miRs.next()) {
            String cArt = miRs.getString("CÓDIGOARTÍCULO");
            String seccion = miRs.getString("SECCIÓN");
            String nombreArt = miRs.getString("NOMBREARTÍCULO");
            double precio = miRs.getDouble("PRECIO");
            Date fecha = new java.sql.Date(miRs.getDate("FECHA").getTime());
            String importado = miRs.getString("IMPORTADO");
            String paisOrigen = miRs.getString("PAÍSDEORIGEN");

            Productos miProduc = new Productos(cArt,
                    seccion,
                    nombreArt,
                    precio,
                    fecha,
                    importado,
                    paisOrigen);

            productos.add(miProduc);
        }


        return productos;
    }

    public void agregarElNuevoProducto(Productos miProducto) {

        //OBTENER CONEXION CON BBD

        //CREAR INSTRUCCION INSERT

        //ESTABLECER PARAMETROS PARA EL PRODUCTO

        //EJECTAR LA INSTRUCCION SQL

    }
}
