package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.model.IndicadorEducativo;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EducacionController {

    @Autowired
    private IndicadorSocialService indicadorSocialService;

    @GetMapping("/educacion")
    public String mostrarEducacion(@RequestParam(name = "ubigeo", defaultValue = "150101") String ubigeo,
                                   @RequestParam(name = "anio", defaultValue = "2025") int anio,
                                   Model model) {
        IndicadorEducativo educativo = indicadorSocialService.obtenerIndicadorEducativoPorDistrito(ubigeo, anio);

        model.addAttribute("educativo", educativo);
        model.addAttribute("anioSeleccionado", anio);

        return "educacion"; // Busca 'templates/educacion.html'
    }
}
