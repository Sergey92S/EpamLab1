package com.shmouradko.geometry.report;

import com.shmouradko.geometry.exception.EmptyFileException;
import com.shmouradko.geometry.exception.WrongDataException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

/**
 * Created by Сергей on 11.10.2016.
 */
public class ReportManager {
    static Logger logger = LogManager.getLogger();

    public static void exceptionReport(int line, WrongDataException e) {
        logger.log(Level.ERROR, "Data at line " + line + " is incorrect", e);
    }

    public static void fileNotFoundExceptionReport(String path, FileNotFoundException e) {
        logger.log(Level.FATAL, "File not found in path = " + path + "", e);
    }

    public static void emptyFileExceptionReport(EmptyFileException e) {
        logger.log(Level.ERROR, "File has no data", e);
    }

    public static void wrongDataExceptionReport(WrongDataException e) {
        logger.log(Level.ERROR, "Current object is not a triangle", e);
    }

    public static void isRightAngleReport(Long id, boolean isRight) {
        if (isRight) {
            logger.log(Level.INFO, "This triangle with id = " + id + " is a right-angle");
        } else {
            logger.log(Level.INFO, "This triangle with id = " + id + " is not a right-angle");
        }
    }

    public static void definePerimeterReport(Long id, double perimeter) {
        logger.log(Level.INFO, "This triangle with id = " + id + " has perimeter = " + perimeter);
    }

    public static void defineSquareReport(Long id, double square) {
        logger.log(Level.INFO, "This triangle with id = " + id + " has perimeter = " + square);
    }

}
