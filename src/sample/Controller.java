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

/**
 * Class that allow to link the buttons and the events
 *
 * @author: Group HCI BD 34
 *
 * @version 30/04/2021
 */

public class Controller extends AnchorPane {
    /**
     * Variable that will contains forms (Add & Edit forms)
     */
    private VBox cont = new VBox(10);
    //FXML components that are needed in the code
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

    //App represent the main App
    private Main app;

    /**
     * A method that initialize the scene, fill the TableView (= table) and
     * set the Action on the three side buttons
     */
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

    /**
     * Method that is triggered by the clicking of the Add Student button
     * since it's impossible to put multiple functions in the setOnAction()
     */
    private void changeAddStudent(){
        changeWindowsStatus(false);
        changeTitle("Add a Student");
        displayFormStudent(null);
    }

    /**
     * Method that is triggered by the clicking of the Edit Student button
     * since it's impossible to put multiple functions in the setOnAction()
     */
    private void changeEditStudent(){
        Student select = tableView.getSelectionModel().getSelectedItem();//Get the selected student in the table
        if(select!=null){ //If no students are selected, no edit can be made
            changeWindowsStatus(false);
            changeTitle("Edit a Student");
            displayFormStudent(select);
        }
    }
    /**
     * Method that allow user to go back to the table view with the displayed data (students)
     */
    private void changeBackButton(){
        changeWindowsStatus(true);
        changeTitle("Student list");
    }

    /**
     * A method that changes the Title of the right Panel
     * @param s : a String that is the Title of the Label @ the top of the windows ("Student list" by default).
     */
    private void changeTitle(String s){
        mainTitle.setText(s);
    }

    /**
     * A method that direct the table setVisible method and empty the form container (cont)
     * @param f : boolean to set the TableView appearance (true : visible & false : not visible)
     */
    private void changeWindowsStatus(boolean f){
        tableView.setVisible(f);
        cont.getChildren().clear();
    }

    /**
     * A method to link the App parameter to the Controller Class
     * @param m : the main app that contains the student list
     */
    public void setMain(Main m){
        this.app = m;
        tableView.setItems(app.listStudent.getStudentList());
    }

    /**
     * Display a form in the main window. Can be a Add or a Edit form.
     * @param stu : student that is going to be displayed in the form (can be Add or Edit form) to have a Add form.
     *            stu variable going to be null to have a AddStudent form
     */
    private void displayFormStudent(Student stu){
        // We check if a student is entered or not
        // (stuNotNull == true -> Edit form
        //  stuNotNull == false -> Add form)
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
        /*---------
         * Listener for the promos radioButtonGroup
         * ---------*/
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

        /*---------
         * ADD ALL COMPONENTS TO CONTAINER (V-box)
         * ---------*/
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

    /**
     * Take the Add form elements and add the student with the data contains in elements.
     * The name.getText() and the lastName.getText() needs to have length greater than 2 characters.
     *
     * @param name : TextField where the name has been entered
     * @param lastName : TextField where the lastName has been entered
     * @param year : Spinner where the yearOfBirth has been entered
     * @param promos : ToggleGroup the group of radio button where the promo has been chose
     * @param majors : ToggleGroup the group of radio button where the majors has been chose
     */
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
    /**
     * Take the Edit form elements and edit the student (s) with the data contains in elements.
     * The name.getText() and the lastName.getText() needs to have length greater than 2 characters.
     *
     * @param s : Student that is going to be edited
     * @param name : TextField where the name has been entered
     * @param lastName : TextField where the lastName has been entered
     * @param year : Spinner where the yearOfBirth has been entered
     * @param promos : ToggleGroup the group of radio button where the promo has been chose
     * @param majors : ToggleGroup the group of radio button where the majors has been chose
     */
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
