package dev.java10x.cadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    // CRUDE
    // Criar novo ninja (CREATE)

    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja adicionado";
    }

    // Mostrar todos os ninjas (READ)

    @GetMapping("/mostrar")
    public String MostrarTodosNinjas(){
        return "Ninja exibido";
    }
    // Mostrar Ninja por ID (READ)

    @GetMapping("/mostrarID")
    public String MostrarTodosNinjasId(){
        return "Mostrar Ninja por ID";
    }


    // Alterar dados do Ninjas (UPDATE)
    @PutMapping("/alterar")
    public String AlterarNinja(){
        return "Ninja alterado";
    }

    // Deletar Ninjas (DELETE)

    @DeleteMapping("/deletar")
    public String DeletarNinja(){
        return "Ninja Deletado";
    }

}
