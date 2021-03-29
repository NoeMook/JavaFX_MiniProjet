package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Student {
    private StringProperty lastName;
    private StringProperty name;
    private int yearOfBirth;
    private Promotion promo;

    public Student(String lastName, String name, int yearOfBirth, Promotion promo) {
        setLastName(lastName);
        setName(name);
        this.yearOfBirth = yearOfBirth;
        this.promo = promo;
    }


    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lastName) {
        this.lastName = new SimpleStringProperty(lastName);
    }

    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty(){return name;}
    public StringProperty lastNameProperty(){return lastName;}


    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public Promotion getPromo() {
        return promo;
    }

    public void setPromo(Promotion promo) {
        this.promo = promo;
    }

    public Option getOption(){
        return null;
    }

}
