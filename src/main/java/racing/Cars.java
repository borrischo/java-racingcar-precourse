package racing;

import racing.car.Car;
import racing.car.Name;
import racing.car.Step;
import racing.condition.ForwardCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Cars {
    private List<Car> cars = new ArrayList<>();

    public Cars() {
    }

    public void addCars(String carsStr) {
        String[] arrCarsStr = carsStr.split(",");
        for (int i=0; i<arrCarsStr.length; i++) {
            if (arrCarsStr[i].trim().length() > 0) {
                Car car = new Car(new Name(arrCarsStr[i]), new Step(), Arrays.asList(new ForwardCondition()));
                this.cars.add(car);
            }
        }
    }

    public void addCars(Car car) {
        this.cars.add(car);
    };

    public List<Car> getCars() {
        return this.cars;
    }

    public int length() {
        return this.cars.size();
    }


}
