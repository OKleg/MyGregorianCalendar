package org.okleg.calendar.domain;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

public class Year {
    private final int value;
    private final List<Month> months;

    public Year(int value) {
        if (value < 1) {
            throw new IllegalArgumentException("Год должен быть больше нуля");
        }
        this.value = value;
        this.months = new ArrayList<>();

        // Объект сам инициализирует свое внутреннее состояние
        for (int m = 1; m <= 12; m++) {
            this.months.add(new Month(value, m));
        }
    }

    public boolean isLeap() {
        if (value % 4 != 0) {
            return false;
        }
        else if (value % 100 != 0) {
            return true;
        }
        else {
            return value % 400 == 0;
        }
//        return java.time.Year.of(value).isLeap();
    }

    public int getValue() { return value; }
    public List<Month> getMonths() { return months; }
}
