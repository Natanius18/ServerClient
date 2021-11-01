import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class Client {
    public static void main(String[] args) throws UnirestException {
        String city = "Odessa";
        HttpResponse<JsonNode> jsonNodeHttpResponse = Unirest.get("http://api.openweathermap.org/data/2.5/weather")
                .header("Accept", "application/json")
                .queryString("q", city)
                .queryString("appid", "4c780711e462b06d3fcf4b05597693c6")
                .asJson();
        Weather weather = new Weather(jsonNodeHttpResponse);
        weather.GetInfo();
    }
}
