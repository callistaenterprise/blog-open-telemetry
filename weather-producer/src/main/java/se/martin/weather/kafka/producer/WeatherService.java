package se.martin.weather.kafka.producer;

import jakarta.enterprise.context.ApplicationScoped;
import se.martin.weather.model.Visibility;
import se.martin.weather.model.Weather;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static se.martin.weather.model.Visibility.*;

/**
 * Class to provide randomised weather readings.
 */
@ApplicationScoped
public class WeatherService {

    public Weather fetch(String stationName) {
        var r = ThreadLocalRandom.current();

        var weather = new Weather();
        weather.setRecordingId(UUID.randomUUID());

        var location = new Weather.Location();
        location.setName(stationName);
        location.setStationId(stationId(stationName));
        location.setLatitude(r.nextDouble(-90.0, 90.0));
        location.setLongitude(r.nextDouble(-180.0, 180.0));
        location.setLatitude(r.nextDouble(8000));
        weather.setLocation(location);

        weather.setObservationTimeUtc(LocalDateTime.now());

        var observations = new Weather.Observations();
        observations.setSolarRadiation(r.nextDouble(100.0));
        observations.setUltraViolet(r.nextDouble(80.0));
        observations.setPrecipitationRate(r.nextDouble(10.0));
        observations.setPrecipitationTotal24h(r.nextDouble(200.0));
        observations.setTemperatureCelsius(r.nextDouble(-30.0, +40.0));
        observations.setWindChillCelsius(r.nextDouble(-10.0, 0.0));
        observations.setWindSpeed(r.nextDouble(25.0));
        observations.setVisibility(checkVisibility(r));
        weather.setObservations(observations);

        return weather;
    }

    private final Map<String, String> stationIdCache = new HashMap<>();

    private String stationId(String stationName) {
        if (stationIdCache.containsKey(stationName)) {
            return stationIdCache.get(stationName);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(26));
        }
        var stationId = sb.toString();
        stationIdCache.put(stationName, stationId);
        return stationId;
    }

    /**
     * Create a random visibility reading
     *
     * @param r
     * @return
     */
    private Visibility checkVisibility(ThreadLocalRandom r) {
        var i = r.nextInt(4);
        return switch (i) {
            case 0 -> Good;
            case 1 -> Average;
            case 2 -> Poor;
            default -> Darkness;
        };
    }
}
