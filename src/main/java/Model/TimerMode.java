package Model;
import java.util.*;


public class TimerMode{

    /**
     * Default constructor
     */
    public TimerMode() {
        timerTime = new Time();
        timerTime.setHour(0);
        timerTime.setMinute(0);
        timerTime.setSecond(0);
        timerTime.setM_second(0);
    }


    Timer timer ;


    private boolean onOff=false;

    private Time timerTime;





    public int enterSetSection(int currentState) {
        switch (currentState){
            case 19:
                return 19;
            case 20:
                return 20;
            case 21:
                return 21;
            case 22:
                return 22;
            default:
                break;
        }
        return currentState;
    }


    public void changeValue(int currentState, int button) {
        switch(currentState){
            case 20:
                if(button ==1){
                    if(timerTime.getHour()==99) timerTime.setHour(0);
                    else timerTime.setHour(timerTime.getHour()+1);
                }else if(button ==3){
                    if(timerTime.getHour()==0) timerTime.setHour(99);
                    else timerTime.setHour(timerTime.getHour()-1);
                }
                break;
            case 21:
                if(button ==1){
                    if(timerTime.getMinute()==59) timerTime.setMinute(0);
                    else timerTime.setMinute(timerTime.getMinute()+1);
                }else if(button ==3){
                    if(timerTime.getMinute()==0) timerTime.setMinute(59);
                    else timerTime.setMinute(timerTime.getMinute()-1);
                }
                break;
            case 22:
                if(button ==1){
                    if(timerTime.getSecond()==59) timerTime.setSecond(0);
                    else timerTime.setSecond(timerTime.getSecond()+1);
                }else if(button ==3){
                    if(timerTime.getSecond()==0) timerTime.setSecond(59);
                    else timerTime.setSecond(timerTime.getSecond()-1);
                }
                break;
            default:
                return;
        }

    }

    public Time startTimer() {
        onOff=true;
        timer = new Timer();
        tempTask();
        return null;
    }

    public Time stopTimer() {
        onOff=false;
        timer = null;
        return null;
    }

    public void resetTimer() {
        timerTime.setHour(0);
        timerTime.setMinute(0);
        timerTime.setSecond(0);
        timerTime.setM_second(0);
    }

    public void tempTask(){
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                while(onOff){
                    int sec=timerTime.getSecond();
                    int min=timerTime.getMinute();
                    int hour= timerTime.getHour();
                    if(sec>0){
                        timerTime.setSecond(--sec);
                    }else if(sec==0){
                        // sec 값이 0이라면 sec=59
                        timerTime.setSecond(59);
                        if(min>0){
                            // minute-1
                            timerTime.setMinute(--min);
                        }else if(min==0){
                            // minute 값이 0이라면 minute=59, hour--
                            timerTime.setMinute(59);
                            timerTime.setHour(--hour);
                        }
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,1000);
    }


    public String getTimerTime(){
        return this.timerTime.getHour() + " : " +  this.timerTime.getMinute() + " : " + this.timerTime.getSecond();
    }

}