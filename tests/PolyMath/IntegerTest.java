package PolyMath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegerTest {
    Integer i1;
    Integer i2;


    @BeforeEach
    void setUp() {
        i1 = new Integer(2);
        i2 = new Integer(5);
    }

    @Test
    void add() {
        Scalar res = i1.add(i2);
        Scalar actualRes = new Integer(5);

        assertEquals(actualRes.toString(), res.toString());
    }

    @Test
    void mul() {
    }

    @Test
    void power() {
    }

    @Test
    void sign() {
    }

    @Test
    void neg() {
    }

    @Test
    void testToString() {
    }
}