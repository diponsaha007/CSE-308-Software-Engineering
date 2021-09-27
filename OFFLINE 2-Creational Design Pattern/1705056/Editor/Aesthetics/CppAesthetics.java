package Aesthetics;

import Color.Color;
import Font.Font;
import Font.MonacoFont;
import Style.Style;
import Color.BlueColor;
import Style.Normal;

public class CppAesthetics implements Aesthetics {

    @Override
    public Font font() {
        return new MonacoFont ();
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
