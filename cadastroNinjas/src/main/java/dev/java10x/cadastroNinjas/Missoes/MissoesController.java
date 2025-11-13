package dev.java10x.cadastroNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("missoes")
public class MissoesController {

    //CRUDE

    // Adicionar Missoes (CREATE)
    @PutMapping("/adicionar")
    public String AdicionarMissao(){
        return "Missao adicionada";
    }

    // Ver todas as Missoes (READ)
    @GetMapping("/mostrar")
    public String VerTodasMissoes(){
        return "Todas Missoes exibidas";
    }

    // Buscar Missoes por ID
    @GetMapping("/mostrarID")
    public String VerMissoesID(){
        return "Missao por ID";
    }

    // Alterar missoes (UPDATE)
    @PutMapping("/alterar")
    public String AlterarMissao(){
        return "Missao alterada";
    }

    // Deletar Missoes(DELETE)
    @DeleteMapping("/deletar")
    public String DeletarMissao(){
        return "Missao deletada";
    }

}
