package CDIO.ImageHandling;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Point;
import org.opencv.core.Scalar;
import org.opencv.highgui.HighGui;
import org.opencv.imgproc.Imgproc;

public class ImageHandling {
    src = HighGui.imread("Picture 10.jpg",1);
    Mat srcH = new Mat();
        src.convertTo(srcH, -1, 0.7, 0);
        HighGui.imwrite("contrast.jpg", srcH);

        Imgproc.cvtColor(srcH, src_gray, Imgproc.COLOR_BGR2GRAY);
        Imgproc.equalizeHist(src_gray, src_gray);
        HighGui.imwrite("outgray.jpg", src_gray);
        Imgproc.GaussianBlur(src_gray, smooth, new Size(11,11),4, 4);
        HighGui.imwrite("blur.jpg", smooth);
        Imgproc.HoughCircles(smooth, circles, Imgproc.CV_HOUGH_GRADIENT, 2, 20, 81, 29, 10, 13);

        System.out.println("Found "+circles.cols() + " circles.");
        for (int i = 0; i < circles.cols(); i++) {
        double[] circle = circles.get(0,i);
        if (src.get((int)circle[1], (int)circle[0])[2]>140){
            list.add(new Ball((int)circle[0],(int)circle[1]));
            Point center = new Point((int)circle[0], (int)circle[1]);

            int radius =  (int) circle[2];
            // circle center
            Core.circle( src, center, 3, new Scalar(0,255,0), -1, 8, 0 );
            // circle outline
            Core.circle( src, center, radius, new Scalar(0,0,255), 3, 8, 0 );
        }
    }
}
