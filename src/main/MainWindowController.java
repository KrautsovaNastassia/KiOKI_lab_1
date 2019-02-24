package main;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    private Stage dialogStage;
    @FXML
    private ComboBox methodsCombo;
    @FXML
    private TextArea sourceArea;
    @FXML
    private TextArea targetArea;
    @FXML
    private TextField keyField;

    private RailFence rf = new RailFence();
    private PassPhrase ph = new PassPhrase();
    private RotatingGrid rg = new RotatingGrid();

    public void initialize(URL url, ResourceBundle rb) {
        initMethodsCombo();
        sourceArea.setText("Nastassia Krautsova");
        keyField.setText("3");
        methodsCombo.getSelectionModel().select(0);
    }

    private void initMethodsCombo(){
        List<String> array = new ArrayList<>();
        array.add("Железнодорожная изгородь");
        array.add("Ключевая фраза");
        array.add("Метод поворачивающейся решетки");
        array.add("Цезарь");
        array.add("Улучшенный Цезарь");
        methodsCombo.getItems().addAll(array);
    }

    @FXML
    public void handleEncryption(){
        int k = methodsCombo.getSelectionModel().getSelectedIndex();
        String key = keyField.getText();
        String message = sourceArea.getText();
        switch(k){
            case 0:
                targetArea.setText(rf.cipherEncryption(message, Integer.parseInt(key)));
                break;
            case 1:
                targetArea.setText(ph.cipherEncryption(message, key));
                break;
            case 2:
                List<int[]> gridKey = openGridForm();
                if(gridKey.size() != 0){
                    targetArea.setText(rg.cipherEncryption(message, gridKey));
                } else {
                    targetArea.clear();
                }
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    @FXML
    public void handleDecryption(){
        int k = methodsCombo.getSelectionModel().getSelectedIndex();
        String key = keyField.getText();
        String message = sourceArea.getText();
        switch(k){
            case 0:
                targetArea.setText(rf.cipherDecryption(message, Integer.parseInt(key)));
                break;
            case 1:
                targetArea.setText(ph.cipherDecryption(message, key));
                break;
            case 2:
                List<int[]> gridKey = openGridForm();
                if(gridKey.size() != 0){
                    targetArea.setText(rg.cipherDecryption(message, gridKey));
                } else {
                    targetArea.clear();
                }
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    private List<int[]>  openGridForm() {
        List<int[]> selectedChb = new ArrayList<>();
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/main/GridForm.fxml"));
            AnchorPane page = (AnchorPane)loader.load();
            Stage dialog = new Stage();
            dialog.setTitle("Ключ");
            dialog.initModality(Modality.WINDOW_MODAL);
            dialog.initOwner(dialogStage);
            Scene scene = new Scene(page);
            dialog.setScene(scene);
            dialog.setResizable(false);
            GridFormController controller = loader.getController();
            controller.setDialogStage(dialog);
            dialog.showAndWait();
            selectedChb = controller.getSelectedChb();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return selectedChb;
    }

}
