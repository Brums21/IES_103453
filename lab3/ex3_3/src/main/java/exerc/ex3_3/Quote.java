package exerc.ex3_3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name = "quotes")
@JsonInclude(JsonInclude.Include.ALWAYS)
public class Quote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //gerar ID automaticamente
    @Column(name = "quote_id")
    private long id;

    @ManyToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JoinColumn(name = "show_id")
    private Show show;

    @Column(name= "strQuote")
    private String strQuote;

    public Quote(){
        
    }

    public Quote(Show show, String strQuote){
        this.show = show;
        this.strQuote = strQuote;
    }

    public String getStrQuote() {
        return strQuote;
    }

    public void setStrQuote(String strQuote) {
        this.strQuote = strQuote;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Show getShow(){
        return this.show;
    }

    public void setShow(Show show){
        this.show = show;
    }

}
