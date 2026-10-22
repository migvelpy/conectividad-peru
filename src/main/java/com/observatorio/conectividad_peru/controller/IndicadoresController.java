package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndicadoresController {

    @Autowired
    private IndicadorSocialDao indicadorSocialDao;

    @GetMapping("/teletrabajo")
    public String teletrabajo(Model model) {
        model.addAttribute("listaTeletrabajo", indicadorSocialDao.obtenerIndicadoresTeletrabajo());
        return "teletrabajo";
    }

    @GetMapping("/educacion")
    public String educacion(Model model) {
        model.addAttribute("listaEducacion", indicadorSocialDao.obtenerIndicadoresEducacion());
        return "educacion";
    }
}