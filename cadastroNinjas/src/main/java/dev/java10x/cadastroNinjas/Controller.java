package dev.java10x.cadastroNinjas;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/boasvindas")
    public String boasVindas(){
        return "Essa é minha primeria mensagem nessa rota";
    }
}
