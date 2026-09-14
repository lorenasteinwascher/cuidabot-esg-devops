package br.com.fiap.cuidabotesg.dto;

import br.com.fiap.cuidabotesg.model.AcaoEsg;

import java.time.LocalDate;

public record AcaoEsgExibicaoDTO(
        Long id,
        String titulo,
        String descricao,
        String categoria,
        String responsavel,
        String status,
        LocalDate dataInicio,
        LocalDate dataFim,
        Long empresaId,
        String nomeEmpresa
) {

    public AcaoEsgExibicaoDTO(AcaoEsg acaoEsg) {
        this(
                acaoEsg.getId(),
                acaoEsg.getTitulo(),
                acaoEsg.getDescricao(),
                acaoEsg.getCategoria(),
                acaoEsg.getResponsavel(),
                acaoEsg.getStatus(),
                acaoEsg.getDataInicio(),
                acaoEsg.getDataFim(),
                acaoEsg.getEmpresa().getId(),
                acaoEsg.getEmpresa().getNome()
        );
    }
}