package com.observatorio.conectividad_peru.service;

import com.observatorio.conectividad_peru.model.MetricasVelocidadSaturacion;
import java.util.List;

public interface VelocidadService {
    MetricasVelocidadSaturacion calcularMetricasPorDistrito(String codigoUbigeo);
    List<MetricasVelocidadSaturacion> listarDistritosCriticos(); // Velocidad < 16 Mbps
}
