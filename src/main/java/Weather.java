import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;

public class Weather {
    private String city;
    private String country;
    private double temp;
    private int pressure;
    private int windSpeed;

    public Weather(HttpResponse<JsonNode> weather) {
        this.city = weather.getBody().getObject().getString("name");
        this.temp = weather.getBody().getObject().getJSONObject("main").getDouble("temp");
        this.pressure = weather.getBody().getObject().getJSONObject("main").getInt("pressure");
        this.country = weather.getBody().getObject().getJSONObject("sys").getString("country");
        this.windSpeed = weather.getBody().getObject().getJSONObject("wind").getInt("speed");
    }

    public void GetInfo(){
        System.out.println(
                "City: " + city + ", " + country + ";\n" +
                        "Temperature: " + temp + " K = " + String.format("%.1f",temp-273.15) + "°C;\n" +
                        "Pressure: " + pressure + " millibars;\n" +
                        "Wind speed: " + windSpeed + " km/h."
        );
    }
}
