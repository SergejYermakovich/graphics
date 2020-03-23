package project;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String pathToFile = "src/main/resources/image.bmp";
        Image image = new Image(pathToFile);

        Image.setNoise(23, image);//добавляем шум к картинке
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/AFTER_NOISE.bmp"));//сохраняем зашумленное изображение

        Filter.filter(image, 22);//производим фильтрацию изображения
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/AFTER_FILTER.bmp"));//сохраняем отфильтрованное изображение

        Contour.setContour(image);
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/CONTOUR.bmp"));//сохраняем отфильтрованное изображение


        Image image1 = new Image(pathToFile);
        Image image2 = new Image(pathToFile);

        Image result = Transformation.overlayImageCopy(image1, image2, 700, 1800, 0, 0, 460, 300);
        ImageIO.write(result.getBufferedImage(), "bmp", new File("src/main/resources/TRANSFORM.bmp"));//сохраняем преобразованное изображение

    }
}
