package com.hzchum.pangu.common.nesting;

import com.hzchum.pangu.common.nesting.pojo.ProfileNestingLengthResult;
import java.util.List;

public class DynamicProgrammingTest {
   public static void main(String[] args) {
      int[] l = new int[]{3660, 5700, 2180, 2300, 4120, 4430, 8000, 1079, 2081, 3305, 5670};
      DynamicProgramming dp = new DynamicProgramming(10000);
      List<ProfileNestingLengthResult> nestingResList = dp.nestingLoop(l);
      nestingResList.forEach(System.out::println);
   }
}
