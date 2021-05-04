import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.Cars;
import racing.output.DashOutput;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @DisplayName("사이즈에 따라서 dash가 생성되는지 확인")
    @CsvSource(value = {"1:-", "2:--", "3:---"}, delimiter = ':')
    public void test_create_dash_by_size(int size, String expected) {
        DashOutput dashOutput = new DashOutput();
        String actual = dashOutput.getDashBySize(size);
        assertThat(actual).isEqualTo(expected);
    }
}
