package eltemps;

import eltemps.domain.Weather;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;


public class FinestraPrincipal {

    private WeatherService weatherService = new WeatherService();
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

    /**
     * Exemple simple de crear un diàleg amb la classe Alert
     * @param actionEvent
     */
    public void clickButton1(ActionEvent actionEvent) {
        Alert al = new Alert(AlertType.WARNING, "Això és un diàleg.");
        al.setHeaderText("Cuidao!");
        al.setTitle("Diàleg");
        al.showAndWait();
    }

    /**
     * Per crear una nova finestra cal crear un Stage que contingui un Scene
     * que alhora contingui el SceneGraf (o graf de controls)
     * @param actionEvent
     */
    public void clickButton2(ActionEvent actionEvent) {
        // Creem un Stage
        Stage stage = new Stage();
        stage.setTitle("Window" + numWin);

        // Fixem la finestra propietària, de manera que si es tanca
        // també es tancarà aquesta
        //stage.initOwner(root.getScene().getWindow());

        try {
            // Carreguem el fitxer fxml que defineix el graf de controls
            // El mètode load() ens retorna una referència al node arrel (de tipus Parent)
            // El mateix mètode load() tb crea una instància de la classe controladora
            FXMLLoader loader = new FXMLLoader(getClass().getResource("window2.fxml"));
            Parent graf = loader.load();

            // A través de l'objecte FXMLLoader podem obtenir la instància del controlador creat
            Window2 win2 = (Window2) loader.getController();
            // Cridem el mètode per a canviar el text de l'etiqueta de fons
            //win2.setLbText("Window" + numWin);

            // Creem la Scene passant-li el graf de controls (la referència al nopde arrel)
            Scene scn = new Scene(graf, 300, 300);

            // Fixem la Scene al nou Stage
            stage.setScene(scn);

            // Si volem una finestra modal ho fixem
            //stage.initModality(Modality.WINDOW_MODAL);

            // Finalment mostrem la nova finestra
            stage.show();

            // Augmentem el número de finestra
            numWin++;
        }
        catch (Exception e){
            System.out.println(e);
        }
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
