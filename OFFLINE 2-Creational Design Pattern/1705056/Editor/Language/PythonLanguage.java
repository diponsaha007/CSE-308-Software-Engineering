package Language;

import Parser.Parser;
import Parser.PythonParser;

public class PythonLanguage implements Language {

    @Override
    public String languageName() {
        return "Python Language";
    }

    @Override
    public Parser parser() {
        return new PythonParser ();
    }
}
