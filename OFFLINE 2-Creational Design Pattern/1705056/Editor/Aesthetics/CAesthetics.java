package Aesthetics;

import Color.Color;
import Font.Font;
import Font.CourierNewFont;
import Style.Style;
import Color.BlueColor;
import Style.Normal;

public class CAesthetics implements Aesthetics {
    @Override
    public Font font() {
        return new CourierNewFont ();
    }

    @Override
    public Style style() {
        return new Normal ();
    }

    @Override
    public Color color() {
        return new BlueColor ();
    }
}
