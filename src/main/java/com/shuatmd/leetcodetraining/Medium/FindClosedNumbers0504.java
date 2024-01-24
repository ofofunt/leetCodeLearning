package com.shuatmd.leetcodetraining.Medium;

//面试题 05.04. 下一个数
//下一个数。给定一个正整数，找出与其二进制表达式中1的个数相同且大小最接近的那两个数（一个略大，一个略小）。
public class FindClosedNumbers0504 {
    //官方解法：分类讨论
    //找出较大的值：首先从右到左找到第一个01 将01变成10,然后将01右边的1全部靠右排
    //比如 11100  -> 101100 -> 100011
    //找出较小的值：首先从右到左找到第一个10 将10变为01 然后将低位的1左移
    //比如 1110 0011 -> 11010011 -> 11011100
    public int[] findClosedNumbersOfficial(int num) {
        if(num == Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }
        int[] ans = new int[2];
        ans[0] = getBig(num);
        ans[1] = getSmall(num);
        return ans;
    }

    private int getSmall(int num) {
        int cnt=0;
        //去掉开始的1
        if((num&(1<<cnt))>0){
            while(cnt<31&& (num & (1<<cnt))>0){
                cnt++;
            }
        }
        //此时cnt为从低位到高位第一个0的位置
        int c0=cnt;


        while(cnt<31&&(num&(1<<cnt))==0){
            cnt++;
        }

        if(cnt==31){
            return -1;
        }


        //1000111
        //c0就是右边1的个数，要左移
        //0100111左移动1位，2=cnt-index
        num-=(1<<cnt);
        cnt--;
        num+=(1<<(cnt));//1000111-》0100111

        int cha=cnt-c0;//cnt指向从低位到高位第一个一串0后面的1 cha="差"是要左移的位数
        while(cnt-c0>0){
            cnt--;
            num+=(1<<cnt);
        }
        //把最右边清0
        while(cha>0){
            cha--;
            num-=(1<<cha);

        }

        return num;
    }

    private int getBig(int num) {
        int cnt=0;
        //去掉低位开始的0
        if((num&(1<<cnt))==0){
            while(cnt<31&&(num&(1<<cnt))==0){
                cnt++;
            }
        }
        //此时cnt为从低位往高位数第一个1的位置
        int c1=cnt;

        while(cnt<31&&(num&(1<<cnt))>0){
            cnt++;
        }

        if(cnt==31){
            return -1;
        }

        num+=(1<<cnt);//    ...00111000
        cnt--;
        num-=(1<<cnt);//变为   01011000

        cnt--;
        //cnt指向要右移的第一个1
        int count=0;
        //c1大于0才需要右移动
        while(c1>0&&cnt>0&&( num&(1<<cnt) )>0){
            num-=(1<<cnt);
            count++;
            cnt--;
        }
        //把右边清0
        while(count>0){
            //count代表几个1      如0000 0011
            count--;
            num+=(1<<count);

        }

        return num;
    }

    //手搓尝试失败
    //手搓尝试：首先需要找到第一个1
    //然后在第一个1的index左右各找一个最近的0
    //替换左边的1,0会得到一个略大的数
    //替换右边的1,0会得到一个略小的数
    public int[] findClosedNumbers(int num) {
        int tmp = num;
        int index = -1;
        int zeroIndexLeft = 0;
        int zeroIndexRight = 0;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            //当index=0 说明还没有找到当前为1的index
            //需要不断找寻最近的0的index
            if (index == -1) {
                if ((tmp & 1) == 1) {
                    index = i;
                }
            }
            //当index已经不为0 说明找到了1的index
            //找到第一个右边的0之后break
            else {
                if ((tmp & 0) == 0) {
                    zeroIndexRight = i;
                    break;
                }
            }
            tmp >>= 1;
        }
        double min = index == 0 ? -1 : num + Math.pow(2, index - 1) - Math.pow(2, index);
        double max = Math.pow(2, zeroIndexRight) + num - Math.pow(2, index);
        return new int[]{(int) max, (int) min};

    }

    public static void main(String[] args) {
        FindClosedNumbers0504 find = new FindClosedNumbers0504();
        find.findClosedNumbers(6);
    }
}
