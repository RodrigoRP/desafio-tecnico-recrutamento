package br.com.rodrigoramos.processoseletivo.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;
    private String nome;
    private String profissao;
    private String localizacao;
    private Integer nivel;



}
