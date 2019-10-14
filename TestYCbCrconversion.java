import java.io.IOException;

public class TestYCbCrconversion {

    public static void main(String[] args) throws IOException {

        RGBImage inImg = new RGBImage(args[0]);

        inImg.createYCbCrPic();
        inImg.convertBackFromYCbCrToRGB();
        inImg.writeImage("convertedToAndFromYCbCr-" + args[0]);
    }

}
