package weatherforecast;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import com.apiclient.IpmaCityForecast; //may need to adapt package name
import com.apiclient.IpmaService;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
 * demonstrates the use of the IPMA API for weather forecast
 */
public class WeatherStarter {

    //todo: should generalize for a city passed as argument
    private static final int CITY_ID_AVEIRO = 1010500;
    private static final Logger logger = LogManager.getLogger(WeatherStarter.class);

    public static void  main(String[] args ) {

        // get a retrofit instance, loaded with the GSon lib to convert JSON into objects
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://api.ipma.pt/open-data/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        logger.info("Got the API");
        // create a typed interface to use the remote API (a client)
        IpmaService service = retrofit.create(IpmaService.class);
        // prepare the call to remote endpoint
        int temp_id = CITY_ID_AVEIRO;

        if (args.length != 0){
            temp_id = Integer.parseInt(args[0]);
        }

        logger.info("Got the city");

        Call<IpmaCityForecast> callSync = service.getForecastForACity(temp_id);

        try {
            Response<IpmaCityForecast> apiResponse = callSync.execute();
            IpmaCityForecast forecast = apiResponse.body();

            if (forecast != null) {
                var firstDay = forecast.getData().listIterator().next();

                System.out.printf( "Day: %s \n Max temp: %4.1f Celcius \n Min temp: %4.1f Celcius %n",
                        firstDay.getForecastDate(),
                        Double.parseDouble(firstDay.getTMax()),
                        Double.parseDouble(firstDay.getTMin()));
                        logger.info("Info obtained");
            } else {
                System.out.println( "No results for this request!");
                logger.error("No results...");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        logger.info("Finished");

    }
}
