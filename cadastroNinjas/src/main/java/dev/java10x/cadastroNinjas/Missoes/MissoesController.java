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
    public MissoesDTO adicionarMissao(@RequestBody MissoesDTO missao){
        return missoesService.adicionarMissao(missao);
    }

    // Ver todas as Missoes (READ)
    @GetMapping("/mostrar")
    public List<MissoesDTO> exibirMissoes(){
        return missoesService.VerTodasMissoes();
    }

    // Buscar Missoes por ID
    @GetMapping("/mostrar/{id}")
    public MissoesDTO exibirMissaoID(@PathVariable Long id){
        return missoesService.missoesID(id);
    }

    // Alterar missoes (UPDATE)
    @PutMapping("/alterar")
    public MissoesDTO AlterarMissao(Long id, MissoesDTO missoesDTO){
        return missoesService.alterarMissao(id,missoesDTO);
    }

    // Deletar Missoes(DELETE)
    @DeleteMapping("/deletar/{id}")
    public void deletarMissoes(@PathVariable Long id){
        missoesService.deletarMissoes(id);
    }

}
