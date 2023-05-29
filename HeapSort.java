public class HeapSort {
    public void heapSort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из кучи один за другим
        for (int i = n - 1; i >= 0; i--) {
            // Перемещение текущего корня в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызов heapify для уменьшения размера кучи
            heapify(arr, i, 0);
        }
    }

    void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализация наибольшего элемента как корня
        int left = 2 * i + 1; // Левый потомок узла i
        int right = 2 * i + 2; // Правый потомок узла i

        // Если левый дочерний элемент больше корня
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // Если самый большой элемент не является корнем
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно heapify затронутая поддерево
            heapify(arr, n, largest);
        }
    }

    // Пример использования
    public static void main(String args[]) {
        int[] arr = { 12, 11, 13, 5, 6, 7 };
        int n = arr.length;

        HeapSort heapSort = new HeapSort();
        heapSort.heapSort(arr);

        System.out.println("Отсортированный массив:");
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
    }
}
