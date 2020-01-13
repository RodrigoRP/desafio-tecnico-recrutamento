package br.com.rodrigoramos.processoseletivo.service;

import br.com.rodrigoramos.processoseletivo.dto.CandidaturaDTO;
import br.com.rodrigoramos.processoseletivo.model.Candidatura;
import br.com.rodrigoramos.processoseletivo.model.Pessoa;
import br.com.rodrigoramos.processoseletivo.model.Vaga;
import br.com.rodrigoramos.processoseletivo.repository.CandidaturaRepository;
import br.com.rodrigoramos.processoseletivo.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidaturaService {

    @Autowired
    private CandidaturaRepository candidaturaRepository;

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private VagaService vagaService;


    public Candidatura save(CandidaturaDTO candidaturaDTO) {

        Pessoa pessoa = pessoaService.findById(candidaturaDTO.getIdPessoa());
        Vaga vaga = vagaService.findById(candidaturaDTO.getIdVaga());
        Candidatura candidatura = convertDtotoModel(pessoa, vaga);
        Double score = calcularScoreCandidato(candidatura);
        candidatura.setScore(score);
        return candidaturaRepository.save(candidatura);
    }

    private Candidatura convertDtotoModel(Pessoa pessoa, Vaga vaga) {
        return new Candidatura(null, pessoa, vaga);
    }

    private Double calcularScoreCandidato(Candidatura candidatura) {
        Double n;
        Double score;
        Double d;

        n = 100 - 25 * (candidatura.getVaga().getNivel() - candidatura.getPessoa().getNivel());
        d = calcularDistanciaCandidato(candidatura.getPessoa().getLocalizacao());
        d = calcularPontuacaoCandidato(d);
        return score = (n + d) / 2;
    }

    private Double calcularPontuacaoCandidato(Double d) {
        if (d >= 0 && d < 6) return 100.0;
        if (d > 5 && d < 11) return 75.0;
        if (d > 10 && d < 16) return 50.0;
        if (d > 15 && d < 21) return 25.0;
        return 100.0;

    }

    private Double calcularDistanciaCandidato(char localizacao) {
        if (localizacao == 'A') return 0.0;
        if (localizacao == 'B') return 5.0;
        if (localizacao == 'C') return 12.0;
        if (localizacao == 'D') return 8.0;
        if (localizacao == 'E') return 16.0;
        else return 16.0;
    }

    public List<Candidatura> findAllByVagaId(Long idVaga) {
        List<Candidatura> candidaturaList = candidaturaRepository.findAllByVagaId(idVaga);
        return candidaturaList;
    }
}
