import Aesthetics.Aesthetics;
import Language.Language;
import Language.CLanguage;
import Language.CppLanguage;
import Language.PythonLanguage;
import Aesthetics.CAesthetics;
import Aesthetics.CppAesthetics;
import Aesthetics.PythonAesthetics;

public class Editor {
    private static Editor editor = new Editor ();
    private Language language;
    private Aesthetics aesthetics;

    private Editor() {

    }

    public void openFile(String filename) {
        if (filename.length () >= 2 && filename.substring (filename.length () - 2).equals (".c")) {
            language = new CLanguage ();
            aesthetics = new CAesthetics ();
        }
        else if (filename.length () >= 4 && filename.substring (filename.length () - 4).equals (".cpp")) {
            language = new CppLanguage ();
            aesthetics = new CppAesthetics ();
        }
        else if (filename.length () >= 3 && filename.substring (filename.length () - 3).equals (".py")) {
            language = new PythonLanguage ();
            aesthetics = new PythonAesthetics ();
        }
        else {
            System.out.println ("Invalid File Input!");
            return;
        }
        show ();
    }

    public void show() {
        System.out.println ("Language : " + language.languageName ());
        System.out.println ("Parser : " + language.parser ().rules ());
        System.out.println ("Font : " + aesthetics.font ().name ());
        System.out.println ("Color : " + aesthetics.color ().name ());
        System.out.println ("Style : " + aesthetics.style ().name ());
    }

    public static Editor getEditor() {
        return editor;
    }
}
