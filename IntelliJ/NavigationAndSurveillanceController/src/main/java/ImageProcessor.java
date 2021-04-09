import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;

public class ImageProcessor {

    /** Simple reading and writting image from specified path*/
    public Mat readImg(){
        Imgcodecs.imread("src/main/resources/img1.jpg");
        System.out.println("Read successful");
        return Imgcodecs.imread("src/main/resources/img1.jpg");
    }
    public void writeImg(){

        Imgcodecs.imwrite("src/main/resources/img2.jpg", readImg());
        System.out.println("Written Successfully");
    }

    /** Detecting faces from specifies image*/
    public static void detectFaceFromImages(Mat capturedMat){

        MatOfRect facesDetected = new MatOfRect();

        CascadeClassifier cascadeClassifier = new CascadeClassifier();
        int minFaceSize = Math.round(capturedMat.rows() * 0.1f);
        cascadeClassifier.load("src/main/resources/haarcascade_frontalface_alt.xml");
        cascadeClassifier.detectMultiScale(capturedMat,
                facesDetected,
                1.1,
                3,
                Objdetect.CASCADE_SCALE_IMAGE,
                new Size(minFaceSize, minFaceSize),
                new Size()
        );

        Rect[] facesArray = facesDetected.toArray();
        for(Rect face : facesArray) {
            Imgproc.rectangle(capturedMat, face.tl(), face.br(), new Scalar(0, 0, 255), 3);
        }
        writeFaceDetectedImg(capturedMat, "src/CaptureImages/faceDetected_img");
    }

    /** Writting face detected image on specified path */
    static int pictureId = 1;
    public static void writeFaceDetectedImg(Mat srcImage, String targetImagePath) {
        Imgcodecs.imwrite(targetImagePath + pictureId +".jpg", srcImage);

        pictureId++;
    }



}
