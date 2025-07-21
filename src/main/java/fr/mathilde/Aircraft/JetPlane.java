package fr.mathilde.Aircraft;

import fr.mathilde.Exception.InvalidLessHeight;

import java.util.Objects;

public class JetPlane extends Aircraft {
    public JetPlane(Long p_id, String p_name, Coordinates p_coordinates) {
        super(p_id, p_name, p_coordinates);
    }
    public void updateConditions() throws InvalidLessHeight {
        String tmp = weatherTower.getWeather(this.coordinates);
        if (Objects.equals(tmp, "SUN"))
        {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 10,
                    this.coordinates.getHeight() + 2);
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): Clear skies and smooth flying ahead.");
        }
        else if (Objects.equals(tmp, "RAIN")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 5,
                    this.coordinates.getHeight());
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): Heavy rain pouring, staying alert.");
        }
        else if (Objects.equals(tmp, "FOG")) {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude() + 1,
                    this.coordinates.getHeight());
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): Can't see the runway through this fog.");
        }
        else {
            this.coordinates = new Coordinates(this.coordinates.getLongitude(),
                    this.coordinates.getLatitude(),
                    this.coordinates.getHeight() - 7);
            System.out.println("JetPlane#" + this.name + "(" + this.id + "): Snow is falling fast, descending carefully.");
        }

        if (this.coordinates.getHeight() < 0)
        {
            throw new InvalidLessHeight("JetPlane#" + this.name + "(" + this.id + ") has reached ground level.");
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
