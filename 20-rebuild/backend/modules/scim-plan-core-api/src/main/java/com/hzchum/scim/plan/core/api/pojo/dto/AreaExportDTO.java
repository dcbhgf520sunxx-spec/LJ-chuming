package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.io.Serializable;

@ExcelTarget("AreaExportDTO")
public class AreaExportDTO implements Serializable {
   @Excel(name = "序号")
   private Integer id;
   @Excel(name = "工作划分")
   private String name;
   @Excel(name = "轴线/标高")
   private String axis;
   @Excel(name = "类型", replace = {"自制_0", "外包_1"})
   private Integer type;
   @Excel(name = "说明")
   private String remark;

   public Integer getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getAxis() {
      return this.axis;
   }

   public Integer getType() {
      return this.type;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaExportDTO)) {
         return false;
      }

      AreaExportDTO other = (AreaExportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$axis = this.getAxis();
               Object other$axis = other.getAxis();
               if (this$axis == null ? other$axis == null : this$axis.equals(other$axis)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof AreaExportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "AreaExportDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", axis="
         + this.getAxis()
         + ", type="
         + this.getType()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
