package Collections;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Comparison {
    public static void main(String[] args) {
        //Тест скорости работы array и linked lists
        List<Integer> Alist = new ArrayList<>();
        List<Integer> Llist = new LinkedList<>();
            //заполняем
        for (int i = 0; i<100000; i++){
            Alist.add(i);
            Llist.add(i);
        }
        //Добавляем 1000 раз элемент в индекс 0 и высчитываем время работы
        long ArrayT = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            Alist.add(0,i);
        }
        System.out.println("Время работы ArrayList: "+(System.currentTimeMillis()-ArrayT));
        //(вышло 15 мс)
        long LinkedT = System.currentTimeMillis();
        for(int i = 0; i < 1000; i++){
            Llist.add(0,i);
        }
        System.out.println("Время работы LinkedList: "+(System.currentTimeMillis()-LinkedT));
        //(вышло 1 мс)
    }
}
