package WaterContainerVmax;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class WaterContainerVmaxTest {

    WaterContainerVmax waterContainerVmax = new WaterContainerVmax();

    @ParameterizedTest
    @ArgumentsSource(WaterContainerVmaxArgumentProvider.class)
    void testWaterContainerVmax(int[] input, int expected) {
        assertEquals(expected, waterContainerVmax.maxArea(input));
    }

    static class WaterContainerVmaxArgumentProvider implements ArgumentsProvider {
        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new int[]{1,8,6,2,5,4,8,3,7}, 49),
                    Arguments.of(new int[]{1,1}, 1)
            );
        }
    }

}