package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimerModeTest {

    @Test
    void changeValue() {
        TimerMode timer = new TimerMode();
        // 최대/최소 값에서 증가/감소 버튼을 눌렀을 때, 최소값/최대값으로 변경되는지
        timer.setValue(20,99);
        timer.changeValue(20,1);
        assertEquals(0,timer.getTimerTime().getHour());

        timer.setValue(21,59);
        timer.changeValue(21,1);
        assertEquals(0,timer.getTimerTime().getMinute());

        timer.setValue(22,59);
        timer.changeValue(22,1);
        assertEquals(0,timer.getTimerTime().getSecond());

        timer.setValue(20,0);
        timer.changeValue(20,3);
        assertEquals(99,timer.getTimerTime().getHour());

        timer.setValue(21,0);
        timer.changeValue(21,3);
        assertEquals(59,timer.getTimerTime().getMinute());

        timer.setValue(22,0);
        timer.changeValue(22,3);
        assertEquals(59,timer.getTimerTime().getSecond());

        // timerTime이 잘 저장되는지
        timer.setTimerTime(1,1,1);
        assertEquals(1,timer.getTimerTime().getHour());
        assertEquals(1,timer.getTimerTime().getMinute());
        assertEquals(1,timer.getTimerTime().getSecond());
    }

    @Test
    void startTimer() {
        // timerTime의 값이 음수 값 이하로 측정되는지 가지는지
        TimerMode timer = new TimerMode();
        timer.setTimerTime(0 ,0,0);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals(0,timer.startTimer().getHour());
        assertEquals(0,timer.startTimer().getMinute());
        assertEquals(0,timer.startTimer().getSecond());


    }

    @Test
    void stopTimer() {

        // timer 시간이 정확히 측정되는가
        TimerMode timer = new TimerMode();
        timer.setTimerTime(0 ,0,4);
        timer.startTimer();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        timer.stopTimer();
        assertEquals(2,timer.getTimerTime().getSecond());

    }

    @Test
    void resetTimer() {
        // 리셋버튼에 의해 0:0:0으로 초기화되는가
        TimerMode timer = new TimerMode();
        timer.setTimerTime(0 ,0,4);
        timer.resetTimer();
        assertEquals(0,timer.getTimerTime().getSecond());
        assertEquals(0,timer.getTimerTime().getMinute());
        assertEquals(0,timer.getTimerTime().getHour());
    }
}