package matura_2023_02.zad_28;

public class Car {
    private String brand;
    private int hPower;

    public Car(String brand, int hPower) {
        this.brand = brand;
        this.hPower = hPower;
    }

    public String getBrand() {
        return brand;
    }

    public int gethPower() {
        return hPower;
    }

    @Override
    public String toString() {
        return brand + ", " + hPower;
    }
}
//brand - модел (низ)
//- hPower – мощност в конски сили (цяло число)
//- конструктор, който задава стойности на характеристиките;
//- метод за предефиниране на метода ToString (за C#) / toString (за
//Java) за клас, така че да връща низа: „<модел>,<мощност>“