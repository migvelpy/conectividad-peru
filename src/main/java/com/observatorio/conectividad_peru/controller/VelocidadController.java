package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.model.MetricasVelocidadSaturacion;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class VelocidadController {

    @Autowired
    private VelocidadService velocidadService;

    @GetMapping("/velocidad")
    public String mostrarVelocidad(@RequestParam(name = "ubigeo", defaultValue = "150101") String ubigeo, Model model) {
        // 1. Obtener métricas específicas del distrito
        MetricasVelocidadSaturacion metricas = velocidadService.calcularMetricasPorDistrito(ubigeo);

        // 2. Obtener lista de los distritos en estado crítico (< 16 Mbps)
        List<MetricasVelocidadSaturacion> distritosCriticos = velocidadService.listarDistritosCriticos();

        model.addAttribute("metricas", metricas);
        model.addAttribute("distritosCriticos", distritosCriticos);

        return "velocidad"; // Busca 'templates/velocidad.html'
    }
}
