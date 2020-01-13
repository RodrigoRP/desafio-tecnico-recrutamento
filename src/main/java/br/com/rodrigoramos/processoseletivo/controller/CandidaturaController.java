package br.com.rodrigoramos.processoseletivo.controller;

import br.com.rodrigoramos.processoseletivo.dto.CandidaturaDTO;
import br.com.rodrigoramos.processoseletivo.model.Candidatura;
import br.com.rodrigoramos.processoseletivo.service.CandidaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping(value = "v1/candidaturas")
public class CandidaturaController {

    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CandidaturaDTO candidaturaDTO) {
        Candidatura candidatura = candidaturaService.save(candidaturaDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(candidatura.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
