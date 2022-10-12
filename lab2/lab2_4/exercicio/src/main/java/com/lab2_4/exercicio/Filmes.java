package com.lab2_4.exercicio;

import java.util.ArrayList;
import java.util.Random;

public class Filmes {
    private Show show;
    private ArrayList<String> quotes = new ArrayList<>();
    private Random random = new Random();

    public Filmes(String titulo, ArrayList<String> quote){
        this.show = new Show(titulo);
        this.quotes = quote;
    }

    public Filmes(String titulo, String quote){
        this.show = new Show(titulo);
        this.quotes.add(quote);
    }

    public Show getShow(){
        return this.show;
    }

    public String getRandomQuote(){
        if (this.quotes.isEmpty()){
            return "ola";
        }
        return this.quotes.get(random.nextInt(this.quotes.size()));     //pode dar asneira
    }


}
