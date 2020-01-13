package br.com.rodrigoramos.processoseletivo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Candidatura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Pessoa pessoa;

    @OneToOne
    private Vaga vaga;

    private Double score;

    public Candidatura(Long id, Pessoa pessoa, Vaga vaga, Double score) {
        this.id = id;
        this.pessoa = pessoa;
        this.vaga = vaga;
        this.score = score;
    }


    public Candidatura(Long id, Pessoa pessoa, Vaga vaga) {
        this.id = id;
        this.pessoa = pessoa;
        this.vaga = vaga;
    }

}
