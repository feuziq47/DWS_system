package Model;

import java.util.Calendar;
import java.util.*;

public class TimekeepingMode{

    private Date currentDate = new Date();
    private Time currentTime = new Time();
    private Calendar time;
    private String[] world = {"KOREA", "AMERICA", "EUROPE", "CHINA", "RUSSIA", "SINGAPORE"};
    private String currentWorld = "KOREA";
    private String[] displayTime = new String[3];
    private String[] displayDate = new String[3];

    public TimekeepingMode() {
        this.time = Calendar.getInstance();
        this.time.clear();
        currentDate.setYear(time.get(Calendar.YEAR));
        currentDate.setMonth(time.get(Calendar.MONTH));
        currentDate.setDay(time.get(Calendar.DAY_OF_MONTH));
        currentTime.setHour(time.get(Calendar.HOUR_OF_DAY));
        currentTime.setMinute(time.get(Calendar.MINUTE));
        currentTime.setSecond(time.get(Calendar.SECOND));

        Timer timer = new Timer();
        long delay =0;
        long inteval = 1000;
        timer.scheduleAtFixedRate(calculateTask,delay,inteval);
    }

    public int enterSetSection(int currentState) {
        switch (currentState) {
            case 0: //기본
                return 1;
            case 1: // world
                return 2;
            case 2:  //year
                return 3;
            case 3: //month
                return 4;
            case 4: //day
                return 5;
            case 5: //hour
                return 6;
            case 6: //minute
                return 7;
            case 7: //second
                return 1;
        }
        return 0;
    }

    public void changeMode(int currentState) { }

    public void changeValue(int currentState, int button) {
        switch (currentState) {
            // time의 값을 currentTime에 추가해주기.
            case 2: // year
                if (button == 1) {
                    time.add(Calendar.YEAR, 1);
                    currentDate.setYear(time.get(Calendar.YEAR));
                } else if (button == 3) {
                    time.add(Calendar.YEAR, -1);
                    if (time.get(Calendar.YEAR) < 1970)
                        time.set(Calendar.YEAR, 1970);
                    currentDate.setYear(time.get(Calendar.YEAR));

                }
                break;
            case 3: //month
                if (button == 1) {
                    time.add(Calendar.MONTH, 1);
                    currentDate.setMonth(time.get(Calendar.MONTH));
                } else if (button == 3) {
                    time.add(Calendar.MONTH, -1);
                    currentDate.setMonth(time.get(Calendar.MONTH));
                }
                break;
            case 4: // day
                if (button == 1) {
                    time.add(Calendar.DATE, 1);
                    currentDate.setDay(time.get(Calendar.DATE));
                } else if (button == 3) {
                    time.add(Calendar.DATE, -1);
                    currentDate.setDay(time.get(Calendar.DATE));
                }
                break;
            case 5: //hour
                if (button == 1) {
                    time.add(Calendar.HOUR_OF_DAY, 1);
                    currentTime.setHour(time.get(Calendar.HOUR_OF_DAY));
                } else if (button == 3) {
                    time.add(Calendar.HOUR_OF_DAY, -1);
                    currentTime.setHour(time.get(Calendar.HOUR_OF_DAY));
                }
                break;
            case 6: //minute
                if (button == 1) {
                    time.add(Calendar.MINUTE, 1);
                    currentTime.setMinute(time.get(Calendar.MINUTE));
                } else if (button == 3) {
                    time.add(Calendar.MINUTE, -1);
                    currentTime.setMinute(time.get(Calendar.MINUTE));
                }
                break;
            case 7:
                if (button == 1) {
                    time.add(Calendar.SECOND, 1);
                    currentTime.setSecond(time.get(Calendar.SECOND));
                } else if (button == 3) {
                    time.add(Calendar.MINUTE, -1);
                    currentTime.setSecond(time.get(Calendar.SECOND));
                }
                break;
        }
    }

    public void previousWorld() {
        switch (currentWorld) {
            case "KOREA":
                currentWorld = "SINGAPORE";
                break;
            case "AMERICA":
                currentWorld = "KOREA";
                break;
            case "EUROPE":
                currentWorld = "AMERICA";
                break;
            case "CHINA":
                currentWorld = "EUROPE";
                break;
            case "RUSSIA":
                currentWorld = "CHINA";
                break;
            case "SINGAPORE":
                currentWorld = "RUSSIA";
                break;
            default:
                currentWorld = "KOREA";
                break;
        }
    }

    public void nextWorld() {
        switch (currentWorld) {
            case "KOREA":
                currentWorld = "AMERICA";
                break;
            case "AMERICA":
                currentWorld = "EUROPE";
                break;
            case "EUROPE":
                currentWorld = "CHINA";
                break;
            case "CHINA":
                currentWorld = "RUSSIA";
                break;
            case "RUSSIA":
                currentWorld = "SINGAPORE";
                break;
            case "SINGAPORE":
                currentWorld = "KOREA";
                break;
            default:
                currentWorld = "KOREA";
                break;
        }
    }
    TimerTask calculateTask = new TimerTask() {
        @Override
        public void run() {
            time.add(Calendar.SECOND, 1);
            currentDate.setYear(time.get(Calendar.YEAR));
            currentDate.setMonth(time.get(Calendar.MONTH));
            currentDate.setDay(time.get(Calendar.DATE));
            currentTime.setHour(time.get(Calendar.HOUR_OF_DAY));
            currentTime.setMinute(time.get(Calendar.MINUTE));
            currentTime.setSecond(time.get(Calendar.SECOND));
        }
    };

    public String displayTime() {
        displayTime[0] = (time.get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "") + time.get(Calendar.HOUR_OF_DAY) + " ";
        displayTime[1] = (time.get(Calendar.MINUTE) < 10 ? "0" : "")+ time.get(Calendar.MINUTE) + " ";
        displayTime[2] = (time.get(Calendar.SECOND) < 10 ? "0" : "")+time.get(Calendar.SECOND) + " ";
        String result = displayTime[0] + displayTime[1] + displayTime[2];
        return result;
    }

    public String displayYear(){
        return (time.get(Calendar.YEAR) + " ");
    }

    public String displayMonth(){
        return (time.get(Calendar.MONTH) < 9 ? "0" : "") + (time.get(Calendar.MONTH)+1 + " ");
    }

    public String displayDay(){
        return (time.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + (time.get(Calendar.DAY_OF_MONTH));
    }

    public String displayHour(){
        return (time.get(Calendar.HOUR_OF_DAY) < 10 ? "0" : "") + time.get(Calendar.HOUR_OF_DAY) + " ";
    }

    public String displayMinute(){
        return (time.get(Calendar.MINUTE) < 10 ? "0" : "")+ time.get(Calendar.MINUTE) + " ";
    }

    public String displaySecond(){
        return (time.get(Calendar.SECOND) < 10 ? "0" : "")+time.get(Calendar.SECOND) + " ";
    }

    public String displayDate() {
        displayDate[0] = (time.get(Calendar.YEAR) + " ");
        displayDate[1] = (time.get(Calendar.MONTH) < 9 ? "0" : "") + (time.get(Calendar.MONTH)+1 + " ");
        displayDate[2] = (time.get(Calendar.DAY_OF_MONTH) < 10 ? "0" : "") + (time.get(Calendar.DAY_OF_MONTH));
        String result = displayDate[0] + displayDate[1] + displayDate[2];
        return result;
    }

    public String displayWorld(){
        return this.currentWorld;
    }



}