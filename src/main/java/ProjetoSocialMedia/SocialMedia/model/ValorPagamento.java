package ProjetoSocialMedia.SocialMedia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.util.Date;
@Entity
public class ValorPagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private Date data;
    private String SnValorAtual;

    public ValorPagamento() {
    }

    public ValorPagamento(Long id, double valor, Date data, String snValorAtual) {
        this.id = id;
        this.valor = valor;
        this.data = data;
        SnValorAtual = snValorAtual;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getSnValorAtual() {
        return SnValorAtual;
    }

    public void setSnValorAtual(String snValorAtual) {
        SnValorAtual = snValorAtual;
    }
}
