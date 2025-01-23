package com.dev.listi.ordermanagement.infra.model;

import com.dev.listi.clientmanagement.infra.model.ClientModel;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "os")
public class OSDataModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String codigo;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClientModel cliente;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private LocalDateTime dataCriacao;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusOS status;

    private String observacoes;

    @Column(nullable = false, unique = true)
    private String linkGerencial;

    @Column(nullable = false, unique = true)
    private String linkAcompanhamento;

    public String getLinkAcompanhamento() {
        return linkAcompanhamento;
    }

    public void setLinkAcompanhamento(String linkAcompanhamento) {
        this.linkAcompanhamento = linkAcompanhamento;
    }

    public String getLinkGerencial() {
        return linkGerencial;
    }

    public void setLinkGerencial(String linkGerencial) {
        this.linkGerencial = linkGerencial;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public StatusOS getStatus() {
        return status;
    }

    public void setStatus(StatusOS status) {
        this.status = status;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ClientModel getCliente() {
        return cliente;
    }

    public void setCliente(ClientModel cliente) {
        this.cliente = cliente;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

