package fr.mathilde.Aircraft;

import java.util.Objects;

public class Balloon extends Aircraft {
    public Balloon(Long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions(){
        String tmp = weatherTower.getWeather(this.coordinates);
        if (Objects.equals(tmp, "SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 2,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 4);
        }
        else if (Objects.equals(tmp, "RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 5);
        }
        else if (Objects.equals(tmp, "FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 3);
        }
        else if (Objects.equals(tmp, "SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 15);
        }
    }
}
