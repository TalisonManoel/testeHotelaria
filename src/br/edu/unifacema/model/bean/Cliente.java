package br.edu.unifacema.model.bean;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author talison
 */
public class Cliente {
    
    private int id_cliente;
    private String nome;
    private String cpf;
    private String situacao;
    private int id_quarto;
    private Timestamp checkin;
    private int id_servico;

    public Cliente(int id_cliente, String nome, String cpf, String situacao, int id_quarto, Timestamp checkin, int id_servico) {
        this.id_cliente = id_cliente;
        this.nome = nome;
        this.cpf = cpf;
        this.situacao = situacao;
        this.id_quarto = id_quarto;
        this.checkin = checkin;
        this.id_servico = id_servico;
    }
    
    
       
    public Cliente() {
    }

    public Timestamp getCheckin() {
        return checkin;
    }

    public void setCheckin(Timestamp checkin) {
        this.checkin = checkin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_servico() {
        return id_servico;
    }

    public void setId_servico(int id_servico) {
        this.id_servico = id_servico;
    }
    
    
}
