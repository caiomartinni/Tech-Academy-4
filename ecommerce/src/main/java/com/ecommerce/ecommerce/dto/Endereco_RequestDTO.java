package com.ecommerce.ecommerce.dto;

public class Endereco_RequestDTO {
    private Integer id;
    private String logr;
    private Integer numero;
    private String bairro;
    private Integer cep;
    private String cidade;
    private String uf;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogr() {
        return logr;
    }

    public void setLogr(String logr) {
        this.logr = logr;
    }


    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getCep() {
        return cep;
    }

    public void setCep(Integer cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
}
