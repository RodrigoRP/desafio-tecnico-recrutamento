package br.com.rodrigoramos.processoseletivo.dto;

import lombok.Data;

@Data
public class PessoaDTO {

    private Long id;
    private String nome;
    private String profissao;
    private char localizacao;
    private Double nivel;

    public PessoaDTO() {
    }

    public PessoaDTO(Long id, String nome, String profissao, char localizacao, Double nivel) {
        this.id = id;
        this.nome = nome;
        this.profissao = profissao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }
}
