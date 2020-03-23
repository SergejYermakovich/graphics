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


        Image img =  new Image (pathToFile);
        Image img1 = new Image(pathToFile);
        Image img3 =  new Image(img.getWidth(),img.getHeight());
        Transformation.overlayImageCopy(img3,img1,700,1800,0,0,460,300);
       // Image transformImage = Transformation.overlayImageCopy(pathToFile, image, 700, 1800, 0, 0, 460, 300);
        ImageIO.write(img3.getBufferedImage(), "bmp", new File("src/main/resources/TRANSFORM.bmp"));//сохраняем преобразованное изображение

    }
}
