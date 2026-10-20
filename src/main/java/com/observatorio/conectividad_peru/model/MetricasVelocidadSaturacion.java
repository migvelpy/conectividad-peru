package com.observatorio.conectividad_peru.model;

public class MetricasVelocidadSaturacion {
    private String codigoUbigeo;
    private String nombreDistrito;
    private double velocidadPromedioMbps;
    private int totalConexiones;
    private int totalEstacionesBase;
    private double indiceSaturacion; // Conexiones activas por estación base
    private boolean esDistritoCritico; // true si velocidad < 16 Mbps

    public MetricasVelocidadSaturacion() {}

    public String getCodigoUbigeo() { return codigoUbigeo; }
    public void setCodigoUbigeo(String codigoUbigeo) { this.codigoUbigeo = codigoUbigeo; }

    public String getNombreDistrito() { return nombreDistrito; }
    public void setNombreDistrito(String nombreDistrito) { this.nombreDistrito = nombreDistrito; }

    public double getVelocidadPromedioMbps() { return velocidadPromedioMbps; }
    public void setVelocidadPromedioMbps(double velocidadPromedioMbps) { this.velocidadPromedioMbps = velocidadPromedioMbps; }

    public int getTotalConexiones() { return totalConexiones; }
    public void setTotalConexiones(String totalConexiones) { }
    public void setTotalConexiones(int totalConexiones) { this.totalConexiones = totalConexiones; }

    public int getTotalEstacionesBase() { return totalEstacionesBase; }
    public void setTotalEstacionesBase(int totalEstacionesBase) { this.totalEstacionesBase = totalEstacionesBase; }

    public double getIndiceSaturacion() { return indiceSaturacion; }
    public void setIndiceSaturacion(double indiceSaturacion) { this.indiceSaturacion = indiceSaturacion; }

    public boolean isEsDistritoCritico() { return esDistritoCritico; }
    public void setEsDistritoCritico(boolean esDistritoCritico) { this.esDistritoCritico = esDistritoCritico; }
}