package com.company.util;

import com.company.command.Action;
import com.company.command.TypeAction;

/**
 *
 * @author fustdag <br>
 *         <b> CommonUtil is an utility class which provide common method for All Application</b>
 *
 */
public class CommonUtil {

    private CommonUtil(){

    }


    /**
     *  Wait to story with 4 seconds while story is loaded
     *
     * **/
    public static void loadStory() {
        try{
            System.out.println("...\n");
            Thread.sleep(4000);
        }
        catch(Exception e1) {
            System.out.println("Wait...");
        }
    }


    public static void load() {
        try{
            System.out.println("...\n");
            Thread.sleep(1);
        }
        catch(Exception e1) {
            System.out.println("Wait...");
        }
    }




    /**
     *  Check String to validate
     *
     * @param input
     *            - String to check
     *
     * **/
    public static boolean validateInput(String input) {
        if (isEmpty(input)) {
            System.out.println("Invalid Information!");
            return false;
        }
        return true;
    }

    /**
     *  Check String whether empty or not
     *
     * @param input
     *            - String to check
     *
     * **/

    public static boolean isEmpty(final String input) {
        return input == null || input.equals("");
    }


    /**
     * Interpret String to Action Enum
     *
     * @param input
     *            - String to interpret for Action enum
     */
    public static TypeAction interpretActionInput(final String input) {
            TypeAction action = TypeAction.INVALID_ACTION;
            try {
                action =Action.get(Integer.valueOf(input));
            } catch (Exception e) {
                System.out.println("Invalid value");
            }
            return action;
    }

}
