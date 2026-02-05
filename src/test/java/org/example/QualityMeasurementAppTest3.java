
package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class QuantityLengthTest {

    private final InputStream originalIn = System.in;

    @BeforeEach
    void setUp() {
        // nothing required now
    }

    @AfterEach
    void tearDown() {
        System.setIn(originalIn); // restore System.in after each test
    }

    private void provideInput(String data) {
        ByteArrayInputStream testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void shouldReturnTrue_when1FeetEquals12Inch() {
        // Input sequence: value1, unit1, value2, unit2
        provideInput("1\nfeet\n12\ninch\n");

        QuantityLength length = new QuantityLength();
        assertTrue(length.compareLength());
    }

    @Test
    void shouldReturnTrue_when12InchEquals1Feet() {
        provideInput("12\ninch\n1\nfeet\n");

        QuantityLength length = new QuantityLength();
        assertTrue(length.compareLength());
    }

    @Test
    void shouldReturnTrue_whenSameFeetValues() {
        provideInput("2\nfeet\n2\nfeet\n");

        QuantityLength length = new QuantityLength();
        assertTrue(length.compareLength());
    }

    @Test
    void shouldReturnTrue_when24InchEquals2Feet() {
        provideInput("24\ninch\n2\nfeet\n");

        QuantityLength length = new QuantityLength();
        assertTrue(length.compareLength());
    }

    @Test
    void shouldReturnFalse_when1FeetNotEquals13Inch() {
        provideInput("1\nfeet\n13\ninch\n");

        QuantityLength length = new QuantityLength();
        assertFalse(length.compareLength());
    }

    @Test
    void shouldReturnFalse_whenInvalidUnitProvided() {
        provideInput("1\ncm\n12\ninch\n");

        QuantityLength length = new QuantityLength();
        assertFalse(length.compareLength());
    }

    @Test
    void shouldReturnFalse_whenBothUnitsInvalid() {
        provideInput("1\nmeter\n2\nyard\n");

        QuantityLength length = new QuantityLength();
        assertFalse(length.compareLength());
    }

    @Test
    void shouldReturnTrue_whenBothZero() {
        provideInput("0\ninch\n0\nfeet\n");

        QuantityLength length = new QuantityLength();
        assertTrue(length.compareLength());
    }

    @Test
    void shouldReturnTrue_whenNegativeValuesAreEqualAfterConversion() {
        provideInput("-1\nfeet\n-12\ninch\n");
    }
}

