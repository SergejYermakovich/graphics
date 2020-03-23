package project;


import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        String pathToFile = "src/main/resources/image.bmp";
        Image image = new Image(pathToFile);

        Image.setNoise(23, image);//добавляем шум к картинке , первый параметр - уровень шума
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/AFTER_NOISE.bmp"));//сохраняем зашумленное изображение

        Filter.filter(image, 22);//производим фильтрацию изображения , 2 параметр это порог
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/AFTER_FILTER.bmp"));//сохраняем отфильтрованное изображение

        Contour.setContour(image ,200);
        ImageIO.write(image.getBufferedImage(), "bmp", new File("src/main/resources/CONTOUR.bmp"));//сохраняем отфильтрованное изображение

        Image result =new Image(pathToFile);
        Transformation.overlayImageCopy(result, new Image(pathToFile), 100, 100, 0, 0, 600, 600);
        ImageIO.write(result.getBufferedImage(), "bmp", new File("src/main/resources/TRANSFORM.bmp"));//сохраняем преобразованное изображение


        StartMenuGUI startMenuGUI = new StartMenuGUI("MENU");
        startMenuGUI.setSize(640, 480);
        startMenuGUI.setVisible(true);
    }
}
