package sample;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;

/**
 * Class that allow to create a student
 *
 * @author: Group HCI BD 34
 *
 * @version 30/04/2021
 */

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

    /**
     * Allow to return string property to print into the table
     * @return name StringProperty
     */
    public StringProperty nameProperty(){return new SimpleStringProperty((String) name);}
    /**
     * Allow to return string property to print into the table
     * @return lastName StringProperty
     */
    public StringProperty lastNameProperty(){return new SimpleStringProperty((String) lastName);}
    /**
     * Allow to return string property to print into the table
     * @return yearOfBirth StringProperty
     */
    public StringProperty dateProperty(){return new SimpleStringProperty((String) String.valueOf(yearOfBirth));}
    /**
     * Allow to return string property to print into the table
     * @return promo StringProperty
     */
    public StringProperty promoProperty(){return new SimpleStringProperty((String) promo.toString());}
    /**
     * Allow to return string property to print into the table.
     * Because student do not need an option but the inheritance Master need
     * Abstract method
     * @return null
     */
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
    public void setOption(Option option){};

}
