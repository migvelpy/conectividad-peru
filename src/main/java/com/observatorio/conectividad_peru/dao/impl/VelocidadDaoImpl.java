package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.VelocidadDao;
import com.observatorio.conectividad_peru.model.MetricasVelocidadSaturacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class VelocidadDaoImpl implements VelocidadDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public MetricasVelocidadSaturacion obtenerDatosVelocidad(String codigoUbigeo) {
        String sql = "SELECT v.ubigeo_distrito, u.nombdist AS distrito, " +
                "((ISNULL(v.claro_4g_prom, 0) + ISNULL(v.bitel_4g_prom, 0) + ISNULL(v.entel_4g_prom, 0)) / 3.0) AS velocidad_bajada, " +
                "ISNULL(v.total_ccpp, 0) AS total_conexiones, " +
                "ISNULL(e.total_estaciones, 0) AS total_estaciones " +
                "FROM fact_cobertura_tecnologias v " +
                "JOIN dim_ubigeo u ON v.ubigeo_distrito = u.iddist " +
                "LEFT JOIN fact_estaciones_base e ON v.ubigeo_distrito = e.ubigeo_distrito " +
                "WHERE v.ubigeo_distrito = ?";

        List<MetricasVelocidadSaturacion> resultados = jdbcTemplate.query(sql, (rs, rowNum) -> {
            MetricasVelocidadSaturacion m = new MetricasVelocidadSaturacion();
            m.setCodigoUbigeo(rs.getString("ubigeo_distrito"));
            m.setNombreDistrito(rs.getString("distrito"));
            m.setVelocidadPromedioMbps(rs.getDouble("velocidad_bajada"));
            m.setTotalConexiones(rs.getInt("total_conexiones"));
            m.setTotalEstacionesBase(rs.getInt("total_estaciones"));
            return m;
        }, codigoUbigeo);

        return resultados.isEmpty() ? null : resultados.get(0);
    }

    @Override
    public List<MetricasVelocidadSaturacion> obtenerDistritosMenoresA16Mbps() {
        String sql = "SELECT TOP 10 v.ubigeo_distrito, u.nombdist AS distrito, " +
                "((ISNULL(v.claro_4g_prom, 0) + ISNULL(v.bitel_4g_prom, 0) + ISNULL(v.entel_4g_prom, 0)) / 3.0) AS velocidad_bajada, " +
                "ISNULL(v.total_ccpp, 0) AS total_conexiones, " +
                "ISNULL(e.total_estaciones, 0) AS total_estaciones " +
                "FROM fact_cobertura_tecnologias v " +
                "JOIN dim_ubigeo u ON v.ubigeo_distrito = u.iddist " +
                "LEFT JOIN fact_estaciones_base e ON v.ubigeo_distrito = e.ubigeo_distrito " +
                "WHERE ((ISNULL(v.claro_4g_prom, 0) + ISNULL(v.bitel_4g_prom, 0) + ISNULL(v.entel_4g_prom, 0)) / 3.0) < 16.0 " +
                "ORDER BY velocidad_bajada ASC";

        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            MetricasVelocidadSaturacion m = new MetricasVelocidadSaturacion();
            m.setCodigoUbigeo(rs.getString("ubigeo_distrito"));
            m.setNombreDistrito(rs.getString("distrito"));
            m.setVelocidadPromedioMbps(rs.getDouble("velocidad_bajada"));
            m.setTotalConexiones(rs.getInt("total_conexiones"));
            m.setTotalEstacionesBase(rs.getInt("total_estaciones"));
            m.setEsDistritoCritico(true);
            return m;
        });
    }
}