package exerc.ex3_3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Ex33Application {

	public static void main(String[] args) {
		SpringApplication.run(Ex33Application.class, args);
	}
	
	/*@Bean
  	public CommandLineRunner demo(QuoteRepository quoteRepository) {
    return (args) -> {
		quotes.add("Burdens are for shoulders strong enough to carry them.");
        quotes.add("After all, tomorrow is another day!");
        quotes.add("My dear, I don't give a damn.");
        quotes.add("I can't think about that right now. If I do, I'll go crazy. I'll think about that tomorrow.");
        quotes.add("It was better to know the worst than to wonder.");
        filmes.add(new Filmes("Gone with the Wind", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

        quotes.add("What are you worried about, if I wanted to kill you, you'd be dead already.");
        quotes.add("A friend should always underestimate your virtues and an enemy overestimate your faults.");
        quotes.add("Monday, Tuesday, Thursday, Wednesday, Friday, Sunday, Saturday.");
        quotes.add("Luca Brasi sleeps with the fishes.");
        quotes.add("I’m gonna make him an offer he can’t refuse.");
        filmes.add(new Filmes("The Godfather", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

        quotes.add("Are you a good witch or a bad witch");
        quotes.add("You’ve no power here! Begone, before someone drops a house on you too!");
        quotes.add("You've always had the power my dear, you just had to learn it yourself.");
        quotes.add("Toto, I've got a feeling we're not in Kansas anymore.");
        quotes.add("You're confusing courage with wisdom.");
        filmes.add(new Filmes("The wizard of Oz", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

        quotes.add("The past always seems better when you look back on it than it did at the time. And the present never looks as good as it will in the future.");
        quotes.add("Other fish run from bigger things. That’s their instinct. But this fish doesn’t run from anything. He doesn’t fear.");
        quotes.add("Trying to get retribution against a fish is crazy.");
        quotes.add("What had once seemed shallow and tedious now loomed in memory like paradise.");
        filmes.add(new Filmes("Jaws", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

        quotes.add("I’ll be back.");
        quotes.add("The future has not been written. There is no fate but what we make for ourselves.");
        quotes.add("Hasta la vista, baby.");
        filmes.add(new Filmes("Terminator", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

        quotes.add("My mama always said, 'Life was like a box of chocolates. You never know what you're gonna get.");
        quotes.add("You have to do the best with what God gave you.");
        quotes.add("My Mama always said you've got to put the past behind you before you can move on.");
        filmes.add(new Filmes("Forrest Gump", new ArrayList<String>(quotes)));
        quotes.removeAll(quotes);

	}*/

}
