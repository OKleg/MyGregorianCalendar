package org.okleg.calendar;

import org.okleg.calendar.domain.Year;
import org.okleg.calendar.serialization.CalendarSerializer;
import org.okleg.calendar.serialization.JsonCalendarSerializer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int inputYear = 1930;

        // Создаем бизнес-объект
        Year calendarYear = new Year(inputYear);

        // Выбираем стратегию отображения (Полиморфизм)
        CalendarSerializer serializer = new JsonCalendarSerializer();

        // Печатаем результат
        System.out.println(serializer.serialize(calendarYear));
    }
}