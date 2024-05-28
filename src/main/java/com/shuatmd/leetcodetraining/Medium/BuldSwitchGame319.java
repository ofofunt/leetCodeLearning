package com.shuatmd.leetcodetraining.Medium;
//319. 灯泡开关
//初始时有 n 个灯泡处于关闭状态。第一轮，你将会打开所有灯泡。接下来的第二轮，你将会每两个灯泡关闭第二个。
//
//第三轮，你每三个灯泡就切换第三个灯泡的开关（即，打开变关闭，关闭变打开）。第 i 轮，你每 i 个灯泡就切换第 i 个灯泡的开关。直到第 n 轮，你只需要切换最后一个灯泡的开关。
//
//找出并返回 n 轮后有多少个亮着的灯泡。
//https://leetcode.cn/problems/bulb-switcher/description/
public class BuldSwitchGame319 {
    //官方解法1：纯数学脑筋急转弯
    //假设我们现在有n个灯泡 选其中第k个灯泡
    //假设k灯泡存在约数x 则k灯泡一定存在约数k/x 比如 6 约数2 同时存在约数 6/2 = 3
    //这说明大部分灯牌存在多对或者一对约数 比如6 1/6 2/3
    //特殊情况是完全平方数 比如 4 9 16 他们的约数x 会等于 k/x
    //只有完全平方数才会存在奇数个约数,也就只有完全平方数的灯会保持开启
    public int bulbSwitchOfficial(int n) {
        return (int) (Math.sqrt(n + 0.5));
    }
    //手搓解法： 尝试一下暴力解法,如果存在因数则需要动一次开关,对每个灯泡判断一次
    //超时 O(n ^ 2)
    public int bulbSwitch(int n) {
        if(n < 2){
            return n;
        }
        int res = n;
        for (int i = 2; i <= n; i++) {
            int time = 0;
            for (int j = 2; j <= n; j++) {
                if(j > i){
                    break;
                }
                if(i % j == 0){
                    time+= 1;
                }
            }
            res -= time%2;
        }
        return res;
    }

    public static void main(String[] args) {
        BuldSwitchGame319 switchGame = new BuldSwitchGame319();
        switchGame.bulbSwitch(3);
    }
}
