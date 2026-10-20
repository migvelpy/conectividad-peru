package com.observatorio.conectividad_peru.dao.impl;

import com.observatorio.conectividad_peru.dao.IndicadorSocialDao;
import com.observatorio.conectividad_peru.model.IndicadorEducativo;
import com.observatorio.conectividad_peru.model.IndicadorLaboral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class IndicadorSocialDaoImpl implements IndicadorSocialDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public IndicadorLaboral obtenerIndicadorLaboral(String codigoUbigeo, int anio) {
        String sql = "SELECT ubigeo_distrito, anio, total_trabajadores, trabajadores_remoto " +
                "FROM fact_enaho_empleo WHERE ubigeo_distrito = ? AND anio = ?";

        List<IndicadorLaboral> lista = jdbcTemplate.query(sql, (rs, rowNum) -> {
            IndicadorLaboral lab = new IndicadorLaboral();
            lab.setCodigoUbigeo(rs.getString("ubigeo_distrito"));
            lab.setAnioEncuesta(rs.getInt("anio"));
            lab.setPoblacionOcupada(rs.getInt("total_trabajadores"));
            lab.setTrabajadoresRemotos(rs.getInt("trabajadores_remoto"));
            return lab;
        }, codigoUbigeo, anio);

        return lista.isEmpty() ? null : lista.get(0);
    }

    @Override
    public IndicadorEducativo obtenerIndicadorEducativo(String codigoUbigeo, int anio) {
        String sql = "SELECT ubigeo_distrito, anio, total_estudiantes, estudiantes_virtual " +
                "FROM fact_enaho_educacion WHERE ubigeo_distrito = ? AND anio = ?";

        List<IndicadorEducativo> lista = jdbcTemplate.query(sql, (rs, rowNum) -> {
            IndicadorEducativo edu = new IndicadorEducativo();
            edu.setCodigoUbigeo(rs.getString("ubigeo_distrito"));
            edu.setAnioEncuesta(rs.getInt("anio"));
            edu.setTotalEstudiantes(rs.getInt("total_estudiantes"));
            edu.setEstudiantesVirtuales(rs.getInt("estudiantes_virtual"));
            return edu;
        }, codigoUbigeo, anio);

        return lista.isEmpty() ? null : lista.get(0);
    }
}
