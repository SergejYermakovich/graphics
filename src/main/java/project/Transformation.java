package project;

import java.awt.*;

public class Transformation {

    public static Image overlayImageCopy(Image result, Image picture, int x, int y, int picx1, int picy1, int picx2, int picy2) {
        for (int i = 0; i < result.width; i++) {
            for (int j = 0; j < result.height; j++) {
                Color qrt = result.get(i, j);
                result.set(i, j, qrt);
            }
        }
        if (picx2 - picx1 > result.height - x) {
            picx2 = result.height - x;
        }
        if (picy2 - picy1 > result.width - y) {
            picy2 = result.width - y;
        }


        for (int i = 0; i < picx2 - picx1; i++) {
            for (int j = 0; j < picy2 - picy1; j++) {
                Color qwe = picture.get(picy1 + j, picx1 + i);
                result.set(j + y, i + x, qwe);
            }
        }
        return result;
    }


}
