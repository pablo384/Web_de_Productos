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

    public Productos getProducto(String codigoArt) {
        Connection miConexion=null;
        PreparedStatement miStatement=null;
        Productos miProducto=null;
        ResultSet miResulset = null;
        String codigoArticulo= codigoArt;

        try {


            //establecer la conexion con BBD
                miConexion=new GetConnection().getSimpleConnection();
            //crear SQL que busque el producto con el Codigo articulo
            String sql="SELECT * FROM PRODUCTOS WHERE CÓDIGOARTÍCULO=?";
            //crear consulta preparada
            miStatement=miConexion.prepareStatement(sql);
            //establecer parameetros de esa consulta

            miStatement.setString(1,codigoArticulo);

            //ejecutar consulta
            miResulset = miStatement.executeQuery();

            //obtener datos de respuesta




            if (miResulset.next()){
                String seccion = miResulset.getString("SECCIÓN");
                String nombreArt = miResulset.getString("NOMBREARTÍCULO");
                double precio = miResulset.getDouble("PRECIO");
                Date fecha = miResulset.getDate("FECHA");
                String importado = miResulset.getString("IMPORTADO");
                String paisOrigen = miResulset.getString("PAÍSDEORIGEN");

                miProducto = new Productos(
                        seccion,
                        nombreArt,
                        precio,
                        fecha,
                        importado,
                        paisOrigen);

            }else {
                throw new Exception("No hemos encontrado el codigo articulo="+codigoArticulo);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return miProducto;
    }

    public void actualizarProducto(Productos productoActualizado) {

    }
}
