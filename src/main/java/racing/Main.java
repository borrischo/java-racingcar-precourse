package racing;


import racing.car.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Racing racing = new Racing();

        String carsNames = racing.inputCarName();
        racing.addCars(carsNames);

        int laps = racing.inputLap();
        racing.setLaps(laps);

        System.out.println("실행결과");
        racing.play();

        List<Car> winners = racing.getWinner();
        for (int i=0; i<winners.size(); i++) {
            if (i == winners.size() - 1) {
                System.out.print(winners.get(i).getName().getTitle());
            } else {
                System.out.print(winners.get(i).getName().getTitle() + ",");
            }
        }

        System.out.println("가 최종 우승 했습니다.");
    }
}
