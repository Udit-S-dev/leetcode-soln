package hacckerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HourGlass {
/*
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 9 2 -4 -4 0
0 0 0 -2 0 0
0 0 -1 -2 -4 0
 */
    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>(6);
//        List<Integer> row0 = Arrays.asList(1, 1, 1, 0 ,0,   0);
//        List<Integer> row1 = Arrays.asList(0, 1, 0, 0 ,0,   0);
//        List<Integer> row2 = Arrays.asList(1, 1, 1, 0 ,0,   0);
//        List<Integer> row3 = Arrays.asList(0, 9, 2,-4,-4,   0);
//        List<Integer> row4 = Arrays.asList(0, 0, 0,-2, 0,   0);
//        List<Integer> row5 = Arrays.asList(0, 0, -1,-2,-4,  0);

        List<Integer> row0 = Arrays.asList(-1,1,-1,0,0,0);
        List<Integer> row1 = Arrays.asList(0,-1,0,0,0,0);
        List<Integer> row2 = Arrays.asList(-1,-1,-1,0,0,0);
        List<Integer> row3 = Arrays.asList(0,-9,2,-4,-4,0);
        List<Integer> row4 = Arrays.asList(-7,0,0,-2,0,0);
        List<Integer> row5 = Arrays.asList(0,0,-1,-2,-4,0);
        arr.add(0,row0);
        arr.add(1,row1);
        arr.add(2,row2);
        arr.add(3,row3);
        arr.add(4,row4);
        arr.add(5,row5);

        parseHourGlass(arr);
    }

    static void parseHourGlass(List<List<Integer>> arr) {
        int startIdx = 0;
        int maxSum = Integer.MIN_VALUE;
        int currSum = 0;
        for (int i = startIdx; i <= 3 + startIdx; i++) {
            for (int j = 0; j <= 3 + startIdx; j++) {
                int row1 = arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i).get(j + 2);
                int row2 = arr.get(i + 1).get(j + 1);
                int row3 = arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2);
                currSum = row1 + row2 + row3;
                System.out.println("i,j::" + (i + startIdx) + "," + (j + startIdx) + " sum::" + currSum);
                maxSum = Math.max(maxSum, currSum);
            }
        }
        System.out.println(maxSum);
    }
}
