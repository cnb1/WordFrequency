import java.util.*;

public class Main {
    public static void main(String[] args) {
//        System.out.println(Arrays.toString(args));
        Map<String, Integer> wordCount = new HashMap<>();
        Set<Integer> numbers = new HashSet<>();
        // add words linear time
        for (String s : args) {
            if (!wordCount.containsKey(s)) {
                wordCount.put(s, 1);
            }
            else {
                wordCount.put(s, wordCount.get(s)+1);
            }
        }

        Map<Integer, List<String>> wordOrder = new HashMap<>();

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (!wordOrder.containsKey(entry.getValue())) {
                numbers.add(entry.getValue());
                wordOrder.put(entry.getValue(), new ArrayList<>());
                wordOrder.get(entry.getValue()).add(entry.getKey());
            }
            else  {
                numbers.add(entry.getValue());
                wordOrder.get(entry.getValue()).add(entry.getKey());
            }
        }
        int[] order = new int[numbers.size()];
        int index = 0;
        for (Integer i : numbers) {
            order[index] = i;
            index++;
        }

        Arrays.sort(order);

        for (int i=order.length-1; i>= 0 ; i--){
            for (String s : wordOrder.get(order[i])) {
                System.out.println(order[i] + " " + s);
            }
        }
    }
}