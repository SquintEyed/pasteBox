package org.example.pasteBox.entity.enums;


public enum ExpirationTime {

    ONE_DAY("day" ),
    ONE_WEEK("week"),
    ONE_MONTH("month"),
    ALL_TIME("allTime");

    private final String time;

    ExpirationTime(String time){
        this.time = time;
    }

    @Override
    public String toString(){
        return this.time;
    }

    public static ExpirationTime setActualExpirationTime(String t){

        for (ExpirationTime e: ExpirationTime.values()){
           if (e.toString().equals(t)){
               return e;
           }
        }
        return null;
    }

}
