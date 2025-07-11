package fr.mathilde.Tower;

import fr.mathilde.Aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {
    private final String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};
    private static final WeatherProvider INSTANCE = new WeatherProvider();

    private WeatherProvider(){
    }

    public static WeatherProvider getInstance(){
        return INSTANCE;
    }

    public String getCurrentWeather(Coordinates p_coordinates) {
        int index = new Random().nextInt(weather.length - 1);
        return (weather[index]);
    }
}
