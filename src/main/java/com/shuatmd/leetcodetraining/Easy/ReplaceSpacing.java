package com.example.leetCodeLearning.src.main.java.com.shuatmd.leetcodetraining.Easy;


public class ReplaceSpacing {
    //Solution 对String的每个index进行遍历，或者直接通过replaceAll达成
    public static String replaceSpace(String s) {
        if(s.length() == 0){
            return s;
        }
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char sb = s.charAt(i);
            if(sb == ' '){
                resultStr.append("%20");
            }
            else {
                resultStr.append(sb);
            }
        }
        System.out.println(s.replaceAll(" ", "%20"));
        return resultStr.toString();
    }

    public static void main(String[] args) {
        String test = "1  2 3 4 5 6    ";
        System.out.println(replaceSpace(test));
    }


}
