package com.hzchum.scim.wms.core.api.utils;

import com.hzchum.scim.wms.core.api.pojo.dto.common.ProfileNestingLengthResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicProgramming {
   private Map<String, Integer> memo = new HashMap<>();
   private int valMax;

   public DynamicProgramming(int valMax) {
      this.valMax = valMax;
   }

   public int maxLength(int[] l, int ml) {
      return this.solve(ml, 0, l) <= ml ? ml : 0;
   }

   private int solve(int r, int i, int[] l) {
      if (r <= 0) {
         return 0;
      }

      if (i >= l.length) {
         return 0;
      }

      String key = r + "," + i;
      if (this.memo.containsKey(key)) {
         return this.memo.get(key);
      }

      int exclude = this.solve(r, i + 1, l);
      int include = r >= l[i] ? l[i] + this.solve(r - l[i], i + 1, l) : Integer.MAX_VALUE;
      int result = Math.max(exclude, include);
      if (result >= Integer.MAX_VALUE) {
         result = 0;
      }

      this.memo.put(key, result);
      return result;
   }

   public ProfileNestingLengthResult nesting(int[] l, int ml) {
      this.valMax = ml;
      this.memo.clear();
      int res = this.maxLength(l, ml);
      int[] assembleIndex = this.findPath(l, res);
      int[] lr = Arrays.stream(assembleIndex).map(index -> l[index]).toArray();
      return new ProfileNestingLengthResult(lr, assembleIndex, l, res, ml);
   }

   public ProfileNestingLengthResult nestingLoop(int[] l) {
      List<Integer> remaining = new ArrayList<>();

      for (int x : l) {
         remaining.add(x);
      }

      int[] currentArray = remaining.stream().mapToInt(i -> i).toArray();
      return this.nesting(currentArray, this.valMax);
   }

   public List<ProfileNestingLengthResult> nestingLoopFor(int[] l) {
      List<ProfileNestingLengthResult> results = new ArrayList<>();
      List<Integer> remaining = new ArrayList<>();

      for (int x : l) {
         remaining.add(x);
      }

      while (!remaining.isEmpty()) {
         int[] currentArray = remaining.stream().mapToInt(i -> i).toArray();
         ProfileNestingLengthResult res = this.nesting(currentArray, this.valMax);
         results.add(res);
         boolean[] used = new boolean[remaining.size()];

         for (int index : res.indexGroup) {
            used[index] = true;
         }

         List<Integer> newRemaining = new ArrayList<>();

         for (int i = 0; i < remaining.size(); i++) {
            if (!used[i]) {
               newRemaining.add(remaining.get(i));
            }
         }

         remaining = newRemaining;
      }

      return results;
   }

   public int[] findPath(int[] l, int tl) {
      List<Integer> indexList = new ArrayList<>();

      for (int i = 0; tl > 0; i++) {
         String selectBranchKey = tl + "," + i;
         String unselectBranchKey = tl + "," + (i + 1);
         if (!this.memo.containsKey(selectBranchKey)) {
            break;
         }

         Integer selectBranchDP = this.memo.get(selectBranchKey);
         Integer unselectBranchDP = this.memo.get(unselectBranchKey);
         if (!selectBranchDP.equals(unselectBranchDP) && tl - l[i] >= 0) {
            indexList.add(i);
            tl -= l[i];
         }
      }

      return indexList.stream().mapToInt(Integer::valueOf).toArray();
   }

   public static void main(String[] args) {
      System.out.println(Integer.MAX_VALUE);
      int[] l = new int[]{12983, 235932, 200760000, 555300000, 412300000, 204030000, 703240000};
      Arrays.sort(l);
      DynamicProgramming dp = new DynamicProgramming(800000000);
      List<ProfileNestingLengthResult> nestingResList = dp.nestingLoopFor(l);
      nestingResList.forEach(System.out::println);
   }
}
