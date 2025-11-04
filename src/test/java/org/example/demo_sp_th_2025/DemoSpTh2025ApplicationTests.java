package org.example.demo_sp_th_2025;

import org.example.demo_sp_th_2025.DAO.ClienteDAO;
import org.example.demo_sp_th_2025.DAO.ComercialDAO;
import org.example.demo_sp_th_2025.modelo.Cliente;
import org.example.demo_sp_th_2025.modelo.Comercial;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Optional;

@SpringBootTest
class DemoSpTh2025ApplicationTests {
    @Autowired
    private ClienteDAO clienteDAO;
    @Autowired
    private ComercialDAO ComercialDAO;

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
        System.out.println("antes de crear" + cliente.getId());
        clienteDAO.create(cliente);
        System.out.println("despues de crear" + cliente.getId());

    }

    @Test
    void testupdate() {
        Cliente cliente = Cliente.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .ciudad("madrid")
                .categoria(1)
                .build();

        System.out.println("antes de actualizar" + cliente.getId());
        clienteDAO.create(cliente);
        cliente.setNombre("jose2");
        clienteDAO.update(cliente);
        Optional<Cliente> optionalClienteReal = clienteDAO.find(cliente.getId());
        if (optionalClienteReal.isPresent()) {
            Assertions.assertEquals("jose2", optionalClienteReal.get().getNombre());
        } else {

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





//Comercial tests



    @Test
    void testcreateComercial() {
        Comercial comercial = Comercial.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .comision(new BigDecimal("0.10"))
                .build();
        System.out.println("antes de crear" + comercial.getId());
        ComercialDAO.create(comercial);
        System.out.println("despues de crear" + comercial.getId());

    }

    @Test
    void testupdateComercial() {
        Comercial comercial = Comercial.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .comision(new BigDecimal("0.10"))
                .build();

        System.out.println("antes de actualizar" + comercial.getId());
        ComercialDAO.create(comercial);
        comercial.setNombre("jose2");
        ComercialDAO.update(comercial);
        Optional<Cliente> optionalClienteReal = clienteDAO.find(comercial.getId());
        if (optionalClienteReal.isPresent()) {
            Assertions.assertEquals("jose2", optionalClienteReal.get().getNombre());
        } else {

            Assertions.fail();
        }
    }

    @Test
    void testdeleteAllComercial() {
        Comercial comercial = Comercial.builder().nombre("jose")
                .apellido1("perez")
                .apellido2("lopez")
                .comision(new BigDecimal("0.10"))
                .build();
    }
}