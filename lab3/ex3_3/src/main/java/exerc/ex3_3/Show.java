package exerc.ex3_3;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "shows")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerar ID automaticamente
    @Column(name="show_id")
    private Long id;

    @Column(name = "titulo")
    private String titulo;

    @Column(name = "year")
    private int year;
    
    public Show(){

    }

    public Show(String titulo, int year){
        this.titulo = titulo;
        this.year = year;
    }

    public Long getIdShow() {
        return id;
    }

    public void setIdShow(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    
}
