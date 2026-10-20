package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.UbigeoDao;
import com.observatorio.conectividad_peru.model.ResumenMacroDto;
import com.observatorio.conectividad_peru.model.UbigeoDistrito;
import com.observatorio.conectividad_peru.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UbigeoServiceImpl implements UbigeoService {

    @Autowired
    private UbigeoDao ubigeoDao;

    @Override
    public List<String> obtenerDepartamentos() {
        return ubigeoDao.obtenerDepartamentos();
    }

    @Override
    public List<String> obtenerProvinciasPorDepartamento(String departamento) {
        if (departamento == null || departamento.trim().isEmpty()) {
            return List.of();
        }
        return ubigeoDao.obtenerProvinciasPorDepartamento(departamento);
    }

    @Override
    public List<UbigeoDistrito> obtenerDistritosPorProvincia(String departamento, String provincia) {
        if (departamento == null || provincia == null) {
            return List.of();
        }
        return ubigeoDao.obtenerDistritosPorProvincia(departamento, provincia);
    }

    @Override
    public ResumenMacroDto obtenerResumenMacroNacional() {
        ResumenMacroDto resumen = ubigeoDao.obtenerResumenMacroNacional();

        // Lógica de negocio: Redondear decimales para presentación en tarjetas de la vista
        if (resumen != null) {
            double velRedondeada = Math.round(resumen.getVelocidadPromedioNacional() * 100.0) / 100.0;
            resumen.setVelocidadPromedioNacional(velRedondeada);
        }

        return resumen;
    }
}