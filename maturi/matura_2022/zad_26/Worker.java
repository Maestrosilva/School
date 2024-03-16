package matura_2022.zad_26;

public class Worker extends Human{
    private final double wage;
    private final int workHours;

    public Worker(String firstName, String lastName, int age, double wage, int workHours) {
        super(firstName, lastName, age);
        this.wage = wage;
        this.workHours = workHours;
    }

    public double salary(){
        return wage * workHours;
    }

    @Override
    public String toString(){
        return String.format("%s, salary: $%.2f", super.toString(), salary());
        //Име Фамилия, години years old, salary: $заплата.
    }
}
