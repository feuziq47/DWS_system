package Model;
import java.awt.*;
import java.util.*;

/**
 * 
 */
public class Ring implements Runnable{

    /**
     * Default constructor
     */
    AlarmMode ALM;
    TimerMode TMR;
    Toolkit toolkit = Toolkit.getDefaultToolkit();
    boolean isRinging;
    public Ring(){
        onOff=false;
        isRinging=false;
    }

    public Ring(AlarmMode alarmMode, TimerMode timerMode) {
        this.onOff = false;
        ALM=alarmMode;
        TMR=timerMode;
        this.isRinging=true;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean k) {
        onOff = k;
    }

    /**
     * 
     */
    private boolean onOff=false;





    public void checkAlarm(AlarmMode alarm, Time time) {
        // 인자1. 알람배열, 인자2. 현재시간
        // 각 알람의 hour, minute이 현재 시간과 동일한지 확인

        for(int i = 0; i< 4; i++) {
            if(alarm.getAlarm(i).getHour() >= 0 ||  alarm.getAlarm(i).getMinute() >= 0) {

                if(alarm.getAlarm(i).getHour() == time.getHour()
                        && alarm.getAlarm(i).getMinute() == time.getMinute())
                {
                    if(alarm.isAlarmIndicator()){
                        this.setOnOff(true);
                    }
                    alarm.removeAlarmNum(i+12);
                } // 동일하면, Ring ON && 알람 삭제
            }
        }
    }


    /**
     * @return
     */
    public boolean checkTimer(TimerMode TRM) {
        if(TRM.getTimerTime().getM_second() == 2){
            return true;
        }
        return false;
    }

    /**
     * 
     */
    public void ringing() {
        isRinging=true;
        for(int i=0; i<3; i++){
            toolkit.beep();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) {

            }
        }
    }


    @Override
    public void run() {
        ringing();
    }

    public boolean isRinging() {
        return isRinging;
    }

    public void setRinging(boolean ringing) {
        isRinging = ringing;
    }
}