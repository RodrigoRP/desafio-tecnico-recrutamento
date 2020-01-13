package br.com.rodrigoramos.processoseletivo.dto;

import lombok.Data;

@Data
public class VagaDTO {

    private Long id;
    private String empresa;
    private String titulo;
    private String descricao;
    private String localizacao;
    private Double nivel;

    public VagaDTO() {
    }

    public VagaDTO(Long id, String empresa, String titulo, String descricao, String localizacao, Double nivel) {
        this.id = id;
        this.empresa = empresa;
        this.titulo = titulo;
        this.descricao = descricao;
        this.localizacao = localizacao;
        this.nivel = nivel;
    }
}
