package com.company.test.util;

import com.company.entities.Hero;
import com.company.util.GameIntroductionUtil;
import com.company.util.SceneUtil;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertNotNull;
/**
 *
 * @author fustdag <br>
 *         <b>Test SceneUtil Class</b>
 */
public class TestSceneUtil {

    @Test
    public void testGamePlayUtil() {
        assertNotNull(GameIntroductionUtil.GAME_STORY);
    }

    @Test
    public void testIsMissionCompleted(){
        Hero hero = new Hero();
        hero.setItems(new ArrayList<>());
        boolean isMissionCompleted = SceneUtil.isMissionCompleted(hero);
        Assert.assertTrue(isMissionCompleted);
    }

    @Test
    public void testIsMissionNotCompleted(){
        Hero hero = new Hero();
        boolean isMissionCompleted = SceneUtil.isMissionCompleted(hero);
        Assert.assertFalse(isMissionCompleted);
    }


}
