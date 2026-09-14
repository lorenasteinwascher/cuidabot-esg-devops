package br.com.fiap.cuidabotesg.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "T_CUIDABOT_RELATORIO_ESG")
public class RelatorioEsg {

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "SEQ_CUIDABOT_RELATORIO_ESG"
    )
    @SequenceGenerator(
            name = "SEQ_CUIDABOT_RELATORIO_ESG",
            sequenceName = "SEQ_CUIDABOT_RELATORIO_ESG",
            allocationSize = 1
    )
    private Long id;

    @Column(name = "descricao", nullable = false, length = 500)
    private String descricao;

    @Column(name = "indicador", nullable = false, length = 100)
    private String indicador;

    @Column(name = "resultado", nullable = false, length = 300)
    private String resultado;

    @Column(name = "data_relatorio", nullable = false)
    private LocalDate dataRelatorio;

    @ManyToOne
    @JoinColumn(name = "empresa_id", nullable = false)
    private Empresa empresa;

    public RelatorioEsg() {
    }

    public RelatorioEsg(Long id, String descricao, String indicador, String resultado, LocalDate dataRelatorio, Empresa empresa) {
        this.id = id;
        this.descricao = descricao;
        this.indicador = indicador;
        this.resultado = resultado;
        this.dataRelatorio = dataRelatorio;
        this.empresa = empresa;
    }

    public Long getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public LocalDate getDataRelatorio() {
        return dataRelatorio;
    }

    public void setDataRelatorio(LocalDate dataRelatorio) {
        this.dataRelatorio = dataRelatorio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}