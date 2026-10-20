package com.observatorio.conectividad_peru.service.impl;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import com.observatorio.conectividad_peru.model.IndicadorEducativo;
import com.observatorio.conectividad_peru.model.IndicadorLaboral;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndicadorSocialServiceImpl implements IndicadorSocialService {

    @Autowired
    private IndicadorSocialDao indicadorSocialDao;

    @Override
    public IndicadorLaboral obtenerIndicadorLaboralPorDistrito(String codigoUbigeo, int anio) {
        IndicadorLaboral lab = indicadorSocialDao.obtenerIndicadorLaboral(codigoUbigeo, anio);

        if (lab != null) {
            // Lógica de negocio: Cálculo de penetración del teletrabajo con validación de división por cero
            if (lab.getPoblacionOcupada() > 0) {
                double porcentaje = ((double) lab.getTrabajadoresRemotos() / lab.getPoblacionOcupada()) * 100.0;
                lab.setPorcentajePenetracionTeletrabajo(Math.round(porcentaje * 100.0) / 100.0);
            } else {
                lab.setPorcentajePenetracionTeletrabajo(0.0);
            }
        }

        return lab;
    }

    @Override
    public IndicadorEducativo obtenerIndicadorEducativoPorDistrito(String codigoUbigeo, int anio) {
        IndicadorEducativo edu = indicadorSocialDao.obtenerIndicadorEducativo(codigoUbigeo, anio);

        if (edu != null) {
            // Lógica de negocio: Cálculo de porcentaje de educación virtual con validación
            if (edu.getTotalEstudiantes() > 0) {
                double porcentaje = ((double) edu.getEstudiantesVirtuales() / edu.getTotalEstudiantes()) * 100.0;
                edu.setPorcentajeAccesoEducacionVirtual(Math.round(porcentaje * 100.0) / 100.0);
            } else {
                edu.setPorcentajeAccesoEducacionVirtual(0.0);
            }
        }

        return edu;
    }
}