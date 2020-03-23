package project;

import java.awt.*;

public class Filter {
    //фильтрация - пороговый фильтр с крестообразным окном 5х5
    public static void filter(Image picture, int p) {
        int red;
        int green;
        int blue;
        for (int col = 2; col < picture.width - 2; col++) {
            for (int row = 2; row < picture.height - 2; row++) {
                red = picture.getRed(picture.get(col, row));
                blue = picture.getBlue(picture.get(col, row));
                green = picture.getGreen(picture.get(col, row));
                if (picture.getBrightness(col, row) - p >= picture.getAroundBrightness(col, row)) {
                    red = picture.getAverageRed(col, row);
                    blue = picture.getAverageBlue(col, row);
                    green = picture.getAverageGreen(col, row);
                }
                picture.set(col, row, new Color(red, green, blue));
            }
        }
    }
}
