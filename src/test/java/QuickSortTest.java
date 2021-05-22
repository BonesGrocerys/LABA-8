import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public class QuickSortTest {

    @Test
    public void simpleTest() {
        int[] arr = {3, 1, 2};
        int[] expected = {1, 2, 3};

        QuickSort.sort(arr, 0, 2);
        Assert.assertArrayEquals(expected, arr);
    }

    @Test
    public void reverseTest(){
        int[] arr = new int[100];
        int[] expected = new int[100];

        for (int i = 0; i<100; i++){
            arr[i] = 99-i;
            expected[i] = i;
        }

        QuickSort.sort(arr, 0, 99);
        Assert.assertArrayEquals(expected, arr);
    }

    private void simpleSort(int[] arr){
        for (int i=1; i < arr.length; i++){
            int j = i;
            int x = arr[i];
            while (j>0 && arr[j-1] > x){
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = x;
        }
    }

    @Test
    public void randomTest(){
        int[] arr = new int[100];
        int[] expected = new int[100];
        Random random = new Random();

        for (int i=0; i<100; i++){
            arr[i] = random.nextInt(1000);
            expected[i] = arr[i];
        }

        simpleSort(expected);
        QuickSort.sort(arr, 0, 99);
        Assert.assertArrayEquals(expected, arr);
    }

    private int[] generate(int n){
        int[] arr = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++){
            arr[i] = random.nextInt(1000);
        }
        return arr;
    }

    @Test
    public void stressTestOne(){
        int[] arr = generate(1000);

        QuickSort.sort(arr, 0, 999);
    }

    @Test
    public void stressTestTwo(){
        int[] arr = generate(100000);

        QuickSort.sort(arr, 0, 99999);
    }

    @Test
    public void stressTestThree(){
        int[] arr = generate(10000000);

        QuickSort.sort(arr, 0, 9999999);
    }
}