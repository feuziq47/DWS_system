package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RingTest {

    @Test
    void checkAlarm() {
        // 알람이 정시에 울리는지
        AlarmMode alm = new AlarmMode();
        TimerMode trm = new TimerMode();
        TimekeepingMode tkm = new TimekeepingMode();
        Ring ring = new Ring(alm, trm);
        Ring ringTh = new Ring();
        tkm.setValue(5, 0);
        tkm.setValue(6, 0);
        alm.getAlarm(0).setHour(0);
        alm.getAlarm(0).setMinute(0);
        ring.checkAlarm(alm, tkm.getCurrentTime());
        assertTrue(ring.isOnOff());

    }



    @Test
    void checkTimer() {
        AlarmMode alm = new AlarmMode();
        TimerMode trm = new TimerMode();
        trm.getTimerTime().setM_second(2);
        Ring ring = new Ring(alm, trm);
        assertTrue(ring.checkTimer(trm));
        trm.getTimerTime().setM_second(0);
        assertFalse(ring.checkTimer(trm));

    }


    @Test
    void ringing() {
        // ringing이 제대로 작동하는지
        Ring ringTh = new Ring();
        Thread Thr = new Thread(ringTh);
        Thr.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertTrue(ringTh.isRinging());
        Thr.interrupt();
    }
}