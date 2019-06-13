package com.company.test.util;

import com.company.util.ASCIIArtUtil;
import org.junit.Test;

import static junit.framework.TestCase.fail;
/**
 *
 * @author fustdag <br>
 *         <b>Test AsciiArt Util Class</b>
 */
public class TestASCIIArtUtil {

    @Test
    public void testAsciiService() {
        try {
            ASCIIArtUtil.printAsci("Test");
        } catch (Exception e) {
            fail("No Exceptions must be raised");
        }
    }
}
