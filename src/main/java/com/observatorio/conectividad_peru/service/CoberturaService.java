package com.observatorio.conectividad_peru.service;

import com.observatorio.conectividad_peru.model.CoberturaOperadora;
import java.util.List;

public interface CoberturaService {
    List<CoberturaOperadora> obtenerCoberturaPorDistrito(String codigoUbigeo);
}
