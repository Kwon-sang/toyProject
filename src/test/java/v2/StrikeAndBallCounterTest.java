package v2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class StrikeAndBallCounterTest {

    @Test
    void gameResultTest () throws NoSuchFieldException, IllegalAccessException {
        //given
        String computer = "123";
        String user = "213";

        //when
        StrikeAndBallCounter strikeAndBallCounter = new StrikeAndBallCounter(computer, user);
        Field strikeCounts = strikeAndBallCounter.getClass().getDeclaredField("strikeCounts");
        Field ballCounts = strikeAndBallCounter.getClass().getDeclaredField("ballCounts");
        strikeCounts.setAccessible(true);
        ballCounts.setAccessible(true);

        //then
        assertEquals(1, strikeCounts.getInt(strikeAndBallCounter));
        assertEquals(2, ballCounts.getInt(strikeAndBallCounter));
    }
}