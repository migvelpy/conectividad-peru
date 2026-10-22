package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class CoberturaDaoImpl implements CoberturaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> obtenerKpisDashboard() {
        return jdbcTemplate.queryForMap("EXEC sp_rf01_kpis_principales");
    }

    @Override
    public List<Map<String, Object>> obtenerDatosMapaNacional() {
        return jdbcTemplate.queryForList("EXEC sp_rf02_mapa_cobertura");
    }

    @Override
    public List<Map<String, Object>> obtenerParticipacionOperadoras() {
        return jdbcTemplate.queryForList("EXEC sp_rf03_operadoras_presencia");
    }

    @Override
    public List<Map<String, Object>> obtenerCoberturaPorDistrito(String codigoUbigeo) {
        String sql = "EXEC sp_obtener_cobertura_por_distrito ?";
        return jdbcTemplate.queryForList(sql, codigoUbigeo);
    }
}
