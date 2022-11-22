package com.example.api_ghibli;

public class ItemsModel {

    private String titulo;
    private String dataLancamento;
    private int poster;

    public ItemsModel(String titulo, String dataLancamento, int poster) {
        this.titulo = titulo;
        this.dataLancamento = dataLancamento;
        this.poster = poster;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}