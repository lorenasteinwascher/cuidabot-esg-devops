package br.com.fiap.cuidabotesg.dto;

import br.com.fiap.cuidabotesg.model.RelatorioEsg;

import java.time.LocalDate;

public record RelatorioEsgExibicaoDTO(
        Long id,
        String descricao,
        String indicador,
        String resultado,
        LocalDate dataRelatorio,
        Long empresaId,
        String nomeEmpresa
) {

    public RelatorioEsgExibicaoDTO(RelatorioEsg relatorioEsg) {
        this(
                relatorioEsg.getId(),
                relatorioEsg.getDescricao(),
                relatorioEsg.getIndicador(),
                relatorioEsg.getResultado(),
                relatorioEsg.getDataRelatorio(),
                relatorioEsg.getEmpresa().getId(),
                relatorioEsg.getEmpresa().getNome()
        );
    }
}