package br.com.rodrigoramos.processoseletivo.service;

import br.com.rodrigoramos.processoseletivo.dto.PessoaDTO;
import br.com.rodrigoramos.processoseletivo.model.Pessoa;
import br.com.rodrigoramos.processoseletivo.repository.PessoaRepository;
import br.com.rodrigoramos.processoseletivo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Pessoa save(Pessoa pessoa) {
        return pessoaRepository.save(pessoa);
    }


    public Pessoa convertDtoToModel(PessoaDTO objDto) {
        return new Pessoa(objDto.getId(), objDto.getNome(), objDto.getProfissao(), objDto.getLocalizacao(), objDto.getNivel());
    }

    public Pessoa findById(Long idPessoa) {
        Optional<Pessoa> obj = pessoaRepository.findById(idPessoa);
        return obj.orElseThrow(() -> new ObjectNotFoundException(
                "Objeto não encontrado! Id: " + idPessoa + ", Tipo: " + Pessoa.class.getName()));
    }
}
