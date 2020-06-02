package Model;
import java.util.*;

/**
 *
 */
public class WorldtimeMode {
    /**
     * Default constructor
     */
    public WorldtimeMode() {
    }

    /**
     * 
     */
    private Worldtime[] worldList;

    /**
     *  현재 화면에 표시되는 국가의 index
     */
    private int currIndex=0;

    /**
     * 변경 필요
     */
    public void changeMode() {
        // TODO implement here
        
    }

    /**
     * @return
     */
    public int changeIndex() {
        currIndex++;

        if(currIndex==5){
            currIndex=0;
        }
        return currIndex;
    }

}