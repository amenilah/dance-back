/*package org.sid.ebankingbackend;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sid.ebankingbackend.models.Event;
import org.sid.ebankingbackend.repository.EventRepo;
import org.sid.ebankingbackend.services.EventServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventServiceImplMockTest {

  @InjectMocks
    private EventServiceImpl eventService;

    @Mock
    private EventRepo eventRepo;

    @Test
    @Order(1)
    public void testEventRateWithMockito() {
        // Arrange
        Event testEvent = new Event();
        testEvent.setId(1L);
        testEvent.setRate(10);
        testEvent.setRateNumber(2);

        Long eventId = testEvent.getId();
        int rate = 5;

        Mockito.when(eventRepo.findById(eventId)).thenReturn(Optional.of(testEvent));
        Mockito.when(eventRepo.save(any(Event.class))).thenReturn(testEvent);

        // Act
        String result = eventService.eventRate(eventId, rate);
        // Assert
        assertEquals(15, testEvent.getRate());
        assertEquals(3, testEvent.getRateNumber());
        assertEquals(5, testEvent.getRateX());
        assertEquals("Thank you", result);

        verify(eventRepo).findById(eventId);
        verify(eventRepo).save(testEvent);
    }
}*/
package org.sid.ebankingbackend;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.sid.ebankingbackend.models.Event;
import org.sid.ebankingbackend.repository.EventRepo;
import org.sid.ebankingbackend.services.EventServiceImpl;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventServiceImplMockTest {

    @InjectMocks
    private EventServiceImpl eventService;

    @Mock
    private EventRepo eventRepo;

    @Test
    @Order(1)
    public void testEventRateWithMockito() {
        // Arrange
        Event testEvent = Event.builder()
                .id(1L)
                .eventDate(new Date())
                .eventName("Sample Event")
                .eventDescription("This is a sample event.")
                .eventAddress("123 Sample Address")
                .rate(10)
                .rateX(0)
                .rateNumber(2)
                .build();

        Long eventId = testEvent.getId();
        int rate = 5;

        Mockito.when(eventRepo.findById(eventId)).thenReturn(Optional.of(testEvent));
        Mockito.when(eventRepo.save(any(Event.class))).thenReturn(testEvent);

        // Act
        String result = eventService.eventRate(eventId, rate);

        // Assert
        assertEquals(15, testEvent.getRate(), "Expected rate to be updated correctly");
        assertEquals(3, testEvent.getRateNumber(), "Expected rate number to increment");
        assertEquals(5, testEvent.getRateX(), "Expected rateX to be updated with new rate");
        assertEquals("Thank you", result, "Expected thank you message");

        verify(eventRepo).findById(eventId);
        verify(eventRepo).save(testEvent);
    }
}

