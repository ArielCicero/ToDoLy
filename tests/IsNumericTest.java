package todoly.tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import todoly.util.IsNumeric;

class IsNumericTest {

    @Test
    void checkIsTrueForStringWithJustAnInteger() {
        // Act, Assert
        assertTrue(IsNumeric.check("2"));
    }
    
    @Test
    void checkIsTrueForStringWithAnIntegerWithSpaces() {
        // Act, Assert
        assertTrue(IsNumeric.check("2 "));
    }

}
