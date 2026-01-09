package dev.java10x.cadastroNinjas.Ninjas;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninja")
public class NinjaController {

    //Injeçao de dependencia
    NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    //TODO: Adicionar metodos na camada service:
    // /adicionar
    // /mostar -X
    // /mostrar por id
    // /alterar
    // /deletar

    // CRUDE
    // Criar novo ninja (CREATE)

    @PostMapping("/adicionar")
    public String criarNinja(){
        return "Ninja adicionado";
    }

    // Mostrar todos os ninjas (READ)

    @GetMapping("/mostrar")
    public List<NinjaModel> listarNinjas(){
       return ninjaService.listarNinjas();
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
