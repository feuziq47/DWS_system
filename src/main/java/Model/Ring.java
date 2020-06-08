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
    public Ring(){
        onOff=false;
    }

    public Ring(AlarmMode alarmMode, TimerMode timerMode) {
        this.onOff = false;
        ALM=alarmMode;
        TMR=timerMode;
    }

    public boolean isOnOff() {
        return onOff;
    }

    public void setOnOff(boolean onOff) {
        onOff = onOff;
    }

    /**
     * 
     */
    private boolean onOff=false;




    /**
     * @return
     */
    public boolean checkAlarm(Time currTime) {
        if(ALM.isAlarmIndicator()){
            for(int i=0; i<4;i++){
                if(ALM.getAlarmTime(i).getHour()==currTime.getHour() && ALM.getAlarmTime(i).getMinute()==currTime.getMinute()){
                    onOff = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * @return
     */
    public boolean checkTimer(Time currTime) {
        if(TMR.isOnOff()){
            for(int i=0; i<4;i++){
                if(TMR.getTimerTime().getHour()==currTime.getHour() && TMR.getTimerTime().getMinute()==currTime.getMinute()){
                    onOff = true;
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 
     */
    public void ringing() {
        for(int i=0; i<3; i++){
            toolkit.beep();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        onOff=false;
    }

    /**
     *
     */
    public void check3Second() {
        // TODO implement here
    }

    @Override
    public void run() {
        ringing();
    }
}