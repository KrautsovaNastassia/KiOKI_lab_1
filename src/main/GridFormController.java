package main;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GridFormController implements Initializable {

    private List<int[]> selectedChb = new ArrayList<>();
    private Stage dialogStage;
    @FXML
    private CheckBox chb00;
    @FXML
    private CheckBox chb01;
    @FXML
    private CheckBox chb02;
    @FXML
    private CheckBox chb03;
    @FXML
    private CheckBox chb10;
    @FXML
    private CheckBox chb11;
    @FXML
    private CheckBox chb12;
    @FXML
    private CheckBox chb13;
    @FXML
    private CheckBox chb20;
    @FXML
    private CheckBox chb21;
    @FXML
    private CheckBox chb22;
    @FXML
    private CheckBox chb23;
    @FXML
    private CheckBox chb30;
    @FXML
    private CheckBox chb31;
    @FXML
    private CheckBox chb32;
    @FXML
    private CheckBox chb33;

    public void initialize(URL url, ResourceBundle rb) {}

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    @FXML
    public void handleAccept(){
        int count_select = 0;
        int sum = 0;
        List<int[]> selectedChb = new ArrayList<>();
        int[] x = new int[4];
        int[] y = new int[4];
        if(chb00.isSelected()){
            count_select++;
            sum = sum + 1;
            x[0] = 0;
            y[0] = 0;
        }
        if(chb01.isSelected()){
            count_select++;
            sum = sum + 2;
            x[1] = 0;
            y[1] = 1;
        }
        if(chb02.isSelected()){
            count_select++;
            sum = sum + 3;
            x[2] = 0;
            y[2] = 2;
        }
        if(chb03.isSelected()){
            count_select++;
            sum = sum + 1;
            x[0] = 0;
            y[0] = 3;
        }
        if(chb10.isSelected()){
            count_select++;
            sum = sum + 3;
            x[2] = 1;
            y[2] = 0;
        }
        if(chb11.isSelected()){
            count_select++;
            sum = sum + 4;
            x[3] = 1;
            y[3] = 1;
        }
        if(chb12.isSelected()){
            count_select++;
            sum = sum + 4;
            x[3] = 1;
            y[3] = 2;
        }
        if(chb13.isSelected()){
            count_select++;
            sum = sum + 2;
            x[1] = 1;
            y[1] = 3;
        }
        if(chb20.isSelected()){
            count_select++;
            sum = sum + 2;
            x[1] = 2;
            y[1] = 0;
        }
        if(chb21.isSelected()){
            count_select++;
            sum = sum + 4;
            x[3] = 2;
            y[3] = 1;
        }
        if(chb22.isSelected()){
            count_select++;
            sum = sum + 4;
            x[3] = 2;
            y[3] = 2;
        }
        if(chb23.isSelected()){
            count_select++;
            sum = sum + 3;
            x[2] = 2;
            y[2] = 3;
        }
        if(chb30.isSelected()){
            sum = sum + 1;
            count_select++;
            x[0] = 3;
            y[0] = 0;
        }
        if(chb31.isSelected()){
            count_select++;
            sum = sum + 3;
            x[2] = 3;
            y[2] = 1;
        }
        if(chb32.isSelected()){
            count_select++;
            sum = sum + 2;
            x[1] = 3;
            y[1] = 2;
        }
        if(chb33.isSelected()){
            sum = sum + 1;
            count_select++;
            x[0] = 3;
            y[0] = 3;
        }
        //System.out.println(count_select);
        //System.out.println(sum);
        if(count_select == 4 && sum == 10){
            selectedChb.add(x);
            selectedChb.add(y);
            this.selectedChb = selectedChb;
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.initOwner(this.dialogStage);
            alert.setTitle("Ошибка");
            alert.setHeaderText("Неверный ключ");
            alert.showAndWait();
        }
        dialogStage.close();
    }

    public List<int[]> getSelectedChb() {
        return selectedChb;
    }
}
