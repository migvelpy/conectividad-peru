package com.observatorio.conectividad_peru.controller;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.dao.UbigeoDao;
import com.observatorio.conectividad_peru.service.CoberturaService;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import com.observatorio.conectividad_peru.service.UbigeoService;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class InicioController {


    @Autowired
    private UbigeoService ubigeoService;
    @Autowired
    private CoberturaService coberturaService;
//prueba borras despues xd
    @Autowired
    private VelocidadService velocidadService;

    @Autowired
    private IndicadorSocialService indicadorSocialService;
    @GetMapping("/")
    public String index (Model model) {
        List<Map<String, Object>> mapaCompleto = coberturaService.obtenerDatosMapaNacional();

        List<Map<String, Object>> top5 = mapaCompleto.stream().limit(5).collect(Collectors.toList());
        model.addAttribute("kpis", coberturaService.obtenerKpisDashboard());
        model.addAttribute("mapaDatos", coberturaService.obtenerDatosMapaNacional());
        model.addAttribute("departamentos", ubigeoService.obtenerDepartamentos());
        model.addAttribute("top5Regiones" , top5);
        return "index";
    }
//Prueba borrar despues XD
    @GetMapping("/test-global")
    public String testGlobal(Model model) {
        // Variables exactas según tus GetMapping
        model.addAttribute("listaOperadoras", coberturaService.obtenerParticipacionOperadoras());
        model.addAttribute("listaTeletrabajo", indicadorSocialService.obtenerIndicadoresTeletrabajo());
        model.addAttribute("listaEducacion", indicadorSocialService.obtenerIndicadoresEducacion());

        // Variables de velocidad
        model.addAttribute("velNacional", velocidadService.obtenerVelocidadNacional());
        model.addAttribute("rankingDistritos", velocidadService.obtenerRankingDistritosVelocidad());

        return "test-global";
    }
}
