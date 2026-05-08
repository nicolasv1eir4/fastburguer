package br.dev.nvs.fastburguer.repository;

import br.dev.nvs.fastburguer.domain.model.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
    
    List<Produto> findByNome (String nome);
    List<Produto> findByNomeContaining(String nome);
}
