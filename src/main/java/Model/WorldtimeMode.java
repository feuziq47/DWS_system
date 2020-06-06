package Model;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.*;


public class WorldtimeMode implements UI_EX {

    public WorldtimeMode() {
        this.worldTime = null;
        this.world = new String[]{
                "KOR","USA","UK","CHI","RSA","SGP"
        };

        this.worldTimezone = new String[]{
                "Asia/Seoul","Etc/GMT+4", "Europe/London", "Asia/China", "Etc/GMT-2" , "Etc/GMT+8"
        };
        this.currTime = Calendar.getInstance();
        this.displayWorldTime = new String[7];
    }

    public WorldtimeMode(int currIndex){
        this.worldTime.setTimeZone(TimeZone.getTimeZone(this.worldTimezone[this.currIndex]));
        this.worldTime.set(Calendar.MILLISECOND, 0);
        this.worldTime.set(
                    this.currTime.get(Calendar.YEAR),
                this.currTime.get(Calendar.MONTH),
                this.currTime.get(Calendar.HOUR_OF_DAY),
                this.currTime.get(Calendar.MINUTE),
                this.currTime.get(Calendar.SECOND)
        );
    }

    private Calendar currTime;
    private Calendar worldTime;
    private String[] world;
    private String [] worldTimezone;
    private String [] displayWorldTime;
    private int currIndex=0;


    public int changeIndex() {
        currIndex++;

        if(currIndex==5){
            currIndex=0;
        }
        return currIndex;
    }

    public String[] display(){
        displayWorldTime[0] = Integer.toString(this.worldTime.get(Calendar.YEAR));
        displayWorldTime[1] = Integer.toString(this.worldTime.get(Calendar.MONTH));
        displayWorldTime[2] = Integer.toString(this.worldTime.get(Calendar.DAY_OF_MONTH));
        displayWorldTime[3] = Integer.toString(this.worldTime.get(Calendar.HOUR_OF_DAY));
        displayWorldTime[4] = Integer.toString(this.worldTime.get(Calendar.MINUTE));
        displayWorldTime[5] = Integer.toString(this.worldTime.get(Calendar.SECOND));
        displayWorldTime[6] = world[currIndex];
        return displayWorldTime;
    }
}