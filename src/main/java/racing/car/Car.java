package racing.car;

import racing.condition.Condition;

import java.util.List;
import java.util.Random;

public class Car {
    // 자동차 이름
    private Name name;
    // 자동차 전진 스탭
    private Step step;
    // 이동 조건
    List<Condition> forwardConditions;

    public Car(Name name, Step step, List<Condition> forwardConditions) {
        this.name = name;
        this.step = step;
        this.forwardConditions = forwardConditions;
    }

    public Name getName() {
        return this.name;
    }

    public Step getStep() {
        return this.step;
    }

    public void putAccelerator() {
        for (Condition condition : forwardConditions) {
            Random random = new Random();
            int value = random.nextInt(10);
            if (condition.check(value)) {
                this.step.forward();
                break;
            }
        }
    }
}
