package br.com.rodrigoramos.processoseletivo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vaga {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String empresa;
    private String titulo;
    private String descricao;
    private String localizacao;
    private Double nivel;


    public Vaga() {
    }

    public Vaga(Long id, String empresa, String titulo, String descricao, String localizacao, Double nivel) {
        this.id = id;
        this.empresa = empresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }


}
