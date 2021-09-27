package Storage;

public class SDCard implements Storage {

    @Override
    public String type() {
        return "Using SD card";
    }
}
