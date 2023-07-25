package com.shuatmd.leetcodetraining.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @BelongsProjects: $(PROJECT_NAME)
 * @BelongsPackage: SPACKAGE_NAME}
 * @Author: Shuran Han
 * @CreateTime: 2023-06-09 15:17
 * @Description: TODO
 * @Version: I.0
 */
public class FindMinuteDifferenceInHHMM035 {
    //手搓解法：偷一下官方的思路
    // hh x 60 + mm 进行排序
    // 遍历相邻间的最小值
    public int findMinDifference(List<String> timePoints) {
        //HH:MM格式最多只有24x60中可能性 如果超过则一定存在重复值
        if(timePoints.size() > 24 * 60){
            return 0;
        }
        //遍历timePoints 将HH:MM 转为分钟制塞入list 并且进行排序
        List<Integer> timeList = new ArrayList<>();
        for (String timePoint : timePoints) {
            String[] split = timePoint.split(":");
            int minutes = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
            timeList.add(minutes);
        }
        //附带stream写法
//        timePoints.stream()
//                .map(x -> Arrays.stream(x.split(":"))
//                        .mapToInt(Integer::parseInt).reduce((a,b)-> a*60 + b)
//                        .getAsInt()).sorted().collect(Collectors.toList());
//        Collections.sort(timeList);
        //加入最小值的 + 24*60 来防止出现负值 以及需要考虑00:00同时作为最大值最小值的情况
        timeList.add(timeList.get(0) + 24*60);
        int result = 24 * 60;
        for (int i = 1; i < timeList.size(); i++) {
            result = Math.min(timeList.get(i) - timeList.get(i - 1), result);
        }
        return result;
    }
}
