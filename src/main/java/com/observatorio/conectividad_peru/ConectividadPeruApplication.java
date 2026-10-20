package com.observatorio.conectividad_peru;

import com.observatorio.conectividad_peru.model.*;
import com.observatorio.conectividad_peru.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class ConectividadPeruApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectividadPeruApplication.class, args);
	}

	@Bean
	public CommandLineRunner ejecutarPruebasConsola(
			UbigeoService ubigeoService,
			VelocidadService velocidadService,
			CoberturaService coberturaService,
			IndicadorSocialService indicadorSocialService) {

		return args -> {
			System.out.println("\n==================================================");
			System.out.println("   INICIANDO PRUEBAS DE LÓGICA DE NEGOCIO");
			System.out.println("==================================================\n");

			try {
				// 1. PRUEBA RF02: Resumen Macro y Departamentos (Inicio)
				System.out.println("--- 1. Prueba RF02: Módulo Inicio ---");
				ResumenMacroDto resumen = ubigeoService.obtenerResumenMacroNacional();
				if (resumen != null) {
					System.out.println("Velocidad Promedio Nacional: " + resumen.getVelocidadPromedioNacional() + " Mbps");
					System.out.println("Total Estaciones Base: " + resumen.getTotalEstacionesBaseNacional());
					System.out.println("Distritos Críticos (< 16 Mbps): " + resumen.getTotalDistritosCriticos());
				}
				List<String> dptos = ubigeoService.obtenerDepartamentos();
				System.out.println("Departamentos encontrados en BD: " + dptos.size() + " -> " + dptos);

				// 2. PRUEBA RF04: Velocidad y Saturación (Ejemplo: UBIGEO 150101 = Lima)
				System.out.println("\n--- 2. Prueba RF04: Módulo Velocidad (UBIGEO 150101) ---");
				MetricasVelocidadSaturacion vel = velocidadService.calcularMetricasPorDistrito("150101");
				if (vel != null) {
					System.out.println("Distrito: " + vel.getNombreDistrito());
					System.out.println("Velocidad: " + vel.getVelocidadPromedioMbps() + " Mbps");
					System.out.println("Índice de Saturación: " + vel.getIndiceSaturacion() + " conexiones/antena");
					System.out.println("¿Es Distrito Crítico?: " + vel.isEsDistritoCritico());
				} else {
					System.out.println("⚠️ No se encontraron datos de velocidad para el UBIGEO 150101");
				}

				// 3. PRUEBA RF03: Cobertura por Operadora
				System.out.println("\n--- 3. Prueba RF03: Módulo Cobertura (UBIGEO 150101) ---");
				List<CoberturaOperadora> cob = coberturaService.obtenerCoberturaPorDistrito("150101");
				if (cob.isEmpty()) {
					System.out.println("⚠️ No hay registros de cobertura para el UBIGEO 150101");
				} else {
					for (CoberturaOperadora op : cob) {
						System.out.println("- Operadora: " + op.getOperadora() +
								" | 4G: " + op.getTotalAntenas4G() +
								" | 5G: " + op.getTotalAntenas5G() +
								" | Activa: " + op.isTieneCobertura());
					}
				}

				// 4. PRUEBA RF05 y RF06: Indicadores Sociales (ENAHO 2025)
				System.out.println("\n--- 4. Prueba RF05/RF06: Indicadores Sociales ---");
				IndicadorLaboral lab = indicadorSocialService.obtenerIndicadorLaboralPorDistrito("150101", 2025);
				if (lab != null) {
					System.out.println("Penetración de Teletrabajo: " + lab.getPorcentajePenetracionTeletrabajo() + "%");
				} else {
					System.out.println("⚠️ Sin datos de teletrabajo para UBIGEO 150101");
				}

				IndicadorEducativo edu = indicadorSocialService.obtenerIndicadorEducativoPorDistrito("150101", 2025);
				if (edu != null) {
					System.out.println("Acceso a Educación Virtual: " + edu.getPorcentajeAccesoEducacionVirtual() + "%");
				} else {
					System.out.println("Sin datos de educación para UBIGEO 150101");
				}

				System.out.println("\n==================================================");
				System.out.println("    TODAS LAS PRUEBAS DE LÓGICA FINALIZARON");
				System.out.println("==================================================\n");

			} catch (Exception e) {
				System.err.println("\n ERROR AL EJECUTAR LA LÓGICA EN CONSOLA:");
				e.printStackTrace();
			}
		};
	}
}
