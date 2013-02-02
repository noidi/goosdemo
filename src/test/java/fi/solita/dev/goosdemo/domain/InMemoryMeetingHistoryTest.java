package fi.solita.dev.goosdemo.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class InMemoryMeetingHistoryTest {

    private InMemoryMeetingHistory inMemoryMeetingHistory = new InMemoryMeetingHistory();

    @Test
    public void shouldContainZeroMeetingsWithUnknownPeople() {
        assertEquals(0, inMemoryMeetingHistory.timesMet("Unknown"));
    }

    @Test
    public void shouldIncreaseMeetingCountWhenPersonMet() {
        // When
        inMemoryMeetingHistory.personMet("Bob");

        // Then
        assertEquals(1, inMemoryMeetingHistory.timesMet("Bob"));
    }

}
