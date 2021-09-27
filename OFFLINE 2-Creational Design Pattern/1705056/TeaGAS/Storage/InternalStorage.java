package Storage;

public class InternalStorage implements Storage {

    @Override
    public String type() {
        return "Using internal storage";
    }
}
