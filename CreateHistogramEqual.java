
import java.io.*;

public class CreateHistogramEqual {

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
            out[i] = Math.abs(255 * (ch[i] - chMin) / (numberOfpixels - 1));
        }
        for (int i = 0; i < histogram.length; i++) {
            System.out.println("histogram at bin " + i + " = " + histogram[i]);

        }
        for (int i = 0; i < ch.length; i++) {
            System.out.println("ch at bin " + i + " = " + ch[i]);

        }
        for (int i = 0; i < out.length; i++) {
            System.out.println("out at bin " + i + " = " + out[i]);

        }
        for (int r = 0; r < img.getNumRows(); r++) {
            for (int c = 0; c < img.getNumCols(); c++) {
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