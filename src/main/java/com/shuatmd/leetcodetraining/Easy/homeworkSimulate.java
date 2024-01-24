package com.shuatmd.leetcodetraining.Easy;

import java.util.Random;

public class homeworkSimulate {
    public static void main(String[] args) {
        //define the probability of winning
        double probabilityA = 0.071367;
        double probabilityB = 0.014642;
        //define the total budget we spend
        double budget = 36000.00;
        //define the odds 
        double oddA = 20;
        double oddB = 150;
        //define the cost for purchasing
        double cost = 50;
        //set the times for simulation
        double simTimes = 100000000;
        int days = 180;
        double loseCount = 0;
        Random rand = new Random();
        for (int i = 0; i < simTimes; i++) {
            double profit = 0.0;
            for (int j = 0; j < days; j++) {
                if (rand.nextDouble() <= probabilityA) {
                    profit+=cost*oddA;
                }
                if (rand.nextDouble() <= probabilityB) {
                    profit+=cost*oddB;
                }
            }
            if(profit < budget){
                loseCount++;
            }
        }
        System.out.println("lose " + loseCount + "times");
        System.out.println("The probability for losing with " + simTimes + " of simulation is : " + loseCount/simTimes);
    }
}
