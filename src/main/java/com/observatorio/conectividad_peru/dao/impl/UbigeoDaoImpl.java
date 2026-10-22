package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.UbigeoDao;
import com.observatorio.conectividad_peru.model.ResumenMacroDto;
import com.observatorio.conectividad_peru.model.UbigeoDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UbigeoDaoImpl implements UbigeoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> obtenerDepartamentos() {
        return jdbcTemplate.queryForList("EXEC sp_obtener_departamentos", String.class);
    }

    @Override
    public List<String> obtenerProvinciasPorDepartamento(String departamento) {
        return jdbcTemplate.queryForList("EXEC sp_obtener_provincias ?", String.class, departamento);
    }

    @Override
    public List<UbigeoDistrito> obtenerDistritosPorProvincia(String departamento, String provincia) {
        return jdbcTemplate.query(
                "EXEC sp_obtener_distritos ?, ?",
                BeanPropertyRowMapper.newInstance(UbigeoDistrito.class),
                departamento, provincia
        );
    }

    @Override
    public ResumenMacroDto obtenerResumenMacroNacional() {
        return jdbcTemplate.queryForObject(
                "EXEC sp_obtener_resumen_macro",
                BeanPropertyRowMapper.newInstance(ResumenMacroDto.class)
        );
    }
}