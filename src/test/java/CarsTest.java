import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Cars;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("콤마로 자동차가 생성되는지 테스트")
    @CsvSource(value = {"pobi,crong,honux:3", "one,two:2", "jacki,pow,sub,min:4", "abc:1"}, delimiter = ':')
    public void test_create_cars_by_comma(String carsStr, int length) {
        Cars cars = new Cars();
        cars.addCars(carsStr);
        assertThat(cars.length()).isEqualTo(length);
    }

    @Test
    @DisplayName("콤마만 있을경우 자동차는 생성되지 않는다.")
    public void test_only_comma_cars() {
        Cars cars = new Cars();
        cars.addCars("a,b,,,,");
        assertThat(cars.getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("생성된 자동차 이름이 올바른지 확인한다.")
    public void test_check_cars_name_by_comma() {
        Cars cars = new Cars();
        cars.addCars("pobi,crong,honux");
        assertThat(cars.getCars().get(0).getName().getTitle()).isEqualTo("pobi");
        assertThat(cars.getCars().get(1).getName().getTitle()).isEqualTo("crong");
        assertThat(cars.getCars().get(2).getName().getTitle()).isEqualTo("honux");
    }

}
