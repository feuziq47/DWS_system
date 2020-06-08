package Model;
import java.util.*;

/**
 *
 *
 */
public class SWMode{

    public SWMode() {
    }



    private String[][] SW= {{"8","STM","red"},{"12","ALM","black"},{"19","TRM","red"},{"25","WLT","red"},{"26","BLC","black"}};
    private String[][] selectedSW= {{"8","STM"},{"25","WLT"},{"19","Timer"}};
    private int currentIndex =0;



    public int changeSW() {
        currentIndex++;
        if(currentIndex == 5){
            currentIndex = 0;
        }
        return currentIndex;
    }


    public void enterChangeSW(int button) {
        if(button ==0){
            selectSW();
        }else if(button ==1){
            changeSW();
        }else{
            return;
        }
    }


    public int selectSW() {

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
                if(SW[i][1]==quitSW){
                    SW[i][2]="black";
                }else if(SW[i][1]==selectedSW[2][1]){
                    SW[i][2]="red";
                }

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
    public String[][] getSW() {
        return SW;
    }
}