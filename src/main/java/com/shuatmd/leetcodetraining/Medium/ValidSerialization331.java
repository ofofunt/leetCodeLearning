package com.shuatmd.leetcodetraining.Medium;

//331. 验证二叉树的前序序列化
//序列化二叉树的一种方法是使用 前序遍历 。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，
//https://leetcode.cn/problems/verify-preorder-serialization-of-a-binary-tree/description/
public class ValidSerialization331 {
    //官方解法： 另辟蹊径
    //使用槽位来验证是否合法 每一个非空的元素其实在占用一个槽位的同时提供了2个新的槽位
    //空节点只占用槽位 并不提供新的槽位
    //以此作为以及对整个string进行循环
    public boolean isValidSerialization(String preorder) {
        int length = preorder.length();
        //从根节点开始应该是2个槽位 所以默认初始状态有2 - 1 = 1个槽位
        int slot = 1;
        for (int i = 0; i < length; i++) {
            //一旦slot为0  需要返回false
            //比如 9 , # , # , 1 一旦为0说明已经不是合法二叉树
            if (slot == 0) {
                return false;
            }
            //如果是逗号则跳过
            if (',' == preorder.charAt(i)) {
                i++;
            } else if ('#' == preorder.charAt(i)) {
                i++;
                slot--;
            } else {
                //考虑到数字可能为多位,需要用while
                while (i < length && ',' != preorder.charAt(i)){
                    i++;
                }
                slot++;
            }
        }
        return slot == 0;
    }
}
