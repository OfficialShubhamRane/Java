import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class App {

    public static void main(String[] args){

        int width = 1280;    //width of the image
        int height = 1020;   //height of the image

        // For storing image in RAM
        BufferedImage image = null;

        // READ IMAGE
        try
        {
            File input_file = new File("E:\\Java\\ComputerVision\\JavaWithCV\\src\\main\\resources\\img.jpg"); //image file path

            /* create an object of BufferedImage type and pass
               as parameter the width,  height and image int
               type.TYPE_INT_ARGB means that we are representing
               the Alpha, Red, Green and Blue component of the
               image pixel using 8 bit integer value. */
            image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            // Reading input file
            image = ImageIO.read(input_file);

            System.out.println("Reading complete.");
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }

        //Write file
        try
        {
            // Output file path
            File output_file = new File("E:\\Java\\ComputerVision\\JavaWithCV\\src\\main\\resources\\img2.jpg");

            // Writing to file taking type and path as
            ImageIO.write(image, "jpg", output_file);

            System.out.println("Writing complete.");
        }
        catch(IOException e)
        {
            System.out.println("Error: "+e);
        }

    }
}
