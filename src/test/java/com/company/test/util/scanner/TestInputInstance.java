package com.company.test.util.scanner;


import com.company.util.scanner.Input;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;

import java.lang.reflect.Field;

import static org.junit.Assert.fail;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 *
 * @author fustdag <br>
 *         <b>Test Alien Factory Class</b>
 */
public class TestInputInstance {

	@Rule
	public final TextFromStandardInputStream  systemInMock
			= emptyStandardInputStream();

	@Test
	public void testGetStaticInstance(){
		try {
			 Input.getInstance();
		}catch (Exception e){
			fail("No Exceptions");

		}
	}

	/**
	 * Test method for {@link com.company.util.scanner.Input#getString(String)} ()}.
	 */
	@Test
	public void testGetStringMethod(){
		try {
			systemInMock.provideLines("Test", "Test");
		    String testString =  Input.getInstance().getString("Test");
		    Assert.assertEquals("Test",testString);
		}catch (Exception e){
			fail("No Exceptions");

		}
	}


	@Before
	public void resetMySingleton() throws SecurityException,
			NoSuchFieldException, IllegalArgumentException,
			IllegalAccessException {
		Field instance = Input.class.getDeclaredField("referenceToSingleInputObject");
		instance.setAccessible(true);
		instance.set(null, null);
	}

}
