package com.observatorio.conectividad_peru.dao;

import com.observatorio.conectividad_peru.model.IndicadorLaboral;
import com.observatorio.conectividad_peru.model.IndicadorEducativo;

public interface IndicadorSocialDao {
    IndicadorLaboral obtenerIndicadorLaboral(String codigoUbigeo, int anio);
    IndicadorEducativo obtenerIndicadorEducativo(String codigoUbigeo, int anio);
}
