package dev.java10x.cadastroNinjas.Ninjas;


import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(unique = true)
    private String email;
    private String vila;

    // Um ninja tem uma unica missao
    @ManyToOne
    @JoinColumn(name = "missoes_ID") //chave estrangeira - foreing key
    @JsonIgnore
    private MissoesModel missoes;


    /*public NinjaModel(Long id, String nome, int idade, String email, String vila) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.vila = vila;
    }*/
}
