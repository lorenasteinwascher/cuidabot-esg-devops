package br.com.fiap.cuidabotesg.service;

import br.com.fiap.cuidabotesg.dto.EmpresaCadastroDTO;
import br.com.fiap.cuidabotesg.dto.EmpresaExibicaoDTO;
import br.com.fiap.cuidabotesg.exception.RecursoNaoEncontradoException;
import br.com.fiap.cuidabotesg.model.Empresa;
import br.com.fiap.cuidabotesg.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpresaService {

    private final EmpresaRepository empresaRepository;

    public EmpresaService(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    public EmpresaExibicaoDTO cadastrar(EmpresaCadastroDTO dto) {
        Empresa empresa = new Empresa();
        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setSetor(dto.setor());

        Empresa empresaSalva = empresaRepository.save(empresa);

        return new EmpresaExibicaoDTO(empresaSalva);
    }

    public List<EmpresaExibicaoDTO> listar() {
        return empresaRepository.findAll()
                .stream()
                .map(EmpresaExibicaoDTO::new)
                .toList();
    }

    public EmpresaExibicaoDTO buscarPorId(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + id));

        return new EmpresaExibicaoDTO(empresa);
    }

    public EmpresaExibicaoDTO atualizar(Long id, EmpresaCadastroDTO dto) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + id));

        empresa.setNome(dto.nome());
        empresa.setCnpj(dto.cnpj());
        empresa.setSetor(dto.setor());

        Empresa empresaAtualizada = empresaRepository.save(empresa);

        return new EmpresaExibicaoDTO(empresaAtualizada);
    }

    public void deletar(Long id) {
        Empresa empresa = empresaRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + id));

        empresaRepository.delete(empresa);
    }
}