
package br.dev.nvs.fastburguer.repository;

import br.dev.nvs.fastburguer.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
    
}
