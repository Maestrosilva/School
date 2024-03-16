package matura_2023_02.zad_28;

public class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
////name – име на участника (низ)
////- age – възраст (цяло число)