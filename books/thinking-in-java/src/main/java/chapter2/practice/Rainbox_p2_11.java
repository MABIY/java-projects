package chapter2.practice;

/**
 * @author lh
 */
public class Rainbox_p2_11 {
    public static void main(String[] args) {
        AllTheColorsOfTheRainbox atc = new AllTheColorsOfTheRainbox();
        System.out.println("atc.anIntegerRepresentingColors = " + atc.anIntegerRepresentingColors);
        atc.changeColor(7);
        atc.changeTheHueOfTheColor(77);
        System.out.println("After color change, atc.anIntegerRepresentingColors = " + atc.anIntegerRepresentingColors);
        System.out.println("atc.hue = " + atc.hue);
    }

}

class AllTheColorsOfTheRainbox{
    int anIntegerRepresentingColors = 0;
    int hue = 0;
    void changeTheHueOfTheColor(int newHue){
        hue = newHue;
    }

    int changeColor(int newColor){
        return anIntegerRepresentingColors = newColor;
    }
}
