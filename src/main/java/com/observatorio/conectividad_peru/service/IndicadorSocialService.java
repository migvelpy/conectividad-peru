package com.observatorio.conectividad_peru.service;

import com.observatorio.conectividad_peru.model.IndicadorLaboral;
import com.observatorio.conectividad_peru.model.IndicadorEducativo;

public interface IndicadorSocialService {
    IndicadorLaboral obtenerIndicadorLaboralPorDistrito(String codigoUbigeo, int anio);
    IndicadorEducativo obtenerIndicadorEducativoPorDistrito(String codigoUbigeo, int anio);
}
