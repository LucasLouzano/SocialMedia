package ProjetoSocialMedia.SocialMedia.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PaymentClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double valor;
    private Date mes;
    @ManyToOne
    @JoinColumn(name = "id_usuario", referencedColumnName = "id")
    private Usuario usuario;

    public PaymentClient() {
    }

    public PaymentClient(Long id, double valor, Date mes, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.mes = mes;
        this.usuario = usuario;
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

    public Date getMes() {
        return mes;
    }

    public void setMes(Date mes) {
        this.mes = mes;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
