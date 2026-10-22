package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class VelocidadDaoImpl implements VelocidadDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> obtenerVelocidadNacional() {
        return jdbcTemplate.queryForMap("EXEC sp_rf04_velocidad_promedio");
    }
}