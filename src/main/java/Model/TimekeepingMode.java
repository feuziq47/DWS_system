package Model;


import java.util.*;

/**
 * 
 */
public class TimekeepingMode {

    private Date currentDate = new Date();
    private Time currentTime = new Time();
    private Calendar time = Calendar.getInstance();
    private String[] world = {"KOREA", "AMERICA", "EUROPE", "CHINA", "RUSSIA", "SINGAPORE"};
    private String currentWorld ="KOREA";
    /**
     * Default constructor
     */
    public TimekeepingMode() {
        currentDate.setYear(time.get(Calendar.YEAR));
        currentDate.setMonth(time.get(Calendar.MONTH));
        currentDate.setDay(time.get(Calendar.DAY_OF_MONTH));
        currentTime.setHour(time.get(Calendar.HOUR_OF_DAY));
        currentTime.setMinute(time.get(Calendar.MINUTE));
        currentTime.setSecond(time.get(Calendar.SECOND));
    }


    /**
     * @param currentState
     */
    public void changeMode(int currentState) {
        // TODO implement here
    }

    /**
     * @param currentState 
     * @return
     */
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

    /**
     * @param currentState
     */
    public void changeValue(int currentState, int button) {
        switch(currentState) {
            // time의 값을 currentTime에 추가해주기.
            case 2: // year
                if (button == 1) {
                    // 증가
                    time.add(Calendar.YEAR, 1);
                } else if (button == 3) {
                    // 감소
                    time.add(Calendar.YEAR, -1);
                    if (time.get(Calendar.YEAR) < 1970)
                        time.set(Calendar.YEAR, 1970);
                }
                break;
            case 3: //month
                if (button == 1) {
                    // 증가
                    time.add(Calendar.MONTH, 1);
                } else if (button == 3) {
                    // 감소
                    time.add(Calendar.MONTH, -1);
                }
                break;
            case 4: // day
                if (button == 1) {
                    // 증가
                    time.add(Calendar.DATE, 1);
                } else if (button == 3) {
                    // 감소
                    time.add(Calendar.MONTH, -1);
                }
                break;
            case 5: //hour
                if (button == 1) {
                    // 증가
                    time.add(Calendar.HOUR_OF_DAY, 1);
                } else if (button == 3) {
                    // 감소
                    time.add(Calendar.HOUR_OF_DAY, -1);
                }
                break;
            case 6: //minute
                if (button == 1) {
                    // 증가
                    time.add(Calendar.MINUTE, 1);
                } else if (button == 3) {
                    // 감소
                    time.add(Calendar.MINUTE, -1);
                }
                break;
        }

    }

    /**
     * 
     */
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
        }


    }

    /**
     * 
     */
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
        }


    }

}