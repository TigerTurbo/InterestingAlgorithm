package com.yshuoo.sort;

import java.util.*;

/**
 * @author yangshuo
 * @date 2020/1/9 9:55
 */
public class QuantumBogoSort {


    /**
     * 检查数组是否有序
     * @return
     */
    private static boolean checkOrder (List<Integer> list){
        for (int i = 1; i < list.size(); i++){
            if (list.get(i) <= list.get(i - 1)){
                return false;
            }
        }
        return true;
    }


    /**
     * 全排列
     */
    private static void permutationSequence(int[] array, int start, int end, List<List<Integer>> arrayList){
        if (start == end){
            List<Integer> list = new ArrayList<>();
            for (int i : array){
                list.add(i);
            }
            arrayList.add(list);
            return;
        }
        for (int i = start; i < end; i++){
            swap(array,i,start);
            permutationSequence(array,start + 1, end, arrayList);
            swap(array,i,start);
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args){

        int[] array = {9,10,8,3,7};
        List<List<Integer>> arrayList = new ArrayList<>();
        permutationSequence(array,0,array.length,arrayList);
        long startTime = System.currentTimeMillis();
        for (List<Integer> list : arrayList){
            boolean isOrder = checkOrder(list);
            if (isOrder){
                for (Integer num : list){
                    System.out.printf(num + " ");
                }
                break;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("排序完成，耗时：" + (endTime-startTime) + " ms");

    }

}
