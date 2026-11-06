package com.hzchum.scim.plan.core.api.pojo.dto.steel;

import io.swagger.annotations.ApiModelProperty;

public class PlateMatchDTOParam {
   @ApiModelProperty("规格索引")
   private Integer specIndex;
   @ApiModelProperty("关键字母")
   private String keyword;

   public Integer getSpecIndex() {
      return this.specIndex;
   }

   public String getKeyword() {
      return this.keyword;
   }

   public void setSpecIndex(final Integer specIndex) {
      this.specIndex = specIndex;
   }

   public void setKeyword(final String keyword) {
      this.keyword = keyword;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PlateMatchDTOParam)) {
         return false;
      } else {
         PlateMatchDTOParam other = (PlateMatchDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$specIndex = this.getSpecIndex();
            Object other$specIndex = other.getSpecIndex();
            if (this$specIndex == null ? other$specIndex == null : this$specIndex.equals(other$specIndex)) {
               Object this$keyword = this.getKeyword();
               Object other$keyword = other.getKeyword();
               return this$keyword == null ? other$keyword == null : this$keyword.equals(other$keyword);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PlateMatchDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specIndex = this.getSpecIndex();
      result = result * 59 + ($specIndex == null ? 43 : $specIndex.hashCode());
      Object $keyword = this.getKeyword();
      return result * 59 + ($keyword == null ? 43 : $keyword.hashCode());
   }

   @Override
   public String toString() {
      return "PlateMatchDTOParam(specIndex=" + this.getSpecIndex() + ", keyword=" + this.getKeyword() + ")";
   }
}
