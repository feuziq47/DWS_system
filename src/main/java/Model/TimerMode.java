package Model;
import java.util.*;

/**
 *  Timer 모드
 */
public class TimerMode {

    /**
     * Default constructor
     */
    public TimerMode() {
    }

    /**
     * Timer 전원
     */
    private boolean onOff=false;

    /**
     * 
     */
    public Time timerTime;




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
        switch (currentState){
            case 19:
                currentState=20;
                // set timer hour
                break;
            case 20:
                currentState=21;
                // set timer minute
                break;
            case 21:
                currentState=22;
                // set timer second
                break;
            case 22:
                currentState=19;
                break;
            default:
                break;
        }
        return currentState;
    }

    /**
     * @param currentState
     */
    public void changeValue(int currentState, int button) {
        // TODO implement here

    }

    /**
     * @return
     */
    public Time startTimer() {
        // TODO implement here

        return null;
    }

    /**
     * @return
     */
    public Time stopTimer() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Time resetTimer() {
        // TODO implement here
        return null;
    }


}