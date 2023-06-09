import Engine.ImageAnalysisV2;
import Engine.ImageAnalyzis;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            double result = ImageAnalyzis.ImageCompare(ImageIO.read(new File("Images/sheldon.jpg")),
                    ImageIO.read(new File("Images/sheldon2.jpg")));
            double result2 = ImageAnalysisV2.ImageCompare(ImageIO.read(new File("Images/sheldon.jpg")),
                    ImageIO.read(new File("Images/sheldon2.jpg")));

            System.out.println("The similitud is: " + result);
            System.out.println("Difference porcentage --> "+ result2);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
