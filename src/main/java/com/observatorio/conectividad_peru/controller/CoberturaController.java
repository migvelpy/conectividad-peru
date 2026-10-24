package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.service.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CoberturaController {

    @Autowired
    private CoberturaService coberturaService;

    @GetMapping("/operadoras")
    public String operadoras(Model model) {
        model.addAttribute("listaOperadoras", coberturaService.obtenerParticipacionOperadoras());
        return "operadoras";
    }

    @GetMapping("/cobertura")
    public String mostrarCobertura(@RequestParam(name = "ubigeo", defaultValue = "150101") String ubigeo, Model model) {
        model.addAttribute("codigoUbigeo", ubigeo);
        model.addAttribute("operadoras", coberturaService.obtenerCoberturaPorDistrito(ubigeo));
        return "cobertura";
    }
}
