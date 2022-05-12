package 学习;

import java.util.Arrays;
import java.util.Queue;

public class PriorityQueue {
    public class MaxHeap {
        private int[] arr;
        private int Initnumber;
        private int Size = 0;

        public int[] getArray() {
            return this.arr;
        }

        public MaxHeap(int Init) {
            this.Initnumber = Init;
            this.arr = new int[Init];
        }

        public void Heapifly_MaxHeap() {
            int index = 0;
            int Left = index * 2 + 1;
            while (Left <= this.Size) {
                int LargestIndex = this.arr[Left] > this.arr[Left + 1] ? Left : Left + 1;
                LargestIndex = this.arr[LargestIndex] > this.arr[index] ? LargestIndex : index;
                if (index == LargestIndex) {
                    break;
                }
                this.swap(LargestIndex, index);
                index = LargestIndex;
                Left = index * 2 + 1;
            }
        }

        public void HeapInsert_MaxHeap() {
            int index = this.Size - 1;
            while (this.arr[index] > this.arr[(index - 1) / 2]) {
                this.swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            }
        }

        public void Insert(int Value) {
            if (Size == Initnumber) {
                arr = Arrays.copyOf(arr, this.Initnumber * 2);
                this.Initnumber = this.Initnumber * 2;
            }
            this.arr[this.Size] = Value;
            this.Size++;
            this.HeapInsert_MaxHeap();
        }

        public int poll() {
            int Element = this.arr[0];
            this.arr[0] = this.arr[this.Size - 1];
            this.Size--;
            this.Heapifly_MaxHeap();
            return Element;
        }

        public void swap(int bigIndex, int smallIndex) {
            int temp = this.arr[bigIndex];
            this.arr[bigIndex] = this.arr[smallIndex];
            this.arr[smallIndex] = temp;
        }
        public int peek(){
            return this.arr[0];
        }
        public int getSize(){
            if(this.isEmpty()){
                return 0;
            }
            return this.Size;
        }
        public boolean isEmpty(){
            return this.Size==0;
        }
    }
    public class MinHeap{
        private int[] arr;
        private int Initnumber;
        private int Size;

        public MinHeap(int Init){

        }
        public void HeapInsert_MinHeap(){
            int index=this.Size-1;
            while(arr[index]<arr[(index-1)/2]){
                swap((index-1)/2,index);
                index=(index-1)/2;
            }
        }
        public void Heapifly_MinHeap(){
            int index=0;
            int Left=index*2+1;
            while(Left<=this.Size){
                int smallIndex=this.arr[Left]<this.arr[Left+1]?Left:Left+1;
                smallIndex=this.arr[index]<this.arr[smallIndex]?index:smallIndex;
                if(index==smallIndex){
                    break;
                }
                swap(smallIndex,index);
                index=smallIndex;
                Left=index*2+1;
            }
        }
        public void Insert(int Value){
          if(Size==this.Initnumber){
              this.arr=Arrays.copyOf(arr,Initnumber*2);
              this.Initnumber=Initnumber*2;
          }
          this.arr[Size]=Value;
          this.Size++;
          this.HeapInsert_MinHeap();;
        }
        public int poll(){
            int Element=this.arr[0];
            arr[0]=arr[Size-1];
            this.Size--;
            this.Heapifly_MinHeap();
            return Element;
        }
        public void swap(int bigIndex,int smallIndex){
            int temp=this.arr[bigIndex];
            this.arr[bigIndex]=this.arr[smallIndex];
            this.arr[smallIndex]=temp;
        }
        public int peek(){
            return this.arr[0];
        }
        public int getSize(){
            if(this.isEmpty()){
                return 0;
            }
          return this.Size;
        }
        public boolean isEmpty(){
            return this.Size==0;
        }
    }



    //库中有优先队列为PriortyQueue
    // 使用方式为Queue<Node>Myqueue=new PriorityQueue<Node>(cNode)
    //其中cmp为比较器，具体使用方式为static Comparator<Node> cNode=new Comparator<Node>(){
    //                        public int compare(Node o1,Node o2){
    //                          升序，即是Value值小的先出队列
    //                          return o1.Value-o2.Value;
    //                          降序，即是Value值大的先出队列
    //                          return o2.Value-o1.Value;
    //                          }
}
