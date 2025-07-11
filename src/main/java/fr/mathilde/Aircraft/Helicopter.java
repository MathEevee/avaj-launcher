package fr.mathilde.Aircraft;

import java.util.Objects;

public class Helicopter extends Aircraft {
    public Helicopter(Long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions(){
        String tmp = weatherTower.getWeather(this.coordinates);
        if (Objects.equals(tmp, "SUN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() + 2);
        }
        else if (Objects.equals(tmp, "RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight());
        }
        else if (Objects.equals(tmp, "FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1,
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight());
        }
        else if (Objects.equals(tmp, "SNOW")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 12);
        }

    }
}
