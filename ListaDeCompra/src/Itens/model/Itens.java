package Itens.model;

import java.util.Date;

public class Itens {
    private int id;
    private String nome;
    private Double quantidade;
    private String medida;
    private String tipo;
    private Date dataInsert;

    //métodods getters
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public String getTipo() {
        return tipo;
    }

    public Date getDataInsert() {
       return dataInsert;
    }

    public String getMedida() {
        return medida;
    }

    //métodos setters
    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setDataInsert(Date dataInsert) {
       this.dataInsert = dataInsert;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
}
