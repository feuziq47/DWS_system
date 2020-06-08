package Model;
import java.util.TimerTask;
import java.util.Timer;
/**
 *
 */
public class StopwatchMode {

    private Time stopwatchTime;
    private Time lapTime;
    private boolean OnOff;

    Timer timer;

    /**
     * Default constructor
     */
    public StopwatchMode() {
        this.OnOff = false;
        stopwatchTime = new Time();
        lapTime = new Time();
        lapTime.setM_second(0);
        lapTime.setSecond(0);
        lapTime.setMinute(0);
        lapTime.setHour(0);
        stopwatchTime.setHour(0);
        stopwatchTime.setMinute(0);
        stopwatchTime.setSecond(0);
        stopwatchTime.setM_second(0);

    }

    public void tempTask(StopwatchMode stw) {
        TimerTask task = new TimerTask() {

            public void run() {
                if (OnOff == true) {
                    stopwatchTime.setM_second(stopwatchTime.getM_second() + 1);
                    if (stopwatchTime.getM_second() == 99 && stopwatchTime.getSecond() == 59 && stopwatchTime.getMinute() == 59) {
                        stw.stopStopwatch();
                        stopwatchTime.setHour(0);
                        stopwatchTime.setMinute(59);
                        stopwatchTime.setSecond(59);
                        stopwatchTime.setM_second(99);
                    } else if (stopwatchTime.getM_second() == 100) {
                        stopwatchTime.setM_second(0);
                        stopwatchTime.setSecond(stopwatchTime.getSecond() + 1);
                    } else if (stopwatchTime.getSecond() == 60) {
                        stopwatchTime.setSecond(0);
                        stopwatchTime.setMinute(stopwatchTime.getMinute() + 1);
                    }
                } else {
                    return;
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 10);

    }


    /**
     *
     */
    public Time startStopwatch() {
        this.OnOff = true;
        timer = new Timer();
        //timer.scheduleAtFixedRate(task, 0, 10);
        tempTask(this);
        lapTime.setM_second(0);
        lapTime.setSecond(0);
        lapTime.setMinute(0);
        lapTime.setHour(0);
        return this.stopwatchTime;
    }

    /**
     *
     */
    public Time stopStopwatch() {
        this.OnOff = false;
        timer = null;
        return this.stopwatchTime;
    }

    /**
     *
     */
    public Time resetStopwatch() {
        this.OnOff = false;
        stopwatchTime.setHour(0);
        stopwatchTime.setMinute(0);
        stopwatchTime.setSecond(0);
        stopwatchTime.setM_second(0);

        return this.stopwatchTime;
    }

    /**
     * @return
     */
    public Time lapTime() {
        this.lapTime.setMinute(this.stopwatchTime.getMinute());
        this.lapTime.setSecond(this.stopwatchTime.getSecond());
        this.lapTime.setM_second((this.stopwatchTime.getM_second()));
        return lapTime;
    }

    public Time getLapTime() {
        return this.lapTime;
    }

    public Time getStopwatchTime() {
        return stopwatchTime;
    }

    public void setMinute(int min) {
        this.stopwatchTime.setMinute(min);
    }
    public void setSecond(int sec) {
        this.stopwatchTime.setSecond(sec);
    }
    public void setM_second(int m_sec) {
        this.stopwatchTime.setM_second(m_sec);
    }

    public boolean isOnOff() {
        return OnOff;
    }

    public void setOnOff(boolean onOff) {
        OnOff = onOff;
    }
}