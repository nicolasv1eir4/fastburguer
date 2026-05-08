
package br.dev.nvs.fastburguer.sevice;

import br.dev.nvs.fastburguer.domain.model.Cliente;
import br.dev.nvs.fastburguer.repository.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ClienteService {
    
      @Autowired
    private ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        return repository.save(cliente);
    }

    public List<Cliente> listar() {
        return repository.findAll();
    }
}

