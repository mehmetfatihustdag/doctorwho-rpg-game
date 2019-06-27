package com.company.test.factory;


import com.company.entities.CharacterType;
import com.company.factory.AbstractFactory;
import com.company.factory.AlienFactory;
import com.company.factory.FactoryProvider;
import com.company.factory.HeroFactory;
import org.junit.Test;


import static com.company.entities.CharacterType.ALIEN;
import static com.company.entities.CharacterType.HERO;
import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

/**
 *
 * @author fustdag <br>
 *         <b>Test Factory Provider</b>
 */
public class TestFactoryProvider {

    @Test
    public void testIsFactoryIsHeroFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory(HERO);
        assertThat(new HeroFactory() , instanceOf(abstractFactory.getClass()));
    }

    @Test
    public void testIsFactoryIsAlienFactory() {
        AbstractFactory abstractFactory = FactoryProvider.getFactory(ALIEN);
        assertThat(new AlienFactory() , instanceOf(abstractFactory.getClass()));
    }




}
