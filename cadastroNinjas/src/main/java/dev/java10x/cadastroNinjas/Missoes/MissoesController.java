package dev.java10x.cadastroNinjas.Missoes;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
public class MissoesController {

    //injeçao de dependencia
    MissoesService missoesService;

    public MissoesController(MissoesService missoesService) {
        this.missoesService = missoesService;
    }

    //CRUDE
    // Adicionar Missoes (CREATE)
    @PostMapping("/adicionar")
    public MissoesModel adicionarMissao(@RequestBody MissoesModel missao){
        return missoesService.adicionarMissao(missao);
    }

    // Ver todas as Missoes (READ)
    @GetMapping("/mostrar")
    public List<MissoesModel> exibirMissoes(){
        return missoesService.VerTodasMissoes();
    }

    // Buscar Missoes por ID
    @GetMapping("/mostrar/{id}")
    public MissoesModel exibirMissaoID(@PathVariable Long id){
        return missoesService.missoesID(id);
    }

    // Alterar missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public MissoesModel AlterarMissao(@PathVariable Long id, @RequestBody MissoesModel missaoAlterada){
        return missoesService.AlterarMissao(id, missaoAlterada);
    }

    // Deletar Missoes(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoes(@PathVariable Long id){
        missoesService.deletarMissoes(id);
    }

}
