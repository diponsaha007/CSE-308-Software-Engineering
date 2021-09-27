package Language;

import Parser.Parser;

public interface Language {
    String languageName();

    Parser parser();
}
