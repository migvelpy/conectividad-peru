package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class VelocidadServiceImpl implements VelocidadService {

    @Autowired
    private VelocidadDao velocidadDao;

    @Override
    public Map<String, Object> obtenerVelocidadNacional() {
        return velocidadDao.obtenerVelocidadNacional();
    }
    @Override
    public List<Map<String, Object>> obtenerRankingDistritosVelocidad() {
        return velocidadDao.obtenerRankingDistritosVelocidad();
    }
}