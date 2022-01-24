package Collections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Maps {
    //Задан массив символов, выяснить количество повторяющихся
        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            java.util.Map<String, Integer> mp = new HashMap<>();
            list.add("a");
            list.add("h");
            list.add("b");
            list.add("a");
            list.add("h");
            list.add("f");
            list.add("a");
            int a=0;
            for(int i=0; i<list.size(); i++) {
                a = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i).equals(list.get(j))) {
                        a++;
                        mp.put(list.get(i),a);
                    }}}
            //выводим мапу значений
            System.out.println(mp);
        }
}

