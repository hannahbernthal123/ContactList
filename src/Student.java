//Hannah Bernthal
public class Student extends Person {
    private int grade;

    public Student(String firstName, String lastName, String phoneNumber, int grade) {
        super (firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    //These are the getter and setter methods.
    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    //This toString() returns the students's first name, last name, and phone number calling the person's toString() with super.
    //It also returns the grade.
    @Override
    public String toString() {
        return super.toString() + " Grade: " + grade;
    }
}
