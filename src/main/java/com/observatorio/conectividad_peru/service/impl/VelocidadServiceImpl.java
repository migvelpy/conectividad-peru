package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import com.observatorio.conectividad_peru.model.MetricasVelocidadSaturacion;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VelocidadServiceImpl implements VelocidadService {

    @Autowired
    private VelocidadDao velocidadDao;

    @Override
    public MetricasVelocidadSaturacion calcularMetricasPorDistrito(String codigoUbigeo) {
        MetricasVelocidadSaturacion metricas = velocidadDao.obtenerDatosVelocidad(codigoUbigeo);

        if (metricas != null) {
            // Lógica de negocio 1: Redondeo de velocidad a 2 decimales
            double velRedondeada = Math.round(metricas.getVelocidadPromedioMbps() * 100.0) / 100.0;
            metricas.setVelocidadPromedioMbps(velRedondeada);

            // Lógica de negocio 2: Calcular índice de saturación (conexiones / estaciones base)
            if (metricas.getTotalEstacionesBase() > 0) {
                double saturacion = (double) metricas.getTotalConexiones() / metricas.getTotalEstacionesBase();
                metricas.setIndiceSaturacion(Math.round(saturacion * 100.0) / 100.0);
            } else {
                metricas.setIndiceSaturacion(0.0);
            }

            // Lógica de negocio 3: Determinar si el distrito está en estado crítico (< 16 Mbps)
            metricas.setEsDistritoCritico(metricas.getVelocidadPromedioMbps() < 16.0);
        }

        return metricas;
    }

    @Override
    public List<MetricasVelocidadSaturacion> listarDistritosCriticos() {
        List<MetricasVelocidadSaturacion> listaCriticos = velocidadDao.obtenerDistritosMenoresA16Mbps();

        // Lógica de negocio: Calcular saturación y asegurar flag crítico para el ranking
        for (MetricasVelocidadSaturacion m : listaCriticos) {
            if (m.getTotalEstacionesBase() > 0) {
                double saturacion = (double) m.getTotalConexiones() / m.getTotalEstacionesBase();
                m.setIndiceSaturacion(Math.round(saturacion * 100.0) / 100.0);
            } else {
                m.setIndiceSaturacion(0.0);
            }
            m.setEsDistritoCritico(true);
        }

        return listaCriticos;
    }
}
