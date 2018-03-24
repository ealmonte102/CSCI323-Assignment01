import java.util.Arrays;

public class Application {
    public static void main(String [] args) {
        int[] a = {9, 5, 2, 3, 0, 1};
        Sorter sorter = new Sorter(a);
        sorter.insertionSort();
        System.out.println(Arrays.toString(a));
    }
}
