package br.com.fiap.cuidabotesg.controller;

import br.com.fiap.cuidabotesg.dto.RelatorioEsgCadastroDTO;
import br.com.fiap.cuidabotesg.dto.RelatorioEsgExibicaoDTO;
import br.com.fiap.cuidabotesg.service.RelatorioEsgService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/relatorios")
public class RelatorioEsgController {

    private final RelatorioEsgService relatorioEsgService;

    public RelatorioEsgController(RelatorioEsgService relatorioEsgService) {
        this.relatorioEsgService = relatorioEsgService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RelatorioEsgExibicaoDTO cadastrar(@RequestBody @Valid RelatorioEsgCadastroDTO dto) {
        return relatorioEsgService.cadastrar(dto);
    }

    @GetMapping
    public List<RelatorioEsgExibicaoDTO> listar() {
        return relatorioEsgService.listar();
    }

    @GetMapping("/{id}")
    public RelatorioEsgExibicaoDTO buscarPorId(@PathVariable Long id) {
        return relatorioEsgService.buscarPorId(id);
    }

    @GetMapping("/empresa/{empresaId}")
    public List<RelatorioEsgExibicaoDTO> buscarPorEmpresa(@PathVariable Long empresaId) {
        return relatorioEsgService.buscarPorEmpresa(empresaId);
    }

    @PutMapping("/{id}")
    public RelatorioEsgExibicaoDTO atualizar(@PathVariable Long id, @RequestBody @Valid RelatorioEsgCadastroDTO dto) {
        return relatorioEsgService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        relatorioEsgService.deletar(id);
    }
}