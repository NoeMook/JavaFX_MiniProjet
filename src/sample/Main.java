package sample;

import sample.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class Main extends Application {
    public List listStudent = new List();
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/sample.fxml"));
            Parent root = loader.load();
            primaryStage.setTitle("Gphy Manager");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            listStudent.fillData();
            Controller controller = loader.getController();
            controller.setMain(this);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}
