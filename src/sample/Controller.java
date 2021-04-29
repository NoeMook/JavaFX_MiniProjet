package sample;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class Controller extends AnchorPane {
    @FXML
    private Label mainTitle;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private Button deleteButton;
    @FXML
    private TableView<Student> tableView;
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
        addButton.setOnAction(e -> changeTitle("Add a Student"));
        editButton.setOnAction(e -> changeTitle("Edit a Student"));
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    }

    private void changeTitle(String s){
        mainTitle.setText(s);
    }

    public void setMain(Main m){
        this.app = m;
        tableView.setItems(app.listStudent.getStudentList());
    }

}
