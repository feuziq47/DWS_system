package Model;
import java.util.*;

/**
 * 
 */
public class SWMode {

    /**
     * Default constructor
     */
    public SWMode() {
    }

    /**
     * 
     */
    private String[][] SW= {{"8","STW"},{"12","ALM"},{"19","TRM"},{"25","WLT"},{"26","BLC"}};
    private String[][] selectedSW= {{"8","STM"},{"12","ALM"},{"19","Timer"}};
    private int currentIndex =0;


    /**
     * @return
     */
    public void changeSW() {
        String showSW = SW[currentIndex][1];
    }

    /**
     * 
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

    /**
     * @return
     */
    public int selectSW() {
        for(int i=0; i<2; i++){
            selectedSW[i]=selectedSW[i+1];
        }
        selectedSW[2]=SW[currentIndex];
        return 0;
    }
    public String getSelectedSWState(int idx){
        return selectedSW[idx][0];
    }

}