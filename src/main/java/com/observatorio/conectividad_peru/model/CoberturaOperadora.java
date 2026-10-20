package com.observatorio.conectividad_peru.model;

public class CoberturaOperadora {
    private String operadora; // Claro, Movistar, Entel, Bitel
    private int totalAntenas3G;
    private int totalAntenas4G;
    private int totalAntenas5G;
    private boolean tieneCobertura;

    public CoberturaOperadora() {}

    public CoberturaOperadora(String operadora, int totalAntenas3G, int totalAntenas4G, int totalAntenas5G, boolean tieneCobertura) {
        this.operadora = operadora;
        this.totalAntenas3G = totalAntenas3G;
        this.totalAntenas4G = totalAntenas4G;
        this.totalAntenas5G = totalAntenas5G;
        this.tieneCobertura = tieneCobertura;
    }

    public String getOperadora() { return operadora; }
    public void setOperadora(String operadora) { this.operadora = operadora; }

    public int getTotalAntenas3G() { return totalAntenas3G; }
    public void setTotalAntenas3G(int totalAntenas3G) { this.totalAntenas3G = totalAntenas3G; }

    public int getTotalAntenas4G() { return totalAntenas4G; }
    public void setTotalAntenas4G(int totalAntenas4G) { this.totalAntenas4G = totalAntenas4G; }

    public int getTotalAntenas5G() { return totalAntenas5G; }
    public void setTotalAntenas5G(int totalAntenas5G) { this.totalAntenas5G = totalAntenas5G; }

    public boolean isTieneCobertura() { return tieneCobertura; }
    public void setTieneCobertura(boolean tieneCobertura) { this.tieneCobertura = tieneCobertura; }
}