package dev.java10x.cadastroNinjas.Ninjas;


import dev.java10x.cadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


// Transforma uma classe em uma entidade de um banco de dados
@Entity
@Table(name= "tb_cadastro")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class NinjaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int idade;
    private String email;

    // Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_ID") //chave estrangeira - foreing key
    private MissoesModel missoes;

}
