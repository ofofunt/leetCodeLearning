package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;

public class RotateMatrixFindMIn {
    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if(numbers[i] > numbers[i + 1]){
                return numbers[i + 1];
            }
        }
        return 0;

    }

}
