package com.observatorio.conectividad_peru.service;

import java.util.List;
import java.util.Map;

public interface CoberturaService {
    Map<String, Object> obtenerKpisDashboard();
    List<Map<String, Object>> obtenerDatosMapaNacional();
    List<Map<String, Object>> obtenerParticipacionOperadoras();
    List<Map<String, Object>> obtenerCoberturaPorDistrito(String codigoUbigeo);
}