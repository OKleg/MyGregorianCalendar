package org.okleg.calendar;
import org.junit.jupiter.api.Test;
import org.okleg.calendar.domain.Month;
import org.okleg.calendar.domain.Week;
import org.okleg.calendar.domain.Year;

import static org.junit.jupiter.api.Assertions.*;

public class CalendarTest {
    @Test
    void testYearEncapsulationAndLeapLogic() {
        Year leapYear = new Year(2024);
        Year normalYear = new Year(2026);

        assertTrue(leapYear.isLeap(), "2024 должен быть високосным");
        assertFalse(normalYear.isLeap(), "2026 не должен быть високосным");

        assertEquals(12, leapYear.getMonths().size(), "В году должно быть 12 месяцев");
    }

    @Test
    void testMonthCreatesValidWeeks() {
        Month january = new Month(2026, 1);

        assertEquals("ЯНВАРЯ", january.getName());
        assertFalse(january.getWeeks().isEmpty());

        for (Week week : january.getWeeks()) {
            assertEquals(7, week.getDays().size());
        }
    }

    @Test
    void testInvalidYearThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new Year(-5));
    }

    private int countFebruaryDays(Year year) {
        Month february = year.getMonths().get(1); // Индекс 1 — это Февраль
        int count = 0;
        for (var week : february.getWeeks()) {
            for (int day : week.getDays()) {
                if (day > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    @Test
    void testTemplate1_NormalYearStartsOnMonday() {
        Year year = new Year(2018);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate2_NormalYearStartsOnTuesday() {
        Year year = new Year(2019);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate3_NormalYearStartsOnWednesday() {
        Year year = new Year(2025);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate4_NormalYearStartsOnThursday() {
        Year year = new Year(2026);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate5_NormalYearStartsOnFriday() {
        Year year = new Year(2021);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate6_NormalYearStartsOnSaturday() {
        Year year = new Year(2022);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate7_NormalYearStartsOnSunday() {
        Year year = new Year(2023);
        assertFalse(year.isLeap());
        assertEquals(28, countFebruaryDays(year));
    }

    @Test
    void testTemplate8_LeapYearStartsOnMonday() {
        Year year = new Year(1996);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate9_LeapYearStartsOnTuesday() {
        Year year = new Year(2024);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate10_LeapYearStartsOnWednesday() {
        Year year = new Year(2008);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate11_LeapYearStartsOnThursday() {
        Year year = new Year(2020);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate12_LeapYearStartsOnFriday() {
        Year year = new Year(2032);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate13_LeapYearStartsOnSaturday() {
        Year year = new Year(2016);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }

    @Test
    void testTemplate14_LeapYearStartsOnSunday() {
        Year year = new Year(2000);
        assertTrue(year.isLeap());
        assertEquals(29, countFebruaryDays(year));
    }
}
