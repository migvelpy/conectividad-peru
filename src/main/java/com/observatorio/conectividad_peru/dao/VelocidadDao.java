package com.observatorio.conectividad_peru.dao;

import java.util.Map;
import java.util.List;

public interface VelocidadDao {

    Map<String, Object> obtenerVelocidadNacional();
    List<Map<String, Object>> obtenerRankingDistritosVelocidad();
}
