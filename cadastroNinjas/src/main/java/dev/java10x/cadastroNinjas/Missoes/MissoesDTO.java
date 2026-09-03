package dev.java10x.cadastroNinjas.Missoes;

import dev.java10x.cadastroNinjas.Ninjas.NinjaDTO;
import dev.java10x.cadastroNinjas.Ninjas.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MissoesDTO {
    private Long ID;
    private String nome;
    private double credito;
    private Rank rank;
    private List<NinjaDTO> ninjas;

}
