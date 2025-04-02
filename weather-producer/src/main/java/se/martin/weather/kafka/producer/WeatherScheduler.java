package se.martin.weather.kafka.producer;

import io.quarkus.scheduler.Scheduled;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import se.martin.weather.avro.WeatherReading;
import se.martin.weather.avro.WeatherReadingMapper;
import se.martin.weather.model.Weather;

import java.time.Instant;

/**
 * Class to publish weather readings using Json, Avro and Protobuf
 */
@ApplicationScoped
public class WeatherScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(WeatherScheduler.class);

    @ConfigProperty(name = "se.martin.weather.station.name", defaultValue = "unknown")
    String stationName;

    @Inject
    @Channel("out-weather-avro")
    Emitter<WeatherReading> avroEmitter;


    @Inject
    WeatherService weatherService;

    @Scheduled(every = "1s")
    void generate() {
        var weather = weatherService.fetch(stationName);
        publishAvro(weather);
    }

    private void publishAvro(Weather weather) {
        LOGGER.info("Producing message using Avro with id {}", weather.getRecordingId().toString());
        avroEmitter.send(Message.of(WeatherReadingMapper.from(weather)));
    }

}