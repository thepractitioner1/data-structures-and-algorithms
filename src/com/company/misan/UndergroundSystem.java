package com.company.misan;

import java.util.HashMap;

class UndergroundSystem {

    private class Node{
        String stationName;
        int time;

        public Node(String stationName, int time){
            this.stationName = stationName;
            this.time = time;
        }
    }

    private class TimeCount{
        int timeTaken;
        double count;

        public TimeCount(int timeTaken , double count){
            this.timeTaken = timeTaken;
            this.count = count;
        }
    }

    private HashMap<String, TimeCount> count = new HashMap<String, TimeCount>();
    private HashMap<Integer, Node> register = new HashMap<Integer, Node>();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        var node = new Node(stationName, t);
        register.put(id, node);
    }



    public void checkOut(int id, String stationName, int t) {
        // hashmap for checkout
        TimeCount timeCountEntry;
        Node customer = register.get(id); //this gets customer

         int durationBetweenCheckOut = t - customer.time; // calculates Duration

         String countKey = customer.stationName + "-" + stationName;
          var station = count.get(countKey);
          if(station!= null) {
               timeCountEntry = new TimeCount(station.timeTaken + durationBetweenCheckOut, station.count + 1);
          }else timeCountEntry = new TimeCount(durationBetweenCheckOut, 1);

        count.put(countKey, timeCountEntry);
    }

    public double getAverageTime(String startStation, String endStation) {
        var countKey = startStation + "-" + endStation;
        TimeCount station = count.get(countKey);
        System.out.println(station.timeTaken);
        System.out.println(station.count);
        return  station.timeTaken/station.count;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
