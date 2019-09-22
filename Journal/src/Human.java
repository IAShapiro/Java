import java.io.Serializable;

public class Human implements Serializable {
    public String firstName;
    public String lastName;
    public transient String nickName;
    public int age;
    public int salary;

    public Human() {}

    public Human(String firstName, String lastName, String nickName, int age, int salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickName = nickName;
        this.age = age;
        this.salary = salary;
    }

    public void printInfo() {
        System.out.println(this.firstName + " [" + this.nickName + "] " + this.lastName + " (" + this.age + ") - " + this.salary);
    }
}