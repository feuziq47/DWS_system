package Model;
import java.util.*;
import java.util.TimerTask;
import java.util.Timer;
/**
 * 
 */
public class StopwatchMode {

    private int min;
    private int sec;
    private int msec;
    private int lapTime;
    private boolean OnOff;

    Timer timer = new Timer();
    /**
     * Default constructor
     */
    public StopwatchMode() {
        this.OnOff = false;
        this.min = 0;
        this.sec = 0;
        this.msec = 0;
        this.lapTime = 0;
    }

    TimerTask task = new TimerTask() {

        public void run() {
            while(true) {
                if(OnOff == true) {
                    msec+=1;
                    if (msec == 100) {
                        msec = 0;
                        sec += 1;
                    }
                    if (sec == 60) {
                        sec = 0;
                        min += 1;
                    }//min이 59를 넘으면 어떻게 될지... 예외상황 있음
                    try {
                        Thread.sleep(9);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    System.out.println(min+" : "+sec+ " : " + msec);
                }
                else {
                    System.out.println(min+" : "+sec+ " : " + msec);
                }
            }

        }
    };



    /**
     * @param currentState
     */
    public void changeMode(int currentState) {
        // TODO implement here
    }

    /**
     * @return
     */
    public Stopwatchtime calStopwatchTime() {
        // TODO implement here
        return null;
    }

    /**
     * 
     */
    public void startStopwatch() {
        this.OnOff = true;
        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 1);
    }

    /**
     * 
     */
    public void stopStopwatch() {
        this.OnOff = false;
    }

    /**
     * 
     */
    public void resetStopwatch() {
        this.OnOff = false;
        timer = null;
        this.msec = 0;
        this.sec = 0;
        this.min = 0;
    }

    /**
     * @return
     */
    public Stopwatchtime lapTime() {
        // TODO implement here
        return null;
    }

}