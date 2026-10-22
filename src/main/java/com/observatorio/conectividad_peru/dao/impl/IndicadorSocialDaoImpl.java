package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class IndicadorSocialDaoImpl implements IndicadorSocialDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Map<String, Object>> obtenerIndicadoresTeletrabajo() {
        return jdbcTemplate.queryForList("EXEC sp_rf05_empleo_regional");
    }

    @Override
    public List<Map<String, Object>> obtenerIndicadoresEducacion() {
        return jdbcTemplate.queryForList("EXEC sp_rf06_educacion_regional");
    }
}