package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("修改区域 请求类")
public class AreaUpdateDTOParam {
   @NotNull(message = "区域id不能为空")
   private Long id;
   @NotBlank(message = "区域名字不能为空")
   @ApiModelProperty(name = "name", value = "区域名称")
   @Size(min = 1, max = 128, message = "名称字数过多")
   private String name;
   @NotNull(message = "产品类型不能为空")
   @ApiModelProperty(name = "productType", value = "产品类型: 主构件 夹芯板 压型板 折边件 压型楼承板 桁架楼承板")
   private Integer productType;
   @NotNull(message = "类型不能为空")
   @Min(value = 0L, message = "类型只能为0或1")
   @Max(value = 1L, message = "类型只能为0或1")
   @ApiModelProperty(name = "type", value = "类型 0：自制，1：外包")
   private Integer type;
   private String supplier;
   @NotNull(message = "区域完成日期不能为空")
   @ApiModelProperty(name = "date", value = "区域完成日期")
   private LocalDate date;
   @NotBlank(message = "轴线或标高不能为空")
   @ApiModelProperty(name = "axis", value = "轴线或标高")
   private String axis;
   @NotNull(message = "排序不能为空")
   @Min(value = 1L, message = "排序最小值为1")
   @Max(value = 999L, message = "排序最大值为999")
   @ApiModelProperty(name = "sort", value = "排序")
   private Integer sort;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 200, message = "备注字数超出限制")
   private String remark;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getType() {
      return this.type;
   }

   public String getSupplier() {
      return this.supplier;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public String getAxis() {
      return this.axis;
   }

   public Integer getSort() {
      return this.sort;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSupplier(final String supplier) {
      this.supplier = supplier;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setAxis(final String axis) {
      this.axis = axis;
   }

   public void setSort(final Integer sort) {
      this.sort = sort;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaUpdateDTOParam)) {
         return false;
      }

      AreaUpdateDTOParam other = (AreaUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$sort = this.getSort();
               Object other$sort = other.getSort();
               if (this$sort == null ? other$sort == null : this$sort.equals(other$sort)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$supplier = this.getSupplier();
                     Object other$supplier = other.getSupplier();
                     if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                        Object this$date = this.getDate();
                        Object other$date = other.getDate();
                        if (this$date == null ? other$date == null : this$date.equals(other$date)) {
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
      return other instanceof AreaUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $sort = this.getSort();
      result = result * 59 + ($sort == null ? 43 : $sort.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $axis = this.getAxis();
      result = result * 59 + ($axis == null ? 43 : $axis.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "AreaUpdateDTOParam(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", supplier="
         + this.getSupplier()
         + ", date="
         + this.getDate()
         + ", axis="
         + this.getAxis()
         + ", sort="
         + this.getSort()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
