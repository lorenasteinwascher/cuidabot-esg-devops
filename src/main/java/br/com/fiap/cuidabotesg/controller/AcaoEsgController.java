package br.com.fiap.cuidabotesg.controller;

import br.com.fiap.cuidabotesg.dto.AcaoEsgCadastroDTO;
import br.com.fiap.cuidabotesg.dto.AcaoEsgExibicaoDTO;
import br.com.fiap.cuidabotesg.service.AcaoEsgService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/acoes-esg")
public class AcaoEsgController {

    private final AcaoEsgService acaoEsgService;

    public AcaoEsgController(AcaoEsgService acaoEsgService) {
        this.acaoEsgService = acaoEsgService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AcaoEsgExibicaoDTO cadastrar(@RequestBody @Valid AcaoEsgCadastroDTO dto) {
        return acaoEsgService.cadastrar(dto);
    }

    @GetMapping
    public List<AcaoEsgExibicaoDTO> listar() {
        return acaoEsgService.listar();
    }

    @GetMapping("/{id}")
    public AcaoEsgExibicaoDTO buscarPorId(@PathVariable Long id) {
        return acaoEsgService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public AcaoEsgExibicaoDTO atualizar(@PathVariable Long id, @RequestBody @Valid AcaoEsgCadastroDTO dto) {
        return acaoEsgService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        acaoEsgService.deletar(id);
    }
}