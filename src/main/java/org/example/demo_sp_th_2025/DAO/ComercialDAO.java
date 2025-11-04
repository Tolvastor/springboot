package org.example.demo_sp_th_2025.DAO;

import org.example.demo_sp_th_2025.modelo.Comercial;
import org.example.demo_sp_th_2025.modelo.Comercial;

import java.util.List;
import java.util.Optional;

public interface ComercialDAO {
    //mapear las operaciones CRUD en la base de datos para la entidad Cliente

    void create(Comercial comercial);

    List<Comercial> getAll();

    Optional<Comercial> find(int id);

    Optional<Comercial> findAll();
        void update(Comercial comercial);
        void delete(int id);
}
