package sample;

import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.*;
import java.util.Iterator;
import java.util.Optional;

public class Controller {
    @FXML
    MenuItem mi_copiar;
    @FXML
    MenuItem mi_enganxar;
    @FXML
    TextArea ta;
    @FXML
    AnchorPane ap;

    /**
     * Mètode corresponent a l'apartat "Per sortir de l'aplicació podeu cridar a Platform.exit()";
     */
    public void sortir() {
        Platform.exit();
    }

    /**
     * Mètode corresponent a l'apartat "Deshabilitar les opcions copiar i enganxar del menú Editar quan no hi hagi cap
     * text seleccionat. Això ho podrem controlar quan es desplegui el menú per exemple."
     * @param event
     */
    public void seleccionarEditar(Event event) {
        if (ta.getSelectedText().length() == 0){
            mi_copiar.setDisable(true);
            mi_enganxar.setDisable(true);
        } else {
            mi_copiar.setDisable(false);
            mi_enganxar.setDisable(false);
        }
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Editar podeu usar diferents mètodes de la
     * classe TextArea"  i "Afegir a l'editor una barra d'eines usant l'element ToolBar. Crear tres botons a la barra
     * d'eines: tallar, copiar i enganxar". En aquest cas, copiar.
     * @param actionEvent
     */
    public void copiarText(ActionEvent actionEvent) {
        ta.copy();
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Editar podeu usar diferents mètodes de la
     * classe TextArea"  i "Afegir a l'editor una barra d'eines usant l'element ToolBar. Crear tres botons a la barra
     * d'eines: tallar, copiar i enganxar". En aquest cas, tallar.
     * @param actionEvent
     */
    public void tallarText(ActionEvent actionEvent) {
        ta.cut();
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Editar podeu usar diferents mètodes de la
     * classe TextArea" i "Afegir a l'editor una barra d'eines usant l'element ToolBar. Crear tres botons a la barra
     * d'eines: tallar, copiar i enganxar". En aquest cas, enganxar.
     * @param actionEvent
     */
    public void enganxarText(ActionEvent actionEvent) {
        ta.paste();
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Editar podeu usar diferents mètodes de la
     * classe TextArea". En aquest cas, desfer.
     * @param actionEvent
     */
    public void desferText(ActionEvent actionEvent) {
        ta.undo();
    }

    /**
     * Mètode corresponent a l'apartat "- Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Tamany.
     * @param actionEvent
     */
    public void tamanyPetit(ActionEvent actionEvent) {
        ta.setFont(Font.font(7));
    }

    /**
     * Mètode corresponent a l'apartat "- Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Tamany.
     * @param actionEvent
     */
    public void tamanyMitja(ActionEvent actionEvent) {
        ta.setFont(Font.font(12));
    }

    /**
     * Mètode corresponent a l'apartat "- Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Tamany.
     * @param actionEvent
     */
    public void tamanyGran(ActionEvent actionEvent) {
        ta.setFont(Font.font(18));
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Font.
     * Fonts testejades des de Windows 10, sense cap problema d'execució.
     * @param actionEvent
     */
    public void fontComicSans(ActionEvent actionEvent) {
        ta.setFont(Font.font ("Comic Sans MS"));
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Font.
     * Fonts testejades des de Windows 10, sense cap problema d'execució.
     * @param actionEvent
     */
    public void fontImpact(ActionEvent actionEvent) {
        ta.setFont(Font.font ("Impact"));
        /* Amb aquestes sentències, funcionava tant la font com el tamany a la vegada, però si ho aplicava a
        fontTimesNewRoman(ActionEvent actionEvent) i fontComicSans(ActionEvent actionEvent), no funcionaven aquests (però sí l'actual)
        double mida_lletra_actual = ta.getFont().getSize();
        ta.setStyle("-fx-font: " + mida_lletra_actual + " Impact;");
        */
    }

    /**
     * Mètode corresponent a l'apartat "Per implementar les accions del menú Opcions podeu usar diferents mètodes de
     * la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un)." En aquest cas, opció de Font.
     * Fonts testejades des de Windows 10, sense cap problema d'execució.
     * @param actionEvent
     */
    public void fontTimesNewRoman(ActionEvent actionEvent) {
        ta.setFont(Font.font ("Times New Roman"));
    }

    /**
     * Mètode corresponent a l'apartat "La opció "Sobre l'Editor" del menú Ajuda ha de mostrar un diàleg modal amb
     * informació sobre l'aplicació. Useu la classe Alert per crear-lo."
     * @param actionEvent
     */
    public void ajuda(javafx.event.ActionEvent actionEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ajuda sobre l'Editor");
        alert.setHeaderText(null);
        alert.setContentText("Editor de text és una pràctica per al mòdul M07 \nCreat el dia 04/11/2020 \nCreador: SLG \nVersió: 2.1. \nIdioma: Català");
        alert.showAndWait();
    }

    // Mètode que es crida abans de tancar la finestra i pregunta si volem sortir o no
    public boolean shutdown() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(ta.getScene().getWindow());
        alert.setHeaderText("Sortir");
        alert.setContentText("Vols sortir de l'editor de text?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            return true;
        }
        return false;
    }

    /**
     * Mètode per obrir un fitxer amb l'editor
     * @param actionEvent
     * @throws IOException
     */
    public void obrirFitxer(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fc = new FileChooser();
        File fitxer = null;
        fc.setTitle("Selecciona el fitxer per obrir...");
        fitxer = fc.showOpenDialog(stage);
        String c = "";
        String ruta = fitxer.getAbsolutePath();
        FileReader fr = null;
        BufferedReader br = null;
        try {
            fr = new FileReader(ruta);
            br = new BufferedReader(fr);
            while (br.ready()) {
                c += br.readLine() + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        ta.setText(c);
        stage.setTitle(fitxer.getName());
    }

    /**
     * Mètode per guardar el fitxer que s'ha generat mitjançant l'editor
     * @param actionEvent
     */
    public void guardarFitxer(ActionEvent actionEvent){
        Stage stage = (Stage) ap.getScene().getWindow();
        FileChooser fc = new FileChooser();
        File fitxer = null;
        fc.setTitle("Guardar com...");
        fitxer = fc.showSaveDialog(stage);
        ObservableList<CharSequence> p = ta.getParagraphs();
        Iterator<CharSequence> iter = p.iterator();
        try
        {
            BufferedWriter bf = new BufferedWriter(new FileWriter(fitxer));
            while(iter.hasNext())
            {
                CharSequence seq = iter.next();
                bf.append(seq);
                bf.newLine();
            }
            bf.flush();
            bf.close();
            //stage.setTitle(fitxer);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
