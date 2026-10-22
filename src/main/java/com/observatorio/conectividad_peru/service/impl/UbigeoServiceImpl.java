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
        return ubigeoDao.obtenerProvinciasPorDepartamento(departamento);
    }

    @Override
    public List<UbigeoDistrito> obtenerDistritosPorProvincia(String departamento, String provincia) {
        return ubigeoDao.obtenerDistritosPorProvincia(departamento, provincia);
    }

    @Override
    public ResumenMacroDto obtenerResumenMacroNacional() {
        return ubigeoDao.obtenerResumenMacroNacional();
    }
}