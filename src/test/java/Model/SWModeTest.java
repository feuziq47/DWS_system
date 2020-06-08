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
        // 2. 이미 선택된 index는 선택되지 않는지 확인
        String[][] setSW = {{"8","STM"},{"25","WLT"},{"19","Timer"}};
        SWM.setSelectedSW(setSW);
        SWM.setCurrentIndex(0);
        assertEquals(-1,SWM.selectSW());
        // 3. 선택된 SW가 마지막 인덱스에 제대로 저장되는지 테스트
        SWM.setCurrentIndex(1);
        SWM.selectSW();
        assertEquals(12,Integer.parseInt(SWM.getSelectedSWIdx(2)));

    }
}