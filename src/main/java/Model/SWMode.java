package Model;
import java.util.*;

/**
 * 
 */
public class SWMode implements UI{

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
    private String[][] SW= {{"8","STW","black"},{"12","ALM","black"},{"19","TRM","black"},{"25","WLT","black"},{"26","BLC","black"}};
    private String[][] selectedSW= {{"8","STM"},{"12","ALM"},{"19","Timer"}};
    private int currentIndex =0;


    /**
     * r
     */
    private String ContentIn1;
    private String ContentIn2;
    private String ContentInMain;

    public void changeSW() {
        currentIndex++;
        String currentSWname = SW[currentIndex][1];
        // display2를 위한 string 생성
        String showIn2section="";
        for(int i=0; i<5; i++){
            if(SW[i][3].equals("black")){
                showIn2section.concat(Integer.toString(i+1));
            }else if(SW[i][3].equals("red")){
                showIn2section.concat(RED+Integer.toString(i+1)+RESET);
            }
        }
        // UI show
        display1("SW");
        display2(showIn2section);
        displayMain(Integer.toString(currentIndex+1)+". "+currentSWname);

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
        // UI show
        // display2를 위한 string 생성
        String showIn2section="";
        for(int i=0; i<5; i++){
            if(SW[i][3].equals("black")){
                showIn2section.concat(Integer.toString(i+1));
            }else if(SW[i][3].equals("red")){
                showIn2section.concat(RED+Integer.toString(i+1)+RESET);
            }
        }
        display1("SW");
        display2(showIn2section);
        displayMain(Integer.toString(currentIndex+1)+". "+currentSWname);
        return 0;
    }

    public String getSelectedSWState(int idx){
        return selectedSW[idx][0];
    }
    public void showDefault(){
        String currentSWname = SW[currentIndex][1];
        // display2를 위한 string 생성
        String showIn2section="";
        for(int i=0; i<5; i++){
            if(SW[i][3].equals("black")){
                showIn2section.concat(Integer.toString(i+1));
            }else if(SW[i][3].equals("red")){
                showIn2section.concat(RED+Integer.toString(i+1)+RESET);
            }
        }
        display1("SW");
        display2(showIn2section);
        displayMain(Integer.toString(currentIndex+1)+". "+currentSWname);
    }
    /**
     ** 첫 번쨰 섹션 display
     */
    @Override
    public void display1(String string) {
        System.out.println(string);
    }

    /**
     ** 두 번쨰 섹션 display
     */
    @Override
    public void display2(String string) {
        System.out.println(string);
    }

    /**
     ** 메인 섹션 display
     */
    @Override
    public void displayMain(String string) {
        System.out.println(string);
    }

}