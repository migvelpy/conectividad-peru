package com.observatorio.conectividad_peru.dao;

import java.util.List;
import java.util.Map;

public interface CoberturaDao {

    Map<String, Object> obtenerKpisDashboard();

    List<Map<String, Object>> obtenerDatosMapaNacional();

    List<Map<String, Object>> obtenerParticipacionOperadoras();

    List<Map<String, Object>> obtenerCoberturaPorDistrito(String codigoUbigeo);
}
