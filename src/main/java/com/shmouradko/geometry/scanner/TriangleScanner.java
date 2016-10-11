package com.shmouradko.geometry.scanner;

import com.shmouradko.geometry.entity.Point;
import com.shmouradko.geometry.entity.Triangle;
import com.shmouradko.geometry.exception.EmptyFileException;
import com.shmouradko.geometry.exception.WrongDataException;
import com.shmouradko.geometry.report.ReportManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Сергей on 10.10.2016.
 */
public class TriangleScanner {
    private static int line;
    private static final int FIRST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int THIRD_ELEMENT = 2;
    private static final int FORTH_ELEMENT = 3;
    private static final int FIFTH_ELEMENT = 4;
    private static final int SIXTH_ELEMENT = 5;
    private static final int SEVENTH_ELEMENT = 6;
    private static final int NUMBER_OF_DATA_IN_LINE = 7;
    private static final String FILE_PATH = System.getProperty("user.dir") + "\\files\\data.txt";
    private static final String DIGITAL_REG_EXP = "^-?\\d+$";
    private static final String DELIMITER = " ";

    private static void validation(String[] dataArray) throws WrongDataException {
        if (dataArray.length != NUMBER_OF_DATA_IN_LINE) {
            throw new WrongDataException();
        }
        for (String data : dataArray) {
            if (data.isEmpty()) {
                throw new WrongDataException();
            }
            if (!data.matches(DIGITAL_REG_EXP)) {
                throw new WrongDataException();
            }
        }
    }

    private static void initialization(List<Triangle> triangleList, String[] dataArray) {
        triangleList.add(new Triangle(Long.parseLong(dataArray[FIRST_ELEMENT]), new Point(Integer.parseInt(dataArray[SECOND_ELEMENT]), Integer.parseInt(dataArray[THIRD_ELEMENT])), new Point(Integer.parseInt(dataArray[FORTH_ELEMENT]), Integer.parseInt(dataArray[FIFTH_ELEMENT])), new Point(Integer.parseInt(dataArray[SIXTH_ELEMENT]), Integer.parseInt(dataArray[SEVENTH_ELEMENT]))));
    }

    public static void scanFile(List<Triangle> triangleList) throws EmptyFileException {
        Scanner scanner = null;
        String[] dataArray;
        try {
            scanner = new Scanner(new File(FILE_PATH));
            while (scanner.hasNext()) {
                try {
                    line++;
                    dataArray = scanner.nextLine().split(DELIMITER);
                    validation(dataArray);
                    initialization(triangleList, dataArray);
                } catch (WrongDataException e) {
                    ReportManager.exceptionReport(line, e);
                }
            }
            if (triangleList.isEmpty()) {
                throw new EmptyFileException();
            }
        } catch (FileNotFoundException e) {
            ReportManager.fileNotFoundExceptionReport(FILE_PATH, e);
            throw new RuntimeException();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

}
