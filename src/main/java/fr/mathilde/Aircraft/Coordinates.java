package fr.mathilde.Aircraft;

public class Coordinates {
    private int latitude;
    private int longitude;
    private int height;

    public Coordinates(int p_longitude, int p_latitude,int p_height) {
        this.latitude = p_latitude;
        this.longitude = p_longitude;
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

//    public void setLongitude(int p_longitude){
//        this.longitude = p_longitude;
//    }
//    public void setLatitude(int p_latitude){
//        this.latitude = p_latitude;
//    }
//    public void setHeight(int p_height){
//        this.height = p_height;
//    }
}
