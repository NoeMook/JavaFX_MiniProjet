package sample;

import com.sun.javafx.scene.control.IntegerField;
import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import sample.Main;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;

import javax.swing.text.Position;
import java.util.Calendar;

public class Controller extends AnchorPane {
    public VBox cont = new VBox(10);
    @FXML
    private Label mainTitle;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button backButton;
    @FXML
    private TableView<Student> tableView;
    @FXML
    private GridPane changingWindow;
    @FXML
    private TableColumn<Student, RadioButton> checkColumn;
    @FXML
    private TableColumn<Student, String> firstNameColumn;
    @FXML
    private TableColumn<Student, String> lastNameColumn;
    @FXML
    private TableColumn<Student, String> dateColumn;
    @FXML
    private TableColumn<Student, String> classColumn;
    @FXML
    private TableColumn<Student, String> majorColumn;

    private Main app;

    public void initialize(){
        addButton.setOnAction(e -> changeAddStudent());
        editButton.setOnAction(e -> changeEditStudent());
        backButton.setOnAction(e -> changeBackButton());
        //changingWindows = 1 column & 2 rows
        changingWindow.add(cont,0,1);

        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        classColumn.setCellValueFactory(cellData -> cellData.getValue().promoProperty());
        majorColumn.setCellValueFactory(cellData -> cellData.getValue().optionProperty());

    }
    private void changeAddStudent(){
        changeWindowsStatus(false);
        changeTitle("Add a Student");
        displayAddStudent();
    }
    private void changeEditStudent(){
        changeWindowsStatus(false);
        changeTitle("Edit a Student");
    }
    private void changeBackButton(){
        changeWindowsStatus(true);
        changeTitle("Student list");
    }
    private void changeTitle(String s){
        mainTitle.setText(s);
    }
    private void changeWindowsStatus(boolean f){
        tableView.setVisible(f);
        cont.getChildren().clear();
    }

    public void setMain(Main m){
        this.app = m;
        tableView.setItems(app.listStudent.getStudentList());
    }

    private void displayAddStudent(){
        cont.setVisible(true);
        Label nameLabel = new Label("Enter the student name :");
        TextField name = new TextField();
        Label lastNameLabel = new Label("Enter the student last name :");
        TextField lastName = new TextField();
        Label yearOfBirthLabel = new Label("Enter the student's year of birth :");
        //IntegerField yearOfBirth = new IntegerField();
        //-------
        Label promoLabel = new Label("Choose the student's class :");
        ToggleGroup promoGroup = new ToggleGroup();
        RadioButton L3radio = new RadioButton(Promotion.L3.toString());
        L3radio.setToggleGroup(promoGroup);
        L3radio.setSelected(true);
        RadioButton M1radio = new RadioButton(Promotion.M1.toString());
        M1radio.setToggleGroup(promoGroup);
        RadioButton M2radio = new RadioButton(Promotion.M2.toString());
        M2radio.setToggleGroup(promoGroup);

        promoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                if (promoGroup.getSelectedToggle().toString() != "L3"){

                }
            }
        });

        Button cancel = new Button("Cancel");
        Button confirm = new Button("Confirm");


        cont.getChildren().add(nameLabel);
        cont.getChildren().add(name);
        cont.getChildren().add(lastNameLabel);
        cont.getChildren().add(lastName);
        cont.getChildren().add(yearOfBirthLabel);
        //cont.getChildren().add(yearOfBirth);
        cont.getChildren().add(promoLabel);
        cont.getChildren().addAll(L3radio,M1radio,M2radio);

        cont.getChildren().add(cancel);
        cont.getChildren().add(confirm);
    }
    private void displayEditStudent(){

    }

}
