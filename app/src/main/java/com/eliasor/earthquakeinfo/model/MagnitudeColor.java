package com.eliasor.earthquakeinfo.model;

import android.graphics.Color;

/**
 * Created by eliasor on 30/01/2017.
 */

//Gradients taken from : http://beautifulgradients.com/

public class MagnitudeColor {
    public static String MAG_0 = "#00FF00";
    public static String MAG_1 = "#33CC00";
    public static String MAG_2 = "#4CB200";
    public static String MAG_3 = "#659900";
    public static String MAG_4 = "#7F7F00";
    public static String MAG_5 = "#996600";
    public static String MAG_6 = "#B24C00";
    public static String MAG_7 = "#CC3300";
    public static String MAG_8 = "#E51900";
    public static String MAG_9 = "#FF0000";

    public static float hextoHue(String colorHex) {
        int color = Color.parseColor(colorHex);
        float[] hsv = new float[3];
        Color.colorToHSV(color, hsv);
        return hsv[0];
    }

    public static float determineMagnitudeColor(float magnitude) {

        if (magnitude < 1)
            return hextoHue(MAG_0);
        else if (magnitude >= 1 && magnitude < 2)
            return hextoHue(MAG_1);
        else if (magnitude >= 2 && magnitude < 3)
            return hextoHue(MAG_2);
        else if (magnitude >= 3 && magnitude < 4)
            return hextoHue(MAG_3);
        else if (magnitude >= 4 && magnitude < 5)
            return hextoHue(MAG_4);
        else if (magnitude >= 5 && magnitude < 6)
            return hextoHue(MAG_5);
        else if (magnitude >= 6 && magnitude < 7)
            return hextoHue(MAG_6);
        else if (magnitude >= 7 && magnitude < 8)
            return hextoHue(MAG_7);
        else if (magnitude >= 8 && magnitude < 9)
            return hextoHue(MAG_8);
        else if (magnitude >= 9)
            return hextoHue(MAG_9);

        return -1;
    }
}
