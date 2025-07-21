package fr.mathilde.Aircraft;
import fr.mathilde.Exception.InvalidAircraft;

public class AircraftFactory {
    private static long id = 0;

    private static long nextId() {
        return ++id;
    }

    public static Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) throws InvalidAircraft {
        Flyable flyable;
        long new_id = nextId();
        switch (p_type) {
            case "Balloon":
                flyable = new Balloon(new_id, p_name, p_coordinates);
                break;
            case "Helicopter":
                flyable = new Helicopter(new_id, p_name, p_coordinates);
                break;
            case "JetPlane":
                flyable = new JetPlane(new_id, p_name, p_coordinates);
                break;
            default:
                return null;
        }
        return flyable;
    }
}
