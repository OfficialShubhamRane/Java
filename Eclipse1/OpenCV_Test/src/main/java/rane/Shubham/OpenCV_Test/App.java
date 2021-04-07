package rane.Shubham.OpenCV_Test;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;

import com.sun.glass.ui.Application;

public class App
{
    public static void main( String[] args )
    {
    	
    	/** The following program code to create and display a simple matrix in Java using OpenCV library **/
    	
        //Loading the core library 
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);     
//        //Creating a matrix 
//        Mat matrix = new Mat(5, 5, CvType.CV_8UC1, new Scalar(0));  
//        //Retrieving the row with index 0 
//        Mat row0 = matrix.row(0);
//        //setting values of all elements in the row with index 0 
//        row0.setTo(new Scalar(1)); 
//        //Retrieving the row with index 3 
//        Mat col3 = matrix.col(3);  
//        //setting values of all elements in the row with index 3 
//        col3.setTo(new Scalar(3)); 
//        //Printing the matrix 
//        System.out.println("OpenCV Mat data:\n" + matrix.dump()); 
    	
    	/** The following program code is to Reading the image from file location **/
    	
//    	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    	Mat mat = Imgcodecs.imread("E:\\Java\\Eclipse1\\OpenCV_Test\\src\\main\\java\\img1.jpg");
//    	System.out.println("Read");
    	
    	/** Following program is an example to write an image using Java program using OpenCV library **/
    	
//        //Loading the OpenCV core library  
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME); 
//        //Instantiating the imagecodecs class 
//        Imgcodecs imageCodecs = new Imgcodecs(); 
//        //Reading the Image from the file and storing it in to a Matrix object 
//        String file ="E:\\Java\\Eclipse1\\OpenCV_Test\\src\\main\\java\\img1.jpg";   
//        Mat matrix = imageCodecs.imread(file); 
//        System.out.println("Image Loaded ..........");
//        String file2 = "E:\\Java\\Eclipse1\\OpenCV_Test\\src\\main\\java\\img2.jpg"; 
//        //Writing the image 
//        imageCodecs.imwrite(file2, matrix); 
//        System.out.println("Image Saved ............"); 
    	
    	/** The following program code shows how you can read an image and display it through swing window using OpenCV library **/
    	 // https://www.tutorialspoint.com/opencv/opencv_gui.htm
    	
    	
    	
    	


    	
    }
}
