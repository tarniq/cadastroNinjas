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
    // /alterar

    // CRUDE
    // Criar novo ninja (CREATE)

    @PostMapping("/adicionar")
    public NinjaModel criarNinja(@RequestBody NinjaModel ninja){
        return ninjaService.adicionarNinja(ninja);
    }

    // Mostrar todos os ninjas (READ)

    @GetMapping("/mostrar")
    public List<NinjaModel> listarNinjas(){
       return ninjaService.listarNinjas();
    }

    // Mostrar Ninja por ID (READ)

    @GetMapping("/mostrar/{id}")
    public NinjaModel listarNinjasID(@PathVariable Long id){
        return ninjaService.listarNinjaID(id);
    }


    // Alterar dados do Ninjas (UPDATE)
    @PutMapping("/alterar/{id}")
    public NinjaModel alterarNinja(@PathVariable Long id, @RequestBody NinjaModel ninjaModelAtt){
        return ninjaService.alterarNinja( id, ninjaModelAtt);
    }

    // Deletar Ninjas (DELETE)

    @DeleteMapping("/deletar/{id}")
    public void deletarNinja(@PathVariable Long id){
        ninjaService.deletarNinja(id);
    }

}
