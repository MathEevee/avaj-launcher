package fr.mathilde.Tower;

import fr.mathilde.Aircraft.Coordinates;

public class WeatherTower extends Tower {
    public WeatherTower() {
        super();
    }
    public String getWeather(Coordinates p_coordinates) {
        return (WeatherProvider.getInstance().getCurrentWeather(p_coordinates));
    }
    public void changeWeather() {
        this.conditionChange();
    }
}
