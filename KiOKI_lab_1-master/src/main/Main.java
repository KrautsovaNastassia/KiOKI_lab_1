package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application{
    private Stage primaryStage;
    private AnchorPane rootLayout;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws IOException {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Шифратор");
        this.initRootLayout();
    }

    public void initRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/main/MainWindow.fxml"));
            rootLayout = (AnchorPane)loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setTitle("Шифратор");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
            MainWindowController controller = loader.getController();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
