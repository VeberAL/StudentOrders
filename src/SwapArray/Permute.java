import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    //Входные данные для метода перестановки permate
    public static <T> List<T[]> permute(T[] arr){
        List<T[]> result = new ArrayList<T[]>();
        permute(new ArrayList<T>(), Arrays.asList(arr), result);
        return result;
    }

    //Этот метод permute выполняет перестановки
    private static <T> void permute(List<T> pre, List<T> cur, List<T[]> out){
        int size = cur.size(); //замеряем размер переданного массива
        //проверка на нулевое количество элементов в массиве
        if(size == 0){
            out.add((T[])pre.toArray());
        } else {
            //если массив ненулевой, то запускаем цикл
            for(int i=0; i<size; ++i){
                List<T> tmpPre = new ArrayList<T>(pre);
                List<T> tmpCur = new ArrayList<T>(cur);
                tmpPre.add(cur.get(i));
                tmpCur.remove((T)cur.get(i));
                permute(tmpPre, tmpCur, out);
            }
        }
    }

    //Ввод каждой строки с измененными значениями
    private static <T> void print(List<T[]> list, OutputStream out, char delim){
        try{
            for(T[] i : list){
                int count = 0;
                for(T t : i){
                    if(++count == i.length){
                        out.write((t.toString()).getBytes()); //getbytes используется для кодирование строки в байты,
                                                              // что позволяет в качестве символов массива использовать не только цифры
                    } else{
                        out.write((t.toString()+delim).getBytes());
                    }
                }
                out.write("\n".getBytes());
            }
        } catch (Exception ex){ //обработка исключения для понимания в каком месте выпадает ошибка
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Исходный массив - ввод с клавиатуры
        System.out.println("Введите размерность массива:");
        Scanner n = new Scanner(System.in);
        int N = n.nextInt();
        Integer[] ints = new Integer[N];
        int i = 0;
        Scanner in = new Scanner(System.in);
        for (Integer element : ints)
        {
            System.out.print("Введите " + (i + 1) + "-й элемент массива: ");
            ints[i] = in.nextInt();
            System.out.println(ints[i] + " - ");
            i++;
        }
        System.out.println("Введенный массив:");
        for (Integer element : ints)
            System.out.print(element + " ");
        System.out.println("");

        System.out.println("Все возможные перестановки указанного массива:");
        //Вывод перестановок на экран
        Main.print(Main.permute(ints), System.out, ',');
        //Вывод символьного массива и всех его перестановок в файл permute.txt
        Character[] chars = {'a', 'b', 'c', 'd', 'e'};
        Main.print(Main.permute(chars), new PrintStream("permute.txt"), ' ');

    }
}
