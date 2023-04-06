package com.shuatmd.leetcodetraining.Medium;

import com.shuatmd.leetcodetraining.Easy.FindContinuousSequenceWithSumTarget57;
import com.shuatmd.leetcodetraining.Easy.FirstUniqChar50;
import com.shuatmd.leetcodetraining.Easy.MissingNumberInConsecutiveArray53;
import com.shuatmd.leetcodetraining.Easy.ReverseWrods58;
import com.shuatmd.leetcodetraining.Hard.ReversePairsInArray51;

public class CharArrayPermutation38test {
    public static void main(String[] args) {
        ReverseWrods58 reverseWrods58 = new ReverseWrods58();
        reverseWrods58.reverseWordsOfficial("the sky is blue");
        FindContinuousSequenceWithSumTarget57 findContinuousSequenceWithSumTarget57 = new FindContinuousSequenceWithSumTarget57();
        findContinuousSequenceWithSumTarget57.findContinuousSequenceScrollWindow(9);
        MissingNumberInConsecutiveArray53 missingNumberInConsecutiveArray = new MissingNumberInConsecutiveArray53();
        System.out.println(missingNumberInConsecutiveArray.missingNumber(new int[]{0,1,2,3,4,6}));
        CharArrayPermutation38 charArrayPermutation = new CharArrayPermutation38();
        ReversePairsInArray51 reversePairsInArray = new ReversePairsInArray51();
        reversePairsInArray.reversePairs(new int[]{7, 3, 2, 6, 0, 1, 5, 4});
        String[] abcds = charArrayPermutation.permutation("abc");
        for (String abcd : abcds) {
            System.out.println(abcd);
        }
        FirstUniqChar50 firstUniqChar = new FirstUniqChar50();
        firstUniqChar.firstUniqChar("loveleetcode");
        NthUglyNumber49 nthUglyNumber = new NthUglyNumber49();
        System.out.println(nthUglyNumber.nthUglyNumber(10));
        LengthOfLongestSubstring48 length = new LengthOfLongestSubstring48();
        length.lengthOfLongestSubstring("abcabcbb");
        TranslateNumIntoChar46 translateNumIntoChar = new TranslateNumIntoChar46();
        translateNumIntoChar.translateNum(25);
    }
}
