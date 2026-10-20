package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.model.ResumenMacroDto;
import com.observatorio.conectividad_peru.service.UbigeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class InicioController {

    @Autowired
    private UbigeoService ubigeoService;

    @GetMapping("/")
    public String mostrarInicio(Model model) {
        // 1. Obtener las métricas macro del Perú para las tarjetas KPI
        ResumenMacroDto resumen = ubigeoService.obtenerResumenMacroNacional();

        // 2. Obtener lista de departamentos para el selector en cascada
        List<String> departamentos = ubigeoService.obtenerDepartamentos();

        // 3. Pasar los datos al HTML de Thymeleaf
        model.addAttribute("resumen", resumen);
        model.addAttribute("departamentos", departamentos);

        // 4. Retorna "inicio" -> busca 'templates/inicio.html'
        return "inicio";
    }
}
