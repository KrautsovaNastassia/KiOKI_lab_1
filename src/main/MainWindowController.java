package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class MainWindowController implements Initializable {

    @FXML
    private ComboBox methodsCombo;
    @FXML
    private TextArea sourceArea;
    @FXML
    private TextArea targetArea;
    @FXML
    private TextField keyField;

    private RailFence rf = new RailFence();

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
        array.add("Криптосистема Цезаря");
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
                break;
            case 2:
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
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

}
