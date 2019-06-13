package com.company.test.util;

import com.company.util.GameIntroductionUtil;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
/**
 *
 * @author fustdag <br>
 *         <b>Test GameIntroductionUtil Class</b>
 */
public class TestGameIntroductionUtil {

    @Test
    public void testGamePlayUtil() {
        assertNotNull(GameIntroductionUtil.GAME_STORY);
    }
}
