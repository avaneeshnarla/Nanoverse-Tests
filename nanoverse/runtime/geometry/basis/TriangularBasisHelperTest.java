package nanoverse.runtime.geometry.basis;

import nanoverse.runtime.control.identifiers.*;
import org.junit.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class TriangularBasisHelperTest {

    private TriangularBasisHelper query;

    @Before
    public void before() throws Exception {
        query = new TriangularBasisHelper();
    }

    @Test
    public void adjustOrigin() throws Exception {
        Coordinate initial = new Coordinate2D(0, 0, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(0, 0, 0);
        assertEquals(actual, expected);
    }

    @Test
    public void adjustX() throws Exception {
        Coordinate initial = new Coordinate2D(8, 0, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(8, 4, 0);
        assertEquals(actual, expected);
    }

    @Test
    public void adjustY() throws Exception {
        Coordinate initial = new Coordinate2D(0, 8, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(0, 8, 0);
        assertEquals(actual, expected);
    }

    @Test
    public void adjustNeg1X() throws Exception {
        // (-1, 0) --> (-1, -1)
        Coordinate initial = new Coordinate2D(-1, 0, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(-1, -1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void adjustNeg2X() throws Exception {
        // (-2, 0) --> (-2, -1)
        Coordinate initial = new Coordinate2D(-2, 0, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(-2, -1, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void adjustNeg3X() throws Exception {
        // (-3, 0) --> (-3, -2)
        Coordinate initial = new Coordinate2D(-3, 0, 0);
        Coordinate actual = query.adjust(initial);
        Coordinate expected = new Coordinate2D(-3, -2, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void invAdjustOrigin() throws Exception {
        Coordinate initial = new Coordinate2D(0, 0, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(0, 0, 0);
        assertEquals(actual, expected);
    }

    @Test
    public void invAdjustX() throws Exception {
        Coordinate initial = new Coordinate2D(8, 4, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(8, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void invAdjustY() throws Exception {
        Coordinate initial = new Coordinate2D(0, 8, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(0, 8, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void invAdjustNeg1X() throws Exception {
        // (-1, 0) <-- (-1, -1)
        Coordinate initial = new Coordinate2D(-1, -1, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(-1, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void invAdjustNeg2X() throws Exception {
        // (-2, 0) <-- (-2, -1)
        Coordinate initial = new Coordinate2D(-2, -1, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(-2, 0, 0);
        assertEquals(expected, actual);
    }

    @Test
    public void invAdjustNeg3X() throws Exception {
        // (-3, 0) <-- (-3, -2)
        Coordinate initial = new Coordinate2D(-3, -2, 0);
        Coordinate actual = query.invAdjust(initial);
        Coordinate expected = new Coordinate2D(-3, 0, 0);
        assertEquals(expected, actual);
    }
}