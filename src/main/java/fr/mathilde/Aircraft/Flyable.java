package fr.mathilde.Aircraft;

import fr.mathilde.Tower.*;

public abstract class Flyable {

    protected WeatherTower weatherTower;
    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
    }
    public abstract void updateConditions();
}
