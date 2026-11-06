package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@ApiModel("桁架楼承板-新增/修改类")
public class TrussFloorPlateSaveDTOParam {
   @NotBlank(message = "桁架楼承板-编号不能为空")
   @ApiModelProperty("桁架楼承板-编号")
   private String code;
   @ApiModelProperty("排序")
   private Integer sort;
   @ApiModelProperty("(桁架楼承板)编号")
   @NotEmpty(message = "桁架楼承板详情列表不能为空")
   private List<TrussFloorDetailsDTOParam> dictionaryDetails;

   public String getCode() {
      return this.code;
   }

   public Integer getSort() {
      return this.sort;
   }

   public List<TrussFloorDetailsDTOParam> getDictionaryDetails() {
      return this.dictionaryDetails;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setDictionaryDetails(final List<TrussFloorDetailsDTOParam> dictionaryDetails) {
      this.dictionaryDetails = dictionaryDetails;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrussFloorPlateSaveDTOParam)) {
         return false;
      }

      TrussFloorPlateSaveDTOParam other = (TrussFloorPlateSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$code = this.getCode();
         Object other$code = other.getCode();
         if (this$code == null ? other$code == null : this$code.equals(other$code)) {
            Object this$dictionaryDetails = this.getDictionaryDetails();
            Object other$dictionaryDetails = other.getDictionaryDetails();
            return this$dictionaryDetails == null ? other$dictionaryDetails == null : this$dictionaryDetails.equals(other$dictionaryDetails);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TrussFloorPlateSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $code = this.getCode();
      result = result * 59 + ($code == null ? 43 : $code.hashCode());
      Object $dictionaryDetails = this.getDictionaryDetails();
      return result * 59 + ($dictionaryDetails == null ? 43 : $dictionaryDetails.hashCode());
   }

   @Override
   public String toString() {
      return "TrussFloorPlateSaveDTOParam(code=" + this.getCode() + ", sort=" + this.getSort() + ", dictionaryDetails=" + this.getDictionaryDetails() + ")";
   }
}
