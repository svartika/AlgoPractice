package march;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class UndergroundSystem {
    class TravelObject {
        String origin, dest;
        int timeStart, timeEnd;
    }
    Hashtable<Integer,TravelObject> travelDetails = new Hashtable<>();
    Hashtable<String, List<Integer>> averageTime = new Hashtable<>();

    String calculateAveragesHashTableKey(String start, String dest) {
        return start.toLowerCase() + dest.toLowerCase();
    }
    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        TravelObject travelObject = new TravelObject();
        travelObject.origin = stationName; travelObject.timeStart = t;
        travelDetails.put(id, travelObject);
    }

    public void checkOut(int id, String stationName, int t) {
        TravelObject travelObject = travelDetails.get(id);
        if(travelObject==null) return;
        travelObject.dest = stationName;
        travelObject.timeEnd = t;
        int timeTaken = travelObject.timeEnd - travelObject.timeStart;
        String averagesHTKey = calculateAveragesHashTableKey(travelObject.origin, travelObject.dest);
        if(averageTime.containsKey(averagesHTKey)) {
            List<Integer> times = averageTime.get(averagesHTKey);
            times.add(timeTaken);
            averageTime.put(averagesHTKey, times);

        } else {
            List<Integer> times = new ArrayList<>();
            times.add(timeTaken);
            averageTime.put(averagesHTKey, times);
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String averagesHTKey = calculateAveragesHashTableKey(startStation, endStation);

        if(averageTime.containsKey(averagesHTKey)) {
            List<Integer> times = averageTime.get(averagesHTKey);
            float sum = 0;
            for (int time: times) sum += time;
            float newAvg = sum/ (times.size());
            return newAvg;

        } else {
            return -1;
        }
    }
}
