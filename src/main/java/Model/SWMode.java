package Model;
import java.util.*;

/**
 *
 *
 */
public class SWMode{

    /**
     * Default constructor
     */
    public SWMode() {
    }
    public static final String RED = "\u001B[31m";
    public static final String RESET = "\u001B[0m";



    /**
     *
     */
    private String[][] SW= {{"8","STM","red"},{"12","ALM","black"},{"19","TRM","red"},{"25","WLT","red"},{"26","BLC","black"}};
    private String[][] selectedSW= {{"8","STM"},{"25","WLT"},{"19","Timer"}};
    private int currentIndex =0;

    public int getCurrentIndex() {
        return currentIndex;
    }
    public String[][] getSW() {
        return SW;
    }

    public void changeSW() {
        currentIndex++;
        if(currentIndex == 5){
            currentIndex = 0;
        }
    }

    /**
     * button에 따라 SW를 선택하거나 다음 SW로 넘어간다.
     */
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
        // 빠지는 SW 이름 저장
        String quitSW=SW[0][1];
        // selectedSW에 현재 SW 저장
        String currentSWname = SW[currentIndex][1];
        for(int i=0; i<2; i++){
            selectedSW[i]=selectedSW[i+1];
        }
        selectedSW[2]=SW[currentIndex];
        // SW 색상 업데이트
        for(int i=0; i<5; i++){
            if(SW[i][1].equals(quitSW)){
                SW[i][2]="black";
            }else if(SW[i][1].equals(selectedSW[2][1])){
                SW[i][2]="red";
            }
        }

        return 0;
    }

    public String getSelectedSWState(int idx){
        return selectedSW[idx][1];
    }
    public String getSelectedSWIdx(int idx){
        return selectedSW[idx][0];
    }

}