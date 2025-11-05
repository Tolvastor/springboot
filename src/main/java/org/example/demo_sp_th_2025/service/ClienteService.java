package org.example.demo_sp_th_2025.service;

import lombok.AllArgsConstructor;
import org.example.demo_sp_th_2025.DAO.ClienteDAO;
import org.example.demo_sp_th_2025.modelo.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ClienteService {
   // implementar la logica de negocio
    private ClienteDAO clienteDAO;

    // alt+insert y seleciono constructor -> atributos
    // inyeccion de dependencias con constructor de clienteDAO
    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public List<Cliente> all(){
        return clienteDAO.getAll();
    }
}
