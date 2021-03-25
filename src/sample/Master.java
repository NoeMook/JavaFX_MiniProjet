package sample;
import java.util.ArrayList;

public class Master extends Student{
    private Option option;
    private ArrayList<Student> studentList;

    public Master(String lastName, String name, int yearOfBirth, Promotion promo, Option option) {
        super(lastName, name, yearOfBirth, promo);
        this.option = option;
        this.studentList = new ArrayList<Student>();
    }

    public Option getOption() {
        return option;
    }

    public void setOption(Option option) {
        this.option = option;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public void fillData(){
        studentList.add(new Student("Nanie", "Gelet", 1999, Promotion.L3));
        studentList.add(new Master("Domino", "Gelet", 1998, Promotion.M1, Option.Biotechnologie));
        studentList.add(new Master("Lalan", "Fou", 1997, Promotion.M2, Option.Imagerie));
    }

    public void deletStudent(String name, String lastName){
        for (Student s:studentList) {
            if (s.getName() == name && s.getLastName() == lastName) {
                studentList.remove(s);
            }
        }
    }
}
