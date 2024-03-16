package matura_2023_02.zad_28;

import java.util.LinkedHashSet;
import java.util.Set;

public class Rally {
    private String name;
    private int year;
    private Set<Pilot> pilots;

    public Rally(String name, int year) {
        this.name = name;
        this.year = year;
        pilots = new LinkedHashSet<>();
    }
    public void addParticipant(Pilot pilot){
        pilots.add(pilot);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(System.lineSeparator());
        sb.append("Rally: ").append(System.lineSeparator())
                .append(name).append(" - ").append(year);
        sb.append(System.lineSeparator());
        sb.append(System.lineSeparator());
        sb.append("Participants: ");
        pilots.forEach(pilot -> {
            sb.append(System.lineSeparator());
            sb.append(pilot);
        }
        );
        return sb.toString();
    }
}

//На първия ред да се извежда текста:
//„Rally: < име на ралито> - < година на провеждане >”
//Следващите редове съдържат данни за участниците в ралито. Всеки ред съдържа
//данни за един участник във формат:
//„<име>,<възраст>,<категория>,<модел>,<мощност>“


//name - име на ралито (низ),
//- year - година на провеждане (цяло число)
//- pilots - списък от участници от клас Pilot
//- конструктор, който задава стойности на характеристиките name и year и
//създава празен списък от участници.;
//- метод за добавяне на участник
//- метод за извеждане на стандартния изход на информация за ралито във вида: