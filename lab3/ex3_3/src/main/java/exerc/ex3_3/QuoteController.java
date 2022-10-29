package exerc.ex3_3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import exerc.ex3_3.Exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api")                         //nao modificar 
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    /* Mapeamento da api:
     *          "/shows" -> mostra todos os filmes com as quotes associadas
     *          "/quote" -> mostra uma quote qualquer de um filme qualquer
     *          "/quotes?show=<show_id>" -> mostra uma quote aleatoria do filme especificado
     */

    @GetMapping("/shows")                       //list all movies
    public List<Quote> findAllQuotes() {
        return quoteService.getQuotes();       //funcional
    }

    @GetMapping("/quote")                   //return a random quote
    public Quote getQuotes(){
        int arraysize = quoteService.getQuotes().size();
        if (arraysize>0){
            return quoteService.getQuotes().get((int)(Math.random() * arraysize));    
        }
        return null;
    }

    @GetMapping("/quotes")              
    public Quote getQuote(@RequestParam(name = "show_id", required = false) Long show_id) throws ResourceNotFoundException {
        if (show_id == null){
            return getQuotes();                 //ir buscar quote qualquer
        }
        List<Quote> filteredQuotes = new ArrayList<Quote>();
        for (Quote quote: quoteService.getQuotes()){
            if (quote.getShow().getIdShow().equals(show_id)){
                filteredQuotes.add(quote);
            }
        }
        if (filteredQuotes.isEmpty()){
            return null;
        }
        return filteredQuotes.get((int)(Math.random() * filteredQuotes.size()));
    }

    @PostMapping("/quotes")                 //put some quotes
    public Quote createQuote(@RequestBody Quote quote) {
        return quoteService.saveQuote(quote);
    }

     
    @PutMapping("/quotes/{id}")          //modify some quotes
    public Quote updateQuote(@RequestBody Quote quote){
        return quoteService.updateQuote(quote);
    }

    
    @DeleteMapping("/quote/{id}")       //delete a movie
    public Map<String, Boolean> deleteEmployee(@RequestParam (name = "quote_id", required = false) Long quote_id){
        Map<String, Boolean> response = new HashMap<>();
        if (quoteService.deleteQuote(quote_id)){    
            response.put("deleted", Boolean.TRUE);
            return response;
        }
        response.put("deleted", Boolean.FALSE);
        return response;
    }
}

