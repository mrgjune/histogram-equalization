
import java.io.*;

public class CreateHistogramEqualWithY {

    public static RGBImage histEqual(RGBImage img) {
        RGBImage histImage = new RGBImage(img.getHeight(), img.getWidth());

        int[] histogram = img.intensityHistogram();
        int[] ch = new int[256];
        int numberOfpixels = img.getWidth() * img.getHeight();

        for (int i = 0; i < histogram.length; i++) {
            ch[i] = 0;
            for (int j = 0; j <= i; j++) {
                ch[i] += histogram[j];
            }

        }
        int chMin = numberOfpixels;

        for (int i = 0; i < ch.length; i++) {
            if (ch[i] != 0 && ch[i] < chMin) {
                chMin = ch[i];
            }
        }
        int[] out = new int[256];

        for (int i = 0; i < out.length; i++) {
            out[i] = 255 * (ch[i] - chMin) / (numberOfpixels - 1);
        }

        for (int r = 0; r < img.getNumRows(); r++) {
            for (int c = 0; c < img.getNumCols(); c++) {
                RGBPixel pixel = img.getPixel(r, c);
                YCbCrPixel yPix = pixel.convertToYCbCr();

                int histVal = img.getPixel(r, c).getRed();
                histVal = out[histVal];
                histImage.setPixel(r, c, histVal, histVal, histVal);
            }
        }

        return histImage;
    }

    public static void main(String args[]) throws IOException {
        RGBImage inImg = new RGBImage(args[0]); // reads the image on disk with name args[0] and creates an RGBImage
                                                // object
        RGBImage outImg;
        outImg = histEqual(inImg);
        outImg.writeImage(args[1]);
    }

}