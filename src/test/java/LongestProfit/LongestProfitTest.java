package LongestProfit;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class LongestProfitTest {
    @ParameterizedTest
    @ArgumentsSource(LongestProfitArgumentsProvider.class)
    void testProfit(int[] input, int expected) {
        assertEquals(expected, LongestProfit.longestProfitAnswer(input));
    }

    static class LongestProfitArgumentsProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) {
            return Stream.of(
                    Arguments.of(null, 0),
                    Arguments.of(new int[]{}, 0),
                    Arguments.of(new int[]{-1, 9, 0, 8, -5, 6, -24}, 3),
                    Arguments.of(new int[]{1, 2, 3, 4, 5}, 5),
                    Arguments.of(new int[]{5, 4, 3, 2, 1}, 1),
                    Arguments.of(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}, 5),
                    Arguments.of(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 6}, 6),
                    Arguments.of(new int[]{1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5}, 7),
                    Arguments.of(new int[]{50, 3, 10, 7, 40, 80}, 4),
                    Arguments.of(new int[]{10, 22, 9, 33, 21, 50, 41, 60}, 5),
                    Arguments.of(new int[]{4, 2, 6, 3, 7, 1}, 3)
            );
        }
    }
}

