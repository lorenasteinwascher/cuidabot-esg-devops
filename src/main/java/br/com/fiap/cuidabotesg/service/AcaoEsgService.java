package br.com.fiap.cuidabotesg.service;

import br.com.fiap.cuidabotesg.dto.AcaoEsgCadastroDTO;
import br.com.fiap.cuidabotesg.dto.AcaoEsgExibicaoDTO;
import br.com.fiap.cuidabotesg.exception.RecursoNaoEncontradoException;
import br.com.fiap.cuidabotesg.model.AcaoEsg;
import br.com.fiap.cuidabotesg.model.Empresa;
import br.com.fiap.cuidabotesg.repository.AcaoEsgRepository;
import br.com.fiap.cuidabotesg.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AcaoEsgService {

    private final AcaoEsgRepository acaoEsgRepository;
    private final EmpresaRepository empresaRepository;

    public AcaoEsgService(AcaoEsgRepository acaoEsgRepository, EmpresaRepository empresaRepository) {
        this.acaoEsgRepository = acaoEsgRepository;
        this.empresaRepository = empresaRepository;
    }

    public AcaoEsgExibicaoDTO cadastrar(AcaoEsgCadastroDTO dto) {
        Empresa empresa = empresaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + dto.empresaId()));

        AcaoEsg acaoEsg = new AcaoEsg();
        acaoEsg.setTitulo(dto.titulo());
        acaoEsg.setDescricao(dto.descricao());
        acaoEsg.setCategoria(dto.categoria());
        acaoEsg.setResponsavel(dto.responsavel());
        acaoEsg.setStatus(dto.status());
        acaoEsg.setDataInicio(dto.dataInicio());
        acaoEsg.setDataFim(dto.dataFim());
        acaoEsg.setEmpresa(empresa);

        AcaoEsg acaoSalva = acaoEsgRepository.save(acaoEsg);

        return new AcaoEsgExibicaoDTO(acaoSalva);
    }

    public List<AcaoEsgExibicaoDTO> listar() {
        return acaoEsgRepository.findAll()
                .stream()
                .map(AcaoEsgExibicaoDTO::new)
                .toList();
    }

    public AcaoEsgExibicaoDTO buscarPorId(Long id) {
        AcaoEsg acaoEsg = acaoEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação ESG não encontrada com o ID: " + id));

        return new AcaoEsgExibicaoDTO(acaoEsg);
    }

    public AcaoEsgExibicaoDTO atualizar(Long id, AcaoEsgCadastroDTO dto) {
        AcaoEsg acaoEsg = acaoEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação ESG não encontrada com o ID: " + id));

        Empresa empresa = empresaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + dto.empresaId()));

        acaoEsg.setTitulo(dto.titulo());
        acaoEsg.setDescricao(dto.descricao());
        acaoEsg.setCategoria(dto.categoria());
        acaoEsg.setResponsavel(dto.responsavel());
        acaoEsg.setStatus(dto.status());
        acaoEsg.setDataInicio(dto.dataInicio());
        acaoEsg.setDataFim(dto.dataFim());
        acaoEsg.setEmpresa(empresa);

        AcaoEsg acaoAtualizada = acaoEsgRepository.save(acaoEsg);

        return new AcaoEsgExibicaoDTO(acaoAtualizada);
    }

    public void deletar(Long id) {
        AcaoEsg acaoEsg = acaoEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ação ESG não encontrada com o ID: " + id));

        acaoEsgRepository.delete(acaoEsg);
    }
}