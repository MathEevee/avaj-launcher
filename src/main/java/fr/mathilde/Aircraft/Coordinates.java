package fr.mathilde.Aircraft;

public class Coordinates {
    private final int latitude;
    private final int longitude;
    private final int height;

    public Coordinates(int p_longitude, int p_latitude,int p_height) {
        this.latitude = p_latitude;
        this.longitude = p_longitude;
        if (p_height > 100) {
            p_height = 100;
        }
        this.height = p_height;
    }
    public int getLongitude(){
        return this.longitude;
    }
    public int getLatitude(){
        return this.latitude;
    }
    public int getHeight(){
        return this.height;
    }

}
