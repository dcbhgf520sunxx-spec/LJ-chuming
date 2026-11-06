package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP  app产品焊缝列表查询 请求参数")
public class CappCraftCardProductAppWeldListDTO {
   private Long id;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   private Integer techCappProductTaskWorkType;

   public Long getId() {
      return this.id;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CappCraftCardProductAppWeldListDTO)) {
         return false;
      } else {
         CappCraftCardProductAppWeldListDTO other = (CappCraftCardProductAppWeldListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
               Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
               return this$techCappProductTaskWorkType == null
                  ? other$techCappProductTaskWorkType == null
                  : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductAppWeldListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      return result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppWeldListDTO(id=" + this.getId() + ", techCappProductTaskWorkType=" + this.getTechCappProductTaskWorkType() + ")";
   }
}
