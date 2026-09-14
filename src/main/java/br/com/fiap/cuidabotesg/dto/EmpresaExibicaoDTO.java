package br.com.fiap.cuidabotesg.dto;

import br.com.fiap.cuidabotesg.model.Empresa;

public record EmpresaExibicaoDTO(
        Long id,
        String nome,
        String cnpj,
        String setor
) {

    public EmpresaExibicaoDTO(Empresa empresa) {
        this(
                empresa.getId(),
                empresa.getNome(),
                empresa.getCnpj(),
                empresa.getSetor()
        );
    }
}