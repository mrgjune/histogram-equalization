
public class TestHistogram {
    public static void main(String[] args) {
        RGBImage inImg = new RGBImage(args[0]);

        int[] hist = inImg.intensityHistogram();

        for (int i = 0; i < hist.length; i++) {
            System.out.println("histogram at bin " + i + " = " + hist[i]);
        }

    }

}