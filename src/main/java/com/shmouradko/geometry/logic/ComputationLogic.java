package com.shmouradko.geometry.logic;

import com.shmouradko.geometry.entity.Triangle;
import com.shmouradko.geometry.exception.EmptyFileException;
import com.shmouradko.geometry.exception.WrongDataException;
import com.shmouradko.geometry.scanner.TriangleScanner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Сергей on 04.10.2016.
 * business-logic of computation with triangle
 */
public class ComputationLogic {
    private static final boolean isTriangle = true;

    public static List<Triangle> initialization(List<Triangle> triangleList) throws EmptyFileException {
        triangleList = new ArrayList<>();
        TriangleScanner.scanFile(triangleList);
        return triangleList;
    }

    /**
     * return the distance between point A and point B
     *
     * @param triangle
     * @return
     */
    public static double defineAB(Triangle triangle) {
        return Math.sqrt(Math.pow((triangle.getA().getY() - triangle.getB().getY()), 2) + Math.pow((triangle.getA().getX() - triangle.getB().getX()), 2));
    }

    /**
     * return the distance between point B and point C
     *
     * @param triangle
     * @return
     */
    public static double defineBC(Triangle triangle) {
        return Math.sqrt(Math.pow((triangle.getB().getY() - triangle.getC().getY()), 2) + Math.pow((triangle.getB().getX() - triangle.getC().getX()), 2));
    }

    /**
     * return the distance between point A and point C
     *
     * @param triangle
     * @return
     */
    public static double defineAC(Triangle triangle) {
        return Math.sqrt(Math.pow((triangle.getA().getY() - triangle.getC().getY()), 2) + Math.pow((triangle.getA().getX() - triangle.getC().getX()), 2));
    }

    /**
     * return the perimeter of current triangle
     *
     * @param triangle
     * @return
     */
    public static double definePerimeter(Triangle triangle) throws WrongDataException {
        if (!isTriangle(triangle)) {
            throw new WrongDataException();
        } else {
            return defineAB(triangle) + defineBC(triangle) + defineAC(triangle);
        }
    }

    /**
     * return the square of current triangle
     *
     * @param triangle
     * @return
     */
    public static double defineSquare(Triangle triangle) throws WrongDataException {
        if (!isTriangle(triangle)) {
            throw new WrongDataException();
        } else {
            return Math.sqrt(definePerimeter(triangle) * (definePerimeter(triangle) - defineAB(triangle)) * (definePerimeter(triangle) - defineBC(triangle)) * (definePerimeter(triangle) - defineAC(triangle)));
        }
    }

    /**
     * return true if the param is a right-angle triangle
     *
     * @param triangle
     * @return
     */
    public static boolean isRightAngle(Triangle triangle) {
        return defineAB(triangle) == Math.sqrt(Math.pow(defineBC(triangle), 2) + Math.pow(defineAC(triangle), 2)) || defineBC(triangle) == Math.sqrt(Math.pow(defineAB(triangle), 2) + Math.pow(defineAC(triangle), 2)) || defineAC(triangle) == Math.sqrt(Math.pow(defineBC(triangle), 2) + Math.pow(defineAB(triangle), 2)) ? isTriangle : !isTriangle;
    }

    /**
     * return true if the param is a triangle
     *
     * @param triangle
     * @return
     */
    public static boolean isTriangle(Triangle triangle) {
        return defineAB(triangle) == (defineBC(triangle) + defineAC(triangle)) || defineAC(triangle) == (defineBC(triangle) + defineAB(triangle)) || defineBC(triangle) == (defineAB(triangle) + defineAC(triangle)) ? !isTriangle : isTriangle;
    }

}
