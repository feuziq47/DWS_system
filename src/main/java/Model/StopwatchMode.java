package Model;
import java.util.*;
import java.util.TimerTask;
import java.util.Timer;
/**
 *
 */
public class StopwatchMode {

    private Time stopwatchTime;
    private String lapTime;
    private boolean OnOff;

    Timer timer;
    /**
     * Default constructor
     */
    public StopwatchMode() {
        this.OnOff = false;
        stopwatchTime = new Time();
        stopwatchTime.setHour(0);
        stopwatchTime.setMinute(0);
        stopwatchTime.setSecond(0);
        stopwatchTime.setM_second(0);

    }
    public void tempTask(){
        TimerTask task = new TimerTask() {

            public void run() {
                if(OnOff == true) {
                    stopwatchTime.setM_second(stopwatchTime.getM_second()+1);
                    if (stopwatchTime.getM_second() == 100) {
                        stopwatchTime.setM_second(0);
                        stopwatchTime.setSecond(stopwatchTime.getSecond()+1);
                    }
                    if (stopwatchTime.getSecond() == 60) {
                        stopwatchTime.setSecond(0);
                        stopwatchTime.setMinute(stopwatchTime.getMinute()+1);
                    }

                    System.out.println(stopwatchTime.getMinute() + " : " +  stopwatchTime.getSecond() + " : " + stopwatchTime.getM_second());
                    //System.out.println(min+" : "+sec+ " : " + m_sec);
                }
                else {
                    System.out.println(stopwatchTime.getMinute() + " : " +  stopwatchTime.getSecond() + " : " + stopwatchTime.getM_second());
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);

    }



    /**
     *
     */
    public void startStopwatch() {
        this.OnOff = true;
        timer = new Timer();
        //timer.scheduleAtFixedRate(task, 0, 10);
        tempTask();
    }

    /**
     *
     */
    public void stopStopwatch() {
        this.OnOff = false;
        timer=null;
    }

    /**
     *
     */
    public void resetStopwatch() {
        this.OnOff = false;
        stopwatchTime.setHour(0);
        stopwatchTime.setMinute(0);
        stopwatchTime.setSecond(0);
        stopwatchTime.setM_second(0);
    }

    /**
     * @return
     */
    public void lapTime() {
        this.lapTime = this.stopwatchTime.getMinute() + " : " +  this.stopwatchTime.getSecond() + " : " + this.stopwatchTime.getM_second();
        System.out.println(lapTime);
    }

    public String getLapTime(){
        return this.lapTime;
    }

    public String getStopwatchTime(){
        return this.stopwatchTime.getMinute() + " : " +  this.stopwatchTime.getSecond() + " : " + this.stopwatchTime.getM_second();
    }
}