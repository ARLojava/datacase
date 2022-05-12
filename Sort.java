package 学习;

public class Sort {
    public void HeapSort_Increase(int[] arr) {
        //若是想要得到降序数组，需要对Heapifly函数的smallIndex进行调整，即是对两个孩子中找最小值然后再与当前index比较，取最小的进行交换
        //HeapInsert函数也需要变更，对while语句条件中，更改当前值比父结点小,直到最小的出现在根节点
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; ++i) {
            //全部点向上调整一遍，得到的点一定是最大的
            HeapInsert(arr, i);
        }
        int HeapSize = arr.length;
        swap(arr, 0, --HeapSize);
        while (HeapSize != 0) {
            //Heapifly函数所对应的是已经交换了的数值，向下调整以得到大根堆
            Heapifly(arr, 0, HeapSize);
            //得到大根堆之后,对数组最后数进行交换,所以得到的数组会是升序数组
            swap(arr, 0, --HeapSize);
        }
    }

    //向下调整
    public static void Heapifly(int[] arr, int index, int HeapSize) {
        //当前索引为index的点与它两个孩子比较,取较大的那个孩子进行交换，然后交换后再与他的孙子进行比较....直到找到比较合适的位置或者越界
        int Left = index * 2 + 1;
        while (Left < HeapSize) {
            int BigIndex = arr[Left] >= arr[Left + 1] ? Left : Left + 1;
            BigIndex = arr[index] >= arr[BigIndex] ? index : BigIndex;
            if (BigIndex == index) {
                break;
            }
            swap(arr, BigIndex, index);
            index = BigIndex;
            Left = index * 2 + 1;
        }

    }

    //向上调整
    public static void HeapInsert(int[] arr, int index) {
        //当前为索引为index的点与它的父结点比较,如果当前的点比父结点大则继续交换，直到父结点比当前结点大
        while (arr[index] > arr[(index - 1) / 2]) {
            swap(arr, index, (index - 1) / 2);
            index = (index - 1) / 2;
        }
    }

    public static void swap(int[] arr, int bigIndex, int smallIndex) {
        int temp = arr[bigIndex];
        arr[bigIndex] = arr[smallIndex];
        arr[smallIndex] = temp;
    }

    public int[] heapSort_Increase(int[] arr) {
        int[] temp = arr;
        if (arr == null || arr.length < 2) {
            return arr;
        }
        int Heapsize = arr.length;
        for (int index = 0; index < arr.length; ++index) {
            HeapInsert(temp, index);
        }
        swap(temp, 0, --Heapsize);
        while (Heapsize != 0) {
            Heapifly(temp, 0, Heapsize);
            swap(temp, 0, --Heapsize);
        }
        return temp;
    }

    public static void Bubble_Sort(int[] arr) {
        for (int index = 0; index < arr.length-1; ++index) {
            for (int j = 0; j < arr.length - index-1; ++j) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }


}
