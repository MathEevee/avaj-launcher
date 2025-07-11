package fr.mathilde.Aircraft;

public class AircraftFactory {
    private static Long id;
    
    public Flyable newAircraft(String p_type, String p_name, Coordinates p_coordinates) {
        Flyable flyable;
        switch (p_type) {
            case "Balloon":
                flyable = new Balloon(NextId(), p_name, p_coordinates);
                break;
            case "Helicopter":
                flyable = new Helicopter(NextId(), p_name, p_coordinates);
                break;
            case "JetPlane":
                flyable = new JetPlane(NextId(), p_name, p_coordinates);
                break;
            default:
                flyable = null;
        }
        return flyable;
    }
    private Long NextId()
    {
        ++id;
        return id;
    }

}
