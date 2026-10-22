package com.observatorio.conectividad_peru;

import com.observatorio.conectividad_peru.service.CoberturaService;
import com.observatorio.conectividad_peru.service.IndicadorSocialService;
import com.observatorio.conectividad_peru.service.UbigeoService;
import com.observatorio.conectividad_peru.service.VelocidadService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ConectividadPeruApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConectividadPeruApplication.class, args);
	}

	@Bean
	CommandLineRunner ejecutarPruebasConsola(
			UbigeoService ubigeoService,
			VelocidadService velocidadService,
			CoberturaService coberturaService,
			IndicadorSocialService indicadorSocialService) {

		return args -> {
			System.out.println("\n==================================================================");
			System.out.println("INICIANDO PRUEBA DE STORED PROCEDURES Y SERVICIOS EN CONSOLA...");
			System.out.println("==================================================================");

			try {
				// 1. Probar Ubigeo (Departamentos)
				var departamentos = ubigeoService.obtenerDepartamentos();
				System.out.println(" [UbigeoService] Departamentos encontrados: " + departamentos);

				// 2. Probar KPIs de Cobertura
				var kpis = coberturaService.obtenerKpisDashboard();
				System.out.println(" [CoberturaService] KPIs del Dashboard: " + kpis);

				// 3. Probar Velocidad Nacional
				var velNacional = velocidadService.obtenerVelocidadNacional();
				System.out.println(" [VelocidadService] Métricas de Velocidad: " + velNacional);

				// 4. Probar Indicadores Sociales (Teletrabajo)
				var teletrabajo = indicadorSocialService.obtenerIndicadoresTeletrabajo();
				System.out.println(" [IndicadorSocialService] Registros de Teletrabajo cargados: " + (teletrabajo != null ? teletrabajo.size() : 0));

				System.out.println(" ¡TODOS LOS STORED PROCEDURES RESPONDEN PERFECTAMENTE DESDE LA BD!");

			} catch (Exception e) {
				System.err.println(" ERROR CRÍTICO AL EJECUTAR LOS STORED PROCEDURES:");
				System.err.println("   -> " + e.getMessage());
				e.printStackTrace();
			}

			System.out.println("==================================================================\n");
		};
	}
}