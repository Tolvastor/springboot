package org.example.demo_sp_th_2025;

import org.example.demo_sp_th_2025.DAO.ClienteDAO;
import org.example.demo_sp_th_2025.modelo.Cliente;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DemoSpTh2025ApplicationTests {
    @Autowired
    private ClienteDAO clienteDAO;

    @Test
    void contextLoads() {
    }

    @Test
    void testcreate() {
        Cliente cliente = Cliente.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .ciudad("madrid")
                .categoria(1)
                .build();
        System.out.println("antes de crear"+cliente.getId());
        clienteDAO.create(cliente);
        System.out.println("despues de crear"+cliente.getId());

    }
    @Test
    void testupdate() {
        Cliente cliente = Cliente.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .ciudad("madrid")
                .categoria(1)
                .build();

        System.out.println("antes de actualizar"+cliente.getId());
        clienteDAO.create(cliente);
        cliente.setNombre("jose2");
        clienteDAO.update(cliente);
        Optional<Cliente> optionalClienteReal = clienteDAO.find(cliente.getId());
        if (optionalClienteReal.isPresent()) {
            Assertions.assertEquals("jose2", optionalClienteReal.get().getNombre());
        } else{

            Assertions.fail();
        }
    }

    @Test
    void testdeleteAll() {
        Cliente cliente = Cliente.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .ciudad("madrid")
                .categoria(1)
                .build();
    }
}
