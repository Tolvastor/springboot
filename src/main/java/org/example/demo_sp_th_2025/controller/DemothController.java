package org.example.demo_sp_th_2025.controller;

import jakarta.servlet.http.HttpSession;
import org.example.demo_sp_th_2025.modelo.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DemothController {
//sin service, solo actuar sobre plantillas html

    //endpoints
    @GetMapping("demoth1")
    public String demoth1(Model model){
        model.addAttribute("parrafo2", "en un lugar de la mancha de cuyo nombre");
        return "demoth1";
    }

    @GetMapping("demoth2")
    public String demothThBlock(Model model){
       Cliente cliente = Cliente.builder()
               .nombre("Don miguel de Cervantes")
               .build();
       Cliente cliente2 = Cliente.builder()
               .nombre("Lope de Vega")
               .build();
       List<Cliente> list= List.of(cliente,cliente2);
       model.addAttribute("escritores",list);
        return "plantilla2";
    }
    @GetMapping("demoth3")
    public String demothThSession(Model model, HttpSession session){

        String mensajeSession = "Lo grabe en demoth3";
        String mensajeModel = "Esto solo lo ve la plantilla demoth3";
        //atributos en model solo visibles en esta plantilla
        model.addAttribute("msgModel", mensajeModel);
        //atributos en sesion son visible en toddos las plantilllas
        session.setAttribute("msgSession", mensajeSession);
        return "plantilla3";
    }

    @GetMapping("demoth3_2")
    public String demothThSession2(Model model, HttpSession session){

        return "plantilla3";
    }

    @GetMapping ("demoth5")
    public String demoth5(Model model){
        Cliente cliente = Cliente.builder()
                .id(181)
                .nombre("Francisco de Quevedo")
                .build();
        model.addAttribute("cliente", cliente);
        return "plantilla5";
    }

}
