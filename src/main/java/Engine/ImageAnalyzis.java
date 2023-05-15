package Engine;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageAnalyzis {
    public static Double ImageCompare(BufferedImage image1, BufferedImage image2)  {
        int image1Width = image1.getWidth();
        int image2Width = image2.getWidth();
        int image1Height = image1.getHeight();
        int image2Height = image2.getHeight();
        long diff =0;
        double avg;

        if (image1Height != image2Height || image1Width != image2Width){
            System.err.println("Images size doesn't match");
            return 0.00;
        }
        for (int j = 0; j < image1Height; j++) {
            for (int i = 0; i < image1Width; i++) {
                System.out.println(i + " x "+j);
                //Get the RGB values of the pixel
                int pixel1 = image1.getRGB(i,j);
                int pixel2 = image2.getRGB(i,j);
                Color color1 = new Color(pixel1, true);
                Color color2 = new Color(pixel2, true);
                int r1 = color1.getRed();
                int g1 = color1.getGreen();
                int b1 = color1.getBlue();
                int r2 = color2.getRed();
                int g2 = color2.getGreen();
                int b2 = color2.getBlue();

                //sum of differences of RGB values of the two images
                long data = Math.abs(r1-r2)+Math.abs(g1-g2)+Math.abs(b1-b2);
                diff = diff + data;
            }
        }
        avg = (double) diff / (image1Width * image1Height * 3);
        return (avg/255)*100;
    }
}
