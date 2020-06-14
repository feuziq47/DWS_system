package Model;
import java.util.*;

/**
 *
 *
 */
public class SWMode{

    public SWMode() {
    }



    private String[][] SW= {{"8","STM","red"},{"12","ALM","red"},{"19","TRM","red"},{"25","WLT","black"},{"26","BLC","black"}};
    private String[][] selectedSW= {{"19","TRM"},{"12","ALM"},{"8","STM"}};
    private int currentIndex =0;



    public int changeSW() {
        currentIndex++;
        if(currentIndex == 5){
            currentIndex = 0;
        }
        return currentIndex;
    }


    public void enterChangeSW(AlarmMode alm, TimerMode tmr, int button) {
        if(button ==0){
            selectSW(alm,tmr);
        }else if(button ==1){
            changeSW();
        }else{
            return;
        }
    }


    public int selectSW(AlarmMode alm, TimerMode tmr) {

        String quitSW=selectedSW[0][1];

        String currentSWname = SW[currentIndex][1];
        if(SW[currentIndex][2]=="black"){
            selectedSW[0][0]=selectedSW[1][0];
            selectedSW[0][1]=selectedSW[1][1];
            selectedSW[1][0]=selectedSW[2][0];
            selectedSW[1][1]=selectedSW[2][1];
            selectedSW[2][0]=SW[currentIndex][0];
            selectedSW[2][1]=SW[currentIndex][1];
            for(int i=0; i<5; i++){
                if(SW[i][1].equals(quitSW)){
                    SW[i][2]="black";
                }
                if(SW[i][1].equals(selectedSW[2][1])){
                    SW[i][2]="red";
                }

            }
            if(quitSW.equals("TRM")){
                tmr.getTimerTime().setM_second(3);
            }else if(quitSW.equals("ALM")){
                alm.setAlarmIndicator(false);
            }
            if(selectedSW[2][1].equals("ALM")){
                alm.checkAlarmArray();
            }else if(selectedSW[2][1].equals("TMR")){
                tmr.getTimerTime().setM_second(0);
            }
        }else{
            return -1;
        }


        return currentIndex;
    }


    public void setSW(String[][] SW) {
        this.SW = SW;
    }
    public void setSelectedSW(String[][] selectedSW) {
        this.selectedSW = selectedSW;
    }
    public void setCurrentIndex(int currentIndex) {
        this.currentIndex = currentIndex;
    }
    public int getCurrentIndex() {
        return currentIndex;
    }
    public String getSelectedSWIdx(int idx){
        return selectedSW[idx][0];
    }
    public String[][] getSelectedSW(){return selectedSW;}
    public String[][] getSW() {
        return SW;
    }
}