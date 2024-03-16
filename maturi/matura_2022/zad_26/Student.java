package matura_2022.zad_26;

public class Student extends Human {
    private final double grade;

    public Student(String firstName, String lastName, int age, double grade) {
        super(firstName, lastName, age);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return String.format("%s, grade: %.2f",
                super.toString(), grade);
        //Име Фамилия, възраст years old, grade: оценка
    }
}