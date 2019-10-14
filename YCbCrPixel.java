
public class YCbCrPixel {

    private int Y; // 0..255
    private double Cb;
    private double Cr;

    public YCbCrPixel(int Y, double Cb, double Cr) {
        this.Y = Y;
        this.Cb = Cb;
        this.Cr = Cr;
    }

    public RGBPixel convertToRGB() {

        int r, g, b;
        r = (int) (Y + 1.4 * (Cr - 128));
        g = (int) (Y - 0.344 * (Cb - 128) - 0.714 * (Cr - 128));
        b = (int) (Y + 1.772 * (Cb - 128));
        return new RGBPixel(r, g, b);
    }

}
