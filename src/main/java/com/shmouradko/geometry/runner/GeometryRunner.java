package com.shmouradko.geometry.runner;

import com.shmouradko.geometry.entity.Triangle;
import com.shmouradko.geometry.exception.EmptyFileException;
import com.shmouradko.geometry.exception.WrongDataException;
import com.shmouradko.geometry.logic.ComputationLogic;
import com.shmouradko.geometry.report.ReportManager;

import java.util.List;

/**
 * Created by Сергей on 09.10.2016.
 */
public class GeometryRunner {

    private static void checkAllTriangles(List<Triangle> triangleList) {
        for (Triangle triangle : triangleList) {
            try {
                ReportManager.isRightAngleReport(triangle.getTriangleId(), ComputationLogic.isRightAngle(triangle));
                ReportManager.definePerimeterReport(triangle.getTriangleId(), ComputationLogic.definePerimeter(triangle));
                ReportManager.defineSquareReport(triangle.getTriangleId(), ComputationLogic.defineSquare(triangle));
            } catch (WrongDataException e) {
                ReportManager.wrongDataExceptionReport(e);
            }
        }
    }

    public static void main(String[] args) {
        List<Triangle> triangleList = null;
        try {
            triangleList = ComputationLogic.initialization(triangleList);
            checkAllTriangles(triangleList);
        } catch (EmptyFileException e) {
            ReportManager.emptyFileExceptionReport(e);
        }
    }
}
