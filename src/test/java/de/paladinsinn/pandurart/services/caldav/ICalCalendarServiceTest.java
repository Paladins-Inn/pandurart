package de.paladinsinn.pandurart.services.caldav;


import de.paladinsinn.pandurart.config.HateoasConfig;
import de.paladinsinn.pandurart.config.LocationConfig;
import de.paladinsinn.pandurart.config.RestClientConfig;
import de.paladinsinn.pandurart.domain.api.calendars.Calendar;
import de.paladinsinn.pandurart.domain.api.calendars.CalendarException;
import de.paladinsinn.pandurart.domain.api.events.Event;
import de.paladinsinn.pandurart.domain.model.calendars.ICalCalendar;
import de.paladinsinn.pandurart.domain.model.importers.NullAuthentication;
import de.paladinsinn.pandurart.persistence.locations.LocationMapperImpl;
import de.paladinsinn.pandurart.persistence.mapper.DisplayTextMapperImpl;
import de.paladinsinn.pandurart.persistence.mapper.ExternalIdMapperImpl;
import de.paladinsinn.pandurart.persistence.mapper.OwnerMapperImpl;
import de.paladinsinn.pandurart.persistence.mapper.TemporalConverter;
import de.paladinsinn.pandurart.persistence.mapper.TimeSpecMapperImpl;
import de.paladinsinn.pandurart.persistence.persons.PersonMapperImpl;
import de.paladinsinn.pandurart.services.geo.GeoCoordinateMapperImpl;
import de.paladinsinn.pandurart.services.geo.GeocodeMapsCoClient;
import de.paladinsinn.pandurart.services.geo.GeocodingService;
import de.paladinsinn.pandurart.services.geo.LocationService;
import java.time.Duration;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.data.jpa.autoconfigure.DataJpaRepositoriesAutoConfiguration;
import org.springframework.boot.hibernate.autoconfigure.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;

/**
 *
 *
 * @author klenkes74 {@literal <rlichti@kaiserpfalz-edv.de>}
 * @since 2025-10-12
 */
//TODO 2025-10-19 klenkes74: Add tests with wiremock for this
@Disabled("Only for manual smoke check")
@SpringBootTest(classes = {
    RestClientConfig.class,
    LocationConfig.class,
    HateoasConfig.class,
    ICalCalendarService.class,
    GeocodingService.class,
    GeocodeMapsCoClient.class,
    GeoCoordinateMapperImpl.class,
    LocationService.class,
    VEventMapperImpl.class,
    LocationMapperImpl.class,
    ExternalIdMapperImpl.class,
    OwnerMapperImpl.class,
    PersonMapperImpl.class,
    TimeSpecMapperImpl.class,
    DisplayTextMapperImpl.class,
    TemporalConverter.class
})
@Profile("test")
@ImportAutoConfiguration(
    exclude = {
        DataJpaRepositoriesAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
    }
)
@Slf4j
public class ICalCalendarServiceTest {
  private static final String CALENDAR_URL = "https://calendar.google.com/calendar/ical/88fb7669d9909b5ae6a8ac88c09526c3c09ff0ac32e840363094c2e758e4dd12@group.calendar.google.com/public/basic.ics";
  
  private static final Calendar calender = ICalCalendar
      .builder()
      .calendarId(CALENDAR_URL)
      .owner("ich")
      .syncPeriod(Duration.ZERO)
      .authentication(NullAuthentication.builder().build())
      .build();
  
  @Autowired
  private ICalCalendarService sut;

  
  @Test
  public void CalendarShouldBeDownloadedFromGoogleWhenSyncIsStarted() throws CalendarException {
    log.trace("enter - ");
    
    List<Event> result = sut.getEvents(calender);
    
    log.info("Result: {}", result);
    
    log.trace("exit - ");
  }
}
