package fr.mathilde.Tower;

import fr.mathilde.Aircraft.Coordinates;

import java.util.Objects;
import java.util.Random;

public class WeatherProvider {
    private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static final WeatherProvider INSTANCE = new WeatherProvider();
    private final Random rand;

    private WeatherProvider(){
        long seed = System.currentTimeMillis();
        this.rand = new Random(seed);
    }

    public static WeatherProvider getInstance(){
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int hash = Objects.hash(
                p_coordinates.getLongitude() / 10,
                p_coordinates.getLatitude() / 10,
                p_coordinates.getHeight() / 10
        );
        int index = Math.abs((hash + rand.nextInt()) % weather.length);
        return weather[index];
    }
}
