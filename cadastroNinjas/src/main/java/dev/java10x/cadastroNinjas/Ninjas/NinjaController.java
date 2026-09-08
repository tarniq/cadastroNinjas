package dev.java10x.cadastroNinjas.Ninjas;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping("/adicionar")
    public ResponseEntity<String> criarNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO ninjaCriado = ninjaService.adicionarNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Criado: " + ninjaCriado.getNome() + "ID: " + ninjaCriado.getId());
    }

    // Mostrar todos os ninjas (READ)

    @GetMapping("/mostrar")
    public ResponseEntity<List<NinjaDTO>> listarNinjas(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjaService.listarNinjas());

    }

    // Mostrar Ninja por ID (READ)

    @GetMapping("/mostrar/{id}")
    public ResponseEntity<?> listarNinjasID(@PathVariable Long id){
        NinjaDTO ninjaID = ninjaService.listarNinjaID(id);
        if (ninjaID == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id +" não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(ninjaID);
    }


    // Alterar dados do Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarNinja(@PathVariable Long id, @RequestBody NinjaDTO ninjaModelAtt){
        NinjaDTO ninjaAlterado = ninjaService.alterarNinja(id, ninjaModelAtt);
        if (ninjaAlterado == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id +" não encontrado");

        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja Alterado: " + ninjaAlterado.getNome());
    }

    // Deletar Ninjas (DELETE)

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarNinja(@PathVariable Long id){
        if (ninjaService.deletarNinja(id) == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja de id: " + id +" não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body("Ninja deletado: " + id);

    }

}
