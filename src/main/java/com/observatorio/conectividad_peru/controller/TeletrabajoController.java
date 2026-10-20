package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.model.IndicadorLaboral;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TeletrabajoController {

    @Autowired
    private IndicadorSocialService indicadorSocialService;

    @GetMapping("/teletrabajo")
    public String mostrarTeletrabajo(@RequestParam(name = "ubigeo", defaultValue = "150101") String ubigeo,
                                     @RequestParam(name = "anio", defaultValue = "2025") int anio,
                                     Model model) {
        IndicadorLaboral laboral = indicadorSocialService.obtenerIndicadorLaboralPorDistrito(ubigeo, anio);

        model.addAttribute("laboral", laboral);
        model.addAttribute("anioSeleccionado", anio);

        return "teletrabajo"; // Busca 'templates/teletrabajo.html'
    }
}
