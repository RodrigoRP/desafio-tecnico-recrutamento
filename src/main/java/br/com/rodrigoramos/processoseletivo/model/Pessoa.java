package br.com.rodrigoramos.processoseletivo.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String profissao;
    private char localizacao;
    private Double nivel;

    private Double score;

    public Pessoa() {
    }


    public Pessoa(Long id, String nome, String profissao, char localizacao, Double nivel) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }
}
