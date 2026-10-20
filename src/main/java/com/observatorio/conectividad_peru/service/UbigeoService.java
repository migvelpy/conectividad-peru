package com.observatorio.conectividad_peru.service;

import com.observatorio.conectividad_peru.model.ResumenMacroDto;
import com.observatorio.conectividad_peru.model.UbigeoDistrito;
import java.util.List;

public interface UbigeoService {
    List<String> obtenerDepartamentos();
    List<String> obtenerProvinciasPorDepartamento(String departamento);
    List<UbigeoDistrito> obtenerDistritosPorProvincia(String departamento, String provincia);
    ResumenMacroDto obtenerResumenMacroNacional();
}
