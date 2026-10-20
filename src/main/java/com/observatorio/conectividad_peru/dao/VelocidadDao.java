package com.observatorio.conectividad_peru.dao;

import com.observatorio.conectividad_peru.model.MetricasVelocidadSaturacion;
import java.util.List;

public interface VelocidadDao {
    MetricasVelocidadSaturacion obtenerDatosVelocidad(String codigoUbigeo);
    List<MetricasVelocidadSaturacion> obtenerDistritosMenoresA16Mbps();
}
