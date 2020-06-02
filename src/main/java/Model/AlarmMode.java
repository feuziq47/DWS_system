package Model;
import java.util.*;

/**
 * 
 */
public class AlarmMode {

    /**
     * Default constructor
     */
    public AlarmMode() {
    }

    /**
     * 
     */
    public int alarmState;




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
        // TODO implement here
        return 0;
    }

    /**
     * @param currentState
     */
    public void changeValue(int currentState) {
        // TODO implement here
    }



    /**
     * 
     */
    public void resetAlarm() {
        // TODO implement here
    }

    /**
     * @return
     */
    public void getAlarmTime(int alarmIndex) {
        // TODO implement here
    }

    /**
     * 
     */
    public void removeAlarmNum(int currentState) {
        // TODO implement here
    }

    /**
     * @return
     */
    public boolean checkAlarmarry() {
        // TODO implement here
        return false;
    }

    public int getAlarmIndex() {
        return alarmState;
    }
}