package org.okleg.calendar;

import org.okleg.calendar.domain.Year;
import org.okleg.calendar.serialization.CalendarSerializer;
import org.okleg.calendar.serialization.ConsoleCalendarSerializer;
import org.okleg.calendar.serialization.JsonCalendarSerializer;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Подключаем чтение из консоли
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер года: ");
        if (scanner.hasNextInt()) {
            int inputYear = scanner.nextInt();

            Year calendarYear = new Year(inputYear);

            //CalendarSerializer serializer = new JsonCalendarSerializer();
            CalendarSerializer serializer = new ConsoleCalendarSerializer();

            String jsonResult = serializer.serialize(calendarYear);

            System.out.println(jsonResult);

        } else {
            System.out.println("Ошибка: Пожалуйста, введите корректный номер года численного формата.");
        }

    }
}