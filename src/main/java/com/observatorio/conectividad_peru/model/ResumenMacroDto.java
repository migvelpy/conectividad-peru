package com.observatorio.conectividad_peru.model;

public class ResumenMacroDto {
    private double velocidadPromedioNacional;
    private int totalEstacionesBaseNacional;
    private int totalDistritosCriticos;
    private double porcentajeBrechaDigital;

    public ResumenMacroDto() {}

    public ResumenMacroDto(double velocidadPromedioNacional, int totalEstacionesBaseNacional,
                           int totalDistritosCriticos, double porcentajeBrechaDigital) {
        this.velocidadPromedioNacional = velocidadPromedioNacional;
        this.totalEstacionesBaseNacional = totalEstacionesBaseNacional;
        this.totalDistritosCriticos = totalDistritosCriticos;
        this.porcentajeBrechaDigital = porcentajeBrechaDigital;
    }

    public double getVelocidadPromedioNacional() { return velocidadPromedioNacional; }
    public void setVelocidadPromedioNacional(double velocidadPromedioNacional) { this.velocidadPromedioNacional = velocidadPromedioNacional; }

    public int getTotalEstacionesBaseNacional() { return totalEstacionesBaseNacional; }
    public void setTotalEstacionesBaseNacional(int totalEstacionesBaseNacional) { this.totalEstacionesBaseNacional = totalEstacionesBaseNacional; }

    public int getTotalDistritosCriticos() { return totalDistritosCriticos; }
    public void setTotalDistritosCriticos(int totalDistritosCriticos) { this.totalDistritosCriticos = totalDistritosCriticos; }

    public double getPorcentajeBrechaDigital() { return porcentajeBrechaDigital; }
    public void setPorcentajeBrechaDigital(double porcentajeBrechaDigital) { this.porcentajeBrechaDigital = porcentajeBrechaDigital; }
}