package eltemps;

import eltemps.domain.Weather;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherService {

    public Weather getCurrentWeather(String city) {
        String crida = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&lang=ca&appid=e45272a1eff49e21a99d62aa7f11153d";

        String forecastJSON = null;

        try {
            forecastJSON = owmCall(crida);
        } catch (IOException e) {
            //e.printStackTrace();
            return null;
        }

        // forecastJSON = "{\"coord\":{\"lon\":2.16,\"lat\":41.39},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"lleugerament ennuvolat\",\"icon\":\"02n\"}],\"base\":\"stations\",\"main\":{\"temp\":10.08,\"feels_like\":7.54,\"temp_min\":8.89,\"temp_max\":11.11,\"pressure\":1004,\"humidity\":53},\"visibility\":10000,\"wind\":{\"speed\":1,\"deg\":0},\"clouds\":{\"all\":20},\"dt\":1607278801,\"sys\":{\"type\":1,\"id\":6398,\"country\":\"ES\",\"sunrise\":1607238205,\"sunset\":1607271720},\"timezone\":3600,\"id\":3128760,\"name\":\"Barcelona\",\"cod\":200}";


        JSONObject joWeather = (JSONObject) new JSONTokener(forecastJSON).nextValue();
        JSONObject joMain = joWeather.getJSONObject("main");
        JSONObject joDesc = joWeather.getJSONArray("weather").getJSONObject(0);
        JSONObject joWind = joWeather.getJSONObject("wind");
        JSONObject joClouds = joWeather.getJSONObject("clouds");

        Weather current = new Weather();

        current.setTemp(joMain.getDouble("temp"));
        current.setFeelsLike(joMain.getDouble("feels_like"));
        current.setMin(joMain.getDouble("temp_min"));
        current.setMax(joMain.getDouble("temp_max"));
        current.setPressure(joMain.getDouble("pressure"));
        current.setHumidity(joMain.getInt("humidity"));
        current.setDescription(joDesc.getString("description"));
        current.setIcon(joDesc.getString("icon"));
        current.setSpeed(joWind.getDouble("speed"));
        current.setClouds(joClouds.getInt("all"));

        if (joWeather.has("rain")) {
            JSONObject joRain = joWeather.getJSONObject("rain");
            current.setRain(joRain.getDouble("1h"));
        }
        if (joWeather.has("snow")) {
            JSONObject joSnow = joWeather.getJSONObject("snow");
            current.setSnow(joSnow.getDouble("1h"));
        }

        return current;
    }

    private String owmCall(String url_crida) throws IOException {
        URL url = new URL(url_crida);
        String response = null;
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            response = readStream(in);
        } finally {
            urlConnection.disconnect();
        }
        return response;
    }

    private static String readStream(InputStream in) throws IOException {
        InputStreamReader is = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(is);
        String line;
        StringBuilder response = new StringBuilder();
        while ((line = rd.readLine()) != null) {
            response.append(line);
            response.append('\r');
        }
        rd.close();
        return response.toString();
    }
}
