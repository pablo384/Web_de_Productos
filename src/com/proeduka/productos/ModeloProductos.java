package com.proeduka.productos;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
            Date fecha = miRs.getDate("FECHA");
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

    public void agregarElNuevoProducto(Productos nuevoProducto) {

        //OBTENER CONEXION CON BBD

        Connection miConexion=null;
        PreparedStatement miStatement=null;

        try {
            miConexion= new GetConnection().getSimpleConnection();



        //CREAR INSTRUCCION INSERT SQL. Crear la consulta preparada

            String sql ="INSERT INTO PRODUCTOS (CÓDIGOARTÍCULO,SECCIÓN,NOMBREARTÍCULO,PRECIO,FECHA,IMPORTADO,PAÍSDEORIGEN)"
                +"VALUES(?,?,?,?,?,?,?)";
            miStatement=miConexion.prepareStatement(sql);

        //ESTABLECER PARAMETROS PARA EL PRODUCTO

            miStatement.setString(1,nuevoProducto.getcArt());
            miStatement.setString(2,nuevoProducto.getSeccion());
            miStatement.setString(3,nuevoProducto.getNombreArt());
            miStatement.setDouble(4,nuevoProducto.getPrecio());

            java.util.Date utilDate=nuevoProducto.getFecha();
            java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());

            miStatement.setDate(5, fechaConvertida);
            miStatement.setString(6,nuevoProducto.getImportado());
            miStatement.setString(7,nuevoProducto.getPaisOrigen());


        //EJECUTAR LA INSTRUCCION SQL
            miStatement.execute();
//            miConexion.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
