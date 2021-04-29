package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

public class Student {
    private String lastName;
    private String name;
    private int yearOfBirth;
    private Promotion promo;

    public Student(String lastName, String name, int yearOfBirth, Promotion promo) {
        this.lastName = lastName;
        this.name = name;
        this.yearOfBirth = yearOfBirth;
        this.promo = promo;
    }


    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }
    public StringProperty nameProperty(){return new SimpleStringProperty((String) name);}
    public StringProperty lastNameProperty(){return new SimpleStringProperty((String) lastName);}
    public StringProperty dateProperty(){return new SimpleStringProperty((String) String.valueOf(yearOfBirth));}
    public StringProperty promoProperty(){return new SimpleStringProperty((String) promo.toString());}
    public StringProperty optionProperty(){return null;}


    public void setName(String name) {
        this.name = name;
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
