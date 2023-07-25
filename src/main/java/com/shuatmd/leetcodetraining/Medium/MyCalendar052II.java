package com.shuatmd.leetcodetraining.Medium;

import java.util.Map;
import java.util.TreeMap;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-07-18 14:42
 * @Description: TODO
 * @Version: I.0
 */
//同MyCalendar058

//换一种思路解决：
//使用一个treeMap存储所有的book记录
//当需要book一个新的记录(m,n)的时候
//首先查询start时间早于m的最晚的一条记录(l,r)
//如果 m < r则说明已经被占用
//然后查询一个start时间晚于m的最早的一条记录
//如果 n < l说明已经被占用
public class MyCalendar052II {
    TreeMap<Integer, Integer> eventMap;

    public MyCalendar052II() {
        eventMap = new TreeMap<Integer, Integer>();
    }

    public boolean book(int start, int end) {
        //查找早于start的最晚的一个时间段
        Map.Entry<Integer, Integer> prevEvent = eventMap.floorEntry(start);
        //判断2个时间段是否覆盖
        if(prevEvent!=null && start < prevEvent.getValue()){
            return false;
        }
        //查找晚于start的最早的一个时间段
        Map.Entry<Integer, Integer> nextEvent = eventMap.ceilingEntry(start);
        //判断2个时间段是否覆盖
        if(nextEvent != null && nextEvent.getKey() < end){
            return false;
        }
        eventMap.put(start, end);
        return true;
    }

}
