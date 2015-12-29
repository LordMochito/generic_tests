package com.codetests.algorithms.mapping.eval;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Currency;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

public class Registro implements Serializable{
	
	List<List<String>> checkFailure; 
    final static String ETI365 = "365";
    final static String CAMPO_B = "$b";
    final static String CAMPO_H = "$h";
    final static String CAMPO_C = "$c";
    private static final long serialVersionUID = -4759758807265375622L;
    public static Set<String> withSalesRights = new HashSet<String>();
    public static Set<String> withoutSalesRights = new HashSet<String>();
    private static String etiRemota = "096";
    private static String externalLinkURL = "$a";
    private static String campoRemoto = "$b";
    private static String contRemoto = "07215";
    private String numeroInformatico;
    private String formato;
    private String biblioteca;
    private List<Etiqueta> etiquetas = new ArrayList<Etiqueta>();
    /**
     * Another unique number used in Odilo
     */
    private String numeroRegistro;
    /**
     * Unique value usually used to locate a record. Is it used as a unique id for the record between the platforms
     * OdiloPlace and OdiloTK, since the {@link #numeroInformatico} is different for each DB of each platform.
     * It has Format {@link UUID}.
     */
    private String signatura;
    /**
     * Another unique id used to give them a hierarchical structure. Currently, for that purpose it is used the table
     * <b>JERARQUIA</b> and OdiloTK, as Odilo uses both hierarchy methods.
     */
    private String nuired;
    /**
     * Catalog used for the authorities.
     */
    private String catalogo;
    /**
     * Creation date of the record.
     */
    private String fechaAlta;
    /**
     * Edition date.
     */
    private String fechaModifica;
    /**
     * Bar code.
     */
    private String codigoBarras;
    /**
     * Record loan profile.
     */
    private String perfil;
    /**
     * MARC 21: Variable control fields --> leader
     */
    private String leader;
    /**
     * MARC 21: Variable control fields --> 001
     */
    private String control001;
    /**
     * MARC 21: Variable control fields --> 003
     */
    private String control003;
    /**
     * MARC 21: Variable control fields --> 005
     */
    private String control005;
    /**
     * MARC 21: Variable control fields --> 006
     */
    private String control006;
    /**
     * MARC 21: Variable control fields --> 007
     */
    private String control007;
    /**
     * MARC 21: Variable control fields --> 008
     */
    private String control008;
    /**
     * User who creates the record. In OdiloTK/OdiloPlace it is used the name of the distributor
     * {@link Distribuidor#nombre}
     */
    private String usuarioAlta;
    /**
     * Last user who modified the record. In OdiloTK/OdiloPlace it is used the name of the distributor
     * {@link Distribuidor#nombre}
     */
    private String usuarioModifica;
    /**
     * Parent record if any. This data will be only loaded if it is expressly requested. Otherwise, no children or parent
     * records will be loaded.
     */
    private Registro padre = null;
    /**
     * Set of children records (HO format). They will be only loaded if expressly requested.
     */
    private Set<Registro> hijos = null;
    /**
     * Set of children records (format not HO). They will be only loaded if expressly requested.
     */
    private List<String> descendants = null;
    /**
     * Comments field, free use.
     */
    private String observaciones;
    /**
     * Record social rating ("stars")
     */
    private Integer valoracion;
    /**
     * Number of ratings of the record
     */
    private Integer numeroVotos;
    /**
     * Number of visits received, (times the record index card is displayed).
     */
    private Integer numVisitas;
    /**
     * Number of times the record have been borrowed
     */
    private Integer numPrestamos;
    /**
     *
     */
    private Integer numDescargas;
    /**
     * Is the record active ?
     */
    private Boolean baja;
    /**
     * Metadata profile id used at imports.
     */
    private String idMetadatos;
    /**
     * Field NUEJEM of table NU_REGIS. Number of loans available.
     * Useless, only for physical loans.
     */
    private Integer numEjemplares;
    /**
     * Field NUVOLU of table NU_REGIS. Number of loans available.
     * Max loans allowed
     */
    private Integer numVolumenes;
    /**
     * NUMVEC
     */
    private Integer maxLicenseLoans;
    /**
     * Field NUMPRE of table NU_REGIS. Only for physical loans.
     */
    private boolean prestamo;
    /**
     * Field NUCLAE of table NU_REGIS. Only for physical loans.
     */
    private String clave;
    /**
     * Record expiration date
     */
    private String fechaBaja;
    private boolean venta;
    private long levelLoad;
    private String bookMoviesId;
    /**
     * Whether the record represent a digital record.
     */
    private boolean isDigital = true;
    /**
     * Whether the record represents a physical record.
     */
    private boolean isPhysical = false;
    /**
     * Current number of holds.
     */
    private Integer numHolds = 0;

    public Registro(String numeroInformatico) {
        this.numeroInformatico = numeroInformatico;
    }

    public Registro(String nInf, String nuIred) {
        this.numeroInformatico = nInf;
        this.nuired = nuIred;
    }

    public Registro() {
    }

    public boolean isVenta() {
        return venta;
    }

    public void setVenta(boolean venta) {
        this.venta = venta;
    }

    public Integer getMaxLicenseLoans() {
        return maxLicenseLoans;
    }

    public void setMaxLicenseLoans(Integer maxLicenseLoans) {
        this.maxLicenseLoans = maxLicenseLoans;
    }

    public List<Etiqueta> getEtiquetasCentena(int i) {
        List<Etiqueta> etiquetas1 = new ArrayList<Etiqueta>();
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getCodigo().startsWith("" + i)) {
                etiquetas1.add(etiqueta);
            }
        }
        return etiquetas1;
    }

    public long getLevelLoad() {
        return levelLoad;
    }

    public void setLevelLoad(long levelLoad) {
        this.levelLoad = levelLoad;
    }

    public Boolean isBaja() {
        return baja;
    }

    public void setBaja(Boolean baja) {
        this.baja = baja;
    }

    /**
     * Gets the tag with a specific code and repeat
     *
     * @param eti Tag code
     * @param rep Tag repeat
     * @return the tag if exists or null if not
     */
    public Etiqueta getEtiqueta(String eti, int rep) {
        for (Etiqueta e : etiquetas) {
            if (e.getCodigo().equals(eti)) {
                if (rep == 1) {
                    return e;
                }
                rep--;
            }
        }
        return null;
    }

    public Etiqueta getEtiquetaFix(String eti, String rep) {
        for (Etiqueta e : etiquetas) {
            if (e.getCodigo().equals(eti)) {
                if (rep.equals(e.getRepeticion())) {
                    return e;
                }
            }
        }
        return null;
    }

    /**
     * Gets the tag with a specific code and repeat
     *
     * @param eti Tag code
     * @param rep Tag repeat
     * @return the tag if exists or null if not
     */
    public Etiqueta getEtiqueta(String eti, String rep) {
        for (Etiqueta e : etiquetas) {
            if (e.getCodigo().equals(eti) && e.getRepeticion().equals(rep)) {
                return e;
            }
        }
        return null;
    }

    /**
     * Gets the field for a specific code and repeat, of a tag with a specific code and repeat.
     *
     * @param eti     Tag code
     * @param repInt  Tag repeat
     * @param camp    Subfield code
     * @param repInt2 Subfield repeat
     * @return the subfield or null if it does not exist
     */
    public Campo getCampo(String eti, int repInt, String camp, int repInt2) {
        Etiqueta et = getEtiqueta(eti, repInt);
        if (et != null) {
            for (Campo c : et.getCampos()) {
                if (c.getSubcampo().equals(camp)) {
                    if (repInt2 == 1) {
                        return c;
                    }
                    repInt2--;
                }
            }
        }
        return null;
    }

    /**
     * Gets the field for a specific code and repeat, of a tag with a specific code and repeat.
     *
     * @param eti     Tag code
     * @param repInt  Repeat tag
     * @param camp    Subfield code
     * @param repInt2 Subfield repeat
     * @return El campo o null si no existe
     */
    public Campo getCampo(String eti, String repInt, String camp, String repInt2) {
        Etiqueta et = getEtiqueta(eti, repInt);
        if (et != null) {
            for (Campo c : et.getCampos()) {
                if (c.getSubcampo().equals(camp) && c.getRepeticion().equals(repInt2)) {
                    return c;
                }
            }
        }
        return null;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getControl001() {
        return control001;
    }

    public void setControl001(String control001) {
        this.control001 = control001;
    }

    public String getControl003() {
        return control003;
    }

    public void setControl003(String control003) {
        this.control003 = control003;
    }

    public String getControl005() {
        return control005;
    }

    public void setControl005(String control005) {
        this.control005 = control005;
    }

    public String getControl006() {
        return control006;
    }

    public void setControl006(String control006) {
        this.control006 = control006;
    }

    public String getControl007() {
        return control007;
    }

    public void setControl007(String control007) {
        this.control007 = control007;
    }

    public String getControl008() {
        return control008;
    }

    public void setControl008(String control008) {
        this.control008 = control008;
    }

    public String getUsuarioAlta() {
        return usuarioAlta;
    }

    public void setUsuarioAlta(String usuarioAlta) {
        this.usuarioAlta = usuarioAlta;
    }

    public String getUsuarioModifica() {
        return usuarioModifica;
    }

    public void setUsuarioModifica(String usuarioModifica) {
        this.usuarioModifica = usuarioModifica;
    }

    public String getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(String fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getFechaBaja() {
        return fechaBaja;
    }

    public void setFechaBaja(String fechaBaja) {
        this.fechaBaja = fechaBaja;
    }

    public String getFechaModifica() {
        return fechaModifica;
    }

    public void setFechaModifica(String fechaModifica) {
        this.fechaModifica = fechaModifica;
    }

    public String getNuired() {
        return nuired;
    }

    public void setNuired(String nuired) {
        this.nuired = nuired;
    }

    public String getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(String catalogo) {
        this.catalogo = catalogo;
    }

    public String getNumeroRegistro() {
        return numeroRegistro;
    }

    public void setNumeroRegistro(String numeroRegistro) {
        this.numeroRegistro = numeroRegistro;
    }

    public String getSignatura() {
        return signatura;
    }

    public void setSignatura(String signatura) {
        this.signatura = signatura;
    }

    public void addEtiqueta(Etiqueta e) {
        etiquetas.add(e);
    }

    public String getNumeroInformatico() {
        return numeroInformatico;
    }

    public void setNumeroInformatico(String numeroInformatico) {
        this.numeroInformatico = numeroInformatico;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getBiblioteca() {
        return biblioteca;
    }

    public void setBiblioteca(String biblioteca) {
        this.biblioteca = biblioteca;
    }

    @XmlElementWrapper(name = "etiquetas")
    @XmlElement(name = "etiqueta")
    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public void setNuregi(String nuregi) {
        this.numeroRegistro = nuregi;
    }

    public Registro getPadre() {
        return padre;
    }

    public void setPadre(Registro padre) {
        this.padre = padre;
    }

    public Set<Registro> getHijos() {
        return hijos;
    }

    public void setHijos(Set<Registro> hijos) {
        this.hijos = hijos;
    }

    public List<String> getDescendants() {
        return descendants;
    }

    public void setDescendants(List<String> descendants) {
        this.descendants = descendants;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public void add(Etiqueta et) {
        etiquetas.add(et);
    }

    /**
     * Adds a new tag or subfield to the record.
     * It checks if the tag already exists, and adds the subfields to it.
     * If the tag does not exist, it is created before.
     *
     * @param et Tag to be added
     */
    public void addDirdat1(Etiqueta et) {
        for (Etiqueta etiqueta : etiquetas) {
            if (etiqueta.getCodigo().equals(et.getCodigo())) {
                etiqueta.getCampos().addAll(et.getCampos());
                return;
            }
        }
        etiquetas.add(et);
    }

    /**
     * Removes empty fields and tags without fields, in this order.
     * This method should be called after populate when cataloging.
     */
    public void limpia() {
        // Limpiar
        List<Etiqueta> etiquetasAEliminar = new ArrayList<Etiqueta>();
        for (Etiqueta e : etiquetas) {
            List<Campo> camposAEliminar = new ArrayList<Campo>();
            int noEliminar = 0;
            for (Campo c : e.getCampos()) {
                if (c.getDatos() == null || c.getDatos().trim().length() < 1) {
                    camposAEliminar.add(c);
                } else {
                    noEliminar++;
                }
            }
            e.getCampos().removeAll(camposAEliminar);
            if (noEliminar == 0) {
                etiquetasAEliminar.add(e);
            }
        }
        etiquetas.removeAll(etiquetasAEliminar);
    }

    public Integer getValoracion() {
        return valoracion;
    }

    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }

    public Integer getNumeroVotos() {
        return numeroVotos;
    }

    public void setNumeroVotos(Integer numeroVotos) {
        this.numeroVotos = numeroVotos;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getNumVisitas() {
        return numVisitas;
    }

    public void setNumVisitas(Integer numVisitas) {
        this.numVisitas = numVisitas;
    }

    public Integer getNumPrestamos() {
        return numPrestamos;
    }

    public void setNumPrestamos(Integer numPrestamos) {
        this.numPrestamos = numPrestamos;
    }

    public String getTextoEtiquetaCampo(String s, String s1) {
        return getTextoEtiquetaCampo(s, 1, s1, 1);
    }

    /**
     * Gets the text of a specific field repeat of a specific tag repeat.
     *
     * @param s    Tag code
     * @param rep1 Tag repeat
     * @param s1   Subfield code
     * @param rep2 Subfield repeat
     * @return subfield text or null if not found
     */
    public String getTextoEtiquetaCampo(String s, int rep1, String s1, int rep2) {
        Campo cp = getCampo(s, rep1, s1, rep2);
        if (cp != null) {
            return cp.getDatos();
        } else {
            return " ";
        }
    }

    /**
     * Gets the text of a set of tags.
     *
     * @param result set o tags
     * @return Text found as a string separated by blank spaces.
     */
    private String getTextoEtiquetas(List<Etiqueta> result) {
        StringBuilder sb = new StringBuilder();
        for (Etiqueta e : result) {
            sb.append(e.getTexto());
            sb.append(" ");
        }
        return sb.toString().trim();
    }

    /**
     * Gets all the tags with a specific code
     *
     * @param eti code to search
     * @return List of tags of this code
     */
    public List<Etiqueta> getEtiquetas(String eti) {
        List<Etiqueta> resutl = new ArrayList<Etiqueta>();

        for (Etiqueta e : etiquetas) {
            if (e.getCodigo().equals(eti)) {
                resutl.add(e);
            }
        }
        return resutl;
    }

    /**
     * Gets the text of all tags with a specific code
     *
     * @param eti code to search
     * @return Text of all tags, or null
     */
    public String getTextoEtiqueta(String eti) {
        List<Etiqueta> result = getEtiquetas(eti);
        String st = getTextoEtiquetas(result);

        if (st.length() > 0) {
            return st;
        } else {
            return null;
        }
    }

    /**
     * Gets the text of all tags with a specific code and a specific field
     *
     * @param eti      Tag code
     * @param subcampo Subfield code
     * @return Text or null if not found
     */
    public String getTextoSubcampo(String eti, String subcampo) {
        List<Etiqueta> etiquetas = getEtiquetas(eti);
        StringBuilder sb = new StringBuilder();

        for (Etiqueta e : etiquetas) {
            sb.append(e.getTextoSubcampo(subcampo));
        }
        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * Gets the text of all tags with a specific code and a specific field
     *
     * @param eti
     * @param subcampo
     * @return
     */
    public List<String> getTextoSubcampoImport(String eti, String subcampo) {
        List<Etiqueta> etiquetas = getEtiquetas(eti);
        List<String> result = new ArrayList<String>();

        for (Etiqueta e : etiquetas) {
            if (e.getCampos() != null && !e.getCampos().isEmpty()) {
                for (Campo c : e.getCampos()) {
                    if (c.getSubcampo() != null && c.getSubcampo().equals(subcampo))
                        result.add(c.getDatos());
                }
            }
        }
        if (result.size() > 0) {
            return result;
        } else {
            return null;
        }
    }

    /**
     * Gets the text of a specific tag repeat and a specific subfield code.
     *
     * @param eti      Tag code
     * @param rep      Tag repeat
     * @param subcampo Subfield code
     * @return Text or null
     */
    public String getTextoSubcampo(String eti, int rep, String subcampo) {
        Etiqueta e = getEtiqueta(eti, rep);
        StringBuilder sb = new StringBuilder();
        if (e != null) {
            sb.append(e.getTextoSubcampo(subcampo));
        }
        if (sb.length() > 0) {
            return sb.toString();
        } else {
            return null;
        }
    }

    /**
     * Check and determine whether the current record can be sold depending on the current code country value
     * {@link UtilShared#codeCountry}, and the sale rights specified with Onix, and stored in 540$a and $b.
     * <p/>
     * The record can be sold by default, if not, this will be specified on purpose at the sale rights.
     *
     * @return
     */

    private boolean containsCurrency(final String currencyCode, final List<Currency> listCurrency) {
        if (listCurrency != null && currencyCode != null) {
            for (Currency currency : listCurrency) {
                    return true;
            }
        }
        return false;
    }

    /**
     * Get the price fields only for the current currency {@link UtilShared#codeCurrency}
     *
     * @return
     */
    private List<Etiqueta> getEtiFromCurrency(String codeCurrency, List<Currency> listCurrency) {
        final List<Etiqueta> e365sWithCurrency = new ArrayList<Etiqueta>();
        if (codeCurrency != null && !codeCurrency.trim().isEmpty()) {
            List<Etiqueta> all365s = getEtiquetas(ETI365);

            if (all365s != null) {
                for (final Etiqueta e365 : all365s) {
                    for (final Campo c : e365.getCampos()) {
                        // If it contains the current currency and it belongs to the list of currencies
                        if (c.getSubcampo().equals("$c") && c.getDatos().equalsIgnoreCase(codeCurrency)
                                && containsCurrency(c.getDatos(), listCurrency)) {
                            e365sWithCurrency.add(e365);
                        }
                    }
                }
            }
        }
        return e365sWithCurrency;
    }


    public boolean hasValidCountry(String codeCountry, Campo c) {
        return "$j".equals(c.getSubcampo()) && codeCountry.equals(c.getDatos());
    }

    public boolean hasValidPriceQualifer(Campo c) {
        return "$m".equals(c.getSubcampo()) && "06".equals(c.getDatos());
    }


    public boolean updateCurrency(final List<Currency> list, final String wCurrency) {
        boolean update = false;

        if (getTextoEtiquetaCampo(ETI365, CAMPO_B).trim().length() > 0 ||
                getTextoEtiquetaCampo(ETI365, CAMPO_H).trim().length() > 0) {

            List<Etiqueta> listPrice = getEtiquetas(ETI365);

            if (listPrice != null && !listPrice.isEmpty()) {
                for (final Etiqueta eti : listPrice) {

                    List<Campo> listCampoBH = eti.getCampos(CAMPO_B);
                    listCampoBH.addAll(eti.getCampos(CAMPO_H));
                    if (listCampoBH != null && !listCampoBH.isEmpty()) {
                        for (final Campo cmpBH : listCampoBH) {
                            List<Campo> cmpC = eti.getCampos(CAMPO_C);
                                update = true;
                        }
                    }
                }
            }
        }

        return update;
    }

    public void updatePriceTaxes(String percentagePrice) {
        if (getTextoEtiquetaCampo(ETI365, CAMPO_B).trim().length() > 0) {
            List<Etiqueta> listPrice = getEtiquetas(ETI365);

            if (listPrice != null && !listPrice.isEmpty()) {
                for (final Etiqueta eti : listPrice) {

                    List<Campo> listCampoB = eti.getCampos(CAMPO_B);
                    if (listCampoB != null && !listCampoB.isEmpty()) {
                        for (final Campo cmpB : listCampoB) {
                            List<Campo> cmpH = eti.getCampos(CAMPO_H);
                        }
                    }
                }
            }
        }
    }

    public void updatePrice(String percentagePrice) {
        if (getTextoEtiquetaCampo(ETI365, CAMPO_H).trim().length() > 0) {
            List<Etiqueta> listPrice = getEtiquetas(ETI365);

            if (listPrice != null && !listPrice.isEmpty()) {
                for (final Etiqueta eti : listPrice) {
                    List<Campo> listCampoH = eti.getCampos(CAMPO_H);
                    if (listCampoH != null && !listCampoH.isEmpty()) {
                        for (final Campo cmpH : listCampoH) {
                            List<Campo> cmpB = eti.getCampos(CAMPO_B);
                        }
                    }
                }
            }
        }
    }

    /**
     * Gets the title of a record, only tag: 245$a
     *
     * @return The title or emptry String
     */
    public String getTituloMinimo() {
        String title = getTextoEtiquetaCampo("245", "$a");
        return title != null ? title.trim() : "";
    }

    /**
     * Gets the title of a record, tags: 245$a+245$b+245$n if exists
     *
     * @return The title or empty String
     */
    public String getTitulo() {
        return getTitulo(-1);
    }

    public String getTitulo(int length) {
        return getTitulo(length, "245");
    }

    public String getTituloSimple() {
        Etiqueta titulo = getEtiqueta("245", 1);

        if (titulo != null) {
            Campo a = titulo.getCampo("$a", "01");

            return a != null
                    ? a.getDatos()
                    : "";
        }

        return "";
    }

    public String getTitulo(int length, String field) {
        if (field == null || field.isEmpty())
            field = "245"; // Default title field

        Etiqueta e245 = getEtiqueta(field, 1);
        // A record should always have a title, but just in case...
        if (e245 != null) {
            Campo dolarA = e245.getCampo("$a", "01");
            if (dolarA != null) {
                Campo dolarB = e245.getCampo("$b", "01");
                Campo dolarN = e245.getCampo("$n", "01");

                String dolarAvalue = dolarA.getDatos() != null ? dolarA.getDatos().trim() : "";

                if (dolarB == null && dolarN == null)
                    return dolarAvalue;
                else {
                    StringBuilder sb = new StringBuilder(dolarAvalue + " ");
                    if (dolarB != null && dolarB.getDatos() != null)
                        sb.append(dolarB.getDatos().trim()).append(" ");
                    if (dolarN != null && dolarN.getDatos() != null)
                        sb.append(dolarN.getDatos().trim());

                        return sb.toString().trim();
                }
            }
        }
        return "";
    }

    /**
     * Get the summary of a record if any
     *
     * @return
     */
    public String getSummary() {
        String cont = getTextoSubcampo("520", "$a");
        if (cont != null && !cont.isEmpty())
            return cont;

        cont = getTextoSubcampo("500", "$a");
        if (cont != null && !cont.isEmpty())
            return cont;

        return "";
    }

    public String getSummaryWithOut500() {
        String cont = getTextoSubcampo("520", "$a");
        if (cont != null && !cont.isEmpty())
            return cont;

        return "";
    }

    /**
     * Gets the text of a record of a set of tags.
     */
    public String getTextDescendienteEntrada(List<String> entradas) {
        if (entradas == null || entradas.isEmpty()) 
            return getTitulo(-1);
        else
        	return null;
    }

    /**
     * Gets the author: tag 100$a
     *
     * @return The author or null
     */
    public String getAutor() {
        final Etiqueta eAuthor = getEtiqueta("100", "01");
        String autor = null;
        if (eAuthor != null) {
            final Campo cAuthor = eAuthor.getCampo("$a", "01");
            if (cAuthor != null && cAuthor.getDatos() != null && !cAuthor.getDatos().isEmpty()) {
                autor = cAuthor.getDatos();
            }
        }

        if (autor == null || autor.isEmpty()) {
            autor = getCorporateAutor();
        }

        return autor;
    }

    /**
     * Gets the corporate author: tag 110$a
     *
     * @return The author or null
     */
    public String getCorporateAutor() {
        final Etiqueta eCorporateAuthor = getEtiqueta("110", "01");
        if (eCorporateAuthor != null) {
            final Campo cCorporateAuthor = eCorporateAuthor.getCampo("$a", "01");
            if (cCorporateAuthor != null && cCorporateAuthor.getDatos() != null && !cCorporateAuthor.getDatos().isEmpty()) {
                return cCorporateAuthor.getDatos();
            }
        }

        return null;
    }

    /**
     * Gets the ISBN: tag 020$a
     *
     * @return The ISBN or null
     */
    public String getISBN() {
        if (getTextoSubcampo("020", "$a") != null) {
            return getTextoSubcampo("020", "$a");
        } else if (getTextoSubcampo("019", "$a") != null) {
            return getTextoSubcampo("019", "$a");
        }

        return "";
    }

    /**
     * Gets all fields for a specific tag and subfield
     *
     * @param e Tag code
     * @param c Subfield code
     * @return List of subfields
     */
    public List<Campo> getCampos(String e, String c) {
        List<Campo> gwtCampos = new ArrayList<Campo>();

        for (Etiqueta et : getEtiquetas(e)) {
            for (Campo cp : et.getCampos()) {
                if (cp.getSubcampo().equals(c)) {
                    gwtCampos.add(cp);
                }
            }
        }
        return gwtCampos;
    }

    /**
     * Adds a new tag/field with a value. It always creates a new tag repeat.
     *
     * @param name  Tag/subfield format EEE$S, e.g. 100$a or 091$h.
     * @param value Subfield value
     */
    public void addEtiCampo(String name, String value) {
        if (name != null && name.length() == 5) {
            String eti = name.substring(0, 3);
            String camp = name.substring(3);

            Etiqueta gwtEtiqueta = new Etiqueta();
            Campo gwtCampo = new Campo();

            gwtCampo.setDatos(value);
            gwtCampo.setSubcampo(camp);

            gwtEtiqueta.setCodigo(eti);
            gwtEtiqueta.add(gwtCampo);

            add(gwtEtiqueta);
        }
    }

    /**
     * Adds a new tag/field with a value. If the tag does not exist, it creates a new one, but if it exists, a new field
     * will be added to this tag.
     *
     * @param name  Tag/subfield format EEE$S, e.g. 100$a or 091$h.
     * @param value Subfield value
     */
    public void addEtiCampoDirdat(String name, String value) {
        if (name != null && name.length() == 5) {
            String eti = name.substring(0, 3);
            String camp = name.substring(3);

            Etiqueta gwtEtiqueta = new Etiqueta();
            Campo gwtCampo = new Campo();

            gwtCampo.setDatos(value);
            gwtCampo.setSubcampo(camp);

            gwtEtiqueta.setCodigo(eti);
            gwtEtiqueta.add(gwtCampo);

            addDirdat1(gwtEtiqueta);
        }
    }

    public void addEtiCampoIfRequired(String name, String value) {
        if (name != null && name.length() == 5) {
            String eti = name.substring(0, 3);
            String camp = name.substring(3);

            final List<Etiqueta> etiquetas1 = getEtiquetas(eti);
            if (etiquetas1.size() == 0) {
                addEtiCampo(name, value);
            } else {
                for (Etiqueta etiqueta : etiquetas1) {
                    for (Campo campo : etiqueta.getCampos()) {
                        if (camp.equals(campo.getSubcampo())) {
                            // Si existe campo$subcampo, agreaga nueva etiqeuta y fin
                            addEtiCampo(name, value);
                            return;
                        }
                    }
                }
                // No encontre repeticion etiqueta/subcampo, coge la primera etiqueta y agrega el subcampo
                Campo gwtCampo = new Campo();
                gwtCampo.setDatos(value);
                gwtCampo.setSubcampo(camp);
                etiquetas1.get(0).add(gwtCampo);
            }
        }
    }

    /**
     * Adds a new repeat of the subfield specified to the field specified.
     */
    public void addSubfieldRepeatToField(String field, String subfield, String value) {
        for (Etiqueta e : etiquetas) {
            if (e.getCodigo().equals(field)) {
                for (Campo c : e.getCampos()) {
                    if (c.getSubcampo().equals(subfield)) {
                        e.getCampos().add(new Campo(subfield, value));
                        return;
                    }
                }
            }
        }
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Integer getNumDescargas() {
        return numDescargas;
    }

    public void setNumDescargas(Integer numDescargas) {
        this.numDescargas = numDescargas;
    }

    /**
     * Gets all the {@link #numeroInformatico} of the children records. They should have been loaded previously.
     *
     * @return Set of {@link #numeroInformatico} (empty if children are not loaded)
     */
    public Collection<String> getNInfsHijos() {
        Set<String> nInfs = new HashSet<String>();
        if (hijos != null) {
            for (Registro reg : hijos) {
                nInfs.add(reg.getNumeroInformatico());
            }
        }
        return nInfs;
    }

    public boolean isPrestamo() {
        return prestamo;
    }

    public void setPrestamo(boolean prestamo) {
        this.prestamo = prestamo;
    }

    public String getIdMetadatos() {
        return idMetadatos;
    }

    public void setIdMetadatos(String idMetadatos) {
        this.idMetadatos = idMetadatos;
    }

    public Integer getNumEjemplares() {
        return numEjemplares;
    }

    public void setNumEjemplares(Integer numEjemplares) {
        this.numEjemplares = numEjemplares;
    }

    public Integer getNumVolumenes() {
        return numVolumenes;
    }

    public void setNumVolumenes(Integer numVolumenes) {
        this.numVolumenes = numVolumenes;
    }


    @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Registro other = (Registro) obj;
		if (baja == null) {
			if (other.baja != null)
				return false;
		} else if (!baja.equals(other.baja))
			return false;
		if (biblioteca == null) {
			if (other.biblioteca != null)
				return false;
		} else if (!biblioteca.equals(other.biblioteca))
			return false;
		if (bookMoviesId == null) {
			if (other.bookMoviesId != null)
				return false;
		} else if (!bookMoviesId.equals(other.bookMoviesId))
			return false;
		if (catalogo == null) {
			if (other.catalogo != null)
				return false;
		} else if (!catalogo.equals(other.catalogo))
			return false;
		if (clave == null) {
			if (other.clave != null)
				return false;
		} else if (!clave.equals(other.clave))
			return false;
		if (codigoBarras == null) {
			if (other.codigoBarras != null)
				return false;
		} else if (!codigoBarras.equals(other.codigoBarras))
			return false;
		if (control001 == null) {
			if (other.control001 != null)
				return false;
		} else if (!control001.equals(other.control001))
			return false;
		if (control003 == null) {
			if (other.control003 != null)
				return false;
		} else if (!control003.equals(other.control003))
			return false;
		if (control005 == null) {
			if (other.control005 != null)
				return false;
		} else if (!control005.equals(other.control005))
			return false;
		if (control006 == null) {
			if (other.control006 != null)
				return false;
		} else if (!control006.equals(other.control006))
			return false;
		if (control007 == null) {
			if (other.control007 != null)
				return false;
		} else if (!control007.equals(other.control007))
			return false;
		if (control008 == null) {
			if (other.control008 != null)
				return false;
		} else if (!control008.equals(other.control008))
			return false;
		if (descendants == null) {
			if (other.descendants != null)
				return false;
		} else if (!descendants.equals(other.descendants))
			return false;
		if (etiquetas == null) {
			if (other.etiquetas != null)
				return false;
		} else if (!etiquetas.equals(other.etiquetas))
			return false;
		if (fechaAlta == null) {
			if (other.fechaAlta != null)
				return false;
		} else if (!fechaAlta.equals(other.fechaAlta))
			return false;
		if (fechaBaja == null) {
			if (other.fechaBaja != null)
				return false;
		} else if (!fechaBaja.equals(other.fechaBaja))
			return false;
		if (fechaModifica == null) {
			if (other.fechaModifica != null)
				return false;
		} else if (!fechaModifica.equals(other.fechaModifica))
			return false;
		if (formato == null) {
			if (other.formato != null)
				return false;
		} else if (!formato.equals(other.formato))
			return false;
		if (hijos == null) {
			if (other.hijos != null)
				return false;
		} else if (!hijos.equals(other.hijos))
			return false;
		if (idMetadatos == null) {
			if (other.idMetadatos != null)
				return false;
		} else if (!idMetadatos.equals(other.idMetadatos))
			return false;
		if (isDigital != other.isDigital)
			return false;
		if (isPhysical != other.isPhysical)
			return false;
		if (leader == null) {
			if (other.leader != null)
				return false;
		} else if (!leader.equals(other.leader))
			return false;
		if (levelLoad != other.levelLoad)
			return false;
		if (maxLicenseLoans == null) {
			if (other.maxLicenseLoans != null)
				return false;
		} else if (!maxLicenseLoans.equals(other.maxLicenseLoans))
			return false;
		if (nuired == null) {
			if (other.nuired != null)
				return false;
		} else if (!nuired.equals(other.nuired))
			return false;
		if (numDescargas == null) {
			if (other.numDescargas != null)
				return false;
		} else if (!numDescargas.equals(other.numDescargas))
			return false;
		if (numEjemplares == null) {
			if (other.numEjemplares != null)
				return false;
		} else if (!numEjemplares.equals(other.numEjemplares))
			return false;
		if (numHolds == null) {
			if (other.numHolds != null)
				return false;
		} else if (!numHolds.equals(other.numHolds))
			return false;
		if (numPrestamos == null) {
			if (other.numPrestamos != null)
				return false;
		} else if (!numPrestamos.equals(other.numPrestamos))
			return false;
		if (numVisitas == null) {
			if (other.numVisitas != null)
				return false;
		} else if (!numVisitas.equals(other.numVisitas))
			return false;
		if (numVolumenes == null) {
			if (other.numVolumenes != null)
				return false;
		} else if (!numVolumenes.equals(other.numVolumenes))
			return false;
		if (numeroInformatico == null) {
			if (other.numeroInformatico != null)
				return false;
		} else if (!numeroInformatico.equals(other.numeroInformatico))
			return false;
		if (numeroRegistro == null) {
			if (other.numeroRegistro != null)
				return false;
		} else if (!numeroRegistro.equals(other.numeroRegistro))
			return false;
		if (numeroVotos == null) {
			if (other.numeroVotos != null)
				return false;
		} else if (!numeroVotos.equals(other.numeroVotos))
			return false;
		if (observaciones == null) {
			if (other.observaciones != null)
				return false;
		} else if (!observaciones.equals(other.observaciones))
			return false;
		if (padre == null) {
			if (other.padre != null)
				return false;
		} else if (!padre.equals(other.padre))
			return false;
		if (perfil == null) {
			if (other.perfil != null)
				return false;
		} else if (!perfil.equals(other.perfil))
			return false;
		if (prestamo != other.prestamo)
			return false;
		if (signatura == null) {
			if (other.signatura != null)
				return false;
		} else if (!signatura.equals(other.signatura))
			return false;
		if (usuarioAlta == null) {
			if (other.usuarioAlta != null)
				return false;
		} else if (!usuarioAlta.equals(other.usuarioAlta))
			return false;
		if (usuarioModifica == null) {
			if (other.usuarioModifica != null)
				return false;
		} else if (!usuarioModifica.equals(other.usuarioModifica))
			return false;
		if (valoracion == null) {
			if (other.valoracion != null)
				return false;
		} else if (!valoracion.equals(other.valoracion))
			return false;
		if (venta != other.venta)
			return false;
		return true;
	}

    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((baja == null) ? 0 : baja.hashCode());
		result = prime * result + ((biblioteca == null) ? 0 : biblioteca.hashCode());
		result = prime * result + ((bookMoviesId == null) ? 0 : bookMoviesId.hashCode());
		result = prime * result + ((catalogo == null) ? 0 : catalogo.hashCode());
		result = prime * result + ((clave == null) ? 0 : clave.hashCode());
		result = prime * result + ((codigoBarras == null) ? 0 : codigoBarras.hashCode());
		result = prime * result + ((control001 == null) ? 0 : control001.hashCode());
		result = prime * result + ((control003 == null) ? 0 : control003.hashCode());
		result = prime * result + ((control005 == null) ? 0 : control005.hashCode());
		result = prime * result + ((control006 == null) ? 0 : control006.hashCode());
		result = prime * result + ((control007 == null) ? 0 : control007.hashCode());
		result = prime * result + ((control008 == null) ? 0 : control008.hashCode());
		result = prime * result + ((descendants == null) ? 0 : descendants.hashCode());
		result = prime * result + ((etiquetas == null) ? 0 : etiquetas.hashCode());
		result = prime * result + ((fechaAlta == null) ? 0 : fechaAlta.hashCode());
		result = prime * result + ((fechaBaja == null) ? 0 : fechaBaja.hashCode());
		result = prime * result + ((fechaModifica == null) ? 0 : fechaModifica.hashCode());
		result = prime * result + ((formato == null) ? 0 : formato.hashCode());
		result = prime * result + ((hijos == null) ? 0 : hijos.hashCode());
		result = prime * result + ((idMetadatos == null) ? 0 : idMetadatos.hashCode());
		result = prime * result + (isDigital ? 1231 : 1237);
		result = prime * result + (isPhysical ? 1231 : 1237);
		result = prime * result + ((leader == null) ? 0 : leader.hashCode());
		result = prime * result + (int) (levelLoad ^ (levelLoad >>> 32));
		result = prime * result + ((maxLicenseLoans == null) ? 0 : maxLicenseLoans.hashCode());
		result = prime * result + ((nuired == null) ? 0 : nuired.hashCode());
		result = prime * result + ((numDescargas == null) ? 0 : numDescargas.hashCode());
		result = prime * result + ((numEjemplares == null) ? 0 : numEjemplares.hashCode());
		result = prime * result + ((numHolds == null) ? 0 : numHolds.hashCode());
		result = prime * result + ((numPrestamos == null) ? 0 : numPrestamos.hashCode());
		result = prime * result + ((numVisitas == null) ? 0 : numVisitas.hashCode());
		result = prime * result + ((numVolumenes == null) ? 0 : numVolumenes.hashCode());
		result = prime * result + ((numeroInformatico == null) ? 0 : numeroInformatico.hashCode());
		result = prime * result + ((numeroRegistro == null) ? 0 : numeroRegistro.hashCode());
		result = prime * result + ((numeroVotos == null) ? 0 : numeroVotos.hashCode());
		result = prime * result + ((observaciones == null) ? 0 : observaciones.hashCode());
		result = prime * result + ((padre == null) ? 0 : padre.hashCode());
		result = prime * result + ((perfil == null) ? 0 : perfil.hashCode());
		result = prime * result + (prestamo ? 1231 : 1237);
		result = prime * result + ((signatura == null) ? 0 : signatura.hashCode());
		result = prime * result + ((usuarioAlta == null) ? 0 : usuarioAlta.hashCode());
		result = prime * result + ((usuarioModifica == null) ? 0 : usuarioModifica.hashCode());
		result = prime * result + ((valoracion == null) ? 0 : valoracion.hashCode());
		result = prime * result + (venta ? 1231 : 1237);
		return result;
	}

    public String getBookMoviesId() {
        return bookMoviesId;
    }

    public void setBookMoviesId(String bookMoviesId) {
        this.bookMoviesId = bookMoviesId;
    }

    public Integer getNumHolds() {
        return numHolds;
    }

    public void setNumHolds(Integer numHolds) {
        this.numHolds = numHolds;
    }

    public boolean isPhysical() {
        return isPhysical;
    }

    public void setPhysical(boolean physical) {
        isPhysical = physical;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setDigital(boolean digital) {
        this.isDigital = digital;
    }

    public List<String> getValueAllFields(String e) {
        List<String> result = new ArrayList<String>();
        for (Etiqueta et : getEtiquetas(e)) {
            for (Campo cp : et.getCampos()) {
                result.add(cp.getDatos());
            }
        }
        return result;
    }

    public List<String> getValueAllLabelsAllFields() {
        List<String> result = new ArrayList<String>();
        for (Etiqueta et : etiquetas) {
            for (Campo cp : et.getCampos()) {
                result.add(cp.getDatos());
            }
        }

        return result;
    }

	@Override
	public String toString() {
		return "Registro [numeroInformatico=" + numeroInformatico + ", formato=" + formato + ", biblioteca="
				+ biblioteca + ", etiquetas=" + etiquetas + ", numeroRegistro=" + numeroRegistro + ", signatura="
				+ signatura + ", nuired=" + nuired + ", catalogo=" + catalogo + ", fechaAlta=" + fechaAlta
				+ ", fechaModifica=" + fechaModifica + ", codigoBarras=" + codigoBarras + ", perfil=" + perfil
				+ ", leader=" + leader + ", control001=" + control001 + ", control003=" + control003 + ", control005="
				+ control005 + ", control006=" + control006 + ", control007=" + control007 + ", control008="
				+ control008 + ", usuarioAlta=" + usuarioAlta + ", usuarioModifica=" + usuarioModifica + ", padre="
				+ padre + ", hijos=" + hijos + ", descendants=" + descendants + ", observaciones=" + observaciones
				+ ", valoracion=" + valoracion + ", numeroVotos=" + numeroVotos + ", numVisitas=" + numVisitas
				+ ", numPrestamos=" + numPrestamos + ", numDescargas=" + numDescargas + ", baja=" + baja
				+ ", idMetadatos=" + idMetadatos + ", numEjemplares=" + numEjemplares + ", numVolumenes=" + numVolumenes
				+ ", maxLicenseLoans=" + maxLicenseLoans + ", prestamo=" + prestamo + ", clave=" + clave
				+ ", fechaBaja=" + fechaBaja + ", venta=" + venta + ", levelLoad=" + levelLoad + ", bookMoviesId="
				+ bookMoviesId + ", isDigital=" + isDigital + ", isPhysical=" + isPhysical + ", numHolds=" + numHolds
				+ "]";
	}

	public List<List<String>> getCheckFailure() {
		return checkFailure;
	}

	public void setCheckFailure(List<List<String>> checkFailure) {
		this.checkFailure = checkFailure;
	}
}
