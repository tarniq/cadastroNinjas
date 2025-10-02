package dev.java10x.cadastroNinjas.Ninjas;


import dev.java10x.cadastroNinjas.Missoes.MissoesModel;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


// Transforma uma classe em uma entidade de um banco de dados
@Entity
@Table(name= "tb_cadastro")
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

    public NinjaModel() {
    }

    public NinjaModel(String nome, int idade, String email, MissoesModel missoes) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.missoes = missoes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public MissoesModel getMissoes() {
        return missoes;
    }

    public void setMissoes(MissoesModel missoes) {
        this.missoes = missoes;
    }
}
