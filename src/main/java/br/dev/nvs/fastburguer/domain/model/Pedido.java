
package br.dev.nvs.fastburguer.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
     private Long numero;
     
    public Long getNumero() {
        return numero;
    }
    
     public void setNumero(Long numero) {
        this.numero = numero;
    }
     
     private LocalDateTime inicioPreparo;

    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    private LocalDateTime dataCriacao;
    

@ManyToMany
@JoinTable(
    name = "pedido_produto",
    joinColumns = @JoinColumn(name = "pedido_id"),
    inverseJoinColumns = @JoinColumn(name = "produto_id")
)
private List<Produto> produtos;
    
    private String cliente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
    this.cliente = cliente;
    
    }
     public LocalDateTime getInicioPreparo() {
        return inicioPreparo;
    }

    public void setInicioPreparo(LocalDateTime inicioPreparo) {
        this.inicioPreparo = inicioPreparo;
    }
    
     @JsonProperty
    public long getMinutosDecorridos() {
        if (inicioPreparo == null) return 0;

        return Duration
                .between(inicioPreparo, LocalDateTime.now())
                .toMinutes();
    }

    @JsonProperty
    public boolean isAtrasado() {
        return inicioPreparo != null && getMinutosDecorridos() > 14;
    }
    
    @JsonProperty
    public List<Produto> getProdutosPreparo() {
        if (produtos == null) return List.of();

        return produtos.stream()
                .filter(p -> p.getCategoria() != Categoria.ACOMPANHAMENTO)
                .collect(Collectors.toList());
    }

    @JsonProperty
    public List<Produto> getProdutosEntrega() {
        if (produtos == null) return List.of();

        return produtos.stream()
                .filter(p -> p.getCategoria() == Categoria.BEBIDA)
                .collect(Collectors.toList());
    }
}