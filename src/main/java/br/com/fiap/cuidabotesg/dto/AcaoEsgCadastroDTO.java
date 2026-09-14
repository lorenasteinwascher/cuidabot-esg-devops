package br.com.fiap.cuidabotesg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record AcaoEsgCadastroDTO(

        @NotBlank(message = "O título é obrigatório")
        @Size(max = 100, message = "O título deve ter no máximo 100 caracteres")
        String titulo,

        @NotBlank(message = "A descrição é obrigatória")
        @Size(max = 500, message = "A descrição deve ter no máximo 500 caracteres")
        String descricao,

        @NotBlank(message = "A categoria é obrigatória")
        String categoria,

        @NotBlank(message = "O responsável é obrigatório")
        String responsavel,

        @NotBlank(message = "O status é obrigatório")
        String status,

        @NotNull(message = "A data de início é obrigatória")
        LocalDate dataInicio,

        LocalDate dataFim,

        @NotNull(message = "O ID da empresa é obrigatório")
        Long empresaId

) {
}