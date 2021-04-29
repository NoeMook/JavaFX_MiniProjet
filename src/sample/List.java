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
        if (promo == Promotion.L3) {
            this.studentList.add(new Student(lastName, name, yearOfBirth, promo));
        }
    }
    public void addStudent(String lastName, String name, int yearOfBirth, Promotion promo, Option opt){
        if (promo == Promotion.L3){
            this.studentList.add(new Student(lastName, name, yearOfBirth, promo));
        }else {
            this.studentList.add(new Master(lastName, name, yearOfBirth, promo, opt));
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
        addStudent("Domino", "Toto", 1998, Promotion.M1,Option.BIOTECHNOLOGIE);
        addStudent("Dupont","Pierre", 1997, Promotion.M2,Option.IMAGERIE);
    }
}
