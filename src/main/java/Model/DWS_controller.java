package Model;

import java.awt.*;
import java.util.*;

/**
 *
 */
public class DWS_controller {



    /**
     * Default constructor
     */

    public DWS_controller() {
        TKM = new TimekeepingMode();
        STM = new StopwatchMode();
        ALM = new AlarmMode();
        WLT = new WorldtimeMode(0);
        ring = new Ring(ALM, TRM);
        ringTh= new Ring();
        TRM = new TimerMode(ring);
        SWM = new SWMode();

        gui = new GUI(this);
        BLC = new BrightcontrolMode(gui);
        currentState = 0;
        displayTimer = new Timer();
        long delay = 0;
        long inteval = 100;
        displayTimer.scheduleAtFixedRate(displayTask, delay, inteval);

    }

    private static int currentState;
    private static Time[] alarmArray;
    private static boolean alarmIndicator;
    private TimekeepingMode TKM;
    private AlarmMode ALM;
    private StopwatchMode STM;
    private WorldtimeMode WLT;
    private BrightcontrolMode BLC;
    private SWMode SWM;
    private TimerMode TRM;
    private Ring ring;
    private Ring ringTh;
    private GUI gui;
    private Timer displayTimer;
    private Thread thread = null;

    private TimerTask displayTask = new TimerTask() {

        public void run() {
            int time = 0;
            if (ALM.isAlarmIndicator() || ring.checkTimer(TRM)) {
                ring.checkAlarm(ALM, TKM.getCurrentTime());
                if(ring.isOnOff() && !ringTh.isRinging()){

                    ringTh= new Ring();
                    thread = new Thread(ringTh);
                    thread.start();
                }
//                while (ring.isOnOff()) {
//                    if (time == 3) {
//                        reqStopRinging();
//                        break;
//                    }
//                    Toolkit toolkit = Toolkit.getDefaultToolkit();
//                    toolkit.beep();
//                    try {
//                        Thread.sleep(1000);
//                        time++;
//                    } catch (Exception e) {
//                    }
//                }
            }
            if (BLC.getBrightness() && TKM.getCurrentTime().getMinute() == 0 && TKM.getCurrentTime().getSecond() == 0) {
                int level = BLC.daylong(TKM.getCurrentTime());
                gui.watchBLC(level);
            } else {
                switch (currentState) {
                    case 0:
                        gui.setBlack(gui.getTextField(1));
                        gui.setBlack(gui.getTextField(2));
                        gui.setBlack(gui.getTextField(3));
                        gui.setBlack(gui.getTextField(4));
                        gui.setBlack(gui.getTextField(5));
                        gui.setBlack(gui.getTextField(6));
                        gui.setBlack(gui.getTextField(7));
                        gui.setBlack(gui.getTextField(8));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(ALM.displayIndicator());
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 1:
                        gui.setBlack(gui.getTextField(8));
                        gui.setRed(gui.getTextField(1));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 2:
                        gui.setBlack(gui.getTextField(1));
                        gui.setRed(gui.getTextField(2));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 3:
                        gui.setBlack(gui.getTextField(2));
                        gui.setRed(gui.getTextField(3));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 4:
                        gui.setBlack(gui.getTextField(3));
                        gui.setRed(gui.getTextField(4));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 5:
                        gui.setBlack(gui.getTextField(4));
                        gui.setRed(gui.getTextField(6));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 6:
                        gui.setBlack(gui.getTextField(6));
                        gui.setRed(gui.getTextField(7));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 7:
                        gui.setBlack(gui.getTextField(7));
                        gui.setRed(gui.getTextField(8));
                        gui.setDisplay1(TKM.displayWorld());
                        gui.setDisplay2(TKM.displayYear());
                        gui.setDisplay3(TKM.displayMonth());
                        gui.setDisplay4(TKM.displayDay());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(TKM.displayHour());
                        gui.setDisplay7(TKM.displayMinute());
                        gui.setDisplay8(TKM.displaySecond());
                        break;
                    case 8:
                    case 9:
                    case 10:
                        gui.setDisplay1("STW");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(STM.getStopwatchTime().getMinute()));
                        gui.setDisplay7(Integer.toString(STM.getStopwatchTime().getSecond()));
                        gui.setDisplay8(Integer.toString(STM.getStopwatchTime().getM_second()));
                        break;
                    case 11:
                        gui.setDisplay1("STW");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(STM.getLapTime().getMinute()));
                        gui.setDisplay7(Integer.toString(STM.getLapTime().getSecond()));
                        gui.setDisplay8(Integer.toString(STM.getLapTime().getM_second()));
                        break;
                    case 12: // alarm[0]
                    case 13: // alarm[1]
                    case 14: // alarm[2]
                    case 15: // alarm[3]
                        gui.setDisplay1("ALM");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setBlack(gui.getTextField(7));
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setBlack(gui.getTextField(8));
                        gui.setDisplay4(TKM.displaySecond());
                        int idx=ALM.getAlarmIndex();
                        gui.setDisplay6(Integer.toString(idx+1));
                        if(ALM.getAlarmTime(currentState).getHour()==-1||ALM.getAlarmTime(currentState).getMinute()==-1){
                            gui.setDisplay7("-- : ");
                            gui.setDisplay8("--");
                        }else{
                            gui.setDisplay7(Integer.toString(ALM.getAlarmTime(currentState).getHour()));
                            gui.setDisplay8(Integer.toString(ALM.getAlarmTime(currentState).getMinute()));
                        }

                        break ;
                    case 16: // hour
                        gui.setDisplay1("ALM");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setRed(gui.getTextField(7));
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setBlack(gui.getTextField(8));
                        gui.setDisplay4(TKM.displaySecond());
                        idx=ALM.getAlarmIndex();
                        gui.setDisplay6(Integer.toString(idx+1));

                        if(ALM.getAlarmTime(currentState).getHour() != -1){
                            gui.setDisplay7(Integer.toString(ALM.getAlarmTime(currentState).getHour()));

                        } else {gui.setDisplay7("-- : ");}

                        break ;
                    case 17: // minute
                        gui.setDisplay1("ALM");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setBlack(gui.getTextField(7));
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setRed(gui.getTextField(8));
                        gui.setDisplay4(TKM.displaySecond());
                        idx=ALM.getAlarmIndex();
                        gui.setDisplay6(Integer.toString(idx+1));

                        if(ALM.getAlarmTime(currentState).getMinute() != -1){
                            gui.setDisplay8(Integer.toString(ALM.getAlarmTime(currentState).getMinute()));
                        } else {gui.setDisplay8("--");}
                        break ;
                    case 19:
                    case 23:
                    case 24:
                        gui.setBlack(gui.getTextField(6));
                        gui.setBlack(gui.getTextField(7));
                        gui.setBlack(gui.getTextField(8));
                        gui.setDisplay1("Timer");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(TRM.getTimerTime().getHour()));
                        gui.setDisplay7(Integer.toString(TRM.getTimerTime().getMinute()));
                        gui.setDisplay8(Integer.toString(TRM.getTimerTime().getSecond()));
                        break;

                    case 20:
                        gui.setRed(gui.getTextField(6));
                        gui.setDisplay1("Timer");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(TRM.getTimerTime().getHour()));
                        gui.setDisplay7(Integer.toString(TRM.getTimerTime().getMinute()));
                        gui.setDisplay8(Integer.toString(TRM.getTimerTime().getSecond()));
                        break;
                    case 21:
                        gui.setBlack(gui.getTextField(6));
                        gui.setRed(gui.getTextField(7));
                        gui.setDisplay1("Timer");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(TRM.getTimerTime().getHour()));
                        gui.setDisplay7(Integer.toString(TRM.getTimerTime().getMinute()));
                        gui.setDisplay8(Integer.toString(TRM.getTimerTime().getSecond()));
                        break;
                    case 22:
                        gui.setBlack(gui.getTextField(7));
                        gui.setRed(gui.getTextField(8));
                        gui.setDisplay1("Timer");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        gui.setDisplay5(" ");
                        gui.setDisplay6(Integer.toString(TRM.getTimerTime().getHour()));
                        gui.setDisplay7(Integer.toString(TRM.getTimerTime().getMinute()));
                        gui.setDisplay8(Integer.toString(TRM.getTimerTime().getSecond()));
                        break;
                    case 25:
                        gui.setDisplay1(WLT.displayWorld());
                        gui.setDisplay2(WLT.displayYear());
                        gui.setDisplay3(WLT.displayMonth());
                        gui.setDisplay4(WLT.displayDay());
                        gui.setDisplay6(WLT.displayHour());
                        gui.setDisplay7(WLT.displayMinute());
                        gui.setDisplay8(WLT.displaySecond());
                        break;
                    case 26:
                    case 27:
                        gui.setDisplay1("BC");
                        gui.setDisplay2(TKM.displayHour());
                        gui.setDisplay3(TKM.displayMinute());
                        gui.setDisplay4(TKM.displaySecond());
                        String on;
                        if (BLC.getBrightness()) on = "ON";
                        else on = "OFF";
                        gui.setDisplay6(on);
                        gui.setDisplay7(" ");
                        gui.setDisplay8(Integer.toString(BLC.getBrightLevel()));
                        break;
                    case 28:
                        String showIn2section = "";
                        for (int i = 0; i < 5; i++) {
                            if (SWM.getSW()[i][2].equals("black")) {
                                gui.setBlack(gui.getTextField(i + 1));
                            } else if (SWM.getSW()[i][2].equals("red")) {
                                gui.setRed(gui.getTextField(i + 1));
                            }
                        }
                        gui.setDisplay1("1");
                        gui.setDisplay2("2");
                        gui.setDisplay3("3");
                        gui.setDisplay4("4");
                        gui.setDisplay5("5");
                        gui.setDisplay6(Integer.toString(SWM.getCurrentIndex() + 1));
                        gui.setDisplay7(" ");
                        gui.setDisplay8(SWM.getSW()[SWM.getCurrentIndex()][1]);
                    default:
                        return;
                }
            }


        }
    };

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
        switch (currentState) {
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
                TRM.changeValue(currentState, button);
                break;
            case 16:
            case 17:
                ALM.changeValue(currentState, button);
                break;
            default:
                return;
        }
    }

    /**
     * @return
     */
    public void reqChangeMode() {

        int firstSWidx = Integer.parseInt(SWM.getSelectedSWIdx(0));
        int secondSWidx = Integer.parseInt(SWM.getSelectedSWIdx(1));
        int thirdSWidx = Integer.parseInt(SWM.getSelectedSWIdx(2));
        if(STM.isOnOff()){  // STM start인지 확인
            if(firstSWidx==8){
                firstSWidx=9;
            }
            if(secondSWidx==8){
                firstSWidx=9;
            }
            if(thirdSWidx==8){
                thirdSWidx=9;
            }
        } else if(STM.getStopwatchTime().getHour()==1){ // STM stop인지
            if(firstSWidx==8){
                firstSWidx=10;
            }
            if(secondSWidx==8){
                firstSWidx=10;
            }
            if(thirdSWidx==8){
                thirdSWidx=10;
            }
        } else if(STM.isLapTime()){ // STM laptime
            if(firstSWidx==8){
                firstSWidx=11;

            }
            if(secondSWidx==8){
                firstSWidx=11;

            }
            if(thirdSWidx==8){
                thirdSWidx=11;

            }
        } else if (TRM.isOnOff()) {
            if (firstSWidx == 19) {
                firstSWidx = 23;

            }
            if (secondSWidx == 19) {
                secondSWidx = 23;

            }
            if (thirdSWidx == 19) {
                thirdSWidx = 23;

            }
        }else if (TRM.getTimerTime().getM_second() == 1) {
            if (firstSWidx == 19) {
                firstSWidx = 24;

            }
            if (secondSWidx == 19) {
                secondSWidx = 24;

            }
            if (thirdSWidx == 19) {
                thirdSWidx = 24;

            }
        }
        if (currentState == 0) {
            currentState = firstSWidx;
        } else if (currentState == firstSWidx) {
            currentState = secondSWidx;
        } else if (currentState == secondSWidx) {
            currentState = thirdSWidx;
        } else if (currentState == thirdSWidx) {
            currentState = 0;
        } else if(currentState ==13 || currentState ==14 || currentState ==15){
            if(firstSWidx==12){
                currentState=secondSWidx;
            }else if(secondSWidx==12){
                currentState=thirdSWidx;
            }else if(thirdSWidx==12){
                currentState=0;
            }
        }else {
            return;
        }

    }

    /**
     *
     */
    public void reqStopRinging() {
        ringTh.setRinging(false);
        thread.interrupt();
        ringTh.setOnOff(false);
        ring.setOnOff(false);

        controlAlarmIndicator();
        if(currentState==23){
            currentState=19;
            TRM.getTimerTime().setM_second(0);

        }

        System.out.println("Ring OFF");
    }

    /**
     *
     */
    public void reqStartStopwatch() {
        currentState = 9;
        STM.startStopwatch();
    }

    /**
     *
     */
    public void reqStopStopwatch() {
        currentState = 10;
        STM.stopStopwatch();
    }

    /**
     *
     */
    public void reqResetStopwatch() {
        currentState = 8;
        STM.resetStopwatch();
    }

    /**
     *
     */
    public void reqLapStopwatch() {
        currentState = 11;
        STM.lapTime();
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

        switch (currentState) {
            case 12:
            case 13:
            case 14:
            case 15:
                if (button == 0) {
                    currentState = 16;
                    ALM.enterSetSection(16);
                }
                break;
            case 16:
                if (button == 0) {
                    currentState = 17;
                    ALM.enterSetSection(17);
                } else {
                    return;
                }
                break;
            case 17:
                if (button == 0) {
                    currentState = 16;
                    ALM.enterSetSection(16);
                } else {
                    return;
                }
                break;

            default:
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
        currentState = 23;
    }

    /**
     *
     */
    public void reqStopTimer() {
        TRM.stopTimer();
        currentState=24;

    }

    /**
     *
     */
    public void reqResetTimer() {

        TRM.resetTimer();
        currentState = 19;

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
        boolean check = BLC.checkBC();
        if (check) {
            BLC.daylong(TKM.getCurrentTime());
            gui.watchBLC(BLC.getBrightLevel());
        }

    }

    /**
     *
     */
    public void reqTurnOffBC() {
        boolean check = BLC.checkBC();
        if (check) {
            BLC.daylong(TKM.getCurrentTime());
            gui.watchBLC(BLC.getBrightLevel());
        }

    }

    /**
     *
     */
    public void reqControlBC() {
        BLC.changeBClevel();
        gui.watchBLC(BLC.getBrightLevel());
    }

    /**
     * @param button
     */
    public void reqChangeSW(AlarmMode alm, TimerMode tmr, int button) {
        currentState = 28;
        SWM.enterChangeSW(alm, tmr,button);
    }

    /**
     * @param button
     */
    public void pressButton(int button) {
        if (ringTh.isRinging()) {
            reqStopRinging();
        } else {
            switch (currentState) {
                case 0:
                    if (button == 0)
                        reqSetTime(0);
                    else if (button == 2)
                        reqChangeMode();
                    else if (button == 3)
                        reqChangeSW(ALM,TRM,button);
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
                        currentState = 9;
                        reqStartStopwatch();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else if (button == 3) {
                        reqResetStopwatch();
                    } else {
                        return;
                    }
                    break;
                case 9:
                    if (button == 0) {
                        reqLapStopwatch();
                    } else if (button == 1) {
                        reqStopStopwatch();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else {
                        return;
                    }
                    break;
                case 10:
                    if (button == 1) {
                        reqStartStopwatch();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else if (button == 3) {
                        reqResetStopwatch();
                    } else {
                        return;
                    }
                    break;
                case 11:
                    if (button == 0) {
                        reqStartStopwatch();
                    }else if(button == 2){
                        reqChangeMode();
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
                    } else if (button == 2) {
                        reqChangeMode();
                    } else if (button == 3) {
                        reqRemoveAlarmNum(currentState);
                        controlAlarmIndicator();
                    } else {
                        return;
                    }
                    break;
                case 16:
                case 17:
                    if (button == 0) {
                        reqSetAlarmTime(button);
                    } else if (button == 1 || button == 3) {
                        reqChangeValue(button);
                    } else if (button == 2) {
                        currentState = 12;
                        if(ALM.getAlarmTime(currentState).getHour()== -1 || ALM.getAlarmTime(currentState).getMinute() ==-1){
                            reqRemoveAlarmNum(currentState);
                        }
                        controlAlarmIndicator();
                    } else {
                        return;
                    }
                    break;
                case 18:
                    if (button == 0) {
                        reqSetAlarmTime(button);
                    } else if (button == 1 || button == 3) {
                        reqChangeValue(button);
                    } else if (button == 2) {
                        int alarmIndex = ALM.getAlarmIndex();
                        currentState = alarmIndex;
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
                    if (button == 1) {
                        reqStopTimer();

                    } else if (button == 2) {
                        reqChangeMode();
                    }
                    break;
                case 24:
                    if (button == 1) {
                        currentState=23;
                        reqStartTimer();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else if (button == 3) {
                        reqResetTimer();
                    }
                    break;
                case 25:
                    if (button == 1) {
                        reqChangeWorld();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else {
                        return;
                    }
                    break;
                case 26:
                    if (button == 1) {
                        reqControlBC();
                    } else if (button == 2) {
                        reqChangeMode();
                    } else if (button == 3) {
                        if (BLC.getBrightness()) {
                            reqTurnOffBC();
                        } else {
                            reqTurnOnBC();
                        }
                    } else {
                        return;
                    }
                    break;
                case 27:
                    break;
                case 28:
                    if (button == 0 || button == 1) {
                        reqChangeSW(ALM, TRM,button);
                    } else if (button == 3) {
                        currentState = 0;
                    } else {
                        return;
                    }
                    break;
                default:
                    return;
            }
        }

    }

    private void reqSelectAlarmNum() {
        if (currentState == 15) {
            currentState = 12;
        } else {
            currentState++;
        }
    }


    public void controlAlarmIndicator() {
        ALM.checkAlarmArray();
    }

    public void setCurrentState(int currentState) {
        DWS_controller.currentState = currentState;
    }

    public StopwatchMode getSTM() {
        return STM;
    }

    public int getCurrentState() {
        return currentState;
    }

    public TimekeepingMode getTKM() {
        return TKM;
    }

    public AlarmMode getALM() {
        return ALM;
    }

    public WorldtimeMode getWLT() {
        return WLT;
    }

    public BrightcontrolMode getBLC() {
        return BLC;
    }

    public SWMode getSWM() {
        return SWM;
    }

    public TimerMode getTRM() {
        return TRM;
    }

    public Ring getRing() {
        return ring;
    }

    public GUI getGui() {
        return gui;
    }

    public Ring getRingTh() {
        return ringTh;
    }
}