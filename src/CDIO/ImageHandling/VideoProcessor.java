package CDIO.ImageHandling;


import nu.pattern.OpenCV;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
//
// Detects faces in an image, draws boxes around them, and writes the results
// to "faceDetection.png".
//

//STOLEN SHIT:
//https://stackoverflow.com/questions/30296626/opencv-import-highgui-in-android-studio-is-showing-error-cannot-resolvei-added
//https://answers.opencv.org/question/34970/detection-of-table-tennis-balls-and-color-correction/
//

// preliminary ideas for imagehandling package.
//Goal of class is to create a video feed object.
//this video feed will be accessed by the processer - how many times a second?
//this processed video image will be mapper - to map to Navigation system.
//this processed video will be used to track robot - and update the robot position.
// start with Still image processing.



public class VideoProcessor {




    public static void main(String[] args) {
        System.out.println("Hello, OpenCV");
        // Load the native library.
        //System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        OpenCV.loadShared();
//        String opencvpath = System.getProperty("user.dir") + "/files/";
//        String libPath = System.getProperty("java.library.path");
//        System.loadLibrary(opencvpath + Core.NATIVE_LIBRARY_NAME);
        jpgProcessor processor = new jpgProcessor();
        processor.run();
    }

    public static class jpgProcessor {

        public void run() {
            String imgpath = System.getProperty("user.dir") + "/src/TestImages/IMG_6092.jpg";
            System.out.println("Working Directory = " +
                    System.getProperty("user.dir"));
            System.out.println(imgpath);

            Mat image = Imgcodecs.imread(imgpath);


            // Save the processed file
            //String filename = imgpath + "_processed";
            //System.out.println(String.format("Writing %s", filename));
            //Imgcodecs.imwrite(filename, image);
        }
    }


//    class jpgProcessor{
//
//        src = HighGui.imread(imgpath,1);
//        Mat srcH = new Mat();
//        src.convertTo(srcH, -1, 0.7, 0);
//        HighGui.imwrite("contrast.jpg", srcH);
//
//        Imgproc.cvtColor(srcH, src_gray, Imgproc.COLOR_BGR2GRAY);
//        Imgproc.equalizeHist(src_gray, src_gray);
//        HighGui.imwrite("outgray.jpg", src_gray);
//        Imgproc.GaussianBlur(src_gray, smooth, new Size(11,11),4, 4);
//        HighGui.imwrite("blur.jpg", smooth);
//        Imgproc.HoughCircles(smooth, circles, Imgproc.CV_HOUGH_GRADIENT, 2, 20, 81, 29, 10, 13);
//
//        System.out.println("Found "+circles.cols() + " circles.");
//        for (int i = 0; i < circles.cols(); i++) {
//            double[] circle = circles.get(0,i);
//            if (src.get((int)circle[1], (int)circle[0])[2]>140){
//                list.add(new Ball((int)circle[0],(int)circle[1]));
//                Point center = new Point((int)circle[0], (int)circle[1]);
//
//                int radius =  (int) circle[2];
//                // circle center
//                Core.circle( src, center, 3, new Scalar(0,255,0), -1, 8, 0 );
//                // circle outline
//                Core.circle( src, center, radius, new Scalar(0,0,255), 3, 8, 0 );
//            }
//        }
//
//
//    }

}




