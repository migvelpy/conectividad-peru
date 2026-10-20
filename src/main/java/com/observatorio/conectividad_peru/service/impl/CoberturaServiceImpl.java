package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.model.CoberturaOperadora;
import com.observatorio.conectividad_peru.service.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoberturaServiceImpl implements CoberturaService {

    @Autowired
    private CoberturaDao coberturaDao;

    @Override
    public List<CoberturaOperadora> obtenerCoberturaPorDistrito(String codigoUbigeo) {
        List<CoberturaOperadora> lista = coberturaDao.obtenerCoberturaPorDistrito(codigoUbigeo);

        // Lógica de negocio: Evaluar si la operadora tiene cobertura activa según número de antenas
        for (CoberturaOperadora op : lista) {
            int totalAntenas = op.getTotalAntenas3G() + op.getTotalAntenas4G() + op.getTotalAntenas5G();
            op.setTieneCobertura(totalAntenas > 0);
        }

        return lista;
    }
}
