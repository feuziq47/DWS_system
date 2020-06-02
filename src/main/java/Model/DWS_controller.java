package Model;
import java.util.*;

/**
 * 
 */
public class DWS_controller {



    /**
     * Default constructor
     */
    public DWS_controller() {

    }

    /**
     * 
     */
    private static int currentState;

    /**
     * 
     */
    private static Time[] alarmArray;

    /**
     * 
     */
    private static boolean alarmIndicator;

    /**
     * 
     */
    private boolean brightness;




    /**
     * 
     */
    private Date currentDate;



    /**
     * 
     */
    private int button;

    private TimekeepingMode TKM;
    private AlarmMode ALM;
    private StopwatchMode STM;
    private WorldtimeMode WLT;
    private BrightcontrolMode BLC;
    private SWMode SWM;
    private TimerMode TRM;
    private Ring ring;




    /**
     * @return
     */
    public int checkState() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public int changeState() {
        // TODO implement here
        return 0;
    }

    /**
     * @param button
     */
    public void reqSetTime(int button) {
        switch (currentState) {
            case 0:
                if (button == 0)
                    currentState = 1;
                break;
            case 1:
                if (button == 0)
                    currentState = TKM.enterSetSection(currentState);
                else if (button == 1)
                    TKM.nextWorld();
                else if (button == 3)
                    TKM.previousWorld();
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                if (button == 0)
                    currentState = TKM.enterSetSection(currentState);
                break;
        }

    }

    /**
     * @param button
     */
    public void reqChangeValue(int button) {
        switch(currentState){
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                TKM.changeValue(currentState, button);
                break;
            case 20:
            case 21:
            case 22:
                TRM.changeValue(currentState,button);
                break;
            case 16:
            case 17:
            case 18:
                ALM.changeValue(currentState);
                break;
            default:
                return;
        }
    }

    /**
     * @return
     */
    public void reqChangeMode() {
        int firstSWidx=Integer.parseInt(SWM.getSelectedSWState(0));
        int secondSWidx=Integer.parseInt(SWM.getSelectedSWState(1));
        int thirdSWidx=Integer.parseInt(SWM.getSelectedSWState(2));
        if (currentState == 0) {
            currentState = firstSWidx;
        }else if(currentState==firstSWidx){
            currentState = secondSWidx;
        }else if(currentState==secondSWidx){
            currentState = thirdSWidx;
        }else if(currentState==thirdSWidx){
            currentState = 0;
        }else{
            return;
        }

    }

    /**
     * 
     */
    public void reqStopRinging() {
        ring.setOnOff(false);
    }

    /**
     * 
     */
    public void reqStartStopwatch() {
        STM.startStopwatch();
    }

    /**
     * 
     */
    public void reqStopStopwatch() {
        STM.stopStopwatch();
    }

    /**
     * 
     */
    public void reqResetStopwatch() {
        STM.resetStopwatch();
    }

    /**
     * 
     */
    public void reqLapStopwatch() {
        STM.lapTime();
    }

    /**
     * 
     */
    public void reqSelectAlarmNum() {
        ALM.getAlarmTime(ALM.getAlarmIndex());
    }

    /**
     * @param currentState
     */
    public void reqRemoveAlarmNum(int currentState) {
        ALM.removeAlarmNum(currentState);
    }

    /**
     * @param button
     */
    public void reqSetAlarmTime(int button) {
        switch(currentState){
            case 12:
                if(button ==0){
                    ALM.getAlarmTime(0);
                }else{
                    return;
                }
                break;
            case 13:
                if(button ==0){
                    ALM.getAlarmTime(1);
                }else{
                    return;
                }
                break;
            case 14:
                if(button ==0){
                    ALM.getAlarmTime(2);
                }else{
                    return;
                }
                break;
            case 15:
                if(button ==0){
                    ALM.getAlarmTime(3);
                }else {
                    return;
                }
                break;
            case 16:
                if(button==0){
                    ALM.enterSetSection(16);
                }else{
                    return;
                }
                break;
            case 17:
                if(button==0){
                    ALM.enterSetSection(17);
                }else{
                    return;
                }
                break;
            case 18:
                if(button==0){
                    ALM.enterSetSection(18);
                }else{
                    return;
                }
                break;
        }
    }

    /**
     * @param button
     */
    public void reqSetTimerTime(int button) {
        currentState = TRM.enterSetSection(currentState);
    }

    /**
     * 
     */
    public void reqStartTimer() {
        TRM.startTimer();
    }

    /**
     * 
     */
    public void reqStopTimer() {
        TRM.stopTimer();
    }

    /**
     * 
     */
    public void reqResetTimer() {
        TRM.resetTimer();
    }

    /**
     * 
     */
    public void reqChangeWorld() {
        WLT.changeIndex();
    }

    /**
     * 
     */
    public void reqTurnOnBC() {
        BLC.checkBC();
    }

    /**
     * 
     */
    public void reqTurnOffBC() {
        BLC.checkBC();
    }

    /**
     * 
     */
    public void reqControlBC() {
        BLC.changeBClevel();
    }

    /**
     * @param button
     */
    public void reqChangeSW(int button) {
        SWM.enterChangeSW(button);
    }

    /**
     * @param button
     */
    public void pressButton(int button) {
        // TODO implement here
        if(ring.isOnOff()){
            reqStopRinging();
        }else{
            switch(currentState){
                case 0:
                    if (button == 0)
                        reqSetTime(0);
                    else if (button == 2)
                        reqChangeMode();
                    else if (button == 3)
                        reqChangeSW(button);
                    break;
                case 1:
                    if (button == 0 || button == 1 || button == 3)
                        reqSetTime(button);
                    else if (button == 2)
                        currentState = 0;
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    if (button == 0)
                        reqSetTime(button);
                    else if (button == 1 || button == 3)
                        reqChangeValue(button);
                    else if (button == 2)
                        currentState = 0;
                    break;

                case 8:
                    if (button == 1) {
                        reqStartStopwatch();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else {
                        return;
                    }
                    break;
                case 9:
                    if (button == 0) {
                        reqLapStopwatch();
                    } else if (button == 1) {
                        reqStopStopwatch();
                    } else {
                        return;
                    }
                    break;
                case 10:
                    if (button == 1) {
                        reqStartStopwatch();
                    } else if (button == 3) {
                        reqResetStopwatch();
                    } else {
                        return;
                    }
                    break;
                case 11:
                    if (button == 0) {
                        reqStartStopwatch();
                    } else {
                        return;
                    }
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                    if (button == 0) {
                        reqSetAlarmTime(button);
                    } else if (button == 1) {
                        reqSelectAlarmNum();
                    } else if (button ==2){
                        reqChangeMode();
                    } else if (button == 3) {
                        reqRemoveAlarmNum(currentState);
                    } else {
                        return;
                    }
                    break;
                case 16:
                case 17:
                case 18:
                    if (button == 0) {
                        reqSetAlarmTime(button);
                    } else if (button == 1 || button == 3) {
                        reqChangeValue(button);
                    } else if (button == 2) {
                        int alarmIndex = ALM.getAlarmIndex();
                        currentState =12+alarmIndex;
                    } else {
                        return;
                    }
                    break;
                case 19:
                    if (button == 0)
                        reqSetTimerTime(button);
                    else if (button == 1)
                        reqStartTimer();
                    else if (button == 2)
                        reqChangeMode();
                    break;
                case 20:
                case 21:
                case 22:
                    if (button == 0)
                        reqSetTimerTime(button);
                    else if (button == 1 || button == 3)
                        reqChangeValue(button);
                    else if (button == 2)
                        currentState = 19;
                    break;
                case 23:
                    if (button == 1)
                        reqStopTimer();
                    break;
                case 24:
                    if (button == 1)
                        reqStartTimer();
                    if (button == 3)
                        reqResetTimer();
                    break;
                case 25:
                    if(button == 1){
                        reqChangeWorld();
                    }else if(button == 2){
                        reqChangeMode();
                    }
                    else{
                        return;
                    }
                    break;
                case 26:
                    if(button == 1){
                        reqControlBC();
                    }else if (button ==2){
                        reqChangeMode();
                    }else if(button == 3){
                        if(BLC.getBrightness()){
                            reqTurnOffBC();
                        }else{
                            reqTurnOnBC();
                        }
                    }else{
                        return;
                    }
                    break;
                case 27:
                    break;
                case 28:
                    if(button == 0 || button==1){
                        reqChangeSW(button);
                    }else if(button == 3){
                        currentState=0;
                    }else{
                        return;
                    }
                    break;
                default:
                    return;
            }
        }

    }

    /**
     * 
     */
    public void turnOnAlarmIndicator() {
        // TODO implement here
    }

    /**
     * 
     */
    public void turnOffAlarmIndicator() {
        // TODO implement here
    }

    /**
     * 
     */
    public void checkCurrentTime() {
        // TODO implement here
    }

}