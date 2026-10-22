package com.observatorio.conectividad_peru.service;

import java.util.List;
import java.util.Map;

public interface IndicadorSocialService {
    List<Map<String, Object>> obtenerIndicadoresTeletrabajo();
    List<Map<String, Object>> obtenerIndicadoresEducacion();
}