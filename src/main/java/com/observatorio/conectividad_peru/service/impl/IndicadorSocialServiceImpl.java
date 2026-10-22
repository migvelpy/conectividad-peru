package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IndicadorSocialServiceImpl implements IndicadorSocialService {

    @Autowired
    private IndicadorSocialDao indicadorSocialDao;

    @Override
    public List<Map<String, Object>> obtenerIndicadoresTeletrabajo() {
        return indicadorSocialDao.obtenerIndicadoresTeletrabajo();
    }

    @Override
    public List<Map<String, Object>> obtenerIndicadoresEducacion() {
        return indicadorSocialDao.obtenerIndicadoresEducacion();
    }
}