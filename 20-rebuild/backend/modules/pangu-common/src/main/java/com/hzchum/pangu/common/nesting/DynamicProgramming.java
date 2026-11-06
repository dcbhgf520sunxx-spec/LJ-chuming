package com.hzchum.pangu.common.nesting;

import com.hzchum.pangu.common.nesting.pojo.ProfileNestingLengthResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.ArrayUtils;

public class DynamicProgramming {
   public int valMax;
   public int numMax;
   public int overMax;
   public int[][] dp;
   public boolean[][] dpState;

   public DynamicProgramming(int valMax) {
      this.valMax = valMax;
      this.overMax = valMax + 1;
   }

   private int solveDp(int r, int i, int[] l, int n) {
      if (r <= 0) {
         return 0;
      }

      if (i == n) {
         return this.overMax;
      }

      if (this.dpState[r][i]) {
         return this.dp[r][i];
      }

      this.dpState[r][i] = true;
      this.dp[r][i] = Math.min(this.solveDp(r, i + 1, l, n), l[i] + this.solveDp(r - l[i], i + 1, l, n));
      return this.dp[r][i];
   }

   public int maxLength(int[] l, int n, int ml) {
      for (int i = ml; i >= 0; i--) {
         int res = this.solveDp(i, 0, l, n);
         if (res <= ml) {
            return res;
         }
      }

      return 0;
   }

   public ProfileNestingLengthResult nesting(int[] l, int ml) {
      this.init(l);
      int lNum = l.length;
      int res = this.maxLength(l, lNum, ml);
      int[] assembleIndex = this.findPath(l, res);
      int[] lr = Arrays.stream(assembleIndex).map(index -> l[index]).toArray();
      return new ProfileNestingLengthResult(lr, assembleIndex, l, res, ml);
   }

   public ProfileNestingLengthResult nesting(int[] l) {
      this.init(l);
      int lNum = l.length;
      int res = this.maxLength(l, lNum, this.valMax);
      int[] assembleIndex = this.findPath(l, res);
      int[] lr = Arrays.stream(assembleIndex).map(index -> l[index]).toArray();
      return new ProfileNestingLengthResult(lr, assembleIndex, l, res, this.valMax);
   }

   public List<ProfileNestingLengthResult> nestingLoop(int[] l) {
      List<ProfileNestingLengthResult> list = new ArrayList<>();
      int[] paddingL = (int[])l.clone();

      while (paddingL.length > 0) {
         ProfileNestingLengthResult nestingRes = this.nesting(paddingL);
         list.add(nestingRes);
         int removeTimes = 0;

         for (int i : nestingRes.indexGroup) {
            paddingL = ArrayUtils.remove(paddingL, i - removeTimes);
            removeTimes++;
         }
      }

      return list;
   }

   private void init(int[] l) {
      this.numMax = l.length;
      this.dp = new int[this.valMax + 1][this.numMax];
      this.dpState = new boolean[this.valMax + 1][this.numMax];
   }

   public int[] findPath(int[] l, int tl) {
      List<Integer> indexList = new ArrayList<>();

      for (int i = 0; tl > 0; i++) {
         int currentDP = this.dp[tl][i];
         boolean selected = i + 1 >= l.length;
         if (!selected) {
            int unselectBranch = this.dp[tl][i + 1];
            if (unselectBranch != currentDP) {
               selected = true;
            }
         }

         if (selected) {
            tl -= l[i];
            indexList.add(i);
         }
      }

      return indexList.stream().mapToInt(Integer::valueOf).toArray();
   }
}
