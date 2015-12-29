package com.codetests.algorithms.mapping.eval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Etiqueta implements Comparable<Etiqueta>, Serializable, Cloneable {
    private static final long serialVersionUID = -8994389453706507471L;
    String autoridad;
    String codigo;
    String repeticion;
    List<Campo> campos = new ArrayList<Campo>();
    String valorIndicador1;
    String valorIndicador2;

    public Etiqueta() {
    }

    public Etiqueta(String codigo) {
        this.codigo = codigo;
    }

    public Etiqueta(String codigo, String subcampo, String valor) {
        this.codigo = codigo;
        add(new Campo(subcampo, valor));
    }

    public String getAutoridad() {
        return autoridad;
    }

    public void setAutoridad(String autoridad) {
        this.autoridad = autoridad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Campo> getCampos() {
        return campos;
    }

    public void setCampos(List<Campo> campos) {
        this.campos = campos;
    }

    public void add(Campo lastCampo) {
        campos.add(lastCampo);
    }

    @Override
    public String toString() {
        return "Etiqueta{" +
                "codigo='" + codigo + ", " + campos.size() + " camposReferencian" + (autoridad != null ? "[AUT : " + autoridad : "}");
    }

    @Override
    public int compareTo(Etiqueta o) {
        return codigo.compareTo(o.getCodigo());
    }

    public String getRepeticion() {
        return repeticion;
    }

    public void setRepeticion(String repeticion) {
        this.repeticion = repeticion;
    }

    /**
     * Gets a specific repeat of a field
     *
     * @param code Field code ($a, $z, ...)
     * @param rep  Field repeat (01, 03, ...)
     * @return field value if found or null otherwise
     */
    public Campo getCampo(String code, String rep) {
        for (Campo c : campos) {
            if (c.getSubcampo().equals(code) && (c.getRepeticion() == null || (c.getRepeticion() != null && rep.equals(c.getRepeticion())))) {
                return c;
            }
        }
        return null;
    }

    /**
     * Creates a string with all the subfields, separated by the special character &nbsp;
     *
     * @return Composed string or an empty string if no texts exists.
     */
    public String getTextoHTML() {
        StringBuffer sb = new StringBuffer();
        for (Campo c : getCampos()) {
            sb.append(c.getDatos());
            sb.append("&nbsp;");

        }
        return sb.toString().trim();
    }

    /**
     * Composes a string with al the subfields values separated by blank spaces.
     *
     * @return Composed string
     */
    public String getTexto() {
        StringBuilder sb = new StringBuilder();
        for (Campo c : getCampos()) {
            sb.append(c.getDatos());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Composes a tag fields list in a specified order. At the end of the list, adds the rest of tag fields
     * not specified in the order.
     *
     * @param ordenCampos field order, format: "$a$v$k$c". Null indicates no order
     * @return Composed list
     */
    public List<Campo> getCamposOrden(String ordenCampos) {
        List<Campo> campos = new ArrayList<Campo>();
        if (ordenCampos != null) {
            for (int k = 0; k < ordenCampos.length(); k += 2) {
                String atr = ordenCampos.substring(k, k + 2);
                final List<Campo> campos1 = getCampos(atr);
                for (Campo c : campos1) {
                    campos.add(c);
                }
            }
            // Metemos los campos que NO estan en el orden
            for (Campo campo : getCampos()) {
                if (!ordenCampos.contains(campo.getSubcampo())) {
                    campos.add(campo);
                }
            }
            return campos;
        } else {
            for (Campo c : getCampos()) {
                campos.add(c);
            }
            return campos;
        }
    }


    /**
     * Gets the value of a specific subfield
     *
     * @param subcampo Subfield code ($a, $k, ...)
     * @return subfield value, or void string "" if not found
     */
    public String getTextoSubcampo(String subcampo) {
        StringBuffer sb = new StringBuffer();
        for (Campo c : getCampos()) {
            if (subcampo.equals(c.getSubcampo())) {
                if (c.getDatos() != null) {
                    sb.append(c.getDatos());
                    sb.append(" ");
                }
            }
        }
        return sb.toString().trim();
    }

    /**
     * Gets a list with all fields of a specific type
     *
     * @param subcampo Subfield code ($a, $j)
     * @return Subfields list
     */
    public List<Campo> getCampos(String subcampo) {
        List<Campo> campos = new ArrayList<Campo>();
        for (Campo c : getCampos()) {
            if (c.getSubcampo().equals(subcampo)) {
                campos.add(c);
            }
        }
        return campos;
    }

    /**
     * Checks whether a subfield exists
     *
     * @param code subfield code
     * @return true if exists, false otherwise
     */
    public boolean hashSubfield(String code) {
        for (Campo c : campos) {
            if (c.subcampo.equals(code)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Duplicates this tag
     *
     * @return new tag, clon of the current tag
     */
    public Etiqueta duplica() {
        Etiqueta et = new Etiqueta();
        et.setAutoridad(autoridad);
        et.setCodigo(codigo);
        et.setRepeticion(repeticion);

        for (Campo campo : campos) {
            et.add(campo.duplica());
        }
        return et;
    }

    /**
     * Checks if two tags are "reasonably" equal. It is checked that they have same code and the same fields.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Etiqueta)) return false;
        Etiqueta et2 = (Etiqueta) obj;

        if (codigo.equals(et2.getCodigo())) {
            if (campos.size() == et2.getCampos().size()) {
                int count = 0;
                for (Campo campo : campos) {
                    if (!campo.equals(et2.getCampos().get(count++))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public String getValorIndicador1() {
        return valorIndicador1;
    }

    public void setValorIndicador1(String valorIndicador1) {
        this.valorIndicador1 = valorIndicador1;
    }

    public String getValorIndicador2() {
        return valorIndicador2;
    }

    public void setValorIndicador2(String valorIndicador2) {
        this.valorIndicador2 = valorIndicador2;
    }

}
