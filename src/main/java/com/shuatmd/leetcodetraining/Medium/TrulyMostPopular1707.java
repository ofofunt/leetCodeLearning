package com.shuatmd.leetcodetraining.Medium;

import java.util.HashMap;
import java.util.Map;

//面试题17 07 婴儿的名字
//每年，政府都会公布一万个最常见的婴儿名字和它们出现的频率，也就是同名婴儿的数量。有些名字有多种拼法，例如，John 和 Jon 本质上是相同的名字，但被当成了两个名字公布出来。给定两个列表，一个是名字及对应的频率，另一个是本质相同的名字对。设计一个算法打印出每个真实名字的实际频率。注意，如果 John 和 Jon 是相同的，并且 Jon 和 Johnny 相同，则 John 与 Johnny 也相同，即它们有传递和对称性。
//
//在结果列表中，选择 字典序最小 的名字作为真实名字
//https://leetcode.cn/problems/baby-names-lcci/description/
public class TrulyMostPopular1707 {
    //自己想的 + 参考题解解法1： 用HashMap来记录同名词 key为各种变种的名字 value为 最后使用的统一name
    public String[] trulyMostPopular(String[] names, String[] synonyms) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, String> unionMap = new HashMap<>();
        //先根据names array做名字与frequency的分割
        for (String name : names) {
            String curName = name.substring(0, name.indexOf('('));
            int frequency = Integer.valueOf(name.substring(name.indexOf('(') + 1, name.indexOf(')')));
            map.put(curName, frequency);
        }
        for (String synonym : synonyms) {
            int idx = synonym.indexOf(',');
            String name1 = synonym.substring(1, idx);
            String name2 = synonym.substring(idx + 1, synonym.length() - 1);
            //用while来显示unionMap的传递关系
            while (unionMap.containsKey(name1)) {
                name1 = unionMap.get(name1);
            }
            while (unionMap.containsKey(name2)) {
                name2 = unionMap.get(name2);
            }
            //如果查出来属于不同祖先,则说明这组同名词没有被添加到unionMap之中,需要添加
            if (!name1.equals(name2)) {
                int frequency = map.getOrDefault(name1, 0) + map.getOrDefault(name2, 0);
                //turname为2个名字中字母顺序更小的值 作为key
                String trueName = name1.compareTo(name2) < 0 ? name1 : name2;
                String nickName = name1.compareTo(name2) < 0 ? name2 : name1;
                unionMap.put(nickName, trueName);
                //将两个同名词合成之后需要再原来的map中删掉nickName的数据 只保留trueName的数据
                map.remove(nickName);
                map.put(trueName, frequency);
            }
        }
        //遍历map来返回格式化结果
        String res[] = new String[map.size()];
        int index = 0;
        for (String s : map.keySet()) {
            StringBuilder sb = new StringBuilder(s);
            sb.append('(');
            sb.append(map.get(s));
            sb.append(')');
            res[index++] = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        TrulyMostPopular1707 test = new TrulyMostPopular1707();
        test.trulyMostPopular(new String[]{"John(15)","Jon(12)","Chris(13)","Kris(4)","Christopher(19)"},new String[]{"(Jon,John)","(John,Johnny)","(Chris,Kris)","(Chris,Christopher)"});
    }
}
