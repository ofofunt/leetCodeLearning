package com.shuatmd.leetcodetraining.Hard;

//LCR 170. 交易逆序对的总数
//在股票交易中，如果前一天的股价高于后一天的股价，则可以认为存在一个「交易逆序对」。请设计一个程序，输入一段时间内的股票交易记录 record，返回其中存在的「交易逆序对」总数。
//https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof/
public class ReversePairsLCR170 {
    //官方解法： 用归并排序来做
    //首先先递归将序列从中间分开 直到不可再分割
    //比如 7 3 2 6 0 1 5 4 会一直分割成 7 3 | 2 6 | 0 1 | 5 4
    //到达底部之后再进行合并的操作, 在合并的时候排序并且记录逆序对
    //比如 7 3  -> 7 大于3 代表存在1对逆序对  排序后存为 3 7
    //下一层中 对 3 7 | 2 6 继续进行归并
    //此时 3 > 2 代表存在 3 2 | 7 2 2个逆序对 右移右指针
    //此时 7 > 6 代表存在 7 6 这1个逆序对 所以 7326这一部分一共存在2 + 1 = 3个逆序对
    //之后要继续下层判断
    int[] tmp;
    int[] record;

    public int reversePairs(int[] record) {
        this.record = record;
        this.tmp = new int[record.length];
        int res = mergeSort(0, record.length - 1);
        return res;
    }

    private int mergeSort(int l, int r) {
        //终止条件
        if (l >= r) {
            return 0;
        }
        int m = (l + r) / 2;
        int res = mergeSort(l, m) + mergeSort(m + 1, r);
        //左边分段的指针
        int i = l;
        //右边分段的指针
        int j = m + 1;
        //将当前处理的分段数据放入tmp之中
        for (int k = l; k <= r; k++) {
            tmp[k] = record[k];
        }
        for (int k = l; k <= r; k++) {
            //i == m + 1表示左边指针已经遍历完,需要将右边部分没有放进来的按照排序好的结果放入
            if (i == m + 1) {
                record[k] = tmp[j];
                //因为左边已经放完 所以需要递增右指针
                j++;
            }
            //j > r + 1说明右边指针已经走完 把左边的数字放入record 同时右移坐指针
            //同理 tmp[j] >= tmp[i] 说明当前左指针指向的数不存在逆序对 因为他小于右指针以及右指针右侧所有的数
            //需要将左指针指向的数字放入record中 同时右移左指针
            else if (j == r + 1 || tmp[j] >= tmp[i]) {
                record[k] = tmp[i];
                i ++;
            }
            //剩余的情况就是左指针的数大于右指针,将右指针中的数放入序列
            //同时需要添加逆序对的个数
            //逆序对的个数等于当前指针到中间边界的距离
            //比如 3 7 | 2 6 左指针在3 右指针在2的时候 3 > 2 表示存在 3 2 | 7 2两个逆序对
            else{
                record[k] = tmp[j];
                j++;
                res += m - i + 1;
            }
        }
        return res;
    }
}
