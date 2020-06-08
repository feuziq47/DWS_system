package Model;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StopwatchModeTest {

    StopwatchMode stw = new StopwatchMode();
   DWS_controller dws = new DWS_controller();
    @Test
    void startStopwatch() {
        // 1. 표시할 수 없는 범위 이상으로 측정이 되는지 test
        stw.setMinute(59);
        stw.setSecond(59);
        stw.setM_second(99);
        stw.startStopwatch();
        assertEquals(59,stw.getStopwatchTime().getMinute());
        assertEquals(59,stw.getStopwatchTime().getSecond());
        assertEquals(99,stw.getStopwatchTime().getM_second());
        // 2. 1/100초 단위로 정확히 측정되는가?
        stw.setMinute(1);
        stw.setSecond(1);
        stw.setM_second(10);
        stw.startStopwatch();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(1,stw.getStopwatchTime().getMinute());
        assertEquals(1,stw.getStopwatchTime().getSecond());
        assertEquals(11,stw.getStopwatchTime().getM_second());


    }

    @Test
    void stopStopwatch() {
        // 시작 상태에서 B 버튼에 의해서 정지되는지 test
        dws.setCurrentState(9);
        dws.pressButton(1);
        assertFalse(stw.isOnOff());

    }

    @Test
    void resetStopwatch() {
        // reset 버튼으로 stopwatch time이 0:0:0으로 초기화되는지
        dws.setCurrentState(10);
        dws.pressButton(3);
        assertEquals(0,stw.resetStopwatch().getMinute());
        assertEquals(0,stw.resetStopwatch().getSecond());
        assertEquals(0,stw.resetStopwatch().getM_second());
    }

    @Test
    void lapTime() {
        // start -> lapTime 로의 변경이 이루어지는지
        dws.setCurrentState(9);
        dws.pressButton(0);
        assertEquals(11,dws.getCurrentState());
    }
}