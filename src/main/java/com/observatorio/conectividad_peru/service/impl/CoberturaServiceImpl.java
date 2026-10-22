package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.service.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CoberturaServiceImpl implements CoberturaService {

    @Autowired
    private CoberturaDao coberturaDao;

    @Override
    public Map<String, Object> obtenerKpisDashboard() {
        return coberturaDao.obtenerKpisDashboard();
    }

    @Override
    public List<Map<String, Object>> obtenerDatosMapaNacional() {
        return coberturaDao.obtenerDatosMapaNacional();
    }

    @Override
    public List<Map<String, Object>> obtenerParticipacionOperadoras() {
        return coberturaDao.obtenerParticipacionOperadoras();
    }

    @Override
    public List<Map<String, Object>> obtenerCoberturaPorDistrito(String codigoUbigeo) {
        // Llama al Stored Procedure mediante el DAO
        return coberturaDao.obtenerCoberturaPorDistrito(codigoUbigeo);
    }
}