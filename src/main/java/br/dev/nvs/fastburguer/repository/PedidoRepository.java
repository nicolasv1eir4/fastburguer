
package br.dev.nvs.fastburguer.repository;

import br.dev.nvs.fastburguer.domain.model.Pedido;
import br.dev.nvs.fastburguer.domain.model.StatusPedido;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
    public List<Pedido> findByStatus(StatusPedido status);
    
    Optional<Pedido> findTopByOrderByNumeroDesc();
    
}