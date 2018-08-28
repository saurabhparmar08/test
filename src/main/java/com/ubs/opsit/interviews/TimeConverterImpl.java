package com.ubs.opsit.interviews;

import java.util.Arrays;

public class TimeConverterImpl implements TimeConverter{

    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final int TOTAL_LIGHTS_IN_FIRST_ROW = 4;
    private static final int TOTAL_LIGHTS_IN_SECOND_ROW = 4;
    private static final int TOTAL_LIGHTS_IN_THIRD_ROW = 11;
    private static final int TOTAL_LIGHTS_IN_FOURTH_ROW = 4;

    @Override
    public String convertTime(String aTime){
        if(aTime == null || aTime.isEmpty()) {
            throw new IllegalArgumentException("Please provide time");
        }
        String[] timeArray = aTime.split(":", 3);

        Integer hours = 0;
        Integer minutes =0;
        Integer seconds = 0;

        if(timeArray.length != 3){
            throw new IllegalArgumentException("Please provide time in HH:MM:SS format");
        }

        hours = Integer.parseInt(timeArray[0]);
        minutes = Integer.parseInt(timeArray[1]);
        seconds = Integer.parseInt(timeArray[2]);

        if (hours > 24 || (hours == 24 && (minutes > 0 || seconds > 0 ))) {
            throw new IllegalArgumentException("Hours can be between 0 to 24");
        } else if (minutes > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 to 59");
        } else if (seconds > 59) {
            throw new IllegalArgumentException("Minutes can be between 0 to 59");
        }
        return buildOutputRows(hours,minutes,seconds);
    }


    private String buildOutputRows(Integer hours, Integer minutes, Integer seconds) {

        String zeroLine = (seconds % 2 == 0) ? "Y" : "O";

        String firstLine = populateLine(TOTAL_LIGHTS_IN_FIRST_ROW, hours / 5,"R");
        String secondLine = populateLine( TOTAL_LIGHTS_IN_SECOND_ROW, hours % 5,"R");
        String thirdLine = populateLine( TOTAL_LIGHTS_IN_THIRD_ROW, minutes / 5,"Y").replaceAll("YYY", "YYR");
        String fourthLine = populateLine( TOTAL_LIGHTS_IN_FOURTH_ROW, minutes % 5,"Y");

        return String.join(NEW_LINE_SEPARATOR, Arrays.asList(zeroLine, firstLine, secondLine, thirdLine, fourthLine));
    }

    private String populateLine(int totalLights, int onLights, String lampColour) {
        StringBuilder line = new StringBuilder("");
        int offLights = totalLights - onLights;
        for(;onLights > 0 ;onLights--){
            line.append(lampColour);
        }
        for(;offLights > 0 ;offLights--){
            line.append("O");
        }
        return line.toString();
    }
}
