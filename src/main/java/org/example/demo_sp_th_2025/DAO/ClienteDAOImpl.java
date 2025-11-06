package org.example.demo_sp_th_2025.DAO;

import lombok.extern.slf4j.Slf4j;
import org.example.demo_sp_th_2025.modelo.Cliente;
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
public class ClienteDAOImpl implements ClienteDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void create(Cliente cliente) {

        String sql = """
                insert into cliente (nombre, apellido1, apellido2, ciudad, categoria)
                values (                ?,      ?,          ?,      ?,      ?)
                """;
        String[] ids = {"id"};
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(con ->{
            PreparedStatement ps = con.prepareStatement(sql, ids);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido1());
            ps.setString(3, cliente.getApellido2());
            ps.setString(4, cliente.getCiudad());
            ps.setInt(5, cliente.getCategoria());
            return ps;
        }, keyHolder);
        cliente.setId(keyHolder.getKey().intValue());
    }

    @Override
    public List<Cliente> getAll() {
        List<Cliente> listClientes = jdbcTemplate.query(
                """
                select * from cliente
                """,
                (rs, rowNum) -> new Cliente(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido1"),
                        rs.getString("apellido2"),
                        rs.getString("ciudad"),
                        rs.getInt("categoria")
                )
        );
        log.info("devuelto {} clientes", listClientes.size());
        return listClientes;
    }
    @Override
    public Optional<Cliente> find(int id){
        try {
            Cliente cliente = jdbcTemplate.queryForObject(
                            """
                            select * from cliente
                            where id = ?
                            """,

                            (rs, rowNum) -> Cliente.builder()
                            .id(rs.getInt("id"))
                            .nombre (rs.getString ("nombre"))
                            .apellido1 (rs.getString ("apellido1"))
                            .apellido2 (rs.getString ("apellido2"))
                                    .ciudad (rs.getString ("ciudad"))
                                    .categoria (rs.getInt ("categoria"))
                            .build(),
                    id
            );
            return Optional.ofNullable(cliente);
             } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }


    @Override
    public Optional<Cliente> findAll() {
        return Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {
        int rowsUpdated = jdbcTemplate.update("""
update cliente
set nombre = ?, apellido1 = ?, apellido2 = ?, ciudad = ?, categoria = ?
where id = ?""", cliente.getNombre(),
                cliente.getApellido1(),
                cliente.getApellido2(),
                cliente.getCiudad(),
                cliente.getCategoria(),
                cliente.getId());
    log.debug("filas actualizadas {} registros actualizados", rowsUpdated);
    }

    @Override
    public void delete(int id) {
        int rowsUpdated = jdbcTemplate.update("""
delete from cliente
where id = ?""", id);
        log.debug("filas eliminadas {} registros eliminados", rowsUpdated);
    }
}
