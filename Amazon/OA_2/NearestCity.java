import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class NearestCity  {
    public static List<String> nearestCities(int numOfCities, List<String> cities, List<Integer> xCoordinates, 
                                                        List<Integer> yCoordinates, int numOfQueries, List<String> queries) {
        List closestCity = new ArrayList<String>(numOfQueries);

        for (String str : queries) {
            
            if(str == ){

            }

        }





        return closestCity;

    }

    public static void main(String[] args) {
       
        List cities = new ArrayList<String>(3);
        cities.add("c1");
        cities.add("c2");
        cities.add("c3");

        List xCoordinates = new ArrayList<Integer>(3);
        xCoordinates.add(3);
        xCoordinates.add(2);
        xCoordinates.add(1);

        
        List yCoordinates = new ArrayList<Integer>(3);
        yCoordinates.add(3);
        yCoordinates.add(2);
        yCoordinates.add(3);

        int numOfQueries = 3;
        List queries = new ArrayList<>(numOfQueries);

        nearestCities(3, cities, xCoordinates, yCoordinates, numOfQueries, queries)
    }
}
