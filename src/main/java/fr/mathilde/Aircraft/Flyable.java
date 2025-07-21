package fr.mathilde.Aircraft;

import fr.mathilde.Exception.InvalidLessHeight;
import fr.mathilde.Tower.*;

public abstract class Flyable {

    protected WeatherTower weatherTower;

    public abstract long getId();
    public abstract String getName();

    public void registerTower(WeatherTower p_tower) {
        this.weatherTower = p_tower;
        this.weatherTower.register(this);
    }

    public abstract void updateConditions() throws InvalidLessHeight;

}
