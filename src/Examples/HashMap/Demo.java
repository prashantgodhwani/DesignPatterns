package Examples.HashMap;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(2, 100);
        map.put(2, 200);
        map.put(3, 400);
        System.out.println(map.get(2));
        System.out.println(map.get(3));
        map.remove(2);
        map.get(1);
    }

}
