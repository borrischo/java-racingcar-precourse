import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Cars;
import racing.condition.ForwardCondition;

import static org.assertj.core.api.Assertions.assertThat;

public class ConditionTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("이동 조건이 4보다 클 경우만 허용하는지 확인")
    @CsvSource(value = {"1:false", "2:false", "3:false", "4:true", "5:true", "6:true"}, delimiter = ':')
    public void test_forward_condition(int value, boolean expected) {
        ForwardCondition forwardCondition = new ForwardCondition();
        boolean actual = forwardCondition.check(value);
        assertThat(actual).isEqualTo(expected);
    }
}
