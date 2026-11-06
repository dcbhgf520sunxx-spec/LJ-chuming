package com.hzchum.scim.wms.core.api.pojo.dto.common;

import java.util.Arrays;

public class ProfileNestingLengthResult {
   public int[] resultGroup;
   public int[] resultOrderGroup;
   public int[] indexGroup;
   public int[] curDealGroup;
   public int nestingLength;
   public int baseMetalLength;

   public ProfileNestingLengthResult(int[] resultGroup, int[] indexGroup, int[] curDealGroup, int nestingLength, int baseMetalLength) {
      this.resultGroup = resultGroup;
      this.indexGroup = indexGroup;
      this.curDealGroup = curDealGroup;
      this.nestingLength = nestingLength;
      this.baseMetalLength = baseMetalLength;
      this.resultOrderGroup = Arrays.stream(resultGroup).sorted().toArray();
   }

   @Override
   public String toString() {
      return "ProfileNestingLengthResult{nestingLength="
         + this.nestingLength
         + ", resultOrderGroup="
         + Arrays.toString(this.resultOrderGroup)
         + ", resultGroup="
         + Arrays.toString(this.resultGroup)
         + ", indexGroup="
         + Arrays.toString(this.indexGroup)
         + ", curDealGroup="
         + Arrays.toString(this.curDealGroup)
         + ", baseMetalLength="
         + this.baseMetalLength
         + '}';
   }
}
