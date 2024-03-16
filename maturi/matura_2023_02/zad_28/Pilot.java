package matura_2023_02.zad_28;

public class Pilot extends Person{

    private Car carp;
    private String category;

    public Pilot(String name, int age, Car carp, String category) {
        super(name, age);
        this.carp = carp;
        this.category = category;
    }

    public Car getCarp() {
        return carp;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("   ");
        sb.append("Name : ").append(name);
        sb.append(System.lineSeparator());
        sb.append("   ");
        sb.append("Age : ").append(age);
        sb.append(System.lineSeparator());
        sb.append("   ");
        sb.append("Category : ").append(category);
        sb.append(System.lineSeparator());
        sb.append("   ");
        sb.append("Car model : ").append(carp.getBrand());
        sb.append(System.lineSeparator());
        sb.append("   ");
        sb.append("Car power : ").append(carp.gethPower());
        sb.append(System.lineSeparator());
        return sb.toString();
    }
}

//- carp (обект от клас Car)
//- category – категория за шофьорска книжка (низ)
//- конструктор, който задава стойности на характеристиките;
//- метод за предефиниране на метода ToString (за C#) / toString (за
//Java) за клас, така че да връща низа:
//„<име>,<възраст>,<категория>,<модел>,<мощност>“