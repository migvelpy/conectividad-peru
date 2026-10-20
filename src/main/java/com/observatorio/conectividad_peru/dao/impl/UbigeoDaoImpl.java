package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.UbigeoDao;
import com.observatorio.conectividad_peru.model.ResumenMacroDto;
import com.observatorio.conectividad_peru.model.UbigeoDistrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UbigeoDaoImpl implements UbigeoDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<String> obtenerDepartamentos() {
        String sql = "SELECT DISTINCT nombdep FROM dim_ubigeo ORDER BY nombdep";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    @Override
    public List<String> obtenerProvinciasPorDepartamento(String departamento) {
        String sql = "SELECT DISTINCT nombprov FROM dim_ubigeo WHERE nombdep = ? ORDER BY nombprov";
        return jdbcTemplate.queryForList(sql, String.class, departamento);
    }

    @Override
    public List<UbigeoDistrito> obtenerDistritosPorProvincia(String departamento, String provincia) {
        String sql = "SELECT iddist AS codigo_ubigeo, nombdep AS departamento, nombprov AS provincia, nombdist AS distrito " +
                "FROM dim_ubigeo WHERE nombdep = ? AND nombprov = ? ORDER BY nombdist";

        return jdbcTemplate.query(sql, (rs, rowNum) -> new UbigeoDistrito(
                rs.getString("codigo_ubigeo"),
                rs.getString("departamento"),
                rs.getString("provincia"),
                rs.getString("distrito")
        ), departamento, provincia);
    }

    @Override
    public ResumenMacroDto obtenerResumenMacroNacional() {
        // Promedio nacional calculado sobre las velocidades de 4G registradas en fact_cobertura_tecnologias
        String sql = "SELECT " +
                "ISNULL((SELECT AVG((ISNULL(claro_4g_prom,0) + ISNULL(bitel_4g_prom,0) + ISNULL(entel_4g_prom,0))/3.0) FROM fact_cobertura_tecnologias), 0.0) AS vel_prom, " +
                "ISNULL((SELECT SUM(total_estaciones) FROM fact_estaciones_base), 0) AS total_antenas, " +
                "ISNULL((SELECT COUNT(*) FROM fact_cobertura_tecnologias WHERE ((ISNULL(claro_4g_prom,0) + ISNULL(bitel_4g_prom,0) + ISNULL(entel_4g_prom,0))/3.0) < 16.0), 0) AS dist_criticos, " +
                "18.5 AS brecha_digital";

        return jdbcTemplate.queryForObject(sql, (rs, rowNum) -> new ResumenMacroDto(
                rs.getDouble("vel_prom"),
                rs.getInt("total_antenas"),
                rs.getInt("dist_criticos"),
                rs.getDouble("brecha_digital")
        ));
    }
}
