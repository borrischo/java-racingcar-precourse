import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Cars;
import racing.Racing;
import racing.car.Car;
import racing.car.Name;
import racing.car.Step;
import racing.condition.ForwardCondition;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @Test
    @DisplayName("자동차의 위치에 따라서 1위 자동차들을 가져온다.")
    public void test_winnier() {
        Cars cars = new Cars();
        Car car1 = new Car(new Name("car1"), new Step(), Arrays.asList(new ForwardCondition()));
        Car car2 = new Car(new Name("car2"), new Step(), Arrays.asList(new ForwardCondition()));
        Car car3 = new Car(new Name("car3"), new Step(), Arrays.asList(new ForwardCondition()));

        car1.getStep().forward();
        car1.getStep().forward();
        car1.getStep().forward();
        car2.getStep().forward();
        car2.getStep().forward();
        car3.getStep().forward();

        cars.addCars(car1);
        cars.addCars(car2);
        cars.addCars(car3);

        Racing racing = new Racing();
        racing.setCars(cars);
        List<Car> actual = racing.getWinner();

        assertThat(actual.get(0).getName().getTitle()).isEqualTo("car1");

    }

}
