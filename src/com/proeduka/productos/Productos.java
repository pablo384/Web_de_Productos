package com.proeduka.productos;

import java.util.Date;

/**
 * Created by pablo on 24/6/2017.
 */
public class Productos {


    public Productos(String cArt, String seccion, String nombreArt, double precio, Date fecha, String importado, String paisOrigen) {
        this.cArt = cArt;
        this.seccion = seccion;
        this.nombreArt = nombreArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }


    public Productos(String seccion, String nombreArt, double precio, Date fecha, String importado, String paisOrigen) {
        this.seccion = seccion;
        this.nombreArt = nombreArt;
        this.precio = precio;
        this.fecha = fecha;
        this.importado = importado;
        this.paisOrigen = paisOrigen;
    }

    public String getcArt() {
        return cArt;
    }

    public void setcArt(String cArt) {
        this.cArt = cArt;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getNombreArt() {
        return nombreArt;
    }

    public void setNombreArt(String nombreArt) {
        this.nombreArt = nombreArt;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getImportado() {
        return importado;
    }

    public void setImportado(String importado) {
        this.importado = importado;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    @Override
    public String toString() {
        return "Productos{" +
                "cArt='" + cArt + '\'' +
                ", seccion='" + seccion + '\'' +
                ", nombreArt='" + nombreArt + '\'' +
                ", precio=" + precio +
                ", fecha=" + fecha +
                ", importado='" + importado + '\'' +
                ", paisOrigen='" + paisOrigen + '\'' +
                '}';
    }

    private String cArt;
    private String seccion;
    private String nombreArt;
    private double precio;
    private Date fecha;
    private String importado;
    private String paisOrigen;
}
