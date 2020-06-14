package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlarmModeTest {

    @Test
    void changeValue() {
        AlarmMode alm = new AlarmMode();

        alm.getAlarmTime(12).setHour(24);
        alm.changeValue(16, 1 );
        assertEquals(1, alm.getAlarmTime(12).getHour());


        alm.getAlarmTime(12).setMinute(59);
        alm.changeValue(17, 1 );
        assertEquals(0, alm.getAlarmTime(12).getMinute());

    }

    @Test
    void removeAlarmNum() {
        AlarmMode alm = new AlarmMode();
        alm.getAlarmTime(12).setHour(24);
        alm.getAlarmTime(12).setMinute(59);
        alm.removeAlarmNum(12);

        assertEquals(0, alm.getAlarmTime(12).getHour());
        assertEquals(0, alm.getAlarmTime(12).getMinute());
    }

    @Test
    void isAlarmIndicator() {
        AlarmMode alm = new AlarmMode();
        assertFalse(alm.isAlarmIndicator());


        alm.getAlarmTime(12).setHour(24);
        alm.getAlarmTime(12).setMinute(59);
        alm.getAlarmTime(13).setHour(24);
        alm.getAlarmTime(13).setMinute(59);
        alm.checkAlarmArray();
        assertTrue(alm.isAlarmIndicator());


        alm.removeAlarmNum(12);
        alm.checkAlarmArray();
        assertTrue(alm.isAlarmIndicator());

    }

    @Test
    void getAlarmTime() {
        AlarmMode alm = new AlarmMode();
        for(int i = 0; i < 4 ; i++){
            assertEquals(0, alm.getAlarmTime(12+i).getHour());
            assertEquals(0, alm.getAlarmTime(12+i).getMinute());
        }

    }

}
