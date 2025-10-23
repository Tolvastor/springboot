package org.example.demo_sp_th_2025.DAO;

import lombok.extern.slf4j.Slf4j;
import org.example.demo_sp_th_2025.modelo.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Slf4j
//Un Repository es un componente y a su vez un estereotipo de Spring
//que forma parte de la 'capa de persistencia'.
@Repository
public class ClienteDAOImpl implements ClienteDAO {

    @Override
    public void create(Cliente cliente) {

    }

    @Override
    public List<Cliente> getAll() {
        return List.of();
    }

    @Override
    public Optional<Cliente> findAll() {
        return Optional.empty();
    }

    @Override
    public void update(Cliente cliente) {

    }

    @Override
    public void delete(int id) {

    }
}
