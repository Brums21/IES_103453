package com.lab2_4.exercicio;

public class Show {
    private String titulo;
    private static Integer count = 0;
    public Integer id;

    public Show(String titulo){
        this.titulo = titulo;
        this.id = count;
        count++;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public Integer getId(){
        return this.id;
    }
}
