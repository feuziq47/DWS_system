package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BrightcontrolModeTest {

    @Test
    void getBrightLevel() {
        BrightcontrolMode blc = new BrightcontrolMode();
        blc.setBrightness(true);
        assertEquals(0,blc.getBrightLevel());
    }

    @Test
    void checkBC() {
        // BC on/off가 한 버튼에 의해 적절히 토글되는가
        BrightcontrolMode blc = new BrightcontrolMode();
        DWS_controller dws = new DWS_controller();
        GUI gui =new GUI(dws);
        blc.setBrightness(true);
        assertEquals(false,blc.checkBC());
    }
    @Test
    void switchBC(){

    }

    @Test
    void initializeBC() {
        // intialize 함수가 제대로 작동하는가
        BrightcontrolMode blc = new BrightcontrolMode();
        blc.setBrightness(true);
        blc.initializeBC();
        assertEquals(0,blc.getBrightLevel());
    }

    @Test
    void changeBClevel() {
        // 밝기 레벨이 0-3 이외의 값을 가지는지
        BrightcontrolMode blc = new BrightcontrolMode();
        blc.setBrightness(true);
        blc.setBrightLevel(3);
        blc.changeBClevel();
        assertEquals(0, blc.getBrightLevel());
    }

    @Test
    void daylong() {
        // 시간에 따라 적절히 BC level이 변화되는지
        BrightcontrolMode blc = new BrightcontrolMode();
        blc.setBrightness(true);
        Time time = new Time();
        time.setHour(15);
        assertEquals(1,blc.daylong(time));

    }

}