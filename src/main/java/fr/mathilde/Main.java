package fr.mathilde;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import fr.mathilde.Aircraft.AircraftFactory;
import fr.mathilde.Aircraft.Coordinates;
import fr.mathilde.Aircraft.Flyable;
import fr.mathilde.Exception.InvalidAircraft;
import fr.mathilde.Exception.InvalidLessHeight;
import fr.mathilde.Exception.InvalidValue;
import fr.mathilde.Tower.WeatherTower;


public class Main {
    static int rec;
    static String regex = "[\\s]";

    static int atoi(String number, long line) throws InvalidValue {
        int result = 0;
        for (int i = 0; i < number.length(); i++){
            if (!Character.isDigit(number.charAt(i)) && number.charAt(i) != '-'){
                throw new InvalidValue("Invalid number format at line " + line + " : " + number);
            }
            if (number.charAt(i) == '-'){
                continue;
            }
            char digit = (char)(number.charAt(i) - '0');
            result += (digit * Math.pow(10, (number.length() - i - 1)));
        }
        if (number.charAt(0) == '-')
            result *= -1;
        if (result > Integer.MAX_VALUE) {
            throw new RuntimeException("Overflow occured " + line + " : " + number);
        } else if (result < Integer.MIN_VALUE) {
            throw new RuntimeException("Underflow occured " + line + " : " + number);
        }
        return result;
    }

    public static void parsing(Scanner myReader, WeatherTower weatherTower) throws InvalidValue, InvalidAircraft, InvalidLessHeight {

            String data = myReader.nextLine();
            if (atoi(data, 1) < 1)
            {
                myReader.close();
                throw new InvalidValue("Error with line 1 : " + data);
            }
            rec = Math.toIntExact(atoi(data, 1));
            int i = 2;
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
                String[] myArray = data.split(regex);
                if (myArray.length != 5)
                {
                    myReader.close();
                    throw new InvalidValue("Error with line " + i + " : " + data);
                }
                int lat = atoi(myArray[2], i);
                int lon = atoi(myArray[3], i);
                int height = atoi(myArray[4], i);
                if (height < 0)
                {
                    myReader.close();
                    throw new InvalidLessHeight("Error with line " + i + " : " + myArray[0] + " height too low > " + height );
                }
                Coordinates coordinates = new Coordinates(lat, lon, height);
                Flyable aircraft = AircraftFactory.newAircraft(myArray[0], myArray[1], coordinates);
                if (aircraft == null)
                {
                    myReader.close();
                    throw new InvalidAircraft("Error with line " + i + " : " + myArray[0]);
                }
                aircraft.registerTower(weatherTower);
                weatherTower.register(aircraft);
                i++;
            }
            myReader.close();
    }
    public static void main(String[] args) {
        try {
            WeatherTower weatherTower = new WeatherTower();
            File myObj = new File("/home/matde-ol/IdeaProjects/avaj-launcher/src/main/java/fr/mathilde/scenario.txt");
            Scanner myReader = new Scanner(myObj);
            parsing(myReader, weatherTower);
            for (int i = 0; i < rec; i++) {
                weatherTower.changeWeather();
        }

        } catch (InvalidValue e) {
            System.err.println("Invalid input: " + e.getMessage());
        } catch (RuntimeException e) {
            System.err.println("Runtime exception: " + e.getMessage());
        } catch (InvalidAircraft e) {
            System.err.println("Invalid Aircraft: " + e.getMessage());
        }
        catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        catch (Exception e) {
            System.err.println("Invalid data in file: " + e.getMessage());
        }
    }
}
