package com.aadil.assement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskAssesment {
    public  int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int N = startTime.length;
        int[][] jobs = new int[N][3];
        for (int i = 0; i < N; i++) {
            jobs[i] = new int[] {startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);
        List<Integer> dpEndTime = new ArrayList<>();
        List<Integer> dpProfit = new ArrayList<>();
        dpEndTime.add(0);
        dpProfit.add(0);
        for (int[] job : jobs) {
            int preIdx = largetstSmallerOrEqual(dpEndTime, job[0]);
            int case1Profit = dpProfit.get(dpProfit.size() - 1);
            int case2Profit = dpProfit.get(preIdx) + job[2];
            if (case2Profit > case1Profit) {
                dpEndTime.add(job[1]);
                dpProfit.add(case2Profit);
            }
        }
        return dpProfit.get(dpProfit.size() - 1);
    }
    private int largetstSmallerOrEqual(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = l + (r - l) / 2;
            if (list.get(m) <= target) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l - 1;
    }
    public static void main(String[] args) {
    	
    	TaskAssesment obj = new TaskAssesment();
    	int[] startTime = {2,3,5};
    	int[] endTime = {7,8,9};
    	int[] profit = {400,800,900};
    int result = (obj.jobScheduling(startTime, endTime, profit)); 
    System.out.println("lokash will take the highest profit job ");
      System.out.println(result); // lokash will take the highest profit job 
		
	}
    
	 
	 

}
