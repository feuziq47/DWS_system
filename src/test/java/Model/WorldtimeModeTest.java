package Model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WorldtimeModeTest {

    @Test
    void changeIndex() {
        WorldtimeMode WTM = new WorldtimeMode(5);

        WTM.changeIndex();

        assertEquals("KOR",WTM.displayWorld());

    }
}