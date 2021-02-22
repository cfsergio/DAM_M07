package eltemps;

import eltemps.domain.Weather;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Window2 {
    @FXML
    private BorderPane lbWinSec;

    private WeatherService5days weatherService = new WeatherService5days();
    private ListView<String> ciutats = new ListView<>();
    private Image image;

    @FXML
    private Label lbInfo;

    @FXML
    private ImageView iv_icon;

    @FXML
    private ListView lvCiutats;

    @FXML
    private Button previsio;

    @FXML
    private Label etiqueta;

    @FXML
    private Button bt1, bt2;

    @FXML
    private Parent root;

    private short numWin;

    public void initialize(){
        numWin = 1;

        lvCiutats.getItems().addAll("Barcelona", "San Cristóbal de La Laguna", "Jaén", "Madrid", "Sant Sebastià");
        lvCiutats.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                    Weather current = weatherService.getCurrentWeather(newValue.toString());
                    if (current != null) {
                        lbInfo.setText("Temp: " + current.getTemp() +
                                "\nFeels like: " + current.getFeelsLike() +
                                "\nMin: " + current.getMin() +
                                "\nMax: " + current.getMax() +
                                "\nIcon: " + current.getIcon() +
                                "\nPressure: " + current.getPressure() +
                                "\nHumidity: " + current.getHumidity());

                        String url = "http://openweathermap.org/img/wn/" + current.getIcon() + "@2x.png";
                        setImage(url);


                    }
                }
        );
    }

    public void testJSON(ActionEvent actionEvent) {
    }

    public static String recuperaURLIcon(String codi_icon) {
        String url_base = "http://openweathermap.org/img/wn/" + codi_icon + "@2x.png";

        return url_base;
    }

    private void setImage(String url) {
        try {
            image = new Image(url);
            iv_icon.setImage(image);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
