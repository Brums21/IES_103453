package exerc.ex3_3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exerc.ex3_3.Exceptions.ResourceNotFoundException;

import java.util.List;

@Service
public class QuoteService {

    @Autowired
    private QuoteRepository repository;

    public Quote saveQuote(Quote quote){
        return repository.save(quote);
    }

    public List<Quote> saveQuotes(List<Quote> quotes){
        return repository.saveAll(quotes);
    }

    public List<Quote> getQuotes(){
        return repository.findAll();
    }

    public Quote getQuoteById(long id) throws ResourceNotFoundException{
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Nao foi encontrado nenhuma quote associada a esse ID"));
    }

    public Boolean deleteQuote(long id){
        if (hasQuote(id)){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public Boolean hasQuote(long id){
        if(repository.findById(id) != null){
            return true;
        }
        return false;
    }

    public Quote updateQuote(Quote quote){
        Quote existingQuote = repository.findById(quote.getId()).orElse(null);
        existingQuote.setId(quote.getId());
        existingQuote.setShow(quote.getShow());
        existingQuote.setStrQuote(quote.getStrQuote());
        return repository.save(existingQuote);
    }


}
