package fr.mathilde;

import fr.mathilde.Aircraft.AircraftFactory;
import fr.mathilde.Aircraft.Coordinates;
import fr.mathilde.Aircraft.Flyable;
import fr.mathilde.Tower.WeatherTower;


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        WeatherTower weatherTower = new WeatherTower();

        Flyable balloon = AircraftFactory.newAircraft("Balloon", "B1", new Coordinates(10, 20, 30));
        Flyable jetPlane = AircraftFactory.newAircraft("JetPlane", "J1", new Coordinates(15, 25, 35));
        Flyable helicopter = AircraftFactory.newAircraft("Helicopter", "H1", new Coordinates(20, 30, 40));

        balloon.registerTower(weatherTower);
        jetPlane.registerTower(weatherTower);
        helicopter.registerTower(weatherTower);

        int simulationCount = 150;

        for (int i = 0; i < simulationCount; i++) {
                weatherTower.changeWeather();
        }
    }
}