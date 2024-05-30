package MajorityElement;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MajorityElement {
    public static Object bruteForce(Object[] input) {
        int target = (input.length/2) + 1;
        HashMap<Object, Integer> map = new HashMap<>();
        Arrays.stream(input).forEach(x -> {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        });
        Object highest = null;
        int max = 0;
        for( Map.Entry<Object, Integer> e : map.entrySet()){
            if(e.getValue() > max && e.getValue() >= target){
                max = e.getValue();
                highest = e.getKey();
            }
        }
        return highest;
    }

    public static Object BoyerMoore(Object[] input) {
        int count = 0;
        Object current = null;
        for (Object o : input) {
            if (count == 0) {
                count++;
                current = o;
            } else if (current.equals(o))
                count++;
            else
                count--;
        }
        count = 0;
        for (Object o : input) {
            if (current.equals(o))
                count++;
        }
        if(count >= input.length/2 +1)
            return current;
        return null;
    }

    // Answer
    public static Object hashMapStream(Object[] input) {
        return Arrays.stream(input).collect(Collectors.groupingBy(e -> e, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() > input.length / 2)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    public static interface test{
        default int doStruff(){
            return 1;
        }
    }
}
