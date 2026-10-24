package com.observatorio.conectividad_peru.service;

import java.util.Map;
import java.util.List;

public interface VelocidadService {
    // RF04: Métricas y promedios nacionales de velocidad
    Map<String, Object> obtenerVelocidadNacional();
    List<Map<String, Object>> obtenerRankingDistritosVelocidad();
}