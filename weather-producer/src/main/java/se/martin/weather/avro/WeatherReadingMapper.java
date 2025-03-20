package se.martin.weather.avro;

import se.martin.weather.model.Weather;

import java.time.format.DateTimeFormatter;

/**
 * Helper class to map from domain model to Avro generated classes
 */
public class WeatherReadingMapper {

    public static WeatherReading from(Weather weather) {
        return WeatherReading.newBuilder()
                .setRecordingId(weather.getRecordingId().toString())
                .setLocation(from(weather.getLocation()))
                .setObservationTimeUtc(DateTimeFormatter.ISO_DATE_TIME.format(weather.getObservationTimeUtc()))
                .setObservations(from(weather.getObservations()))
                .build();
    }

    private static Location from(Weather.Location location) {
        return Location.newBuilder()
                .setName(location.getName())
                .setStationId(location.getStationId())
                .setLatitude((location.getLatitude()))
                .setLongitude(location.getLongitude())
                .setElevation(location.getElevation())
                .build();
    }

    private static Observations from(Weather.Observations observations) {
        if (observations == null) {
            return null;
        }
        return Observations.newBuilder()
                .setSolarRadiation(observations.getSolarRadiation())
                .setUltraViolet(observations.getUltraViolet())
                .setPrecipitationRate(observations.getPrecipitationRate())
                .setPrecipitationTotal24hh(observations.getPrecipitationTotal24h())
                .setTemperatureCelsius(observations.getTemperatureCelsius())
                .setWindChillCelsius(observations.getWindChillCelsius())
                .setWindSpeed(observations.getWindSpeed())
                .setVisibility(from(observations.getVisibility()))
                .build();
    }

    private static Visibility from(se.martin.weather.model.Visibility visibility) {
        return switch (visibility) {
            case Good -> Visibility.good;
            case Average -> Visibility.average;
            case Poor -> Visibility.poor;
            case Darkness -> Visibility.total_utter_darkness;
        };
    }

}
