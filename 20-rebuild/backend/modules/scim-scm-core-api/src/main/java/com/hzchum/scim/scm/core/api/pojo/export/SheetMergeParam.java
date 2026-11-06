package com.hzchum.scim.scm.core.api.pojo.export;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class SheetMergeParam implements Serializable {
   private int sheetIndex;
   private int desColumnIndex;
   private int[] mergeColumnIndexs;
   private List<String> ignoreCellValues;

   public int getSheetIndex() {
      return this.sheetIndex;
   }

   public int getDesColumnIndex() {
      return this.desColumnIndex;
   }

   public int[] getMergeColumnIndexs() {
      return this.mergeColumnIndexs;
   }

   public List<String> getIgnoreCellValues() {
      return this.ignoreCellValues;
   }

   public void setSheetIndex(final int sheetIndex) {
      this.sheetIndex = sheetIndex;
   }

   public void setDesColumnIndex(final int desColumnIndex) {
      this.desColumnIndex = desColumnIndex;
   }

   public void setMergeColumnIndexs(final int[] mergeColumnIndexs) {
      this.mergeColumnIndexs = mergeColumnIndexs;
   }

   public void setIgnoreCellValues(final List<String> ignoreCellValues) {
      this.ignoreCellValues = ignoreCellValues;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SheetMergeParam)) {
         return false;
      }

      SheetMergeParam other = (SheetMergeParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getSheetIndex() != other.getSheetIndex()) {
         return false;
      }

      if (this.getDesColumnIndex() != other.getDesColumnIndex()) {
         return false;
      }

      if (!Arrays.equals(this.getMergeColumnIndexs(), other.getMergeColumnIndexs())) {
         return false;
      }

      Object this$ignoreCellValues = this.getIgnoreCellValues();
      Object other$ignoreCellValues = other.getIgnoreCellValues();
      return this$ignoreCellValues == null ? other$ignoreCellValues == null : this$ignoreCellValues.equals(other$ignoreCellValues);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SheetMergeParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSheetIndex();
      result = result * 59 + this.getDesColumnIndex();
      result = result * 59 + Arrays.hashCode(this.getMergeColumnIndexs());
      Object $ignoreCellValues = this.getIgnoreCellValues();
      return result * 59 + ($ignoreCellValues == null ? 43 : $ignoreCellValues.hashCode());
   }

   @Override
   public String toString() {
      return "SheetMergeParam(sheetIndex="
         + this.getSheetIndex()
         + ", desColumnIndex="
         + this.getDesColumnIndex()
         + ", mergeColumnIndexs="
         + Arrays.toString(this.getMergeColumnIndexs())
         + ", ignoreCellValues="
         + this.getIgnoreCellValues()
         + ")";
   }

   public SheetMergeParam(final int sheetIndex, final int desColumnIndex, final int[] mergeColumnIndexs, final List<String> ignoreCellValues) {
      this.sheetIndex = sheetIndex;
      this.desColumnIndex = desColumnIndex;
      this.mergeColumnIndexs = mergeColumnIndexs;
      this.ignoreCellValues = ignoreCellValues;
   }

   public SheetMergeParam() {
   }
}
