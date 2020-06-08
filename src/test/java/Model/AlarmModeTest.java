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
        // hour의 값이 24를 초과하는지

        alm.getAlarmTime(12).setMinute(59);
        alm.changeValue(17, 1 );
        assertEquals(0, alm.getAlarmTime(12).getMinute());
        // minute의 값이 59를 초과하는지
    }

    @Test
    void removeAlarmNum() {
        AlarmMode alm = new AlarmMode();
        alm.getAlarmTime(12).setHour(24);
        alm.getAlarmTime(12).setMinute(59);
        alm.removeAlarmNum(12);

        assertEquals(0, alm.getAlarmTime(12).getHour());
        assertEquals(0, alm.getAlarmTime(12).getMinute());
    } // 현재 currentState에서 선택된 알람이 삭제되는지

    @Test
    void isAlarmIndicator() {
        AlarmMode alm = new AlarmMode();
        assertFalse(alm.isAlarmIndicator());
        // 알람 설정 안된 상태에서 Indicator가 off(false) 상태인지

        alm.getAlarmTime(12).setHour(24);
        alm.getAlarmTime(12).setMinute(59);
        alm.getAlarmTime(13).setHour(24);
        alm.getAlarmTime(13).setMinute(59);
        alm.checkAlarmArray();
        assertTrue(alm.isAlarmIndicator());
        // 알람이 하나라도 켜지면 Indicator가 on(true) 상태인지

        alm.removeAlarmNum(12);
        alm.checkAlarmArray();
        assertTrue(alm.isAlarmIndicator());
        // 설정된 알람 2개 중 1개가 삭제되었을때 Indicator가 on(true) 상태인지
    }

    @Test
    void getAlarmTime() {
        AlarmMode alm = new AlarmMode();
        for(int i = 0; i < 4 ; i++){
            assertEquals(0, alm.getAlarmTime(12+i).getHour());
            assertEquals(0, alm.getAlarmTime(12+i).getMinute());
        }
        // 현재 currentState 에서 알람의 hour, minute 값을 가져오는지
    }

}
