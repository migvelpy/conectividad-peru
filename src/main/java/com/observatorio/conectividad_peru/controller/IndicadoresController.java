package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndicadoresController {

    @Autowired
    private IndicadorSocialService indicadorSocialService;

    @GetMapping("/teletrabajo")
    public String teletrabajo(Model model) {
        model.addAttribute("listaTeletrabajo", indicadorSocialService.obtenerIndicadoresTeletrabajo());
        return "teletrabajo";
    }

    @GetMapping("/educacion")
    public String educacion(Model model) {
        model.addAttribute("listaEducacion", indicadorSocialService.obtenerIndicadoresEducacion());
        return "educacion";
    }
}