package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class VelocidadController {

    @Autowired
    private VelocidadDao velocidadDao;

    @GetMapping("/velocidad")
    public String velocidad(Model model) {
        model.addAttribute("velNacional", velocidadDao.obtenerVelocidadNacional());
        return "velocidad";
    }
}
