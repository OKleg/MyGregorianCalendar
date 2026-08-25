package org.okleg.calendar.serialization;

import org.okleg.calendar.domain.Year;

public interface  CalendarSerializer {
    String serialize(Year year);
}
