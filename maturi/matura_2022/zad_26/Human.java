package matura_2022.zad_26;

public class Human {
    protected final String firstName;
    protected final String lastName;
    protected final int age;

    public Human(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(age < 0){
            throw new IllegalArgumentException("Age cannot be negative");
        }
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("%s %s, %d years old", firstName, lastName, age);
        //Име Фамилия, възраст years old
    }
}
//• firstName (име): знаков низ;
//• lastName(фамилия): знаков низ;
//• age (възраст): цяло число.