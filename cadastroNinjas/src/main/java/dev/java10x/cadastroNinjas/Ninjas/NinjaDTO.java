package dev.java10x.cadastroNinjas.Ninjas;

import dev.java10x.cadastroNinjas.Missoes.MissoesModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NinjaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String email;
    private String vila;
    private MissoesModel missoes;

}
