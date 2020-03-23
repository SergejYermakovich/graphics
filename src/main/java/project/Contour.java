package project;


import java.awt.*;

public class Contour {

//    public static void setContour(Image image) {
//        for (int col = 1; col < image.width - 1; col++) {
//            for (int row = 1; row < image.height - 1; row++) {
//                int newF = Math.abs(5 * getS(col, row, image) - 3 * getT(col, row, image));
//            }
//        }
//    }

    private static int getS(int x, int y, Image image) {
        int s = 0;
        s += image.getBrightness(x - 1, y + 1)
                + image.getBrightness(x, y + 1)
                + image.getBrightness(x + 1, y + 1);
        return s;
    }

    private static int getT(int x, int y, Image image) {
        int t = 0;
        t += image.getBrightness(x + 1, y)
                + image.getBrightness(x + 1, y - 1)
                + image.getBrightness(x, y - 1)
                + image.getBrightness(x - 1, y - 1)
                + image.getBrightness(x - 1, y);
        return t;
    }

    public static int[][] getFMatrix(Image image) {
        int fArray[][] = new int[image.width - 1][image.height-1];

        for (int col = 1; col < image.width - 1; col++) {
            for (int row = 1; row < image.height - 1; row++) {
                int newF = Math.abs(5 * getS(col, row, image) - 3 * getT(col, row, image));
                fArray[col][row] = newF;
            }
        }


        return fArray;
    }

//    public static int[][] calibrate(int[][] array) {
//        int[][] calibratedArray = new int[array.length][array[0].length];
//        for (int i = 0; i < array.length; i++) {
//            for (int j = 0; j < array[0].length; j++) {
//                calibratedArray[i][j] = (array[i][j] + 255) / 2;
//            }
//        }
//        return calibratedArray;
//    }

    public static void setContour(Image picture, int border) {
        int[][] nonCalibratedArray = getFMatrix(picture);
       // int[][] calibratedArray = calibrate(nonCalibratedArray);
        for (int col = 0; col < nonCalibratedArray.length; col++) {
            for (int row = 0; row < nonCalibratedArray[0].length; row++) {
                if (nonCalibratedArray[col][row] >= border) {
                    picture.set(col, row, new Color(0, 0, 0));
                } else {
                    picture.set(col, row, new Color(255, 255, 255));
                }
            }
        }
    }
}
