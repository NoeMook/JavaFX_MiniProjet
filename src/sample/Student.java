package sample;

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
}
