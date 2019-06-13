package com.company.util.scanner;

import java.util.Scanner;

/**
 * <i>Singleton</i> class to assist with basic keyboard input operations. Only a single <i>Input</i> object will ever be created. The <i>Input</i> class clusters related input operations and will build one <i>scanner</i> object
 to use with input.
 * <i>scanner</i> objects are big and complex; thus, this approach reduces the overhead associated with the repeated creation of <i>scanner</i> objects.
 *
 * @author  Rex Woollard
 * Referenced From : http://elearning.algonquincollege.com/coursemat/woollar/Courses/Common/OOP-Java/Input/InputCode-Singleton.pdf
 *
 */
public  class Input {
    /** Keyword <i>static</i> makes this a <i>class</i> oriented variable, rather than <i>object</i> oriented variable; only one instance of an <i>Input</i> object will ever exist, and the instance is tracked by this reference
     variable. */
    private static Input referenceToSingleInputObject = null;
    /** Object-oriented instance variable, but since only one <i>Input</i> can ever be created, only one <i>scanner</i> object will ever be created. */
    private static Scanner scannerKeyboard ;
    /** A <i>private</i> constructor guarantees that no <i>Input</i> object can be created from outside the <i>Input</i> class; this is essential for the <i>singleton</i> design pattern. */
    private Input() { scannerKeyboard = new Scanner(System.in); }
    /** The <i>static</i> modifier means this method can be called without the existence of an <i>Input</i> object; if no <i>Input</i> object exists one will be created; if one already exists, it will be re-used. */
    public static Input getInstance() {
        if (referenceToSingleInputObject == null)
            referenceToSingleInputObject = new Input();
        return referenceToSingleInputObject;
    } // end static Input getInstance()

    /**
     * Presents a prompt to the user and retrieves a <i>reference-to-String</i>.
     * @param sPrompt reference to a <i>String</i> object whose contents will be displayed to the user as a prompt.
     * @return <i>reference-to-String</i> object created by keyboard input
     */
    public String getString(String sPrompt) {
        System.out.print(sPrompt);
        String sInput =null;
        scannerKeyboard.useDelimiter("\r\n"); // Setting this delimiter ensures that we capture everything up to the <Enter> key. Without this, input stops at the next whitespace (space, tab, newline etc.).
        if(scannerKeyboard.hasNextLine()) {
            sInput = scannerKeyboard.nextLine();
        }
        scannerKeyboard.reset(); // The preceding use of useDelimiter() changed the state of the scanner object. reset() re-establishes the original state.
        return sInput;
    }

}
