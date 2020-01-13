package br.com.rodrigoramos.processoseletivo.controller;

import br.com.rodrigoramos.processoseletivo.dto.VagaDTO;
import br.com.rodrigoramos.processoseletivo.model.Candidatura;
import br.com.rodrigoramos.processoseletivo.model.Vaga;
import br.com.rodrigoramos.processoseletivo.service.CandidaturaService;
import br.com.rodrigoramos.processoseletivo.service.VagaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "v1/vagas")
public class VagaController {
    @Autowired
    private VagaService vagaService;
    @Autowired
    private CandidaturaService candidaturaService;

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody VagaDTO vagaDTO) {
        Vaga vaga = vagaService.save(vagaService.convertDtotoModel(vagaDTO));
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(vaga.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{idVaga}/candidaturas/ranking")
    public ResponseEntity<List<Candidatura>> getRanking(@PathVariable Long idVaga) {
        List<Candidatura> candidaturaList = candidaturaService.findAllByVagaId(idVaga);

        return ResponseEntity.ok().body(candidaturaList);
    }



}
