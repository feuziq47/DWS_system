package Model;

import java.util.*;


public class BrightcontrolMode {


    public BrightcontrolMode(GUI g) {
        gui=g;
    }
    public BrightcontrolMode(){

    }

    private boolean brightness = false;
    private GUI gui;



    private int brightLevel=0;



    public boolean checkBC() {
        switchBC();
        return brightness;
    }


    public void switchBC() {
        brightness= !brightness;
        if(!brightness) {
            initializeBC();
        }
    }

    public void initializeBC() {
        brightLevel=0;

    }


    public int changeBClevel() {
        if(brightness){
            if(brightLevel==3){
                brightLevel=0;
            }else{
                brightLevel++;
            }
            //gui.watchBLC(brightLevel);
        }
        return brightLevel;
    }

    public int daylong(Time currentTime) {
        if(brightness){
            int hour = currentTime.getHour();
            if(20>=hour && hour>12){
                brightLevel=1;
            }else if(hour>=4 && hour<=12){
                brightLevel=2;;
            }else{
                brightLevel=3;
            }
        }
        return brightLevel;
    }
    public boolean getBrightness(){
        return brightness;
    }

    public void setBrightness(boolean brightness) {
        this.brightness = brightness;
    }

    public void setBrightLevel(int brightLevel) {
        this.brightLevel = brightLevel;
    }
    public int getBrightLevel() {
        return brightLevel;
    }
}