package com.observatorio.conectividad_peru.model;

public class UbigeoDistrito {
    private String codigoUbigeo;
    private String departamento;
    private String provincia;
    private String distrito;

    public UbigeoDistrito() {}

    public UbigeoDistrito(String codigoUbigeo, String departamento, String provincia, String distrito) {
        this.codigoUbigeo = codigoUbigeo;
        this.departamento = departamento;
        this.provincia = provincia;
        this.distrito = distrito;
    }

    public String getCodigoUbigeo() { return codigoUbigeo; }
    public void setCodigoUbigeo(String codigoUbigeo) { this.codigoUbigeo = codigoUbigeo; }

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }

    public String getProvincia() { return provincia; }
    public void setProvincia(String provincia) { this.provincia = provincia; }

    public String getDistrito() { return distrito; }
    public void setDistrito(String distrito) { this.distrito = distrito; }
}
