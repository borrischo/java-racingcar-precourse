package racing;

import racing.car.Car;
import racing.car.Name;
import racing.car.Step;
import racing.condition.ForwardCondition;
import racing.output.DashOutput;
import racing.validate.CarNameValidate;
import racing.validate.Validate;

import java.util.*;

public class Racing {
    private Cars cars = new Cars();
    private DashOutput dashOutput = new DashOutput();
    private Validate carnameValidate = new CarNameValidate();
    Scanner input = new Scanner(System.in);
    private int laps = 0;

    public void addCars(String cars) {
        this.cars.addCars(cars);
    }

    public String inputCarName() {
        boolean validStart = true;
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String carsNames = input.next();

        String[] arrCarsStr = carsNames.split(",");
        for (int i=0; i<arrCarsStr.length; i++) {
            if(!carnameValidate.valid(arrCarsStr[i])) {
                validStart = false;
                break;
            }
        }

        if(validStart == false) {
            System.out.println("6글자 이상의 이름의 차가 있습니다. 다시 시도해주세요");
            carsNames = this.inputCarName();
        }

        return carsNames;
    }

    public int inputLap() {
        System.out.println("시도할 회수는 몇회인가요?");
        int laps = input.nextInt();
        return laps;
    }

    public void setCars(Cars cars) {
        this.cars = cars;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public void play() {
        for (int i=0; i<this.laps; i++) {
            cars.getCars().forEach(car -> {
                car.putAccelerator();
                System.out.println(car.getName().getTitle() + " : " + dashOutput.getDashBySize(car.getStep().getPosition()));
            });
            System.out.println("");
        }
    }

    public List<Car> getWinner() {
        Car maxCar = Collections.max(this.cars.getCars(), (Car curCar, Car nextCar) -> {
            if (curCar.getStep().getPosition() == nextCar.getStep().getPosition()) {
                return 0;
            }

            if (curCar.getStep().getPosition() > nextCar.getStep().getPosition()) {
                return 1;
            }

            return -1;
        });

        int maxPosition = maxCar.getStep().getPosition();
        List<Car> winners = new ArrayList<>();

        cars.getCars().forEach(car -> {
            if (maxPosition <= car.getStep().getPosition()) {
                winners.add(car);
            }
        });

        return winners;
    }
}
