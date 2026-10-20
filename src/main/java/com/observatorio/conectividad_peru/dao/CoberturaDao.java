package com.observatorio.conectividad_peru.dao;

import com.observatorio.conectividad_peru.model.CoberturaOperadora;
import java.util.List;

public interface CoberturaDao {
    List<CoberturaOperadora> obtenerCoberturaPorDistrito(String codigoUbigeo);
}
