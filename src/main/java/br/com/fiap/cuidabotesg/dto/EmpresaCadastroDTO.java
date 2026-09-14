package br.com.fiap.cuidabotesg.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record EmpresaCadastroDTO(

        @NotBlank(message = "O nome da empresa é obrigatório")
        @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
        String nome,

        @NotBlank(message = "O CNPJ é obrigatório")
        @Size(min = 14, max = 14, message = "O CNPJ deve ter 14 caracteres")
        String cnpj,

        @NotBlank(message = "O setor é obrigatório")
        @Size(max = 80, message = "O setor deve ter no máximo 80 caracteres")
        String setor

) {
}