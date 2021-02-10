package eltemps;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class WeatherService5days {
    private String city;
    private String day;
    private Integer temperature;
    private String description;

    public WeatherService5days(String city) {
        this.city = city;
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText);
            return json;
        } finally {
            is.close();
        }
    }

    public void getWeather(){
        int i = 0;
        JSONObject json;
        JSONObject json_specific; //get specific data in jsonobject variable
        SimpleDateFormat df2 = new SimpleDateFormat("EEEE", Locale.ENGLISH); //Entire word/day as output
        Calendar c = Calendar.getInstance();

        try {
            json = readJsonFromUrl("api.openweathermap.org/data/2.5/forecast?q="+city+"&units=metric&lang=eng&appid=e45272a1eff49e21a99d62aa7f11153d");
        } catch (IOException e) {
            return;
        }
        json_specific = json.getJSONObject("list");
        json_specific = json.getJSONObject("main");
        this.temperature = json_specific.getInt("temp");
        c.add(Calendar.DATE, i);
        this.day = df2.format(c.getTime());
        json_specific = json.getJSONArray("weather").getJSONObject(0);
        this.description = json_specific.get("description").toString();
    }

    public String getCity() {
        return city;
    }

    public String getDay() {
        return day;
    }

    public Integer getTemperature() {
        return temperature;
    }

    public String getDescription() {
        return description;
    }
}
