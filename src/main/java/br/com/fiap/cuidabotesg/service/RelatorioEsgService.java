package br.com.fiap.cuidabotesg.service;

import br.com.fiap.cuidabotesg.dto.RelatorioEsgCadastroDTO;
import br.com.fiap.cuidabotesg.dto.RelatorioEsgExibicaoDTO;
import br.com.fiap.cuidabotesg.exception.RecursoNaoEncontradoException;
import br.com.fiap.cuidabotesg.model.Empresa;
import br.com.fiap.cuidabotesg.model.RelatorioEsg;
import br.com.fiap.cuidabotesg.repository.EmpresaRepository;
import br.com.fiap.cuidabotesg.repository.RelatorioEsgRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RelatorioEsgService {

    private final RelatorioEsgRepository relatorioEsgRepository;
    private final EmpresaRepository empresaRepository;

    public RelatorioEsgService(RelatorioEsgRepository relatorioEsgRepository, EmpresaRepository empresaRepository) {
        this.relatorioEsgRepository = relatorioEsgRepository;
        this.empresaRepository = empresaRepository;
    }

    public RelatorioEsgExibicaoDTO cadastrar(RelatorioEsgCadastroDTO dto) {
        Empresa empresa = empresaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + dto.empresaId()));

        RelatorioEsg relatorio = new RelatorioEsg();
        relatorio.setDescricao(dto.descricao());
        relatorio.setIndicador(dto.indicador());
        relatorio.setResultado(dto.resultado());
        relatorio.setDataRelatorio(dto.dataRelatorio());
        relatorio.setEmpresa(empresa);

        RelatorioEsg relatorioSalvo = relatorioEsgRepository.save(relatorio);

        return new RelatorioEsgExibicaoDTO(relatorioSalvo);
    }

    public List<RelatorioEsgExibicaoDTO> listar() {
        return relatorioEsgRepository.findAll()
                .stream()
                .map(RelatorioEsgExibicaoDTO::new)
                .toList();
    }

    public RelatorioEsgExibicaoDTO buscarPorId(Long id) {
        RelatorioEsg relatorio = relatorioEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Relatório ESG não encontrado com o ID: " + id));

        return new RelatorioEsgExibicaoDTO(relatorio);
    }

    public List<RelatorioEsgExibicaoDTO> buscarPorEmpresa(Long empresaId) {
        empresaRepository.findById(empresaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + empresaId));

        return relatorioEsgRepository.findByEmpresaId(empresaId)
                .stream()
                .map(RelatorioEsgExibicaoDTO::new)
                .toList();
    }

    public RelatorioEsgExibicaoDTO atualizar(Long id, RelatorioEsgCadastroDTO dto) {
        RelatorioEsg relatorio = relatorioEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Relatório ESG não encontrado com o ID: " + id));

        Empresa empresa = empresaRepository.findById(dto.empresaId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Empresa não encontrada com o ID: " + dto.empresaId()));

        relatorio.setDescricao(dto.descricao());
        relatorio.setIndicador(dto.indicador());
        relatorio.setResultado(dto.resultado());
        relatorio.setDataRelatorio(dto.dataRelatorio());
        relatorio.setEmpresa(empresa);

        RelatorioEsg relatorioAtualizado = relatorioEsgRepository.save(relatorio);

        return new RelatorioEsgExibicaoDTO(relatorioAtualizado);
    }

    public void deletar(Long id) {
        RelatorioEsg relatorio = relatorioEsgRepository.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Relatório ESG não encontrado com o ID: " + id));

        relatorioEsgRepository.delete(relatorio);
    }
}