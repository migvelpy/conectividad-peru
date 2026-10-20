package com.observatorio.conectividad_peru.model;

public class IndicadorLaboral {
    private String codigoUbigeo;
    private int anioEncuesta;
    private int poblacionOcupada;
    private int trabajadoresRemotos;
    private double porcentajePenetracionTeletrabajo;

    public IndicadorLaboral() {}

    public String getCodigoUbigeo() { return codigoUbigeo; }
    public void setCodigoUbigeo(String codigoUbigeo) { this.codigoUbigeo = codigoUbigeo; }

    public int getAnioEncuesta() { return anioEncuesta; }
    public void setAnioEncuesta(int anioEncuesta) { this.anioEncuesta = anioEncuesta; }

    public int getPoblacionOcupada() { return poblacionOcupada; }
    public void setPoblacionOcupada(int poblacionOcupada) { this.poblacionOcupada = poblacionOcupada; }

    public int getTrabajadoresRemotos() { return trabajadoresRemotos; }
    public void setTrabajadoresRemotos(int trabajadoresRemotos) { this.trabajadoresRemotos = trabajadoresRemotos; }

    public double getPorcentajePenetracionTeletrabajo() { return porcentajePenetracionTeletrabajo; }
    public void setPorcentajePenetracionTeletrabajo(double porcentajePenetracionTeletrabajo) { this.porcentajePenetracionTeletrabajo = porcentajePenetracionTeletrabajo; }
}
