package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimekeepingModeTest {

    @Test
    void enterSetSection() {

    }

    @Test
    void changeValue() {
        TimekeepingMode tkm = new TimekeepingMode();

        tkm.setValue(2, 1970);
        tkm.changeValue(2, 3);
        //Year의 값이 1970아래로 내려가는지
        assertEquals("1970 ", tkm.displayYear());


        tkm.setValue(3, 11);
        tkm.changeValue(3, 1);
        //Month의 값이 1로 되돌아 가는지
        assertEquals("01 ", tkm.displayMonth());

        tkm.setValue(4, 31);
        tkm.changeValue(4, 1);
        //Day의 값이 1로 되돌아 가는지
        assertEquals("01", tkm.displayDay());

        tkm.setValue(5, 23);
        tkm.changeValue(5, 1);
        //Hour의 값이 0로 되돌아가는지
        assertEquals("00 ", tkm.displayHour());

        tkm.setValue(6, 59);
        tkm.changeValue(6, 1);
        //Minute의 값이 0으로 되돌아가는지
        assertEquals("00 ", tkm.displayMinute());

        tkm.setValue(7, 59);
        tkm.changeValue(7, 1);
        //Second의 값이 0으로 되돌아가는지
        assertEquals("00 ", tkm.displaySecond());

    }

    //
    @Test
    void previousWorld() {
        TimekeepingMode tkm = new TimekeepingMode();
        tkm.previousWorld();
        assertEquals("SINGAPORE", tkm.displayWorld());
    }

    @Test
    void nextWorld() {
        TimekeepingMode tkm = new TimekeepingMode();
        tkm.nextWorld();
        assertEquals("AMERICA", tkm.displayWorld());
    }

    //
    @Test
    void displayYear() {
        TimekeepingMode tkm = new TimekeepingMode();
        assertEquals("1970 ", tkm.displayYear());
    }

    @Test
    void displayDay() {
        TimekeepingMode tkm = new TimekeepingMode();
        assertEquals("01", tkm.displayDay());
    }

    @Test
    void displayHour() {
        TimekeepingMode tkm = new TimekeepingMode();
        assertEquals("00 ", tkm.displayHour());
    }

    @Test
    void displayMinute() {
        TimekeepingMode tkm = new TimekeepingMode();
        assertEquals("00 ", tkm.displayMinute());
    }

}