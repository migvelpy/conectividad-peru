package com.observatorio.conectividad_peru.model;

public class IndicadorEducativo {
    private String codigoUbigeo;
    private int anioEncuesta;
    private int totalEstudiantes;
    private int estudiantesVirtuales;
    private double porcentajeAccesoEducacionVirtual;

    public IndicadorEducativo() {}

    public String getCodigoUbigeo() { return codigoUbigeo; }
    public void setCodigoUbigeo(String codigoUbigeo) { this.codigoUbigeo = codigoUbigeo; }

    public int getAnioEncuesta() { return anioEncuesta; }
    public void setAnioEncuesta(int anioEncuesta) { this.anioEncuesta = anioEncuesta; }

    public int getTotalEstudiantes() { return totalEstudiantes; }
    public void setTotalEstudiantes(int totalEstudiantes) { this.totalEstudiantes = totalEstudiantes; }

    public int getEstudiantesVirtuales() { return estudiantesVirtuales; }
    public void setEstudiantesVirtuales(int estudiantesVirtuales) { this.estudiantesVirtuales = estudiantesVirtuales; }

    public double getPorcentajeAccesoEducacionVirtual() { return porcentajeAccesoEducacionVirtual; }
    public void setPorcentajeAccesoEducacionVirtual(double porcentajeAccesoEducacionVirtual) { this.porcentajeAccesoEducacionVirtual = porcentajeAccesoEducacionVirtual; }
}
