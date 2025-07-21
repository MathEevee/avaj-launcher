package fr.mathilde.Aircraft;

import fr.mathilde.Exception.InvalidLessHeight;

import java.util.Objects;

public class Balloon extends Aircraft {
    public Balloon(Long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() throws InvalidLessHeight {
        String tmp = weatherTower.getWeather(this.coordinates);
        if (Objects.equals(tmp, "SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 4);
            System.out.println("Balloon#" + this.name + "(" + this.id + "): Let's enjoy the good weather and take some pics.");
        }
        else if (Objects.equals(tmp, "RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5);
            System.out.println("Balloon#" + this.name + "(" + this.id + "): Damn you rain! You messed up my balloon.");
        }
        else if (Objects.equals(tmp, "FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3);
            System.out.println("Balloon#" + this.name + "(" + this.id + "): I can’t see anything from up here!");
        }
        else {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15);
            System.out.println("Balloon#" + this.name + "(" + this.id + "): It's snowing. We're gonna crash.");

        }
        if (this.coordinates.getHeight() < 0)
        {
            throw new InvalidLessHeight("Balloon#" + this.name + "(" + this.id + ") landing.");
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
