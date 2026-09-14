package br.com.fiap.cuidabotesg.controller;

import br.com.fiap.cuidabotesg.dto.EmpresaCadastroDTO;
import br.com.fiap.cuidabotesg.dto.EmpresaExibicaoDTO;
import br.com.fiap.cuidabotesg.service.EmpresaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaService empresaService;

    public EmpresaController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaExibicaoDTO cadastrar(@RequestBody @Valid EmpresaCadastroDTO dto) {
        return empresaService.cadastrar(dto);
    }

    @GetMapping
    public List<EmpresaExibicaoDTO> listar() {
        return empresaService.listar();
    }

    @GetMapping("/{id}")
    public EmpresaExibicaoDTO buscarPorId(@PathVariable Long id) {
        return empresaService.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public EmpresaExibicaoDTO atualizar(@PathVariable Long id, @RequestBody @Valid EmpresaCadastroDTO dto) {
        return empresaService.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        empresaService.deletar(id);
    }
}