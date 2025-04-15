package se.martin.weather.avro;

import org.junit.jupiter.api.Test;
import se.martin.weather.model.Weather;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherReadingMapperTest {

    @Test
    public void testMapping() throws IOException {
        // Create a location - leave out the elevation
        Weather.Location location = new Weather.Location();
        location.setStationId("XXXADK123");
        location.setLongitude(Double.valueOf(10.0));
        location.setLatitude(Double.valueOf(54.0));

        // Create a weather object
        var weather = new Weather();
        weather.setRecordingId(UUID.randomUUID());
        weather.setLocation(location);
        weather.setObservationTimeUtc(LocalDateTime.now());

        // Map to avro object
        WeatherReading weatherReading = WeatherReadingMapper.from(weather);

        // Check the avro object
        assertNotNull(weatherReading.getLocation());
        assertEquals(location.getLongitude(), weatherReading.getLocation().getLongitude());
        assertEquals(location.getLatitude(), weatherReading.getLocation().getLatitude());
        assertNull(weatherReading.getLocation().getElevation());
    }
}
