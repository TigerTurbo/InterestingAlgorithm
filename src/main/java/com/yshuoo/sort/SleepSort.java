package com.yshuoo.sort;

/**
 * 睡眠排序
 * @author yangshuo
 * @date 2020/1/7 14:59
 */
public class SleepSort {

    public static void main(String[] args){

        int[] arr = {10,10,9,7,5,4,8,20,4,1,2,3};
        Thread[] sortThreads = new Thread[arr.length];
        for (int i = 0; i < sortThreads.length; i++) {
            final int index = i;
            sortThreads[i] = new Thread(()->{
                try {
                    Thread.sleep(arr[index]);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(arr[index]);
            });
        }
        for (int i = 0; i < sortThreads.length; i++) {
            sortThreads[i].start();
        }

    }
}
