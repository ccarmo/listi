package com.dev.listi.infra.db.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clientes")
public class ClientModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String telefone;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<OSDataModel> ordensDeServico;

    public List<OSDataModel> getOrdensDeServico() {
        return ordensDeServico;
    }

    public void setOrdensDeServico(List<OSDataModel> ordensDeServico) {
        this.ordensDeServico = ordensDeServico;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
