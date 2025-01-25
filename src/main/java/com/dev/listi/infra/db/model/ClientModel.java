package com.dev.listi.infra.db.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "clients")
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

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<OSDataModel> ordensDeServico;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserModel userModel;



    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

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
