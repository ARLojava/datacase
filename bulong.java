package 学习;

public class bulong {
    public int[] bitMap;
    public bulong(int number) {
        this.bitMap = new int[number];
    }
    public int get_statue(int a){
        int numberIndex= a /32;
        int bitIndex= a %32;
        int s=((this.bitMap[numberIndex]>>bitIndex)&1);  //得到X位状态
        return s;
    }
    public void changTo_1(int a){
        int numberIndex= a /32;
        int bitIndex= a %32;
        this.bitMap[numberIndex]=this.bitMap[numberIndex]|(1<<bitIndex);   //改变x位的状态为1
    }
    public void changTo_0(int a){
        int numberIndex= a /32;
        int bitIndex= a %32;
        this.bitMap[numberIndex]=this.bitMap[numberIndex]&(~(1<<bitIndex)); //改变x位的状态为0
    }
}

