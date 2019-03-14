package todoly.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import todoly.util.IsNumeric;

/**
 * Test class for IsNumeric
 * 
 * @author Ariel Cicero
 * @version 1.0, 14 Mar 2019
 */
class IsNumericTest {


    /**
     * Assert that IsNumeric.check() returns true for
     * strings containing numbers in base-ten.
     * Inputs parameters like 0.379d or -0.24D, 15d are considered as doubles.
     * Inputs parameters like 3.8f, -3.87F, 32f are considered as floats.
     */
    @Test
    void checkIsTrueForStringWithNumbers() {
        // Act, Assert
        assertTrue(IsNumeric.check("3"));
        assertTrue(IsNumeric.check("0"));
        assertTrue(IsNumeric.check("-0f"));
        assertTrue(IsNumeric.check("3.8f"));
        assertTrue(IsNumeric.check("-3.87F"));
        assertTrue(IsNumeric.check("-3"));
        assertTrue(IsNumeric.check("32f"));
        assertTrue(IsNumeric.check("15D"));
        assertTrue(IsNumeric.check("3.2"));
        assertTrue(IsNumeric.check("0.2"));
        assertTrue(IsNumeric.check("-0.28"));
        assertTrue(IsNumeric.check("0.24D"));
        assertTrue(IsNumeric.check("0.379d"));
    }
    
    /**
     * Assert that IsNumeric.check() returns true for
     * strings containing numbers in base-ten and empty spaces at the beginning and/or at the end.
     * Inputs parameters like 0.379d or -0.24D, 15d are considered as doubles.
     * Inputs parameters like 3.8f, -3.87F, 32f are considered as floats.
     */
    @Test
    void checkIsTrueForStringWithNumbersWithSpacesAtTheBeginningAndEnd() {
        // Act, Assert
        assertTrue(IsNumeric.check(" 3"));
        assertTrue(IsNumeric.check("32 "));
        assertTrue(IsNumeric.check("  3.2  "));
        assertTrue(IsNumeric.check(" -0.2"));
        assertTrue(IsNumeric.check(" -0.2d"));
        assertTrue(IsNumeric.check("0.24D "));
        assertTrue(IsNumeric.check("0.28  "));
        assertTrue(IsNumeric.check(" 3.8f"));
        assertTrue(IsNumeric.check("-3.87F  "));
    }
    
    /**
     * Assert that IsNumeric.check() returns false for
     * strings containing numbers in base-ten and empty other kind of chars.
     * Inputs parameters like 0.379d or -0.24D, 15d are considered as doubles.
     * Inputs parameters like 3.8f, -3.87F, 32f are considered as floats.
     */
    @Test
    void checkIsFalseForStringWithNumbersAndOtherChars() {
        // Act, Assert
        assertFalse(IsNumeric.check("a3"));
        assertFalse(IsNumeric.check("3l"));
        assertFalse(IsNumeric.check("345L"));
        assertFalse(IsNumeric.check("32b"));
        assertFalse(IsNumeric.check("*3.2  "));
        assertFalse(IsNumeric.check("/0.2"));
        assertFalse(IsNumeric.check("0.28L"));
        assertFalse(IsNumeric.check("0.28."));
        assertFalse(IsNumeric.check("3.2.4"));
        assertFalse(IsNumeric.check("0x400"));
        assertFalse(IsNumeric.check("0.24Dd"));
    }
    
    /**
     * Assert that IsNumeric.check() returns false for
     * strings that does not contain numbers.
     */
    @Test
    void checkIsFalseForStringWithoutNumbers() {
        // Act, Assert
        assertFalse(IsNumeric.check("a"));
        assertFalse(IsNumeric.check("ö"));
        assertFalse(IsNumeric.check(""));
        assertFalse(IsNumeric.check("´´´"));
        assertFalse(IsNumeric.check("lgk"));
        assertFalse(IsNumeric.check("lL y"));
        assertFalse(IsNumeric.check("  "));
        assertFalse(IsNumeric.check("h*  "));
        assertFalse(IsNumeric.check("/+"));
        assertFalse(IsNumeric.check("-"));
        assertFalse(IsNumeric.check("+"));
        assertFalse(IsNumeric.check("d"));
        assertFalse(IsNumeric.check("ariel"));
        assertFalse(IsNumeric.check("#€%/!"));
    }
    
    /**
     * Assert that IsNumeric.check() throws NullPointerException
     * when the string parameter is null.
     */
    @Test
    void checkThrowsNullPointerException() {
        // Act, Assert
        Assertions.assertThrows(NullPointerException.class,() -> {
            IsNumeric.check(null);
        });
    }
}
