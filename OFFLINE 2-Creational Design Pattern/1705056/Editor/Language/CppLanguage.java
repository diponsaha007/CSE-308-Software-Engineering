package Language;

import Parser.Parser;
import Parser.CppParser;

public class CppLanguage implements Language {
    @Override
    public String languageName() {
        return "Cpp Language";
    }

    @Override
    public Parser parser() {
        return new CppParser ();
    }
}
