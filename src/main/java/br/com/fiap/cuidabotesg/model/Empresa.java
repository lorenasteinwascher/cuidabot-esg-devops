package br.com.fiap.cuidabotesg.model;

import jakarta.persistence.*;

@Entity
@Table(name = "T_CUIDABOT_EMPRESA")
public class Empresa {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CUIDABOT_EMPRESA"
    )
    @SequenceGenerator(
            name = "SEQ_CUIDABOT_EMPRESA",
            sequenceName = "SEQ_CUIDABOT_EMPRESA",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "cnpj", nullable = false, unique = true, length = 14)
    private String cnpj;

    @Column(name = "setor", nullable = false, length = 80)
    private String setor;

    public Empresa() {
    }

    public Empresa(Long id, String nome, String cnpj, String setor) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.setor = setor;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }
}