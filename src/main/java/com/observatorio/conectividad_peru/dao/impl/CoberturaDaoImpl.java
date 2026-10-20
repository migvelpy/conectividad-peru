package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.CoberturaDao;
import com.observatorio.conectividad_peru.model.CoberturaOperadora;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CoberturaDaoImpl implements CoberturaDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<CoberturaOperadora> obtenerCoberturaPorDistrito(String codigoUbigeo) {
        String sql = "SELECT empresa_operadora AS operadora, " +
                "0 AS antenas_3g, " +
                "ISNULL(total_antenas_4g, 0) AS antenas_4g, " +
                "0 AS antenas_5g, " +
                "CASE WHEN ISNULL(total_antenas_4g, 0) > 0 THEN 1 ELSE 0 END AS tiene_cobertura " +
                "FROM fact_cobertura_operadora WHERE iddist = ?";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new CoberturaOperadora(
                rs.getString("operadora"),
                rs.getInt("antenas_3g"),
                rs.getInt("antenas_4g"),
                rs.getInt("antenas_5g"),
                rs.getBoolean("tiene_cobertura")
        ), codigoUbigeo);
    }
}
