package sample;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class that allow to create a master student with an option
 *
 * @author: Group HCI BD 34
 *
 * @version 30/04/2021
 */
public class Master extends Student{

    //create the option attribute
    private Option option;

    /**
     * Create a master
     * @param lastName master's last name
     * @param name master's name
     * @param yearOfBirth master's year of birth
     * @param promo master's promotion
     * @param option master's option
     */
    public Master(String lastName, String name, int yearOfBirth, Promotion promo, Option option) {
        super(lastName, name, yearOfBirth, promo);
        this.option = option;
    }

    /**
     * Permits to return the master's option
     * @return option the master's option
     */
    public Option getOption() {
        return option;
    }

    /**
     * Permits to set the master's ption
     * @param option the new option
     */
    public void setOption(Option option) {
        this.option = option;
    }

    /**
     * Switch the enumerate type into string
     * @return new SimpleStringProperty(r) option enumerate type into string
     */
    public StringProperty optionProperty(){
        String r = "";
        if (option != null){
            r = (String) option.toString();
        }
        return new SimpleStringProperty(r);
    }
}
