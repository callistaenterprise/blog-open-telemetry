package se.martin.weather.model;

import java.time.LocalDateTime;
import java.util.UUID;

public class Weather {

    private UUID recordingId;
    private Location location;
    private LocalDateTime observationTimeUtc;
    private Observations observations;

    public UUID getRecordingId() {
        return recordingId;
    }

    public void setRecordingId(UUID recordingId) {
        this.recordingId = recordingId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocalDateTime getObservationTimeUtc() {
        return observationTimeUtc;
    }

    public void setObservationTimeUtc(LocalDateTime observationTimeUtc) {
        this.observationTimeUtc = observationTimeUtc;
    }

    public Observations getObservations() {
        return observations;
    }

    public void setObservations(Observations observations) {
        this.observations = observations;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "recordingId=" + recordingId +
                ", location=" + location +
                ", observationTimeUtc=" + observationTimeUtc +
                ", observations=" + observations +
                '}';
    }

    public static class Location {
        private String name;
        private String stationId;
        private Double latitude;
        private Double longitude;
        private Double elevation;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStationId() {
            return stationId;
        }

        public void setStationId(String stationId) {
            this.stationId = stationId;
        }

        public Double getLatitude() {
            return latitude;
        }

        public void setLatitude(Double latitude) {
            this.latitude = latitude;
        }

        public Double getLongitude() {
            return longitude;
        }

        public void setLongitude(Double longitude) {
            this.longitude = longitude;
        }

        public Double getElevation() {
            return elevation;
        }

        public void setElevation(Double elevation) {
            this.elevation = elevation;
        }

        @Override
        public String toString() {
            return "Location{" +
                    "name='" + name + '\'' +
                    ", stationId='" + stationId + '\'' +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", elevation=" + elevation +
                    '}';
        }
    }

    public static class Observations {
        private double solarRadiation;
        private double ultraViolet;
        private double precipitationRate;
        private double precipitationTotal24h;
        private double temperatureCelsius;
        private double windChillCelsius;
        private double windSpeed;
        private Visibility visibility;

        public double getSolarRadiation() {
            return solarRadiation;
        }

        public void setSolarRadiation(double solarRadiation) {
            this.solarRadiation = solarRadiation;
        }

        public double getUltraViolet() {
            return ultraViolet;
        }

        public void setUltraViolet(double ultraViolet) {
            this.ultraViolet = ultraViolet;
        }

        public double getPrecipitationRate() {
            return precipitationRate;
        }

        public void setPrecipitationRate(double precipitationRate) {
            this.precipitationRate = precipitationRate;
        }

        public double getPrecipitationTotal24h() {
            return precipitationTotal24h;
        }

        public void setPrecipitationTotal24h(double precipitationTotal24h) {
            this.precipitationTotal24h = precipitationTotal24h;
        }

        public double getTemperatureCelsius() {
            return temperatureCelsius;
        }

        public void setTemperatureCelsius(double temperatureCelsius) {
            this.temperatureCelsius = temperatureCelsius;
        }

        public double getWindChillCelsius() {
            return windChillCelsius;
        }

        public void setWindChillCelsius(double windChillCelsius) {
            this.windChillCelsius = windChillCelsius;
        }

        public double getWindSpeed() {
            return windSpeed;
        }

        public void setWindSpeed(double windSpeed) {
            this.windSpeed = windSpeed;
        }

        public Visibility getVisibility() {
            return visibility;
        }

        public void setVisibility(Visibility visibility) {
            this.visibility = visibility;
        }

        @Override
        public String toString() {
            return "Observations{" +
                    "solarRadiation=" + solarRadiation +
                    ", ultraViolet=" + ultraViolet +
                    ", precipitationRate=" + precipitationRate +
                    ", precipitationTotal24h=" + precipitationTotal24h +
                    ", temperatureCelsius=" + temperatureCelsius +
                    ", windChillCelsius=" + windChillCelsius +
                    ", windSpeed=" + windSpeed +
                    ", visibility=" + visibility +
                    '}';
        }
    }

}
