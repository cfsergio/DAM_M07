package eltemps;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ControllerPrevisio {
    WeatherService5days wmFiveDays;
    String city;

    @FXML
    private Label lbWinSec;
    public String getLbText() {
        return lbWinSec.getText();
    }
    public void setLbText(String txt) {
        this.lbWinSec.setText(txt);
    }

    public void initialize(){
        city = wmFiveDays.getCity();
    }
}
