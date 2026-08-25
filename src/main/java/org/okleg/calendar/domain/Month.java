package org.okleg.calendar.domain;
import java.time.YearMonth;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Month {
    private final String name;
    private final List<Week> weeks;

    public Month(int year, int monthNumber) {
        YearMonth yearMonth = YearMonth.of(year, monthNumber);
        this.name = yearMonth.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")).toUpperCase();
        this.weeks = buildWeeks(yearMonth);
    }

    private List<Week> buildWeeks(YearMonth yearMonth) {
        List<Week> generatedWeeks = new ArrayList<>();
        List<Integer> currentWeekDays = new ArrayList<>();
        //
        int firstDayOfWeek = yearMonth.atDay(1).getDayOfWeek().getValue();

        for (int i = 1; i < firstDayOfWeek; i++) {
            currentWeekDays.add(0);
        }
        //
        int daysInMonth = yearMonth.lengthOfMonth();
        for (int day = 1; day <= daysInMonth; day++) {
            currentWeekDays.add(day);

            if (currentWeekDays.size() == 7) {
                generatedWeeks.add(new Week(currentWeekDays));
                currentWeekDays = new ArrayList<>();
            }
        }

        // Дозаполняем последнюю неделю
        if (!currentWeekDays.isEmpty()) {
            while (currentWeekDays.size() < 7) {
                currentWeekDays.add(0);
            }
            generatedWeeks.add(new Week(currentWeekDays));
        }

        return List.copyOf(generatedWeeks);
    }

    public String getName() { return name; }
    public List<Week> getWeeks() { return weeks; }
}
