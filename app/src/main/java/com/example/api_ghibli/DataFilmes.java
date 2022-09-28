package com.example.api_ghibli;

public class DataFilmes {

    private String nomeFilme;
    private String dataFilme;
    private Integer imagemFilme;

    public DataFilmes(String nomeFilme, String dataFilme, Integer imagemFilme) {
        this.nomeFilme = nomeFilme;
        this.dataFilme = dataFilme;
        this.imagemFilme = imagemFilme;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getDataFilme() {
        return dataFilme;
    }

    public void setDataFilme(String dataFilme) {
        this.dataFilme = dataFilme;
    }

    public Integer getImagemFilme() {
        return imagemFilme;
    }

    public void setImagemFilme(Integer imagemFilme) {
        this.imagemFilme = imagemFilme;
    }
}
