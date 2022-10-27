package exerc.ex3_3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    private QuoteRepository quoteRepository;

    @Autowired
    private ShowRepository showRepository;


    /* Mapeamento da api:
     *          "/shows" -> mostra todos os filmes com as quotes associadas
     *          "/quote" -> mostra uma quote qualquer de um filme qualquer
     *          "/quotes?show=<show_id>" -> mostra uma quote aleatoria do filme especificado
     */

    @GetMapping("/shows")                       //list all movies
    public List<Quote> getAllQuotes() {
        return quoteRepository.findAll();       //funcional
    }

    @GetMapping("/quote")
    public ResponseEntity<Quote> getQuotes(){
        List<Quote> quotes = quoteRepository.findAll();
        if (quotes.size() != 0){
            Quote randquote = quotes.get((int)(Math.random() * quotes.size()));
            return ResponseEntity.ok().body(randquote);
        }
        return ResponseEntity.ok().body(null);
    }

    
    @GetMapping("/quotes")              
    public ResponseEntity<Quote> getAllQuotes(@RequestParam(value="show", required=false) String show_id) {
        if (show_id == null){
            return getQuotes();
        }
        List<Quote> quotesShow = quoteRepository.findByShowId(Integer.parseInt(show_id));
        if (quotesShow.size()<1){
            return ResponseEntity.ok().body(null);
        }
        return ResponseEntity.ok().body(quotesShow.get((int)(Math.random() * quotesShow.size())));   
    }

    
    @PostMapping("/quotes")                 //put some quotes
    public Quote createQuote() {
        Show show = new Show("titulo do filme", 2002);
        Quote quote = new Quote(showRepository.save(show), "Isto e uma quote qualquer");
        return quoteRepository.save(quote);
    }

    /* 
    @PutMapping("/employees/{id}")          //modify some quotes
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
         @Valid @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        employee.setEmailId(employeeDetails.getEmailId());
        employee.setLastName(employeeDetails.getLastName());
        employee.setFirstName(employeeDetails.getFirstName());
        final Employee updatedEmployee = employeeRepository.save(employee);
        return ResponseEntity.ok(updatedEmployee);
    }*/

    
    @DeleteMapping("/quote/{id}")       //delete a movie
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long quoteId)
         throws ResourceNotFoundException {
        Quote quote = quoteRepository.findById(quoteId)
       .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + quoteId));
        quoteRepository.delete(quote);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}

