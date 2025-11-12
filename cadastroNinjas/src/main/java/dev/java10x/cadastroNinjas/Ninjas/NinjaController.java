package dev.java10x.cadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeria mensagem nessa rota";
    }


    // CRUDE
    // Criar novo ninja (CREATE)

    @PostMapping("/criar")
    public String criarNinja(){
        return "Ninja criado";
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
