package sample;

import sample.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Class that allow to start the application
 *
 * @author: Group HCI BD 34
 *
 * @version 30/04/2021
 */

public class Main extends Application {
    public List listStudent = new List();
    @Override
    public void start(Stage primaryStage) throws Exception{
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML/sample.fxml")); //join an fxml file
            Parent root = loader.load();
            primaryStage.setTitle("Gphy Manager"); //Name of the window
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            listStudent.fillData(); //fill the data for the tests
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
