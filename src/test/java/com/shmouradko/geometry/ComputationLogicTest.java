package com.shmouradko.geometry;

import com.shmouradko.geometry.entity.Point;
import com.shmouradko.geometry.entity.Triangle;
import com.shmouradko.geometry.exception.WrongDataException;
import com.shmouradko.geometry.logic.ComputationLogic;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Сергей on 05.10.2016.
 */
@RunWith(value = Parameterized.class)
public class ComputationLogicTest {

    private long triangleId;
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private boolean isRightAngle;
    private boolean isTriangle;
    private Triangle triangle;

    public ComputationLogicTest(long triangleId, int x1, int y1, int x2, int y2, int x3, int y3, boolean isRightAngle, boolean isTriangle) {
        this.triangleId=triangleId;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
        this.isRightAngle = isRightAngle;
        this.isTriangle = isTriangle;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1, 1, 1, 2, 1, 3, false, false},
                {2, -1, -1, -1, -2, -1, -3, false, false}
        });
    }

    @Before
    public void initTriangle() {
        triangle = new Triangle(triangleId, new Point(x1, y1), new Point(x2, y2), new Point(x3, y3));
    }

    @Test(expected = WrongDataException.class)
    public void definePerimeterTest() throws WrongDataException {
        ComputationLogic.definePerimeter(triangle);
    }

    @Test(expected = WrongDataException.class)
    public void defineSquareTest() throws WrongDataException {
        ComputationLogic.defineSquare(triangle);
    }

    @Test
    public void isRectangleTestTrue() {
        assertTrue(ComputationLogic.isRightAngle(triangle) == isRightAngle);
    }

    @Test
    public void isRectangleTestFalse() {
        assertFalse(ComputationLogic.isRightAngle(triangle) == !isRightAngle);
    }

    @Test
    public void isTriangleTestTrue() {
        assertTrue(ComputationLogic.isTriangle(triangle) == isTriangle);
    }

    @Test
    public void isTriangleTestFalse() {
        assertFalse(ComputationLogic.isTriangle(triangle) == !isTriangle);
    }

    @After
    public void clearTriangle() {
        triangle = null;
    }

}
