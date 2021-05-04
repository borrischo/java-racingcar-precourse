package racing.validate;

public class CarNameValidate implements Validate {
    @Override
    public boolean valid(String name) {
        int nameLength = name.length();
        if (nameLength > 0 && nameLength < 6) {
            return true;
        }

        return false;
    }
}
