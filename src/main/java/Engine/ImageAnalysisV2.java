package Engine;

import java.awt.image.BufferedImage;

public class ImageAnalysisV2 {

    public static double ImageCompare(BufferedImage image1, BufferedImage image2) {
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
        for (int y = 0; y < image1Height; y++) {
            for (int x = 0; x < image1Width; x++) {
                int rgbA = image1.getRGB(x,y);
                int rgbB = image2.getRGB(x,y);
                int redA = (rgbA >> 16) & 0xff;
                int greenA = (rgbA >> 8 ) & 0xff;
                int blueA = (rgbA) & 0xff;

                int redB = (rgbB >> 16) & 0xff;
                int greenB = (rgbB >> 8 ) & 0xff;
                int blueB = (rgbB) & 0xff;

                diff += Math.abs(redA - redB);
                diff += Math.abs(greenA - greenB);
                diff += Math.abs(blueA - blueB);

            }
        }
        avg = (double) diff / (image1Width * image1Height * 3);
        return (avg/255)*100;
    }
}
