package org.okleg.calendar.serialization;

import org.okleg.calendar.domain.Year;
import org.okleg.calendar.domain.Month;
import org.okleg.calendar.domain.Week;

public class ConsoleCalendarSerializer implements CalendarSerializer {

    @Override
    public String serialize(Year year) {
        StringBuilder sb = new StringBuilder();

        // Красивая шапка
        sb.append("=========================================\n");
        sb.append("       КАЛЕНДАРЬ НА ").append(year.getValue()).append(" ГОД\n");
        sb.append("=========================================\n\n");

        // Выводим последовательно каждый месяц
        for (Month month : year.getMonths()) {
            sb.append("----- ").append(month.getName()).append("-----");
            sb.append(" Пн  Вт  Ср  Чт  Пт  Сб  Вс\n");

            for (Week week : month.getWeeks()) {
                for (int day : week.getDays()) {
                    if (day == 0) {
                        sb.append("    "); // Вместо нулей печатаем пустые отступы
                    } else {
                        sb.append(String.format("%3d ", day)); // Красивое выравнивание чисел
                    }
                }
                sb.append("\n");
            }
            sb.append("\n"); // Отступ между месяцами
        }

        return sb.toString();
    }
}