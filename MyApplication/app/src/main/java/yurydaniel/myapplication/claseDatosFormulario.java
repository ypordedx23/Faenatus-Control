package yurydaniel.myapplication;

/**
 * Created by Yadira on 23/11/2016.
 */

public class claseDatosFormulario {

    String fecha;
    String horasf;
    String horasfin;
    String halconeros;
    String localizacions;
    String climas;
    String alturas;
    String especies;
    String cantidads;
    String tamanioGrupos;
    String actividads;
    String metControls;
    String metControlComents;
    String resultados;
    String estadoMalls;
    String estadoMallComents;
    String responsables;
    String procedimientos;


    public claseDatosFormulario(String horasf, String halconeros, String climas, String localizacions, String alturas, String especies, String cantidads, String actividads, String tamanioGrupos, String metControls, String metControlComents, String estadoMalls, String resultados, String fecha, String estadoMallComents, String responsables, String procedimientos) {
        this.horasf = horasf;
        this.halconeros = halconeros;
        this.climas = climas;
        this.localizacions = localizacions;
        this.alturas = alturas;
        this.especies = especies;
        this.cantidads = cantidads;
        this.actividads = actividads;
        this.tamanioGrupos = tamanioGrupos;
        this.metControls = metControls;
        this.metControlComents = metControlComents;
        this.estadoMalls = estadoMalls;
        this.resultados = resultados;
        this.fecha = fecha;
        this.estadoMallComents = estadoMallComents;
        this.responsables = responsables;
        this.procedimientos = procedimientos;
    }
    public claseDatosFormulario(String fecha, String horasf, String horasfin, String halconeros, String localizacions, String climas, String alturas, String especies, String cantidads, String tamanioGrupos, String actividads, String metControls, String metControlComents, String resultados, String estadoMalls, String estadoMallComents, String responsables, String procedimientos) {
        this.fecha = fecha;
        this.horasf = horasf;
        this.horasfin = horasfin;
        this.halconeros = halconeros;
        this.localizacions = localizacions;
        this.climas = climas;
        this.alturas = alturas;
        this.especies = especies;
        this.cantidads = cantidads;
        this.tamanioGrupos = tamanioGrupos;
        this.actividads = actividads;
        this.metControls = metControls;
        this.metControlComents = metControlComents;
        this.resultados = resultados;
        this.estadoMalls = estadoMalls;
        this.estadoMallComents = estadoMallComents;
        this.responsables = responsables;
        this.procedimientos = procedimientos;
    }

    public String getHorasf() {
        return horasf;
    }

    public void setHorasf(String horasf) {
        this.horasf = horasf;
    }

    public String getHalconeros() {
        return halconeros;
    }

    public void setHalconeros(String halconeros) {
        this.halconeros = halconeros;
    }

    public String getLocalizacions() {
        return localizacions;
    }

    public void setLocalizacions(String localizacions) {
        this.localizacions = localizacions;
    }

    public String getClimas() {
        return climas;
    }

    public void setClimas(String climas) {
        this.climas = climas;
    }

    public String getAlturas() {
        return alturas;
    }

    public void setAlturas(String alturas) {
        this.alturas = alturas;
    }

    public String getEspecies() {
        return especies;
    }

    public void setEspecies(String especies) {
        this.especies = especies;
    }

    public String getTamanioGrupos() {
        return tamanioGrupos;
    }

    public void setTamanioGrupos(String tamanioGrupos) {
        this.tamanioGrupos = tamanioGrupos;
    }

    public String getCantidads() {
        return cantidads;
    }

    public void setCantidads(String cantidads) {
        this.cantidads = cantidads;
    }

    public String getActividads() {
        return actividads;
    }

    public void setActividads(String actividads) {
        this.actividads = actividads;
    }

    public String getMetControls() {
        return metControls;
    }

    public void setMetControls(String metControls) {
        this.metControls = metControls;
    }

    public String getResultados() {
        return resultados;
    }

    public void setResultados(String resultados) {
        this.resultados = resultados;
    }

    public String getMetControlComents() {
        return metControlComents;
    }

    public void setMetControlComents(String metControlComents) {
        this.metControlComents = metControlComents;
    }

    public String getEstadoMalls() {
        return estadoMalls;
    }

    public void setEstadoMalls(String estadoMalls) {
        this.estadoMalls = estadoMalls;
    }

    public String getEstadoMallComents() {
        return estadoMallComents;
    }

    public void setEstadoMallComents(String estadoMallComents) {
        this.estadoMallComents = estadoMallComents;
    }

    public String getResponsables() {
        return responsables;
    }

    public void setResponsables(String responsables) {
        this.responsables = responsables;
    }

    public String getProcedimientos() {
        return procedimientos;
    }

    public void setProcedimientos(String procedimientos) {
        this.procedimientos = procedimientos;
    }

    public String getFecha() {        return fecha;    }

    public void setFecha(String fecha) {        this.fecha = fecha;    }



    @Override
    public String toString() {
        return "claseDatosFormulario{" +
                "horasf='" + horasf + '\'' +
                ", halconeros='" + halconeros + '\'' +
                ", localizacions='" + localizacions + '\'' +
                ", climas='" + climas + '\'' +
                ", alturas='" + alturas + '\'' +
                ", especies='" + especies + '\'' +
                ", cantidads=" + cantidads +
                ", tamanioGrupos='" + tamanioGrupos + '\'' +
                ", actividads='" + actividads + '\'' +
                ", metControls='" + metControls + '\'' +
                ", metControlComents='" + metControlComents + '\'' +
                ", resultados='" + resultados + '\'' +
                ", estadoMalls='" + estadoMalls + '\'' +
                ", estadoMallComents='" + estadoMallComents + '\'' +
                ", responsables='" + responsables + '\'' +
                ", procedimientos='" + procedimientos + '\'' +
                '}';
    }


}
