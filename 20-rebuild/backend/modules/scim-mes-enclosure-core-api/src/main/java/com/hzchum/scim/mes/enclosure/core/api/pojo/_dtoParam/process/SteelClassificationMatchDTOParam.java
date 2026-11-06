package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.process;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SteelClassificationMatchDTOParam {
   @ApiModelProperty("规格索引")
   @NotNull(message = "索引不能为空")
   @Min(0L)
   @Max(4L)
   private Integer specIndex;
   @ApiModelProperty("关键字母")
   @NotBlank(message = "关键字母不能为空")
   @Size(max = 8, message = "关键字母长度不能大于8")
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
      } else if (!(o instanceof SteelClassificationMatchDTOParam)) {
         return false;
      } else {
         SteelClassificationMatchDTOParam other = (SteelClassificationMatchDTOParam)o;
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
      return other instanceof SteelClassificationMatchDTOParam;
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
      return "SteelClassificationMatchDTOParam(specIndex=" + this.getSpecIndex() + ", keyword=" + this.getKeyword() + ")";
   }
}
