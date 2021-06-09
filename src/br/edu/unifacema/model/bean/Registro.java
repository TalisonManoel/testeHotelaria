package br.edu.unifacema.model.bean;

import java.sql.Timestamp;

/**
 * @author talison
 */
public class Registro {
    
    private int id_registro;
    private String registro;
    private Timestamp data;

    public Registro() {
    }

    public int getId_registro() {
        return id_registro;
    }

    public void setId_registro(int id_registro) {
        this.id_registro = id_registro;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public Timestamp getData() {
        return data;
    }

    public void setData(Timestamp data) {
        this.data = data;
    }
    
    
    
}
