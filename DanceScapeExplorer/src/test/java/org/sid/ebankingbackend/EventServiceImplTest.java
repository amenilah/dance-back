/*package org.sid.ebankingbackend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.sid.ebankingbackend.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.sid.ebankingbackend.models.Event;
import org.sid.ebankingbackend.services.EventServiceImpl;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventServiceImplTest {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private EventRepo eventRepo;

    @Test
    @Order(1)
    public void testEventRate() {
        // Arrange
        Event testEvent = new Event();
        testEvent.setId(1L);
        testEvent.setRate(10);
        testEvent.setRateNumber(2);

        eventRepo.save(testEvent);

        Long eventId = testEvent.getId();
        int rate = 5;

        // Act
        String result = eventService.eventRate(eventId, rate);

        Event updatedEvent = eventRepo.findById(eventId).orElseThrow();

        // Assert
        assertEquals(15, updatedEvent.getRate());
        assertEquals(3, updatedEvent.getRateNumber());
        assertEquals(5, updatedEvent.getRateX());
        assertEquals("Thank you", result);
    }
}*/
package org.sid.ebankingbackend;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer;
import org.sid.ebankingbackend.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.sid.ebankingbackend.models.Event;
import org.sid.ebankingbackend.services.EventServiceImpl;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest/*(properties = "spring.config.location=classpath:application-test.properties")*/
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EventServiceImplTest {

    @Autowired
    private EventServiceImpl eventService;

    @Autowired
    private EventRepo eventRepo;

    @Test
    @Order(1)
    public void testEventRate() {
        // Arrange
        Event testEvent = Event.builder()
                .id(1L)
                .rate(10)
                .rateNumber(2)
                .build();

        eventRepo.save(testEvent);

        Long eventId = testEvent.getId();
        int rate = 5;

        // Act
        String result = eventService.eventRate(eventId, rate);

        Event updatedEvent = eventRepo.findById(eventId).orElseThrow();

        // Assert
        assertEquals(15, updatedEvent.getRate(), "Expected rate to be updated correctly");
        assertEquals(3, updatedEvent.getRateNumber(), "Expected rate number to increment");
        assertEquals(5, updatedEvent.getRateX(), "Expected rateX to be updated with new rate");
        assertEquals("Thank you", result, "Expected thank you message");
    }
}
