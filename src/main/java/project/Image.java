package project;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    private String imgName;
    private BufferedImage bufferedImage;
    int width;
    int height;

    public Image(String name) {
        this.imgName = name;
        try {
            this.bufferedImage = ImageIO.read(new File(name));
            this.width=bufferedImage.getWidth();
            this.height=bufferedImage.getHeight();
        } catch (IOException ex) {
            throw new RuntimeException("cant read the file");
        }
    }

    public String getImgName() {
        return imgName;
    }

    public BufferedImage getBufferedImage() {
        return bufferedImage;
    }

    public Color get(int col, int row) {
        return new Color(bufferedImage.getRGB(col, row));

    }

    public void set(int col, int row, Color color) {
        bufferedImage.setRGB(col, row, color.getRGB());
    }


    public int getBlue(Color color) {
        return color.getBlue();
    }

    public int getRed(Color color) {
        return color.getRed();
    }

    public int getGreen(Color color) {
        return color.getGreen();
    }

    public int getBrightness(int x, int y) {
        return ((int) ((0.3 * getRed(get(x, y))) + (0.6 * getGreen(get(x, y))) + (0.1 * getBlue(get(x, y)))));
    }

    public int getAroundBrightness(int x, int y) {
        return (getBrightness(x - 1, y) + getBrightness(x - 2, y)
                + getBrightness(x + 1, y) + getBrightness(x + 2, y)
                + getBrightness(x, y - 1) + getBrightness(x, y - 2)
                + getBrightness(x, y + 1) + getBrightness(x, y + 2)) / 8;

    }

    public int getAverageBlue(int x, int y) {
        return (getBlue(get(x + 1, y)) + getBlue(get(x + 2, y))
                + getBlue(get(x - 1, y)) + getBlue(get(x - 2, y))
                + getBlue(get(x, y + 1)) + getBlue(get(x, y - 1))
                + getBlue(get(x, y + 2)) + getBlue(get(x, y - 2))) / 8;
    }

    public int getAverageRed(int x, int y) {
        return (getRed(get(x + 1, y)) + getRed(get(x + 2, y))
                + getRed(get(x - 1, y)) + getRed(get(x - 2, y))
                + getRed(get(x, y + 1)) + getRed(get(x, y - 1))
                + getRed(get(x, y + 2)) + getRed(get(x, y - 2))) / 8;
    }

    public int getAverageGreen(int x, int y) {
        return (getGreen(get(x + 1, y)) + getGreen(get(x + 2, y))
                + getGreen(get(x - 1, y)) + getGreen(get(x - 2, y))
                + getGreen(get(x, y + 1)) + getGreen(get(x, y - 1))
                + getGreen(get(x, y + 2)) + getGreen(get(x, y - 2))) / 8;
    }


    public static void setNoise(int noise, Image picture) {
        int red;
        int blue;
        int green;
        for (int col = 0; col < picture.width; col++) {
            for (int row = 0; row < picture.height; row++) {
                if ((int) (Math.random() * 100) < noise) {
                    red = (int) (Math.random() * 255);
                    green = (int) (Math.random() * 255);
                    blue = (int) (Math.random() * 255);
                } else {
                    green = picture.getGreen(picture.get(col, row));
                    red = picture.getRed(picture.get(col, row));
                    blue = picture.getBlue(picture.get(col, row));
                }
                picture.set(col, row, new Color(red, green, blue));
            }
        }
    }

}



