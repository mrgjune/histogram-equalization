/*

	A class that represents 1 pixel of a color image

	The ranges of the red, green and blue values are 0 .. 255 inclusive

	Author: Michael Eckmann
	Skidmore College
	for Fall 2019
	Digital Image Processing Course

*/
public class RGBPixel {
    private int r;
    private int g;
    private int b;

    public RGBPixel(int r, int g, int b) {
        if (r < 0) {
            r = 0;
        } else {
            if (r > 255) {
                r = 255;
            }
        }
        this.r = r;

        if (g < 0) {
            g = 0;
        } else {
            if (g > 255) {
                g = 255;
            }
        }
        this.g = g;

        if (b < 0) {
            b = 0;
        } else {
            if (b > 255) {
                b = 255;
            }
        }
        this.b = b;
    }

    public int getRed() {
        return r;
    }

    public int getGreen() {
        return g;
    }

    public int getBlue() {
        return b;
    }

    public void setRed(int r) {
        if (r >= 0 && r <= 255)
            this.r = r;
    }

    public void setGreen(int g) {
        if (g >= 0 && g <= 255)
            this.g = g;
    }

    public void setBlue(int b) {
        if (b >= 0 && b <= 255)
            this.b = b;
    }

    public int getIntensity() {
        return (int) (r * 0.299 + g * 0.587 + b * 0.114);
    }

    public YCbCrPixel convertToYCbCr() {
        int Y = getIntensity();
        double Cb = -0.17 * r - 0.33 * g + 0.5 * b + 128;
        double Cr = 0.5 * r - 0.42 * g - 0.08 * b + 128;
        return new YCbCrPixel(Y, Cb, Cr);
    }

}
