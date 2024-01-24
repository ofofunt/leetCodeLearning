package com.shuatmd.leetcodetraining.Medium;

//面试题 16.18. 模式匹配
//你有两个字符串，即pattern和value。 pattern字符串由字母"a"和"b"组成，用于描述字符串中的模式。
// 例如，字符串"catcatgocatgo"匹配模式"aabab"（其中"cat"是"a"，"go"是"b"），该字符串也匹配像"a"、"ab"和"b"这样的模式。但需注意"a"和"b"不能同时表示相同的字符串。
// 编写一个方法判断value字符串是否匹配pattern字符串。
//输入： pattern = "abba", value = "dogdogdogdog"
//输出： true
//解释： "a"="dogdog",b=""，反之也符合规则
//输入： pattern = "abba", value = "dogcatcatdog"
//输出： true
//https://leetcode.cn/problems/pattern-matching-lcci/description/
public class patternMatching1618 {
    //巨恶心的枚举题  直接套一下官方解算了
    public boolean patternMatching(String pattern, String value) {
        //首先计算一下pattern中需要匹配的a模式与b模式数量
        int countA = 0;
        int countB = 0;
        char[] chars = pattern.toCharArray();
        for (char c : chars) {
            if ('a' == c) {
                countA++;
            } else {
                countB++;
            }
        }
        //如果countB的数量大于countA 我们需要翻转一下,因为后续解法会默认pattern中a出现的更多
        if (countB > countA) {
            int tmp = countA;
            countA = countB;
            countB = tmp;
            for (int i = 0; i < chars.length; i++) {
                chars[i] = chars[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(chars);
        }

        //判断特殊情况,如果value为空时,countB为空 则说明为true
        //value = '' pattern = 'a' 或者 'aa'或者'aaaa' a = '' 输出为true 只要没有b的存在就行
        if (value.length() == 0) {
            return countB == 0;
        }
        //如果value不为空但是pattern为空则一定会输出错
        if (pattern.length() == 0) {
            return false;
        }

        //接下来进行模糊匹配+枚举的流程
        //假定a出现的次数更多, 我们从a的长度为0开始进行枚举
        for (int lenA = 0; countA * lenA <= value.length(); lenA++) {
            //根据countA的个数算出value剩下的需要被匹配的长度
            int rest = value.length() - countA * lenA;
            //当剩余长度等于0且countB为0时,继续循环 eg 存在pattern b=‘’的情况
            //当剩余长度大于0且rest可以被countB整除时 继续循环
            if ((countB == 0 && rest == 0) || (countB != 0 && rest % countB == 0)) {
                int lenB = rest == 0 ? 0 : rest / countB;
                //定义每次分割的位置
                int pos = 0;
                boolean correct = true;
                String valueA = "";
                String valueB = "";
                //根据a,b两个pattern来分别尝试进行匹配
                for (char c : pattern.toCharArray()) {
                    if ('a' == c) {
                        String sub = value.substring(pos, pos + lenA);
                        //首次检索到a的时候 根据a的长度和当前的index 对a进行赋值
                        if (valueA.length() == 0) {
                            valueA = sub;
                        }
                        //当后续判断时,如果当前valueA 也就是pattern a的值不等于当前截取的sub a 说明这个模板是错的 直接返回false
                        else if (!valueA.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += lenA;
                    } else {
                        String sub = value.substring(pos, pos + lenB);
                        if(valueB.length() == 0){
                            valueB = sub;
                        }
                        else if(!valueB.equals(sub)){
                            correct = false;
                            break;
                        }
                        pos +=lenB;
                    }
                }
                //最后记得还需要判别pattern a与pattern b的数值不能一样
                if(correct && !valueA.equals(valueB)){
                    return true;
                }
            }
        }
        return false;
    }
}
