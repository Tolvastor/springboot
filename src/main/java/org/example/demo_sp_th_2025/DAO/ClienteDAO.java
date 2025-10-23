package org.example.demo_sp_th_2025.DAO;

import org.example.demo_sp_th_2025.modelo.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteDAO {
    //mapear las operaciones CRUD en la base de datos para la entidad Cliente
        void create(Cliente cliente);
        List<Cliente> getAll();
        Optional<Cliente> findAll();
        void update(Cliente cliente);
        void delete(int id);
}
