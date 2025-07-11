package fr.mathilde.Aircraft;

public abstract class Aircraft extends Flyable {
    protected Long id;
    protected String name;
    protected Coordinates coordinates;


    protected Aircraft(Long p_id, String p_name, Coordinates p_coordinates) {
        this.id = p_id;
        this.name = p_name;
        this.coordinates = p_coordinates;
    }



    @Override
    public abstract void updateConditions();
}
