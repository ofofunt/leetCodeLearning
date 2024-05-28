package com.shuatmd.leetcodetraining.Easy;

import java.util.Arrays;
import java.util.List;

public class Vowels345 {
    //官方解法： 同样是双指针,但是判断变简单了
    public String reverseVowels(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        int i = 0, j = n - 1;
        while (i < j) {
            while (i < n && !isVowel(arr[i])) {
                ++i;
            }
            while (j > 0 && !isVowel(arr[j])) {
                --j;
            }
            //这里i < j就代表i j 同时找到了原因字母
            //且可以避免换完一次之后又找到原来的位置
            if (i < j) {
                swap(arr, i, j);
                ++i;
                --j;
            }
        }
        return new String(arr);
    }

    public boolean isVowel(char ch) {
        return "aeiouAEIOU".indexOf(ch) >= 0;
    }

    public void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //手搓解法： 费劲版本双指针
    public String reverseVowelsDraft(String s) {
        List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        int left = 0;
        int right = s.length() - 1;
        char[] charArray = s.toCharArray();
        while (left < right && left < s.length() && right > 0) {
            if (!vowels.contains(charArray[left])) {
                left++;
            }
            if (!vowels.contains(charArray[right])) {
                right--;
            }
            if (vowels.contains(charArray[right]) && vowels.contains(charArray[left])) {
                charArray[left] = s.charAt(right);
                charArray[right] = s.charAt(left);
                left++;
                right--;
            }
        }
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {
        Vowels345 vowels345 = new Vowels345();
        vowels345.reverseVowels("HELLO");
    }
}
