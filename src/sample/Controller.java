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

import javax.swing.*;
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
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().dateProperty());
        classColumn.setCellValueFactory(cellData -> cellData.getValue().promoProperty());
        majorColumn.setCellValueFactory(cellData -> cellData.getValue().optionProperty());
        changingWindow.add(cont,0,1);
    }
    private void changeAddStudent(){
        changeWindowsStatus(false);
        changeTitle("Add a Student");
        displayFormStudent(null);
    }
    private void changeEditStudent(){
        Student select = tableView.getSelectionModel().getSelectedItem();
        if(select!=null){
            changeWindowsStatus(false);
            changeTitle("Edit a Student");
            displayFormStudent(select);
        }
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

    private void displayFormStudent(Student stu){
        boolean stuNotNull = (stu != null);
        cont.setVisible(true);
        cont.setStyle("-fx-padding: 20;");
        Label nameLabel = new Label("Enter the student name :");
        TextField name = new TextField();
        if(stuNotNull) {name.setText(stu.getName());}
        Label lastNameLabel = new Label("Enter the student last name :");
        TextField lastName = new TextField();
        if(stuNotNull) {lastName.setText(stu.getLastName());}
        Label yearOfBirthLabel = new Label("Enter the student's year of birth :");
        Spinner yearOfBirth = new Spinner(1900,2021,2021);
        if(stuNotNull) {yearOfBirth.getValueFactory().setValue(stu.getYearOfBirth());}
        /*---------
        * PROMO SELECTION
        * ---------*/
        GridPane promoGroupPane = new GridPane();
        promoGroupPane.setHgap(10);
        Label promoLabel = new Label("Choose the student's class :");
        ToggleGroup promoGroup = new ToggleGroup();
        RadioButton L3radio = new RadioButton(Promotion.L3.toString());
        L3radio.setToggleGroup(promoGroup);
        RadioButton M1radio = new RadioButton(Promotion.M1.toString());
        M1radio.setToggleGroup(promoGroup);
        RadioButton M2radio = new RadioButton(Promotion.M2.toString());
        M2radio.setToggleGroup(promoGroup);
        promoGroupPane.add(L3radio,0,0);
        promoGroupPane.add(M1radio,1,0);
        promoGroupPane.add(M2radio,2,0);
        if(!stuNotNull){
            L3radio.setSelected(true);
        }else{
            String p = stu.getPromo().toString();
            if(p == "L3"){
                L3radio.setSelected(true);
            }else if(p == "M1"){
                M1radio.setSelected(true);
            }else{
                M2radio.setSelected(true);
            }
        }
        /*---------
         * MAJOR SELECTION
         * ---------*/
        Label majorLabel = new Label("Choose the students major :");
        ToggleGroup majorGroup = new ToggleGroup();
        RadioButton bioTechRadio = new RadioButton(Option.BIOTECHNOLOGIE.toString());
        bioTechRadio.setToggleGroup(majorGroup);
        RadioButton imagRadio = new RadioButton(Option.IMAGERIE.toString());
        imagRadio.setToggleGroup(majorGroup);
        RadioButton physioRadio = new RadioButton(Option.PHYSIOLOGIE.toString());
        physioRadio.setToggleGroup(majorGroup);

        if(!stuNotNull || stu.getPromo()==Promotion.L3){
            bioTechRadio.setSelected(true);
            majorLabel.setVisible(false);
            bioTechRadio.setVisible(false);
            imagRadio.setVisible(false);
            physioRadio.setVisible(false);
        }else {
            majorLabel.setVisible(true);
            bioTechRadio.setVisible(true);
            imagRadio.setVisible(true);
            physioRadio.setVisible(true);
            String m = stu.getOption().toString();
            if (m == "BIOTECHNOLOGIE") {
                bioTechRadio.setSelected(true);
            } else if (m == "IMAGERIE") {
                imagRadio.setSelected(true);
            } else {
                physioRadio.setSelected(true);
            }
        }
        promoGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                RadioButton selectedPromo = (RadioButton) promoGroup.getSelectedToggle();
                if (selectedPromo.getText() != "L3"){
                    majorLabel.setVisible(true);
                    bioTechRadio.setVisible(true);
                    imagRadio.setVisible(true);
                    physioRadio.setVisible(true);
                }else{
                    majorLabel.setVisible(false);
                    bioTechRadio.setVisible(false);
                    imagRadio.setVisible(false);
                    physioRadio.setVisible(false);
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
        cont.getChildren().add(yearOfBirth);
        cont.getChildren().add(promoLabel);
        cont.getChildren().add(promoGroupPane);
        cont.getChildren().add(majorLabel);
        cont.getChildren().addAll(bioTechRadio,imagRadio,physioRadio);

        cont.getChildren().add(cancel);
        cancel.setOnAction(e -> changeBackButton());

        cont.getChildren().add(confirm);
        if(stu == null){
            confirm.setOnAction(e -> addValue(name,lastName,yearOfBirth,promoGroup,majorGroup));
        }else{
            confirm.setOnAction(e-> editValue(stu,name,lastName,yearOfBirth,promoGroup,majorGroup));
        }
    }
    private void addValue(TextField name, TextField lastName,Spinner year,ToggleGroup promos,ToggleGroup majors){
        if (name.getText().length() >= 2 & lastName.getText().length() >= 2) {
            String n = name.getText();
            String ln = lastName.getText();
            int y = (int) year.getValue();
            String p = ((RadioButton) promos.getSelectedToggle()).getText();
            String m = ((RadioButton) majors.getSelectedToggle()).getText();
            app.listStudent.addStudent(ln.toUpperCase(), n, y, Promotion.valueOf(p), Option.valueOf(m));
            changeBackButton();
        }
    }
    private void editValue(Student s,TextField name, TextField lastName,Spinner year,ToggleGroup promos,ToggleGroup majors){
        if (name.getText().length() >= 2 & lastName.getText().length() >= 2) {
            s.setName(name.getText());
            s.setLastName(lastName.getText().toUpperCase());
            s.setYearOfBirth((int) year.getValue());
            s.setPromo(Promotion.valueOf(((RadioButton) promos.getSelectedToggle()).getText()));
            System.out.println(s.getClass());
            if (s.getPromo() != Promotion.L3) {
                s.setOption(Option.valueOf(((RadioButton) majors.getSelectedToggle()).getText()));
            } else {
                s.setOption(null);
            }
            tableView.refresh();
        }
        changeBackButton();
    }
}
