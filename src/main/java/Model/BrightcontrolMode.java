package Model;

import java.sql.Time;
import java.util.*;

/**
 *  밝기 조절 모드
 */
public class BrightcontrolMode {

    /**
     * Default constructor
     */
    public BrightcontrolMode() {
    }

    /**
     * 밝기조절 모드 on/off 여부
     */
    private boolean brightness = false;

    /**
     *  밝기 level
     */
    private int brightLevel=0;


    /**
     * 다른 모드로 변경
     * @param currentState
     */
    public void changeMode(int currentState) {
        // TODO implement here

    }

    /**
     * brightness true/false 값 확인
     * @return
     */
    public boolean checkBC() {
        // TODO implement here
        return brightness;
    }

    /**
     * BC on/off 변경
     */
    public void switchBC() {
        // TODO implement here
        brightness= !brightness;
    }

    /**
     * brightLevel의 값을 0으로 초기화
     */
    public void initializeBC() {
        // TODO implement here
        brightLevel=0;
    }

    /**
     * brightLevel 변경
     * @return
     */
    public int changeBClevel() {
        // TODO implement here
        if(brightLevel==3){
            brightLevel=0;
        }else{
            brightLevel++;
        }
        return brightLevel;
    }

    /**
     *
     */
    public void daylong(Time currentTime) {
        // TODO implement here
        Calendar cal = Calendar.getInstance();
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if(20>=hour && hour>12){
            brightLevel=1;
        }else if(hour>=4 && hour<=12){
            brightLevel=2;;
        }else{
            brightLevel=3;
        }
    }
    public boolean getBrightness(){
        return brightness;
    }
}