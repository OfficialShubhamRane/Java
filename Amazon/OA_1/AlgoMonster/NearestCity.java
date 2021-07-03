package AlgoMonster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NearestCity {

    static class City {
        String name;
        int x;
        int y;
        public City(String name_, int x_, int y_) {
            name = name_;
            x = x_;
            y = y_;
        }
        public int dist(City otherCity) {
          return Math.abs(x - otherCity.x) + Math.abs(y - otherCity.y);
        }
    }

    public static List<String> nearestCities(int numOfCities, List<String> cities, List<Integer> xCoordinates, List<Integer> yCoordinates, int numOfQueries, List<String> queries) {
        Map<Integer, ArrayList<City>> xToCities = new HashMap<>();
        Map<Integer, ArrayList<City>> yToCities = new HashMap<>();
        Map<String, City> cityByName = new HashMap<>();

        for (int i = 0; i < cities.size(); i++) {
            String cityName = cities.get(i);
            int x = xCoordinates.get(i);
            int y = yCoordinates.get(i);
            City city = new City(cityName, x, y);
            xToCities.computeIfAbsent(x, v -> new ArrayList<>());
            yToCities.computeIfAbsent(y, v -> new ArrayList<>());
            xToCities.get(x).add(city);
            yToCities.get(y).add(city);
            cityByName.put(cityName, city);
        }

        List<String> ans = new ArrayList<>();
        Map<String, String> cache = new HashMap<>();

        for (String name : queries) {

            if (cache.containsKey(name)) {
                ans.add(cache.get(name));
                continue;
            }

            City city = cityByName.get(name);
            int minDist = Integer.MAX_VALUE;
            String closest = null;
            List<City> searchCities = xToCities.get(city.x);
            searchCities.addAll(yToCities.get(city.y));
            for (City otherCity : searchCities) {
                if (otherCity.equals(city)) {
                    continue;
                }
                int dist = city.dist(otherCity);
                if (closest == null || dist < minDist || (dist == minDist && otherCity.name.compareTo(closest) < 0)) {
                    minDist = city.dist(otherCity);
                    closest = otherCity.name;
                }
            }
            if (closest != null) {
                ans.add(closest);
                cache.put(name, closest);
            } else {
                ans.add("NONE");
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        //Driver code here
    }
}
