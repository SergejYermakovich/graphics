package project;

import java.awt.*;

public class Transformation {


        public static void overlayImageCopy(Image qwe1, Image picture, int x, int y, int picx1, int picy1, int picx2, int picy2) {
            for (int i = 0; i < picture.width; i++) {
                for (int j = 0; j < picture.height; j++) {
                    Color qrt = picture.get(i, j);
                    qwe1.set(i, j, qrt);
                }
            }
            if (picx2 - picx1 > picture.height - x) {
                picx2 = picture.height - x;
            }
            if (picy2 - picy1 > picture.width - y) {
                picy2 = picture.width - y;
            }

            for (int i = 0; i < picx2 - picx1; i++) {
                for (int j = 0; j < picy2 - picy1; j++) {
                    Color qwe = picture.get(picy1 + j, picx1 + i);
                    qwe1.set(j + y, i + x, qwe);
                }
            }
        }


}
