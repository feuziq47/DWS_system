package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SWModeTest {


    SWMode SWM = new SWMode();
    @Test
    void changeSW() {
        // 1. 마지막 기능창에서 처음 기능창으로 넘어가는지
        SWM.setCurrentIndex(4);
        assertEquals(0,SWM.changeSW());
    }

    @Test
    void selectSW() {
        TimerMode tmr = new TimerMode();
        AlarmMode alm = new AlarmMode();

        // 2. 이미 선택된 index는 선택되지 않는지 확인
        String[][] setSW = {{"8","STM"},{"25","WLT"},{"19","Timer"}};
        SWM.setSelectedSW(setSW);
        SWM.setCurrentIndex(0);
        assertEquals(-1,SWM.selectSW(alm,tmr));
        // 3. 선택된 SW가 마지막 인덱스에 제대로 저장되는지 테스트
        SWM.setCurrentIndex(1);
        SWM.selectSW(alm,tmr);
        assertEquals(19,Integer.parseInt(SWM.getSelectedSWIdx(2)));
        // 4. SW가 4개 이상 선택되는지
        SWM.setCurrentIndex(1);
        SWM.selectSW(alm,tmr);
        SWM.setCurrentIndex(2);
        SWM.selectSW(alm,tmr);
        assertEquals(3,SWM.getSelectedSW().length);


    }
}