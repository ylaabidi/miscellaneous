import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class MajorityElementTests {
    @ParameterizedTest
    @ArgumentsSource(MajorityElementArgumentsProvider.class)
    void testMajorityElement(Object[] input, Object expected) {
        assertEquals(expected, MajorityElement.bruteForce(input));
    }


}

class MajorityElementArgumentsProvider implements ArgumentsProvider {
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
        return Stream.of(
                Arguments.of(new Integer[]{3, 3, 4, 2, 4, 4, 2, 4, 4}, 4),
                Arguments.of(new String[]{"c", "c", "d", "b", "d", "d", "b", "d" }, null)
                // Add more test cases here
        );
    }
}