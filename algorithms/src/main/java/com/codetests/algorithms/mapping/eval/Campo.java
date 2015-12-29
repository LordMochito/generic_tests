package com.codetests.algorithms.mapping.eval;

import java.io.Serializable;

public class Campo implements Comparable<Campo>, Serializable, Cloneable {
    private static final long serialVersionUID = 3393671508309621900L;
    String subcampo;
    String datos;
    String autoridad;
    String repeticion;

    public Campo() {
    }

    public Campo(String subcampo) {
        this.subcampo = subcampo;
    }

    public Campo(String subcampo, String datos) {
        this.subcampo = subcampo;
        this.datos = datos;
    }

    public String getSubcampo() {
        return subcampo;
    }

    public void setSubcampo(String subcampo) {
        this.subcampo = subcampo;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String datos) {
        this.datos = datos;
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }

    @Override
    public String toString() {
        return "Campo{" +
                "subcampo='" + subcampo + '\'' +
                ", datos='" + datos + (autoridad != null ? " [AUT : " + autoridad : "}");
    }

    public Campo duplica(Etiqueta e) {
        Campo c = new Campo();
        c.setSubcampo(subcampo);
        c.setDatos(datos);
        c.setAutoridad(autoridad);
        return c;
    }

    @Override
    public int compareTo(Campo o) {
        return subcampo.compareTo(((Campo) o).getSubcampo());
    }

    /**
     * Duplicates this object "subfield"
     */
    public Campo duplica() {
        Campo cp = new Campo();
        cp.setSubcampo(subcampo);
        cp.setDatos(datos);
        cp.setAutoridad(autoridad);
        cp.setRepeticion(repeticion);
        return cp;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Campo)) return false;
        Campo cp2 = (Campo) obj;

        return subcampo.equals(cp2.getSubcampo()) && datos.equals(cp2.getDatos());
    }
}