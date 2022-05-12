package 学习;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {

        int[] res=new int[arr1.length];
        int[] nums=new int[1000];
        int max=0;
        for(int i:arr1){
            //从arr1中统计一个元素所出现的数量
            nums[i]++;
            max=Math.max(max,i);
        }
        int index=0;
        for(int j:arr2){
            //在arr2中找相关的元素
            while(nums[j]>0){
                res[index++]=j;
                nums[j]--;
            }
        }
        //处理未在arr2中出现的数据
        for(int i=0;i<=max;++i){
            while(nums[i]>0){
                res[index++]=i;
                nums[i]--;
            }
        }
        return  res;
    }
}
