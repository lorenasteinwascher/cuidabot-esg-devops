package br.com.fiap.cuidabotesg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record RelatorioEsgCadastroDTO(

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotBlank(message = "O indicador é obrigatório")
        @Size(max = 100, message = "O indicador deve ter no máximo 100 caracteres")
        String indicador,

        @NotBlank(message = "O resultado é obrigatório")
        @Size(max = 300, message = "O resultado deve ter no máximo 300 caracteres")
        String resultado,

        @NotNull(message = "A data do relatório é obrigatória")
        LocalDate dataRelatorio,

        @NotNull(message = "O ID da empresa é obrigatório")
        Long empresaId

) {
}