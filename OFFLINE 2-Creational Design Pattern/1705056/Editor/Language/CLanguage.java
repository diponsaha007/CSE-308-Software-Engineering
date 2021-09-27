package Language;

import Parser.Parser;
import Parser.CParser;

public class CLanguage implements Language {

    @Override
    public String languageName() {
        return "C Language";
    }

    @Override
    public Parser parser() {
        return new CParser ();
    }
}
