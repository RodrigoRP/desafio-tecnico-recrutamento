package br.com.rodrigoramos.processoseletivo.dto;

import lombok.Data;

@Data
public class CandidaturaDTO {

    private Long idVaga;
    private Long idPessoa;


    public CandidaturaDTO(Long idVaga, Long idPessoa) {
        this.idVaga = idVaga;
        this.idPessoa = idPessoa;
    }
}
