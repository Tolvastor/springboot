package org.example.demo_sp_th_2025.DAO;

import lombok.extern.slf4j.Slf4j;
import org.example.demo_sp_th_2025.modelo.Comercial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

@Slf4j
//Un Repository es un componente y a su vez un estereotipo de Spring
//que forma parte de la 'capa de persistencia'.
@Repository

public class ComercialDAOImpl implements ComercialDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Comercial comercial) {

        String sql = """
                insert into cliente (nombre, apellido1, apellido2, comision)
                values (                ?,      ?,          ?,        ?)
                """;
        String[] ids = {"id"};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con ->{
            PreparedStatement ps = con.prepareStatement(sql, ids);
            ps.setString(1, comercial.getNombre());
            ps.setString(2, comercial.getApellido1());
            ps.setString(3, comercial.getApellido2());
            ps.setString(4, String.valueOf(comercial.getComision()));

            return ps;
        }, keyHolder);
        comercial.setId(keyHolder.getKey().intValue());
    }


    @Override
    public List<Comercial> getAll() {
        List<Comercial> listComercial = jdbcTemplate.query(
                """
                select * from comercial
                """,
                (rs, rowNum) -> new Comercial(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("apellido2"),
                        rs.getBigDecimal("comision")

                )
        );
        log.info("devuelto {} clientes", listComercial.size());
        return listComercial;
    }
    @Override
    public Optional<Comercial> find(int id){
        try {
            Comercial comercial = jdbcTemplate.queryForObject(
                            """
                            select * from comercial
                            where id = ?
                            """,

                            (rs, rowNum) -> Comercial.builder()
                            .id(rs.getInt("id"))
                            .nombre (rs.getString ("nombre"))
                            .apellido1 (rs.getString ("apellido1"))
                            .apellido2 (rs.getString ("apellido2"))
                            .comision (rs.getBigDecimal ("comision"))
                            .build(),
                    id
            );
            return Optional.ofNullable(comercial);
             } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Comercial> findAll() {
        return Optional.empty();
    }


    @Override
    public void update(Comercial comercial) {
        int rowsUpdated = jdbcTemplate.update("""
update comercial
set nombre = ?, apellido1 = ?, apellido2 = ?, comision = ?
where id = ?""", comercial.getNombre(),
                comercial.getApellido1(),
                comercial.getApellido2(),
                comercial.getComision(),
                comercial.getId());
    log.debug("filas actualizadas {} registros actualizados", rowsUpdated);
    }

    @Override
    public void delete(int id) {
        int rowsUpdated = jdbcTemplate.update("""
delete from comercial
where id = ?""", id);
        log.debug("filas eliminadas {} registros eliminados", rowsUpdated);
    }
}
