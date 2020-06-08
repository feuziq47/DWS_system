package Model;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.*;


public class WorldtimeMode {

    public WorldtimeMode() {

    }

    public WorldtimeMode(int currIndex) {
        currTime  = Calendar.getInstance();
        this.currIndex = currIndex;
        this.worldTime = Calendar.getInstance();
        this.worldTime.clear();
        this.worldTime.setTimeZone(TimeZone.getTimeZone(this.worldTimezone[this.currIndex]));
        this.currTime.setTimeZone(TimeZone.getTimeZone(this.worldTimezone[currIndex]));
        this.worldTime.set(Calendar.MILLISECOND, this.currTime.get(Calendar.MILLISECOND));
        this.worldTime.set(
                this.currTime.get(Calendar.YEAR),
                this.currTime.get(Calendar.MONTH),
                this.currTime.get(Calendar.DAY_OF_MONTH),
                this.currTime.get(Calendar.HOUR_OF_DAY),
                this.currTime.get(Calendar.MINUTE),
                this.currTime.get(Calendar.SECOND)
        );
        Timer timer = new Timer();
        long delay =0;
        long inteval = 1000;
        timer.scheduleAtFixedRate(calculateTask,delay,inteval);
    }

    private Calendar currTime;
    private Calendar worldTime = null;
    private String[] world = new String[]{
            "KOR", "USA", "UK", "CHI", "RSA", "SGP"
    };

    private String[] worldTimezone = new String[]{
            "Asia/Seoul", "Etc/GMT+4", "Europe/London", "Asia/China", "Etc/GMT-2", "Etc/GMT+8"
    };

    private String[] displayWorldTime = new String[3];
    private String[] displayWorldDate = new String[3];
    private int currIndex = 0;


    public void changeIndex() {
        this.currIndex++;

        if (this.currIndex == 5) {
            this.currIndex = 0;
        }

        changeWorldTime();
    }

    public void changeWorldTime(){
        currTime  = Calendar.getInstance();
        this.worldTime = Calendar.getInstance();
        this.worldTime.clear();
        this.worldTime.setTimeZone(TimeZone.getTimeZone(this.worldTimezone[this.currIndex]));
        this.currTime.setTimeZone(TimeZone.getTimeZone(this.worldTimezone[currIndex]));
        this.worldTime.set(Calendar.MILLISECOND, this.currTime.get(Calendar.MILLISECOND));
        this.worldTime.set(
                this.currTime.get(Calendar.YEAR),
                this.currTime.get(Calendar.MONTH),
                this.currTime.get(Calendar.DAY_OF_MONTH),
                this.currTime.get(Calendar.HOUR_OF_DAY),
                this.currTime.get(Calendar.MINUTE),
                this.currTime.get(Calendar.SECOND)
        );
    }

    TimerTask calculateTask = new TimerTask() {
        @Override
        public void run() {
            currTime  = Calendar.getInstance();
            worldTime = Calendar.getInstance();
            worldTime.clear();
            worldTime.setTimeZone(TimeZone.getTimeZone(worldTimezone[currIndex]));
            currTime.setTimeZone(TimeZone.getTimeZone(worldTimezone[currIndex]));
            worldTime.set(Calendar.MILLISECOND, currTime.get(Calendar.MILLISECOND));
            worldTime.set(
                    currTime.get(Calendar.YEAR),
                    currTime.get(Calendar.MONTH),
                    currTime.get(Calendar.DAY_OF_MONTH),
                    currTime.get(Calendar.HOUR_OF_DAY),
                    currTime.get(Calendar.MINUTE),
                    currTime.get(Calendar.SECOND)
            );
        }
    };




    public String displayYear() {
        return (this.worldTime.get(Calendar.YEAR) + " ");
    }

    public String displayMonth() {
        return (this.worldTime.get(Calendar.MONTH) < 9 ? "0" : "") + (this.worldTime.get(Calendar.MONTH) + 1 + " ");
    }

    public String displayDay() {
        return (this.worldTime.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + (this.worldTime.get(Calendar.DAY_OF_MONTH) + " ");
    }

    public String displayHour() {
        return (this.worldTime.get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "") + (this.worldTime.get(Calendar.HOUR_OF_DAY) + " ");
    }

    public String displayMinute() {
        return (worldTime.get(Calendar.MINUTE) < 10 ? "0" : "") +(this.worldTime.get(Calendar.MINUTE) + " ");
    }

    public String displaySecond() {
        return (worldTime.get(Calendar.SECOND) < 10 ? "0" : "") + (this.worldTime.get(Calendar.SECOND) + " ");
    }

    public String displayWorld() {
        return world[currIndex];
    }
}