package com.company.test.factory;


import com.company.constant.GameConstants;
import com.company.factory.AbstractFactory;
import com.company.factory.AlienFactory;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
 *
 * @author fustdag <br>
 *         <b>Test Factory Provider</b>
 */
public class TestFactoryProvider {

    @Test
    public void testIsFactoryIsHeroFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory(GameConstants.HERO);
        assertThat(new HeroFactory() , instanceOf(abstractFactory.getClass()));
    }

    @Test
    public void testIsFactoryIsAlienFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory(GameConstants.ALIEN);
        assertThat(new AlienFactory() , instanceOf(abstractFactory.getClass()));
    }

    @Test
    public void testIsFactoryIsProduceNull() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory("INVALID");
        assertEquals(null,abstractFactory);

    }



}
