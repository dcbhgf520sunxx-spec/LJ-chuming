package com.hzchum.scim.system.core.api.pojo.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;

@ApiModel("桁架楼承板 详情新增修改类")
public class TrussFloorDetailsDTOParam {
   @ApiModelProperty("围护字典id")
   private Long id;
   @NotBlank(message = "字典名称不能为空")
   @ApiModelProperty("围护字典名称")
   private String name;
   @ApiModelProperty("围护字典中文名称")
   private String remark;
   @NotBlank(message = "字典详情名称或值不能为空")
   @ApiModelProperty("字典详情名称或值")
   private String label;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getLabel() {
      return this.label;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setLabel(final String label) {
      this.label = label;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TrussFloorDetailsDTOParam)) {
         return false;
      }

      TrussFloorDetailsDTOParam other = (TrussFloorDetailsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$label = this.getLabel();
               Object other$label = other.getLabel();
               return this$label == null ? other$label == null : this$label.equals(other$label);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TrussFloorDetailsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $label = this.getLabel();
      return result * 59 + ($label == null ? 43 : $label.hashCode());
   }

   @Override
   public String toString() {
      return "TrussFloorDetailsDTOParam(id=" + this.getId() + ", name=" + this.getName() + ", remark=" + this.getRemark() + ", label=" + this.getLabel() + ")";
   }
}
