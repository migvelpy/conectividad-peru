package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.model.CoberturaOperadora;
import com.observatorio.conectividad_peru.service.CoberturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CoberturaController {

    @Autowired
    private CoberturaService coberturaService;

    @GetMapping("/cobertura")
    public String mostrarCobertura(@RequestParam(name = "ubigeo", defaultValue = "150101") String ubigeo, Model model) {
        // Cargar cobertura del distrito (por defecto 150101 = Lima)
        List<CoberturaOperadora> operadoras = coberturaService.obtenerCoberturaPorDistrito(ubigeo);

        model.addAttribute("codigoUbigeo", ubigeo);
        model.addAttribute("operadoras", operadoras);

        return "cobertura"; // Busca 'templates/cobertura.html'
    }
}
