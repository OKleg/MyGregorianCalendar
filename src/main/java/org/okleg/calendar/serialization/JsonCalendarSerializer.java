package org.okleg.calendar.serialization;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.okleg.calendar.domain.Year;

public class JsonCalendarSerializer implements CalendarSerializer  {
    private final ObjectMapper objectMapper;

    public JsonCalendarSerializer() {
        this.objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    }

    @Override
    public String serialize(Year year) {
        try {
            return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(year);
        } catch (Exception e) {
            throw new RuntimeException("Ошибка сериализации календаря", e);
        }
    }
}
