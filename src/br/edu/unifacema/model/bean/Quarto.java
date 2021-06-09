package br.edu.unifacema.model.bean;
/**
 * @author talison
 */
public class Quarto {
    
    private int id_quarto;
    private int numero;
    private int andar;
    private double preco;
    private String estado;
    private int periodo;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    public int getId_quarto() {
        return id_quarto;
    }

    public void setId_quarto(int id_quarto) {
        this.id_quarto = id_quarto;
    }

    @Override
    public String toString() { 
        
        int num = this.getNumero();
        double prec = this.getPreco();
        String desc = "Nº: "+num+", Preço: R$ "+preco;
        
        return desc; //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
