import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

public class ArraysSort {
    public static int size=10_000_000;
    public static int[]arr =new int[size];
        public static void main(String[] args) {

            fillRandom();
            System.out.println(Arrays.toString(arr));
            long start = System.nanoTime(); //tic
            quickSort(0, arr.length-1);
            long end = System.nanoTime(); //toc
            System.out.println("Time in s: "+(end-start)/1e+9);
        }


    public static void fillRandom() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(89) + 10;
        }
    }
    public static void bubbleSort() {
        for (int i = 0; i < size - 1; i++)
            for (int j = 0; j < size - i - 1; j++)
                if (arr[j] < arr[j + 1]) {
                    //printColor(j, j + 1);
                    swap(j, j + 1);
                }
    }
    public static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void quickSort(int low, int high) {
        if (arr.length == 0)
            return;//завершить выполнение если длина массива равна 0
        if (low >= high)
            return;//завершить выполнение если уже нечего делить
        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opora = arr[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < opora) {
                i++;
            }
            while (arr[j] > opora) {
                j--;
            }
            if (i <= j) {//меняем местами
                swap(i,j);
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(low, j);
        if (high > i)
            quickSort(i, high);
    }
}
