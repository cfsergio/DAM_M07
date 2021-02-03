package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        primaryStage.setTitle("        E D I T O R        D E        T E X T O S");
        primaryStage.setScene(new Scene(root, 556, 367));
        primaryStage.setResizable(false);

        // Programem l'event OnCloseRequest per a cridar el mètode que hem fet
        // al Controller per preguntar si volem sortir o no.
        primaryStage.setOnCloseRequest(event -> {
            if (!controller.shutdown()) {
                // Si no volem sortir interrumpim el curs normal de l'event: el "consumim"
                event.consume();
            }
            // Si no fem res l'event segueix el seu curs normal i sortim de la finestra i l'aplicació
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
