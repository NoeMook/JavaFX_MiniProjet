package sample;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class List {
    private ObservableList<Student> studentList;

    public List() {
        this.studentList = FXCollections.observableArrayList();
    }

    public ObservableList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ObservableList<Student> studentList) {
        this.studentList = studentList;
    }

    public void addStudent(String lastName, String name, int yearOfBirth, Promotion promo){
        if (promo == Promotion.L3){
            this.studentList.add(new Student(lastName, name, yearOfBirth, promo));
        }
        else {
            //Scanner userInput = new Scanner(System.in);  // Create a Scanner object
            //System.out.println("Enter option");

            //String option = userInput.nextLine();  // Read user input
            this.studentList.add(new Master(lastName, name, yearOfBirth, promo, null));//Option.valueOf(option.toUpperCase())));
        }
    }

    public void deleteStudent(String name, String lastName) {
        for (Student s : this.studentList) {
            if (s.getName() == name && s.getLastName() == lastName) {
                this.studentList.remove(s);
            }
        }
    }

    public void fillData(){
        addStudent("Dell","Robert", 1999, Promotion.L3);
        addStudent("Domino", "Toto", 1998, Promotion.M1);
        addStudent("Dupont","Pierre", 1997, Promotion.M2);
    }

    public void showStudent(){
        for (Student s:this.studentList) {
            System.out.println(s.getLastName());
            System.out.println(s.getName());
            System.out.println(s.getYearOfBirth());
            System.out.println(s.getPromo());

            if (s.getPromo() != Promotion.L3) {
                System.out.println(s.getOption());
            }
        }
    }
}
