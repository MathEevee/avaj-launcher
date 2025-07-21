package fr.mathilde.Aircraft;

import fr.mathilde.Exception.InvalidLessHeight;

import java.util.Objects;

public class Helicopter extends Aircraft {
    public Helicopter(Long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() throws InvalidLessHeight {
        String tmp = weatherTower.getWeather(this.coordinates);
        if (Objects.equals(tmp, "SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2);
            System.out.println("Helicopter#" + name + "(" + id + "): Smooth flying in this sunshine.");
        }
        else if (Objects.equals(tmp, "RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight());
            System.out.println("Helicopter#" + name + "(" + id + "): Blades getting hammered by rain.");
        }
        else if (Objects.equals(tmp, "FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight());
            System.out.println("Helicopter#" + name + "(" + id + "): Navigating blind in this fog.");
        }
        else {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12);
            System.out.println("Helicopter#" + name + "(" + id + "): My rotor is going to freeze!");
        }
        if (this.coordinates.getHeight() < 0)
        {
            throw new InvalidLessHeight("Helicopter#" + this.name + "(" + this.id + ") is landing safely.");
        }

    }
    @Override
    public long getId() {
        return this.id;
    }
    @Override
    public String getName() {
        return this.name;
    }
}
