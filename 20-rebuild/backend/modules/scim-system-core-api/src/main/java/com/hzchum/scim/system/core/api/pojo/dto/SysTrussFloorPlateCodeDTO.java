package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("桁架楼承板-编号类")
public class SysTrussFloorPlateCodeDTO {
   @ApiModelProperty(name = "code", notes = " 编号:桁架楼承板特有")
   private String code;
   @ApiModelProperty(name = "sort", notes = "排序")
   private Integer sort;
   @ApiModelProperty(name = "status", notes = " 状态 1启用 0禁用  ")
   private Boolean status;

   public String getCode() {
      return this.code;
   }

   public Integer getSort() {
      return this.sort;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public void setCode(final String code) {
      this.code = code;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysTrussFloorPlateCodeDTO)) {
         return false;
      }

      SysTrussFloorPlateCodeDTO other = (SysTrussFloorPlateCodeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sort = this.getSort();
      Object other$sort = other.getSort();
      if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$code = this.getCode();
            Object other$code = other.getCode();
            return this$code == null ? other$code == null : this$code.equals(other$code);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysTrussFloorPlateCodeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $code = this.getCode();
      return result * 59 + ($code == null ? 43 : $code.hashCode());
   }

   @Override
   public String toString() {
      return "SysTrussFloorPlateCodeDTO(code=" + this.getCode() + ", sort=" + this.getSort() + ", status=" + this.getStatus() + ")";
   }
}
