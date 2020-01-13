package br.com.rodrigoramos.processoseletivo.service;

import br.com.rodrigoramos.processoseletivo.dto.VagaDTO;
import br.com.rodrigoramos.processoseletivo.model.Pessoa;
import br.com.rodrigoramos.processoseletivo.model.Vaga;
import br.com.rodrigoramos.processoseletivo.repository.VagaRepository;
import br.com.rodrigoramos.processoseletivo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VagaService {

    @Autowired
    private VagaRepository vagaRepository;

    public Vaga convertDtotoModel(VagaDTO vagaDTO) {
        return new Vaga(null, vagaDTO.getEmpresa(), vagaDTO.getTitulo(), vagaDTO.getDescricao(), vagaDTO.getLocalizacao(), vagaDTO.getNivel());
    }

    public Vaga save(Vaga vaga) {
        return vagaRepository.save(vaga);
    }

    public Vaga findById(Long idVaga) {
        Optional<Vaga> obj = vagaRepository.findById(idVaga);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + idVaga + ", Tipo: " + Pessoa.class.getName()));
    }
}
