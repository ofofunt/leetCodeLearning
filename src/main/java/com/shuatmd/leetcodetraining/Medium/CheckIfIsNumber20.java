package com.shuatmd.leetcodetraining.Medium;

public class CheckIfIsNumber20 {
    public boolean isNumber(String s) {
        if(s == null || s.length()==0){
            return false;
        }
        boolean isE = false;
        boolean isDot = false;
        boolean isSymbol = false;
        boolean isNum = false;
        //去掉头部空格
        s = s.trim();
        for (int i = 0; i < s.length(); i++) {
            //判断是否为数字
            if(s.charAt(i)>= '0' && s.charAt(i)<= '9'){
                isNum = true;
                //小数点只可以出现在e之前 且只能出现一次
            } else if (s.charAt(i) == '.' && !isDot && !isE) {
                isDot = true;
                //当当前char为e是 需要确保前面有数字，且前面没有出现过e
            } else if ((s.charAt(i) == 'e' || s.charAt(i) == 'E') && !isE && isNum) {
                isE = true;
                //确保e之后有数字出现
                isNum = false;
            }else if((s.charAt(i) == '-' || s.charAt(i) == '+') && (i == 0 || s.charAt(i-1) == 'e' || s.charAt(i-1) == 'E')){
                isSymbol = true;
            }
            else{
                return false;
            }

        }
        return isNum;
    }

    public static void main(String[] args) {
        CheckIfIsNumber20 checkIfIsNumber20 = new CheckIfIsNumber20();
        boolean number = checkIfIsNumber20.isNumber(" 1");
        System.out.println(number);
    }

}
