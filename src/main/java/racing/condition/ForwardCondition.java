package racing.condition;

public class ForwardCondition implements Condition {
    public boolean check(int value) {

        if (value >= 4) {
            return true;
        }

        return false;
    }
}
