package com.shuatmd.leetcodetraining.Medium;

//面试题 16.04. 井字游戏
//设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
//
//以下是井字游戏的规则：
//
//玩家轮流将字符放入空位（" "）中。
//第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
//"X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
//当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
//当所有位置非空时，也算为游戏结束。
//如果游戏结束，玩家不允许再放置字符。
//如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
//https://leetcode.cn/problems/tic-tac-toe-lcci/description/
public class TicatoeGame1604 {
    //改良版本：判断空格,同时加入提前跳出
    //判断横竖时,如果横竖第二位的元素与第一位不同 则不可能存在胜出的情况
    public String tictactoeAdvanced(String[] board) {
        int length = board.length;
        //横的总和
        int heng = 0;
        //纵的总和
        int zong = 0;
        //左斜线的总和
        int left = 0;
        //右斜线的总和
        int right = 0;
        //记录是否存在空格
        boolean flag = false;
        //记录当前横是否为空格
        boolean hflag = true;
        //记录当前竖是否为空格
        boolean zflag = true;
        for (int i = 0; i < length; i++) {
            hflag = true;
            zflag = true;
            heng = 0;
            zong = 0;
            //当前遍历的横向的起点
            char hengStart = board[i].charAt(0);
            //当前遍历的纵向的起点
            char zongStart = board[0].charAt(i);
            //先判断当前横纵向起点是否为空
            //根据当前横纵起点的值给heng zong附上初始值
            if (hengStart == ' ') {
                hflag = false;
                flag = true;
            } else {
                heng = hengStart;
            }
            if (zongStart == ' ') {
                zflag = false;
                flag = true;
            } else {
                zong = zongStart;
            }
            //因为已经计算了初始值,所以从1开始遍历
            for (int j = 1; j < length; j++) {
                //横纵起点都为空,则当前横纵列不可能存在胜出的情况
                //因为无论横纵都无法用同一个字母填满
                if (!hflag && !zflag) {
                    break;
                }
                //当横不为空时,进入判断
                if (hflag) {
                    //判断是否与起点相等,如果不相等则说明也无法填填满横向 这次循环之后可以不再对横向进行判断
                    if (board[i].charAt(j) == hengStart) {
                        heng = heng + (int) board[i].charAt(j);
                    } else {
                        hflag = false;
                    }
                }
                //同上部分的逻辑
                if (zflag) {
                    if (board[j].charAt(i) == zongStart) {
                        zong = zong + (int) board[j].charAt(i);
                    } else {
                        zflag = false;
                    }
                }
                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }
            //当有起点不为空时 才需要计算是否有胜出
            if (hflag || zflag) {
                if (heng == (int) 'X' * length || zong == (int) 'X' * length) {
                    return "X";
                }
                if (heng == (int) 'O' * length || zong == (int) 'O' * length) {
                    return "O";
                }
            }
            //外部循环来判断左右两个斜线是否有胜出
            left = left + (int) board[i].charAt(i);
            right = right + (int) board[i].charAt(length - i - 1);
        }
        if (left == (int) 'X' * length || right == (int) 'X' * length) {
            return "X";
        }
        if (left == (int) 'O' * length || right == (int) 'O' * length) {
            return "O";
        }
        if (flag) {
            return "Pending";
        }
        return "Draw";
    }

    //分类讨论：分别检查横竖斜线是否存在胜出
    //最后判断是否存在空格 如果存在则说明为pending
    //可以通过大部分unit test 但是会存在判断错误的情况
    //不会跳过空格 算了空格的情况可能会存在误判
    public String tictactoe(String[] board) {
        int length = board.length;
        //横的总和
        int heng = 0;
        //纵的总和
        int zong = 0;
        //左斜线的总和
        int left = 0;
        //右斜线的总和
        int right = 0;
        //记录是否存在空格
        boolean flag = false;
        for (int i = 0; i < length; i++) {
            heng = 0;
            zong = 0;
            for (int j = 0; j < length; j++) {
                //对纵横进行累加,循环完一次横行之后判断纵横是否胜出
                heng = heng + (int) board[i].charAt(j);
                zong = zong + (int) board[j].charAt(i);
                if (board[i].charAt(j) == ' ') {
                    flag = true;
                }
            }
            if (heng == (int) 'X' * length || zong == (int) 'X' * length) {
                return "X";
            }
            if (heng == (int) 'O' * length || zong == (int) 'O' * length) {
                return "O";
            }
            //外部循环来判断左右两个斜线是否有胜出
            left = left + (int) board[i].charAt(i);
            right = right + (int) board[i].charAt(length - i - 1);
        }
        if (left == (int) 'X' * length || right == (int) 'X' * length) {
            return "X";
        }
        if (left == (int) 'O' * length || right == (int) 'O' * length) {
            return "O";
        }
        if (flag) {
            return "Pending";
        }
        return "Draw";
    }
}
