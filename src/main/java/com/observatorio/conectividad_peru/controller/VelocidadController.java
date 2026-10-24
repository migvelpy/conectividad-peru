package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VelocidadController {

    @Autowired
    private VelocidadService velocidadService;

    @GetMapping("/velocidad")
    public String velocidad(Model model) {
        model.addAttribute("velNacional", velocidadService.obtenerVelocidadNacional());
        model.addAttribute("rankingDistritos", velocidadService.obtenerRankingDistritosVelocidad());
        return "velocidad";
    }
}
