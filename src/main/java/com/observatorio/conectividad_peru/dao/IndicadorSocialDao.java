package com.observatorio.conectividad_peru.dao;

import java.util.List;
import java.util.Map;

public interface IndicadorSocialDao {

    List<Map<String, Object>> obtenerIndicadoresTeletrabajo();

    List<Map<String, Object>> obtenerIndicadoresEducacion();
}
