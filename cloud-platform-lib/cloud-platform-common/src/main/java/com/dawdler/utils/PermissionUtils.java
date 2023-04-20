package com.dawdler.utils;

import com.google.common.collect.Lists;

import java.util.List;

public class PermissionUtils {


        // 权限分配 或运算 （first | second）
        // 权限删除 求补,与运算 (firstsecond & (~ second))
        // 权限验证 与运算 (firstsecond & second) == second

    public static Long addPermission(List<Integer> permValueList) {
        Long totalPermValue = 0L ;
        if(permValueList == null ||  permValueList.size() == 0 ){
            return 0L;
        }
        // 权限分配 或运算 （first | second）
        for (Integer permValue : permValueList) {
            totalPermValue += (int)Math.pow(2, permValue);
        }
        return totalPermValue;
    }

    public static boolean checkPermission(int userPurview, List<Integer> optPurview) {
        int purviewValue =0;
        for (int i = 0; i < optPurview.size(); i++) {
            int j = optPurview.get(i);
            purviewValue+= (int)Math.pow(2, j);
        }
        System.out.println("操作要求码："+purviewValue);//132 ---10000100
        return (userPurview&purviewValue) == purviewValue;
    }

    // 可优化
    public static List<Long> listPermission(Long userPurview) {
        List<Long> list = Lists.newArrayList();
        String binValue = Long.toBinaryString(userPurview);
        for(int i=0;i<binValue.length();i++){
            if('1' == binValue.charAt(i)){
                list.add(binValue.length()-i-1L);
            }
        }
        return  list;
    }



    public static void main(String[] args) {
       /* List list = Lists.newArrayList(1,2,4);
        int a = addPermission(list);
        System.out.println(a);

        List choiceList = Lists.newArrayList(1,2,5);
        boolean flag = checkPermission(a,choiceList);
        System.out.println(flag);*/

        listPermission(240L);


    }


}
