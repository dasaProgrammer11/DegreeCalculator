package com.prac.degreeCalculator;

public class DegreeCalculator {
    private final int TOTAL_DEGREE = 360;
    private final int TOTAL_MINUTES = 60;
    private final int MINUTES_GAP_IN_HOURS = 5;
    private int dispositionPerMinutes;
    private int hour;
    private int minutes;

    private int getDispositionPerMinutes() {
        dispositionPerMinutes = TOTAL_DEGREE / TOTAL_MINUTES;
        return dispositionPerMinutes;
    }

    private float getDegreeFactor() {

        return (float) minutes/TOTAL_MINUTES;
    }

    private float getExtraDegreeOfHourHand(){
        return (MINUTES_GAP_IN_HOURS*dispositionPerMinutes)*getDegreeFactor();
    }

    private float getDegreeForHour(){
       return MINUTES_GAP_IN_HOURS*hour*dispositionPerMinutes;
    }

    private float getTotalDegreeOfHour(){
        return getDegreeForHour()+getExtraDegreeOfHourHand();
    }

    private float getDegreeOfMinutes(){
        return dispositionPerMinutes*minutes;
    }

    private float getDifferenceOfDegree(){
        getDispositionPerMinutes();
        return Math.abs(getDegreeOfMinutes()-getTotalDegreeOfHour());
    }

    public float getDegreeOfDifferenceBetweenHourAndMinutes(String time){
        hour= Integer.parseInt(time.split(":")[0]);
        minutes= Integer.parseInt(time.split(":")[1]);
        return getDifferenceOfDegree();
    }
}
