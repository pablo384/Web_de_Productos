package com.proeduka.productos;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by pablo on 25/6/2017.
 */
final class GetConnection {

    /** Uses JNDI and Datasource (preferred style).   */
    Connection getJNDIConnection(){
        String DATASOURCE_CONTEXT = "java:comp/env/jdbc/Productos";

        Connection result = null;
        try {
            Context initialContext = new InitialContext();
            if ( initialContext == null){
                log("JNDI problem. Cannot get InitialContext.");
            }
            DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
            if (datasource != null) {
                result = datasource.getConnection();
            }
            else {
                log("Failed to lookup datasource.");
            }
        }
        catch ( NamingException ex ) {
            log("Cannot get connection: " + ex);
        }
        catch(SQLException ex){
            log("Cannot get connection: " + ex);
        }
        return result;
    }

    /** Uses DriverManager.  */
    Connection getSimpleConnection() {
        //See your driver documentation for the proper format of this string :
        String DB_CONN_STRING = "jdbc:mysql://localhost:3306/cursosql";
        //Provided by your driver documentation. In this case, a MySql driver is used :
        String DRIVER_CLASS_NAME = "com.mysql.jdbc.Driver";
        String USER_NAME = "root";
        String PASSWORD = "";

        Connection result = null;
        try {
            Class.forName(DRIVER_CLASS_NAME).newInstance();
        }
        catch (Exception ex){
            log("Check classpath. Cannot load db driver: " + DRIVER_CLASS_NAME);
        }

        try {
            result = DriverManager.getConnection(DB_CONN_STRING, USER_NAME, PASSWORD);
        }
        catch (SQLException e){
            log( "Driver loaded, but cannot connect to db: " + DB_CONN_STRING);
        }
        return result;
    }

    private static void log(Object aObject){
        System.out.println(aObject);
    }
}
