package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.dao.UbigeoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {

    @Autowired
    private CoberturaDao coberturaDao;

    @Autowired
    private UbigeoDao ubigeoDao;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("kpis", coberturaDao.obtenerKpisDashboard());
        model.addAttribute("mapaDatos", coberturaDao.obtenerDatosMapaNacional());
        model.addAttribute("departamentos", ubigeoDao.obtenerDepartamentos());
        return "index";
    }
}
