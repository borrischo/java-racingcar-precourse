import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Cars;
import racing.validate.CarNameValidate;
import racing.validate.Validate;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidateTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("이름이 6이상 일경우 false반환 여부 확인")
    @CsvSource(value = {"aaaaaa:false", "aaaaa:true", "a:true", "aaaaaaaaaaa:false"}, delimiter = ':')
    public void test_valid_car_name(String carName, boolean expected) {
        Validate carValidate = new CarNameValidate();
        boolean actual = carValidate.valid(carName);
        assertThat(actual).isEqualTo(expected);
    }
}
