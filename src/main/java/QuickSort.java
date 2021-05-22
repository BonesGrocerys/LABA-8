public class QuickSort {

    public static void sort(int[] array, int low, int high){
        //завершить выполнение, если длина массива равна 0
        if (array.length == 0)
            return;

        //завершить выполнение если уже нечего делить
        if (low >= high)
            return;

        // выбрать опорный элемент
        int middle = low + (high - low) / 2;
        int opor = array[middle];

        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (array[i] < opor) {
                i++;
            }

            while (array[j] > opor) {
                j--;
            }

            if (i <= j) {
                //меняем местами
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            sort(array, low, j);

        if (high > i)
            sort(array, i, high);
    }

}
