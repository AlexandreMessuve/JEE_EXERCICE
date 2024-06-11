package exercice03.exercice03.entity;

public class Person {
    private String lastname;
    private String firstname;
    private int age;

    public Person(String lastname, String firstname, int age) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.age = age;
    }
    public Person() {}
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
