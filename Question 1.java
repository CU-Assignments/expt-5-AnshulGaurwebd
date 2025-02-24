//22bcs13276_Anshul Gaur

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<String> numbers = Arrays.asList("10", "20", "30", "40", "50");
        List<Integer> intList = new ArrayList<>();
        for (String num : numbers) {
            intList.add(Integer.parseInt(num));
        }
        int sum = 0;
        for (Integer num : intList) {
            sum += num;
        }
        System.out.println("Sum: " + sum);
    }
}
