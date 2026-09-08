package dev.java10x.cadastroNinjas.Missoes;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> adicionarMissao(@RequestBody MissoesDTO missao){
        MissoesDTO missaoAdicionada =  missoesService.adicionarMissao(missao);
        return ResponseEntity.ok("Missão: " + missaoAdicionada.getNome() + " adicionada com sucesso");
    }

    // Ver todas as Missoes (READ)
    @GetMapping("/mostrar")
    public ResponseEntity<List<MissoesDTO>> exibirMissoes(){
        List<MissoesDTO> missao = missoesService.VerTodasMissoes();
        return ResponseEntity.ok(missao);
    }

    // Buscar Missoes por ID
    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> exibirMissaoID(@PathVariable Long id){
        MissoesDTO missao = missoesService.missoesID(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id: " + id + " não encontrada");
        }
        return ResponseEntity.ok(missao);
    }

    // Alterar missoes (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> AlterarMissao(@PathVariable Long id, @RequestBody MissoesDTO missoesDTO){
        MissoesDTO missao = missoesService.alterarMissao(id, missoesDTO);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id: " + id + " não encontrada");
        }
        return ResponseEntity.ok("Missão alterada com sucesso");

    }

    // Deletar Missoes(DELETE)
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarMissoes(@PathVariable Long id){
        Long missao = missoesService.deletarMissoes(id);
        if (missao == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Missão de id: " + id + " não encontrada");
        }
        return ResponseEntity.ok("Ninja deletado com sucesso");

    }

}
