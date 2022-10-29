package exerc.ex3_3;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex33Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex33Application.class, args);
	}
	
	@Bean
  	public CommandLineRunner demo(QuoteRepository quoteRepository) {
    return (args) -> {
      quoteRepository.deleteAll();
      Show showtemp = new Show("Gone with the wind", 1939);
      ArrayList<Quote> quotes = new ArrayList<>();
      quotes.add(new Quote(showtemp, "Burdens are for shoulders strong enough to carry them."));
      quotes.add(new Quote(showtemp, "After all, tomorrow is another day!"));
      quotes.add(new Quote(showtemp, "My dear, I don't give a damn."));
      quotes.add(new Quote(showtemp, "I can't think about that right now. If I do, I'll go crazy. I'll think about that tomorrow."));
      quotes.add(new Quote(showtemp, "It was better to know the worst than to wonder."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);

      showtemp = new Show("The Godfather", 1972);
      quotes.add(new Quote(showtemp, "What are you worried about, if I wanted to kill you, you'd be dead already."));
      quotes.add(new Quote(showtemp, "A friend should always underestimate your virtues and an enemy overestimate your faults."));
      quotes.add(new Quote(showtemp, "Monday, Tuesday, Thursday, Wednesday, Friday, Sunday, Saturday."));
      quotes.add(new Quote(showtemp, "Luca Brasi sleeps with the fishes."));
      quotes.add(new Quote(showtemp, "I’m gonna make him an offer he can’t refuse."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);

      showtemp = new Show("The Wizard of Oz", 1939);
      quotes.add(new Quote(showtemp, "Are you a good witch or a bad witch"));
      quotes.add(new Quote(showtemp, "You’ve no power here! Begone, before someone drops a house on you too!"));
      quotes.add(new Quote(showtemp, "You've always had the power my dear, you just had to learn it yourself."));
      quotes.add(new Quote(showtemp, "Toto, I've got a feeling we're not in Kansas anymore."));
      quotes.add(new Quote(showtemp, "You're confusing courage with wisdom."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);

      showtemp = new Show("Jaws", 1975);
      quotes.add(new Quote(showtemp, "The past always seems better when you look back on it than it did at the time. And the present never looks as good as it will in the future."));
      quotes.add(new Quote(showtemp, "Other fish run from bigger things. That’s their instinct. But this fish doesn’t run from anything. He doesn’t fear."));
      quotes.add(new Quote(showtemp, "Trying to get retribution against a fish is crazy."));
      quotes.add(new Quote(showtemp, "What had once seemed shallow and tedious now loomed in memory like paradise."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);

      showtemp = new Show("The Terminator", 1984);
      quotes.add(new Quote(showtemp,"I’ll be back."));
      quotes.add(new Quote(showtemp,"The future has not been written. There is no fate but what we make for ourselves."));
      quotes.add(new Quote(showtemp,"Hasta la vista, baby."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);

      showtemp = new Show("Forrest Gump", 1994);
      quotes.add(new Quote(showtemp, "My mama always said, 'Life was like a box of chocolates. You never know what you're gonna get."));
      quotes.add(new Quote(showtemp, "You have to do the best with what God gave you."));
      quotes.add(new Quote(showtemp, "My Mama always said you've got to put the past behind you before you can move on."));
      quoteRepository.saveAll(quotes);
      showtemp = null;
      quotes.removeAll(quotes);
    };

	}

}
