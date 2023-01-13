package v2;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class GameResultTest {

    @Test
    void gameResultTest () throws NoSuchFieldException, IllegalAccessException {
        //given
        String computer = "123";
        String user = "213";

        //when
        GameResult gameResult = new GameResult(computer, user);
        Field strikeCounts = gameResult.getClass().getDeclaredField("strikeCounts");
        Field ballCounts = gameResult.getClass().getDeclaredField("ballCounts");
        strikeCounts.setAccessible(true);
        ballCounts.setAccessible(true);

        //then
        assertEquals(1, strikeCounts.getInt(gameResult));
        assertEquals(2, ballCounts.getInt(gameResult));
    }
}