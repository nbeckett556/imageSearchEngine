import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

public class CreateRgbHist {
    public static int[] createRgbHistVector(String filePath) throws Exception {
        File file= new File(filePath);
        BufferedImage img = ImageIO.read(file);
        int numPix = img.getHeight() * img.getWidth();
        int[] red = new int[numPix];
        int[] green = new int[numPix];
        int[] blue = new int[numPix];
        red = getPixValues(red, green, blue, img).get(0);
        green = getPixValues(red, green, blue, img).get(1);
        blue = getPixValues(red, green, blue, img).get(2);

        int[] red_histogram = new int[256];
        calcColourChannelHist(red, red_histogram);

        int[] green_histogram = new int[256];
        calcColourChannelHist(green, green_histogram);

        int[] blue_histogram = new int[256];
        calcColourChannelHist(blue, blue_histogram);

        return concatRgbHistArrays(red_histogram, green_histogram, blue_histogram);
    }

    private static ArrayList<int[]> getPixValues(int[] red, int[] green, int[] blue, BufferedImage img)
    {
        int count = 0;
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                int pixel = img.getRGB(x, y);
                Color color = new Color(pixel, true);
                red[count] = color.getRed();
                green[count] = color.getGreen();
                blue[count] = color.getBlue();
                count++;
            }
        }
       ArrayList<int[]> RGB = new ArrayList<>();
        RGB.add(red);
        RGB.add(green);
        RGB.add(blue);
        return RGB;
    }

    private static void calcColourChannelHist(int[] inputArr, int[] outputArr)
    {
        for (int j : inputArr) {
            outputArr[j] = outputArr[j] + 1;
        }
    }

    private static int[] concatRgbHistArrays(int[] red, int[] green, int[] blue)
    {
        int[] concatArr = new int[red.length + green.length + blue.length];
        System.arraycopy(red, 0, concatArr, 0, red.length);
        System.arraycopy(green, 0, concatArr, red.length, green.length);
        System.arraycopy(blue, 0, concatArr, red.length+green.length, blue.length);

        return concatArr;
    }
}
