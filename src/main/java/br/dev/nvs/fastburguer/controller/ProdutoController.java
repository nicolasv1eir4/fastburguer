package br.dev.nvs.fastburguer.controller;

import br.dev.nvs.fastburguer.DTO.ProdutoDTO;
import br.dev.nvs.fastburguer.domain.model.Categoria;
import br.dev.nvs.fastburguer.domain.model.Produto;
import br.dev.nvs.fastburguer.repository.ProdutoRepository;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProdutoController {

   @Autowired
    private ProdutoRepository repository;

    @GetMapping
    public List<Produto> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Produto criar(@Valid @RequestBody ProdutoDTO dto) {
        Produto p = new Produto();
        p.setNome(dto.nome);
        p.setCategoria(Categoria.valueOf(dto.categoria.toUpperCase()));
        p.setPreco(dto.preco);
        return repository.save(p);
    }
}