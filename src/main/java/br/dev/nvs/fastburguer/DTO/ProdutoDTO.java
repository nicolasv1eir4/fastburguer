
package br.dev.nvs.fastburguer.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;


public class ProdutoDTO {
    @NotBlank
    public String nome;

    @NotBlank
    public String categoria;

    @Positive
    public double preco;
}