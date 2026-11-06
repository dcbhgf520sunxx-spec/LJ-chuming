package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class PlanDetailResponseDTO {
   @ApiModelProperty(name = "id", notes = "计划详情id")
   private Long id;
   @ApiModelProperty(name = "type", notes = "计划详情类型 类型   1-深化计划  2 -加工计划  4-安装计划")
   private Integer type;
   @ApiModelProperty(name = "startDate", notes = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", notes = "结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "remark", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "name", notes = "名称")
   private String name;
   @ApiModelProperty(name = "date", notes = "区域完成日期")
   private LocalDate date;
   @ApiModelProperty(name = "axis", notes = "轴线或标高")
   private String axis;
   @ApiModelProperty(name = "type", notes = "制造方式 0：自制，1：外包")
   private Integer areaType;
   @ApiModelProperty(name = "supplier", notes = "供应商(外包时才有)")
   private String supplier;

   public Long getId() {
      return this.id;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getName() {
      return this.name;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public String getAxis() {
      return this.axis;
   }

   public Integer getAreaType() {
      return this.areaType;
   }

   public String getSupplier() {
      return this.supplier;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setAreaType(final Integer areaType) {
      this.areaType = areaType;
   }

   public void setSupplier(final String supplier) {
      this.supplier = supplier;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanDetailResponseDTO)) {
         return false;
      }

      PlanDetailResponseDTO other = (PlanDetailResponseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$areaType = this.getAreaType();
            Object other$areaType = other.getAreaType();
            if (this$areaType == null ? other$areaType == null : this$areaType.equals(other$areaType)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$endDate = this.getEndDate();
                  Object other$endDate = other.getEndDate();
                  if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                     Object this$remark = this.getRemark();
                     Object other$remark = other.getRemark();
                     if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                        Object this$name = this.getName();
                        Object other$name = other.getName();
                        if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                           Object this$date = this.getDate();
                           Object other$date = other.getDate();
                           if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                              Object this$axis = this.getAxis();
                              Object other$axis = other.getAxis();
                              if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                                 Object this$supplier = this.getSupplier();
                                 Object other$supplier = other.getSupplier();
                                 return this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier);
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof PlanDetailResponseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $areaType = this.getAreaType();
      result = result * 59 + ($areaType == null ? 43 : $areaType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $supplier = this.getSupplier();
      return result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
   }

   @Override
   public String toString() {
      return "PlanDetailResponseDTO(id="
         + this.getId()
         + ", type="
         + this.getType()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", remark="
         + this.getRemark()
         + ", name="
         + this.getName()
         + ", date="
         + this.getDate()
         + ", axis="
         + this.getAxis()
         + ", areaType="
         + this.getAreaType()
         + ", supplier="
         + this.getSupplier()
         + ")";
   }
}
