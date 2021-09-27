package Aesthetics;

import Color.Color;
import Font.Font;
import Font.ConsolasFont;
import Style.Style;
import Color.BlueColor;
import Style.Normal;

public class PythonAesthetics implements Aesthetics {

    @Override
    public Font font() {
        return new ConsolasFont ();
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

