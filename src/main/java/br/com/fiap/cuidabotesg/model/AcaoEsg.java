package br.com.fiap.cuidabotesg.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_CUIDABOT_ACAO_ESG")
public class AcaoEsg {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CUIDABOT_ACAO_ESG"
    )
    @SequenceGenerator(
            name = "SEQ_CUIDABOT_ACAO_ESG",
            sequenceName = "SEQ_CUIDABOT_ACAO_ESG",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column(name = "responsavel", nullable = false, length = 100)
    private String responsavel;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "data_inicio", nullable = false)
    private LocalDate dataInicio;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public AcaoEsg() {
    }

    public AcaoEsg(Long id, String titulo, String descricao, String categoria, String responsavel, String status, LocalDate dataInicio, LocalDate dataFim, Empresa empresa) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.responsavel = responsavel;
        this.status = status;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}