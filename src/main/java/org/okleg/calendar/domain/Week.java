package org.okleg.calendar.domain;

import java.util.List;

public class Week {
    private final List<Integer> days;

    public Week(List<Integer> days) {
        if (days.size() != 7) {
            throw new IllegalArgumentException("Неделя должна состоять из 7 дней");
        }
        this.days = List.copyOf(days); // Защита от изменений снаружи (Immutability)
    }

    public List<Integer> getDays() {
        return days;
    }
}
